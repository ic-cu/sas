package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.comparc.FkFonte;
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
	private Properties config;
	private Properties invProp;
	private Properties fontiMap;
	private PreparedStatement stmtInventari;
	private PreparedStatement stmtDComparcUA;
	private PreparedStatement stmtDComparcUD;
	private PreparedStatement stmtDatiInventarialiPrimoLivello;
	private PreparedStatement stmtIstituto;
	ResultSet rs, rsad;
	FkFonte fkf;
	String fkFonte = null;
	ProfGroup pg;
	private static Logger log;

/*
 * Questi campi sono usati da diversi metodi per evitare un complesso e inutile passaggio di
 * informazioni sostanzialmente condivise. Altri dati invece restano parametri dei singoli metodi
 */
	private String siglaIstituto;
	private int numInventario;

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
		new it.beniculturali.sas.catalogo.comparc.ObjectFactory();
		new it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory();
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
 * Questo metodo fornisce un iterator di EntityWrapper legate ad un istituto. Sarà cura del
 * chiamante gestire questa lista. Il contenuto delle EntityWrapper può variare molto. Anzi, è
 * proprio per questo che non basta un iterator di Entity, perché le Entity possibili sono quattro e
 * incompatibili fra loro
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
						case 1700:
							entw = createEntityDComparcUDSPXCartografie(idDatoInventariale, tipo, codiProvenienza, numCorda);
							break;
						default:
							entw = createEntityDComparc(idDatoInventariale, tipo, codiProvenienza, numCorda);
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
			if(entw != null) ewl.add(entw);
		}

/*
 * Finiti i complessi, si riporta al chiamante l'iteratore alla lista dei complessi
 */
		log.info("Istituto " + siglaIstituto + ", fine elaborazione");
		return ewl.iterator();
	}

	private EntityWrapper createEntityDComparcUDSPXCartografie(long idInventario, int tipo, String codiProvenienza,
			long numCorda)
	{
		// TODO Auto-generated method stub
		return null;
	}

