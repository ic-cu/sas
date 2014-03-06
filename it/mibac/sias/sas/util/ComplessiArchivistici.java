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
	private Properties				config;
	private PreparedStatement	stmtDComparc;
	private PreparedStatement	stmtDComparcPrimoLivello;
	private PreparedStatement	stmtDComparcSottoLivelli;
	private PreparedStatement	stmtDComparcAltreden;
	private PreparedStatement	stmtIstituto;
	ResultSet									rs, rsad;
	FkFonte										fkf;
	String										fkFonte	= null;
	ProfGroup									pg;
	private static Logger			log;

	/*
	 * Questo costruttore richiede solo una connessione (che non tocca a lui chiudere, attenzione) che
	 * usa solo per creare la preparedStatement, così è pronta per essere eseguita da altri metodi
	 */
	public ComplessiArchivistici(Connection conn)
	{
		config = new Properties();
		try
		{
			FileReader prop = new FileReader("query.prop");
			config.load(prop);
			prop.close();
			new it.beniculturali.sas.catalogo.commons.ObjectFactory();
			stmtDComparc = conn.prepareStatement(config.getProperty("query.comparc"));
			stmtDComparcPrimoLivello = conn.prepareStatement(config.getProperty("query.comparc.pl"));
			stmtDComparcSottoLivelli = conn.prepareStatement(config.getProperty("query.comparc.sl"),
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			stmtDComparcAltreden = conn.prepareStatement(config.getProperty("query.comparc.altreden"));
			stmtIstituto = conn.prepareStatement(config.getProperty("query.istituto"), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			fkFonte = config.getProperty("sogc.fk_fonte");
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
 * Questo metodo estrae un iteratore di coppie (idComparc, numCorda). Esso comincia dal primo
 * livello che è quello immediatamente legato ad un istituto il cui id è il parametro; poi invoca un
 * metodo ricorsivo che, per ogni complesso, estrae i suoi figli fino ad arrivare alle foglie,
 * sempre creando coppie (idComparc, numCorda) che saranno accodate all'iteratore.
 */

	public Iterator<long[]> getComparcIterator(int idIstituto)
	{
		ResultSet rs = null;
		ArrayList<long[]> al;
		al = new ArrayList<long[]>();
		long idComplesso, numCorda, numFigli;
		try
		{
			stmtDComparcPrimoLivello.setInt(1, idIstituto);
			rs = stmtDComparcPrimoLivello.executeQuery();
			while(rs.next())
			{
				idComplesso = rs.getLong("idComplesso");
				numCorda = rs.getLong("text_num_corda");
				numFigli = rs.getLong("figli");
				al.add(new long[] { idComplesso, numCorda, numFigli });
				log.info("Complesso " + idComplesso + ", numero corda " + numCorda + ", figli " + numFigli);
				if(numFigli > 0)
				{
					al.addAll(getSubComparcList(idComplesso));
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return al.iterator();
	}

	public ArrayList<long[]> getSubComparcList(long idComplesso)
	{
		ArrayList<long[]> al;
		ArrayList<long[]> pl;
		Iterator<long[]> pli;
		al = new ArrayList<long[]>();
		pl = new ArrayList<long[]>();
		long[] la;
		long idFiglio, numCorda, numFigli;
		try
		{
			ResultSet rs = null;
			stmtDComparcSottoLivelli.setLong(1, idComplesso);
			rs = stmtDComparcSottoLivelli.executeQuery();
			log.info("Figli del complesso " + idComplesso);

			// Cicliamo sui figli di questo complesso

			while(rs.next())
			{
				idFiglio = rs.getLong("idFiglio");
				numCorda = rs.getLong("text_num_corda");
				numFigli = rs.getLong("figli");

/*
 * Aggiunge alla lista globale dei complessi questo figlio, ma se esso stesso ha dei figli, lo
 * aggiunge ad una lista locale di padri che sarà scandita dopo la fine del result set
 */
				log.info("Complesso " + idFiglio + ", numero corda " + numCorda + ", figli " + numFigli);
				al.add(new long[] { idFiglio, numCorda, numFigli });
				if(numFigli > 0) pl.add(new long[] { idFiglio, numFigli });
			}

/*
 * Il result set è finito, quindi tutti i figli (non nipoti) di questo complesso sono stati inclusi
 * nell'elenco globale. Si scorre l'elenco di quei figli che sono a loro volta padri e si effettua
 * la ricorsione
 */

			pli = pl.iterator();
			while(pli.hasNext())
			{
				la = pli.next();
				idFiglio = la[0];
				numFigli = la[1];
				al.addAll(getSubComparcList(idFiglio));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}

	/*
	 * Questo metodo fornisce un iterator di DComparc legati ad un istituto. Sarà cura del chiamante
	 * gestire questa lista.
	 */
	public Iterator<DComparc> createEntity(int idIstituto)
	{
		DComparcWrapper dcomparcw = null;
		ArrayList<DComparc> dwl = null;
		Iterator<long[]> idComplessi;
		dwl = new ArrayList<DComparc>();
		String siglaIstituto = null;
		String temp = null;
		long idComplesso, numCorda;
		long[] coppia;
		int numComplesso = 0;

/*
 * Una prima query serve a reperire informazioni minimali circa un istituto
 */

		try
		{
			stmtIstituto.setInt(1, idIstituto);
			stmtIstituto.execute();
			rs = stmtIstituto.getResultSet();
			rs.next();
			siglaIstituto = rs.getString("fk_fonte");
			log.info("Istituto " + siglaIstituto + ", inizio elaborazione");
/*
 * Si ricava l'iteratore sull'elenco di tutti gli id dei complessi legati a questo istituto,
 * ciascuno con un "numero di corda" da usare per l'ordinamento, poi si cicla sull'iteratore
 */
			idComplessi = getComparcIterator(idIstituto);
			while(idComplessi.hasNext())
			{
				coppia = idComplessi.next();
				idComplesso = coppia[0];
				numCorda = coppia[1];

/*
 * Prelevato l'id di un complesso e il suo numero di corda, passiamo a popolare tutti gli altri dati
 * di questo complesso entrando col suo id nella query apposita. Ma subito viene impostato il numero
 * di corda
 */
				stmtDComparc.setLong(1, idComplesso);
				stmtDComparc.execute();
				rs = stmtDComparc.getResultSet();
				log.info("Istituto " + siglaIstituto + ", elaborazione complesso " + idComplesso + " (" + numComplesso++ + ")");

/*
 * È opportuno controllare che il resultset abbia delle righe e segnalare il caso contrario
 */

				if(rs.next())
				{
					dcomparcw = new DComparcWrapper();
					dcomparcw.setTextNumCorda((int) numCorda);
					temp = rs.getString("codi_provenienza");
					if(temp.length() == 0 || temp == null)
					{
						temp = siglaIstituto + "-F" + idComplesso;
						log.warn("Istituto " + siglaIstituto + ", complesso " + idComplesso
								+ ", codi_provenienza nullo o vuoto, sarà impostato a " + temp);
					}
					dcomparcw.setCodiProvenienza(temp);
					dcomparcw.setFkVocTipoComparc(rs.getLong("fk_voc_tipo_comparc"));
					dcomparcw.setFkVocTipoComparc(1);
					dcomparcw.setTextDenUniformata(rs.getString("text_den_uniformata"));

/*
 * Per evitare errori di validazione delle fonti, non tutte codificate correttamente negli XSD, si
 * usa una fonte fittizia sicuramente valida
 */

					if(fkFonte != null)
					{
						dcomparcw.setFkFonte(fkFonte);
					}
					else
					{
						dcomparcw.setFkFonte(rs.getString("fk_fonte"));
					}
					dcomparcw.setTextEstrCronoTestuali(rs.getString("text_estr_crono_testuali"));
					try
					{
						dcomparcw.setDateEstremoRemoto(rs.getString("date_estremo_remoto"));
						dcomparcw.setDateEstremoRecente(rs.getString("date_estremo_recente"));
					}
					catch(DatatypeConfigurationException e)
					{
						log.warn("Istituto " + siglaIstituto + ", complesso " + rs.getString("ID_ComplessoDoc") + "scartato: "
								+ e.getMessage());
						continue;
					}
					catch(IllegalArgumentException e)
					{
						log.warn("Istituto " + siglaIstituto + ", complesso " + rs.getString("ID_ComplessoDoc") + "scartato: "
								+ e.getMessage());
						continue;
					}
					// dcomparcw.setDComparcDatiConsistenza(rs
					// .getLong("dati_consistenza_nume_consistenza"));
					try
					{
						dcomparcw.setTextStoriaArchivistica(rs.getString("text_storia_archivistica"));
						dcomparcw.setTextUrl(rs.getString("text_url"));
						dcomparcw.setNumeMtLineariComplessivi(rs.getBigDecimal("nume_mt_lineari_complessivi"));
						dcomparcw.setNumeRipartoMtLineariSottolvl(rs.getBigDecimal("nume_riparto_mt_lineari_sottolvl"));
					}
					catch(IllegalArgumentException e)
					{
						log.warn("Istituto " + siglaIstituto + ", complesso " + rs.getString("ID_ComplessoDoc") + ": "
								+ e.getMessage());
					}
					catch(SiasSasException e)
					{
						log.warn("Istituto " + siglaIstituto + ", complesso " + rs.getString("ID_ComplessoDoc") + ": "
								+ e.getMessage());
					}

					log.info("Istituto " + siglaIstituto + ", complesso " + rs.getString("ID_ComplessoDoc"));

/*
 * Popoliamo le localizzazioni. Si usa ovviamente un'altra statement, ma si ricicla il resultset rs.
 * Le localizzazioni secondarie sono ripetibili, per cui si dovrà ciclare sul resultset,
 * diversamente da prima.
 */

					stmtDComparcAltreden.setLong(1, idComplesso);
					stmtDComparcAltreden.execute();
					rsad = stmtDComparcAltreden.getResultSet();
					// rsad.next();

					while(rsad.next())
					{
						dcomparcw.addAltraDen(rsad.getString("text_altreden"), rsad.getString("text_estr_crono_testuali"));
						log.info("Istituto " + siglaIstituto + ", complesso " + idComplesso + ", elaborata altra denominazione "
										+ rsad.getString("text_altreden"));
					}
					dwl.add(dcomparcw.getDComparc());
				}
				else
				{
					log.warn("Istituto " + siglaIstituto + ", complesso " + idComplesso + ", la query non ha prodotto risultati");
				}
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
