package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.comparc.DComparc;
import it.beniculturali.sas.catalogo.comparc.FkFonte;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.log4j.Logger;

public class ComplessiArchivistici
{
	private Properties queryProp;
	private PreparedStatement stmtDComparc;
	private PreparedStatement stmtDComparcAltreden;
	private PreparedStatement stmtIstituto;
	ResultSet rs, rsad;
	FkFonte fkf;
	String fkFonte = null;
	ProfGroup pg;
	private static Logger log;

	/*
	 * Questo costruttore richiede solo una connessione (che non tocca a lui
	 * chiudere, attenzione) che usa solo per creare la preparedStatement, così è
	 * pronta per essere eseguita da altri metodi
	 */
	public ComplessiArchivistici(int idIstituto, Connection conn)
	{
		queryProp = new Properties();
		try
		{
			FileReader prop = new FileReader("query.prop");
			queryProp.load(prop);
			prop.close();
			new it.beniculturali.sas.catalogo.commons.ObjectFactory();
			stmtDComparc = conn.prepareStatement(queryProp
					.getProperty("query.comparc"));
			stmtDComparcAltreden = conn.prepareStatement(queryProp
					.getProperty("query.comparc.altreden"));
			stmtIstituto = conn.prepareStatement(queryProp
					.getProperty("query.istituto"), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			fkFonte = queryProp.getProperty("sogc.fk_fonte");
			log = Logger.getLogger("COMPARC");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * Nuova versione del createEntity. Questa è più autonoma rispetto alla
	 * precedente, qui rimossa, perché ha bisogno solo di una connessione e di un
	 * idIstituto, poi pensa lei a trovare la query da eseguire e ad usare i
	 * risultati come avveniva in quella rimossa, che invece richiedeva già un
	 * resultset
	 */
	public Iterator<DComparc> createEntity(int idIstituto)
	{
		DComparcWrapper dcomparcw = null;
		ArrayList<DComparc> dwl = null;
		dwl = new ArrayList<DComparc>();
		String siglaIstituto = null;
		try
		{
			stmtIstituto.setInt(1, idIstituto);
			stmtIstituto.execute();
			rs = stmtIstituto.getResultSet();
			rs.next();
			siglaIstituto = rs.getString("fk_fonte");
			log.info("Istituto " + siglaIstituto + ", inizio elaborazione");
			/*
			 * A questo punto la connessione è stabilita. Si prepara una query e si
			 * esegue con id_istituto
			 */
			stmtDComparc.setInt(1, idIstituto);
			stmtDComparc.execute();

			/*
			 * rs è il resultset che dovrebbe elencare tutti i ca di un istituto
			 */
			rs = stmtDComparc.getResultSet();

			while(rs.next())
			{
				dcomparcw = new DComparcWrapper();
				dcomparcw.setCodiProvenienza(rs.getString("codi_provenienza"));
				dcomparcw.setFkVocTipoComparc(rs.getLong("fk_voc_tipo_comparc"));
				dcomparcw.setFkVocTipoComparc(1);
				dcomparcw.setTextDenUniformata(rs.getString("text_den_uniformata"));
				/*
				 * Per evitare errori di validazione delle fonti, non tutte codificate
				 * correttamente negli XSD, si usa una fonte fittizia sicuramente valida
				 */
				if(fkFonte != null)
				{
					dcomparcw.setFkFonte(fkFonte);
				}
				else
				{
					dcomparcw.setFkFonte(rs.getString("fk_fonte"));
				}
				dcomparcw.setTextEstrCronoTestuali(rs
						.getString("text_estr_crono_testuali"));
				try
				{
					dcomparcw.setDateEstremoRemoto(rs.getString("date_estremo_remoto"));
					dcomparcw.setDateEstremoRecente(rs.getString("date_estremo_recente"));
				}
				catch(DatatypeConfigurationException e)
				{
					log
							.warn("Istituto " + siglaIstituto + ", complesso "
									+ rs.getString("ID_ComplessoDoc") + "scartato: "
									+ e.getMessage());
					break;
				}
				catch(IllegalArgumentException e)
				{
					log
							.warn("Istituto " + siglaIstituto + ", complesso "
									+ rs.getString("ID_ComplessoDoc") + "scartato: "
									+ e.getMessage());
					break;
				}
				// dcomparcw.setDComparcDatiConsistenza(rs
				// .getLong("dati_consistenza_nume_consistenza"));
				try
				{
					dcomparcw.setTextStoriaArchivistica(rs
							.getString("text_storia_archivistica"));
					dcomparcw.setTextUrl(rs.getString("text_url"));
					dcomparcw.setTextNumCorda(rs.getInt("text_num_corda"));
					dcomparcw.setNumeMtLineariComplessivi(rs
							.getBigDecimal("nume_mt_lineari_complessivi"));
					dcomparcw.setNumeRipartoMtLineariSottolvl(rs
							.getBigDecimal("nume_riparto_mt_lineari_sottolvl"));
				}
				catch(IllegalArgumentException e)
				{
					log.warn("Istituto " + siglaIstituto + ", complesso "
							+ rs.getString("ID_ComplessoDoc") + ": " + e.getMessage());
				}
				catch(SiasSasException e)
				{
					log.warn("Istituto " + siglaIstituto + ", complesso "
							+ rs.getString("ID_ComplessoDoc") + ": " + e.getMessage());
				}

				log.info("Istituto " + siglaIstituto + ", complesso "
						+ rs.getString("ID_ComplessoDoc"));

				/*
				 * Popoliamo le localizzazioni. Si usa ovviamente un'altra statement, ma
				 * si ricicla il resultset rs. Le localizzazioni secondarie sono
				 * ripetibili, per cui si dovrà ciclare sul resultset, diversamente da
				 * prima.
				 */

				stmtDComparcAltreden.setInt(1, idIstituto);
				stmtDComparcAltreden.execute();
				rsad = stmtDComparcAltreden.getResultSet();
				// rsad.next();

				while(rsad.next())
				{
					dcomparcw.addAltraDen(rsad.getString("text_altreden"), rsad.getString("text_estr_crono_testuali"));
					log.info("Istituto " + siglaIstituto
							+ ", elaborata altra denominazione "
							+ rsad.getString("text_altreden"));
				}
				dwl.add(dcomparcw.getDComparc());
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		log.info("Istituto " + siglaIstituto + ", fine elaborazione");
		return dwl.iterator();
	}
}