/*
 * Metodo per produrre una EntityWrapper contenente un DComparcUD. Sarebbe opportuno indagare sul
 * fatto che è impossibile distinguere questo codice da quello che finisce in UA, ovviamente perché
 * anche le query sono indistinguibili.
 */
	private EntityWrapper createEntityDComparcUD(long idDatoInventariale, int tipo, String codiProvenienza, long numCorda)
			throws IllegalArgumentException, DatatypeConfigurationException
	{
		EntityWrapper entw = new EntityWrapper();
		DComparcUDWrapper dudw = new DComparcUDWrapper();
		try
		{
			stmtDComparcUD.setLong(1, idDatoInventariale);
			stmtDComparcUD.execute();
			rs = stmtDComparcUD.getResultSet();
			if(rs.next())
			{
				log.info("Istituto " + siglaIstituto + ", elaborazione unità documentale " + idDatoInventariale + " ("
						+ numInventario++ + ")");
				dudw.setFkVocTipoComparc(tipo);
				dudw.setCodiProvenienza(codiProvenienza);
				dudw.setTextNumCorda((int) numCorda);
				dudw.setTextDenUniformata(rs.getString("text_den_uniformata"));
				dudw.setTextDenCritica(rs.getString("text_den_uniformata"));
				dudw.setFkVocTipoLinguaContenuto(rs.getLong("lingua"));
				dudw.setFkVocStatoDescrizione(rs.getInt("fk_voc_stato_descrizione"));
				dudw.setFlagComparcProprietaStatale(rs.getString("flag_comparc_proprieta_statale_tf"));
				dudw.setFkFonte(rs.getString("fk_fonte"));
				/* qui andrebbe gestito "CoseNotevoli"... */
				dudw.setTextEstrCronoTestuali(rs.getString("text_estr_crono_testuali"));
				dudw.setDateEstremoRemoto(rs.getString("date_estremo_remoto"));
				dudw.setDateEstremoRecente(rs.getString("date_estremo_recente"));
				dudw.setTextNote(rs.getString("text_note_1"));
				dudw.addTextNote(rs.getString("text_note_2"));
				dudw.addTextNote(rs.getString("text_note_3"));
				dudw.setTextStoriaArchivistica(rs.getString("text_storia_archivistica"));
				dudw.setTextCriteriOrdinamento(rs.getString("text_criteri_ordinamento"));
				dudw.setFlagConsultabileConservatore(rs.getInt("flag_consultabile_conservatore_tf"));
				dudw.setTextLimitiConsultazione(rs.getString("text_limiti_consultazione"));
				dudw.setTextModoRiproduzione(rs.getString("text_modo_riproduzione"));
				/* gestire "nume_consistenza" */
				/* gestire "consistenza" */
				dudw.setFkVocStatoConservazione(rs.getLong("fk_voc_stato_conservazione"));
				dudw.setTextAnticaSegnatura(rs.getString("text_antica_segnatura"));
				dudw.setTextTitolareDiritti(rs.getString("text_titolare_diritti"));
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
		entw.getContent().add(dudw.getDComparc());
		return entw;
	}

	private EntityWrapper createEntityDComparcUA(long idDatoInventariale, int tipo, String codiProvenienza, long numCorda)
			throws IllegalArgumentException, DatatypeConfigurationException
	{
		EntityWrapper entw = new EntityWrapper();
		DComparcUAWrapper duaw = new DComparcUAWrapper();
		try
		{
			stmtDComparcUA.setLong(1, idDatoInventariale);
			stmtDComparcUA.execute();
			rs = stmtDComparcUA.getResultSet();
			if(rs.next())
			{
				log.info("Istituto " + siglaIstituto + ", elaborazione unità archivistica " + idDatoInventariale + " ("
						+ numInventario++ + ")");
				duaw.setFkVocTipoComparc(tipo);
				duaw.setCodiProvenienza(codiProvenienza);
				duaw.setTextNumCorda((int) numCorda);
				duaw.setTextDenUniformata(rs.getString("text_den_uniformata"));
				duaw.setTextDenCritica(rs.getString("text_den_uniformata"));
				duaw.setFkVocTipoLinguaContenuto(rs.getLong("lingua"));
				duaw.setFkVocStatoDescrizione(rs.getInt("fk_voc_stato_descrizione"));
				duaw.setFlagComparcProprietaStatale(rs.getString("flag_comparc_proprieta_statale_tf"));
				duaw.setFkFonte(rs.getString("fk_fonte"));
				/* qui andrebbe gestito "CoseNotevoli"... */
				duaw.setTextEstrCronoTestuali(rs.getString("text_estr_crono_testuali"));
				duaw.setDateEstremoRemoto(rs.getString("date_estremo_remoto"));
				duaw.setDateEstremoRecente(rs.getString("date_estremo_recente"));
				duaw.setTextNote(rs.getString("text_note_1"));
				duaw.addTextNote(rs.getString("text_note_2"));
				duaw.addTextNote(rs.getString("text_note_3"));
				duaw.setTextStoriaArchivistica(rs.getString("text_storia_archivistica"));
				duaw.setTextCriteriOrdinamento(rs.getString("text_criteri_ordinamento"));
				duaw.setFlagConsultabileConservatore(rs.getInt("flag_consultabile_conservatore_tf"));
				duaw.setTextLimitiConsultazione(rs.getString("text_limiti_consultazione"));
				duaw.setTextModoRiproduzione(rs.getString("text_modo_riproduzione"));
				/* gestire "nume_consistenza" */
				/* gestire "consistenza" */
				duaw.setFkVocStatoConservazione(rs.getLong("fk_voc_stato_conservazione"));
				duaw.setTextAnticaSegnatura(rs.getString("text_antica_segnatura"));
				duaw.setTextTitolareDiritti(rs.getString("text_titolare_diritti"));
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
		entw.getContent().add(duaw.getDComparc());
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
