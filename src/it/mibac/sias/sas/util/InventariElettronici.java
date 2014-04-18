package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.comparc.DComparc;
import it.beniculturali.sas.catalogo.comparc.FkFonte;
import it.beniculturali.sas.catalogo.comparc.ObjectFactory;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordBody.Entity;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.log4j.Logger;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class InventariElettronici
{
	private Properties				config;
	private Properties				invProp;
	private Properties				fontiMap;
	private PreparedStatement	stmtInventari;
	private PreparedStatement	stmtDComparcFusioneDI;
	private PreparedStatement	stmtDatiInventarialiPrimoLivello;
	private PreparedStatement	stmtDComparcSottoLivelli;
	private PreparedStatement	stmtDComparcAltreden;
	private PreparedStatement	stmtIstituto;
	ResultSet									rs, rsad;
	FkFonte										fkf;
	String										fkFonte	= null;
	ProfGroup									pg;
	private static Logger			log;

/*
 * Questi campi sono usati da diversi metodi per evitare un complesso e inutile passaggio di
 * informazioni sostanzialmente condivise. Altri dati invece restano parametri dei singoli metodi
 */
	private DComparcWrapper		dw;
	private String						siglaIstituto;
	private int								numComplesso;
	private it.beniculturali.sas.catalogo.comparc.ObjectFactory 		comparcObjF;
	private it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory envelopeObjF;

	/*
	 * Questo costruttore richiede solo una connessione (che non tocca a lui chiudere, attenzione) che
	 * usa solo per creare la preparedStatement, così è pronta per essere eseguita da altri metodi
	 */
	public InventariElettronici(Connection conn)
	{
		config = new Properties();
		invProp = new Properties();
		fontiMap = new Properties();
		try
		{
			FileReader prop = new FileReader("query.prop");
			config.load(prop);
			prop.close();
			prop = new FileReader("fonti.map");
			fontiMap.load(prop);
			prop.close();
			prop = new FileReader("inventari.prop");
			invProp.load(prop);
			prop.close();
			stmtIstituto = conn.prepareStatement(config.getProperty("query.istituto"));
			stmtInventari = conn.prepareStatement(invProp.getProperty("q.inventari"));
			stmtDatiInventarialiPrimoLivello = conn.prepareStatement(invProp.getProperty("q.dati.inventariali.pl"));

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
		comparcObjF = new it.beniculturali.sas.catalogo.comparc.ObjectFactory();
		envelopeObjF = new it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory();
	}

	private Iterator<BigInteger> getInventari(int idIstituto)
	{
		log.info("Istituto " + siglaIstituto + ", estrazione eventuali inventari");
		ArrayList<BigInteger> inv = new ArrayList<BigInteger>();
		try
		{
			stmtInventari.setLong(1, idIstituto);
			stmtInventari.execute();
			rs = stmtInventari.getResultSet();
			while(rs.next())
			{
				log.info("Istituto " + siglaIstituto + ", estrazione inventario " + rs.getString(2));
				inv.add(new BigInteger(rs.getString(2)));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return inv.iterator();
	}

/*
 * Questo metodo fornisce un iterator di Entity legate ad un istituto. Sarà cura del chiamante
 * gestire questa lista. Il contenuto delle Entity può variare molto.
 */
	public Iterator<EntityWrapper> createEntity(int idIstituto)
	{
		ArrayList<EntityWrapper> ewl = null;
		Iterator<BigInteger> idInventari;
		ewl = new ArrayList<EntityWrapper>();
		long idInventario, numCorda;
		int tipo;
		String codiProvenienza;

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
		}
		catch(SQLException e)
		{
			log.warn("Istituto " + siglaIstituto + " (" + idIstituto + ") scartato: " + e.getMessage());
		}
		log.info("Istituto " + siglaIstituto + ", inizio elaborazione");

/*
 * Si ricava l'iteratore sull'elenco di tutti gli id degli inventari legati a questo istituto,
 * ciascuno con un "numero di corda" da usare per l'ordinamento, poi si cicla sull'iteratore
 */

		idInventari = getInventari(idIstituto);
		while(idInventari.hasNext())
		{
			idInventario = idInventari.next().longValue();
			log.info("Istituto " + siglaIstituto + ", elaborazione inventario " + idInventario);
			try
			{
				stmtDatiInventarialiPrimoLivello.setLong(1, idInventario);
				stmtDatiInventarialiPrimoLivello.execute();
				rs = stmtDatiInventarialiPrimoLivello.getResultSet();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}

			Entity ent = null;
			try
			{
				while(rs.next())
				{
					tipo = rs.getInt("fk_voc_tipo_comparc");
					codiProvenienza = rs.getString("codi_provenienza");
					numCorda = rs.getLong("text_num_corda");
					switch(tipo)
					{
						case 10:
							ent = createEntityDComparcUA(idInventario, tipo, codiProvenienza, numCorda);
							break;
						case 13:
							ent = createEntityDComparcUD(idInventario, tipo, codiProvenienza, numCorda);
							break;
						case 17:
							ent = createEntityDComparcUDSPXCartografie(idInventario, tipo, codiProvenienza, numCorda);
							break;
						default:
							ent = createEntityDComparc(idInventario, tipo, codiProvenienza, numCorda);
							break;
					}
				}
			}
			catch(Exception e)
			{
				// TODO: handle exception
			}
			ewl.add(ent);
		}

/*
 * Finiti i complessi, si riporta al chiamante l'iteratore alla lista dei complessi
 */
		log.info("Istituto " + siglaIstituto + ", fine elaborazione");
		return ewl.iterator();
	}

	private Entity createEntityDComparcUDSPXCartografie(long idInventario, int tipo, String codiProvenienza, long numCorda)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private Entity createEntityDComparcUD(long idInventario, int tipo, String codiProvenienza, long numCorda)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private Entity createEntityDComparcUA(long idInventario, int tipo, String codiProvenienza, long numCorda)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private Entity createEntityDComparc(long idInventario, int tipo, String codiProvenienza, long numCorda)
	{
		Entity ent = envelopeObjF.createEnvelopeRecordListRecordRecordBodyEntity();
		DComparcWrapper dw = new DComparcWrapper();
		try
		{
			dw.setFkVocTipoComparc(tipo);
		}
		catch(SiasSasException e)
		{
			e.printStackTrace();
		}
		dw.setCodiProvenienza(codiProvenienza);
		dw.setTextNumCorda((int) numCorda);
		ent.getContent().add(dw.getDComparc());
		return ent;
	}
}
