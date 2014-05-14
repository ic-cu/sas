package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.comparc.FkFonte;
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

public class InventariElettronici
{
	private Properties				config;
	private Properties				invProp;
	private Properties				fontiMap;
	private PreparedStatement	stmtInventari;
	private PreparedStatement	stmtDComparcUA;
	private PreparedStatement	stmtDComparcUD;
	private PreparedStatement	stmtDatiInventarialiPrimoLivello;
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
	private String						siglaIstituto;
	private int								numInventario;
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
			stmtDComparcUA = conn.prepareStatement(invProp.getProperty("q.dati.inventariali.dcomparc.ua"));
			stmtDComparcUD = conn.prepareStatement(invProp.getProperty("q.dati.inventariali.dcomparc.ud"));
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
		long idDatoInventariale;
		String codiProvenienza;
		EntityWrapper entw = null;

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

			try
			{
				while(rs.next())
				{
					idDatoInventariale = rs.getLong("ID_datoinventariale");
					tipo = rs.getInt("fk_voc_tipo_comparc");
					codiProvenienza = rs.getString("codi_provenienza");
					numCorda = rs.getLong("text_num_corda");
					switch(tipo)
					{
						case 10:
							entw = createEntityDComparcUA(idDatoInventariale, tipo, codiProvenienza, numCorda);
							break;
						case 13:
							entw = createEntityDComparcUD(idDatoInventariale, tipo, codiProvenienza, numCorda);
							break;
						case 17:
//							entw = createEntityDComparcUDSPXCartografie(idDatoInventariale, tipo, codiProvenienza, numCorda);
							break;
						default:
//							entw = createEntityDComparc(idDatoInventariale, tipo, codiProvenienza, numCorda);
							break;
					}
				}
			}
			catch(IllegalArgumentException e)
			{
				log.warn("Istituto " + siglaIstituto + " (" + idIstituto + "), argomento non ammesso: " + e.getMessage());
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			catch(DatatypeConfigurationException e)
			{
				log.warn("Istituto " + siglaIstituto + " (" + idIstituto + "), configurazione dati errata: " + e.getMessage());
			}
			if(entw != null)
			ewl.add(entw);
		}

/*
 * Finiti i complessi, si riporta al chiamante l'iteratore alla lista dei complessi
 */
		log.info("Istituto " + siglaIstituto + ", fine elaborazione");
		return ewl.iterator();
	}

	private EntityWrapper createEntityDComparcUDSPXCartografie(long idInventario, int tipo, String codiProvenienza, long numCorda)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private EntityWrapper createEntityDComparcUD(long idDatoInventariale, int tipo, String codiProvenienza, long numCorda) throws IllegalArgumentException, DatatypeConfigurationException
	{
		EntityWrapper entw = new EntityWrapper();
		DComparcUDWrapper	udw = new DComparcUDWrapper();
		try
		{
			stmtDComparcUD.setLong(1, idDatoInventariale);
			stmtDComparcUD.execute();
			rs = stmtDComparcUD.getResultSet();
			if(rs.next())
			{
				log.info("Istituto " + siglaIstituto + ", elaborazione unità documentale " + idDatoInventariale + " (" + numInventario++ + ")");
				udw.setFkVocTipoComparc(tipo);
				udw.setCodiProvenienza(codiProvenienza);
				udw.setTextNumCorda((int) numCorda);
				udw.setTextDenUniformata(rs.getString("text_den_uniformata"));
				udw.setTextDenCritica(rs.getString("text_den_uniformata"));
				udw.setFkVocTipoLinguaContenuto(rs.getLong("lingua"));
				udw.setFkVocStatoDescrizione(rs.getInt("fk_voc_stato_descrizione"));
				udw.setFlagComparcProprietaStatale(rs.getString("flag_comparc_proprieta_statale_tf"));
				udw.setFkFonte(rs.getString("fk_fonte"));
				/* qui andrebbe gestito "CoseNotevoli"... */
				udw.setTextEstrCronoTestuali(rs.getString("text_estr_crono_testuali"));
				udw.setDateEstremoRemoto(rs.getString("date_estremo_remoto"));
				udw.setDateEstremoRecente(rs.getString("date_estremo_recente"));
				udw.setTextNote(rs.getString("text_note_1"));
				udw.addTextNote(rs.getString("text_note_2"));
				udw.addTextNote(rs.getString("text_note_3"));
				udw.setTextStoriaArchivistica(rs.getString("text_storia_archivistica"));
				udw.setTextCriteriOrdinamento(rs.getString("text_criteri_ordinamento"));
				udw.setFlagConsultabileConservatore(rs.getInt("flag_consultabile_conservatore_tf"));
				udw.setTextLimitiConsultazione(rs.getString("text_limiti_consultazione"));
				udw.setTextModoRiproduzione(rs.getString("text_modo_riproduzione"));
				/* gestire "nume_consistenza" */
				/* gestire "consistenza" */
				udw.setFkVocStatoConservazione(rs.getLong("fk_voc_stato_conservazione"));
				udw.setTextAnticaSegnatura(rs.getString("text_antica_segnatura"));
				udw.setTextTitolareDiritti(rs.getString("text_titolare_diritti"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(SiasSasException e)
		{
			e.printStackTrace();
		}
		entw.setCodiProvenienza(codiProvenienza);
		entw.getContent().add(udw.getDComparc());
		return entw;
	}

	private EntityWrapper createEntityDComparcUA(long idDatoInventariale, int tipo, String codiProvenienza, long numCorda) throws IllegalArgumentException, DatatypeConfigurationException
	{
		EntityWrapper entw = new EntityWrapper();
		DComparcUAWrapper	uaw = new DComparcUAWrapper();
		try
		{
			stmtDComparcUA.setLong(1, idDatoInventariale);
			stmtDComparcUA.execute();
			rs = stmtDComparcUA.getResultSet();
			if(rs.next())
			{
				log.info("Istituto " + siglaIstituto + ", elaborazione unità archivistica " + idDatoInventariale + " (" + numInventario++ + ")");
				uaw.setFkVocTipoComparc(tipo);
				uaw.setCodiProvenienza(codiProvenienza);
				uaw.setTextNumCorda((int) numCorda);
				uaw.setTextDenUniformata(rs.getString("text_den_uniformata"));
				uaw.setTextDenCritica(rs.getString("text_den_uniformata"));
				uaw.setFkVocTipoLinguaContenuto(rs.getLong("lingua"));
				uaw.setFkVocStatoDescrizione(rs.getInt("fk_voc_stato_descrizione"));
				uaw.setFlagComparcProprietaStatale(rs.getString("flag_comparc_proprieta_statale_tf"));
				uaw.setFkFonte(rs.getString("fk_fonte"));
				/* qui andrebbe gestito "CoseNotevoli"... */
				uaw.setTextEstrCronoTestuali(rs.getString("text_estr_crono_testuali"));
				uaw.setDateEstremoRemoto(rs.getString("date_estremo_remoto"));
				uaw.setDateEstremoRecente(rs.getString("date_estremo_recente"));
				uaw.setTextNote(rs.getString("text_note_1"));
				uaw.addTextNote(rs.getString("text_note_2"));
				uaw.addTextNote(rs.getString("text_note_3"));
				uaw.setTextStoriaArchivistica(rs.getString("text_storia_archivistica"));
				uaw.setTextCriteriOrdinamento(rs.getString("text_criteri_ordinamento"));
				uaw.setFlagConsultabileConservatore(rs.getInt("flag_consultabile_conservatore_tf"));
				uaw.setTextLimitiConsultazione(rs.getString("text_limiti_consultazione"));
				uaw.setTextModoRiproduzione(rs.getString("text_modo_riproduzione"));
				/* gestire "nume_consistenza" */
				/* gestire "consistenza" */
				uaw.setFkVocStatoConservazione(rs.getLong("fk_voc_stato_conservazione"));
				uaw.setTextAnticaSegnatura(rs.getString("text_antica_segnatura"));
				uaw.setTextTitolareDiritti(rs.getString("text_titolare_diritti"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(SiasSasException e)
		{
			e.printStackTrace();
		}
		entw.setCodiProvenienza(codiProvenienza);
		entw.getContent().add(uaw.getDComparc());
		return entw;
	}

	private EntityWrapper createEntityDComparc(long idInventario, int tipo, String codiProvenienza, long numCorda)
	{
		EntityWrapper ent = new EntityWrapper();
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
