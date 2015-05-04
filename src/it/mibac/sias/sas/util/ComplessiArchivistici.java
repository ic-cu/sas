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

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class ComplessiArchivistici
{
	private Properties config;
	private Properties comparcProp;
	private Properties fontiMap;
	private PreparedStatement stmtDComparc;
	private PreparedStatement stmtDComparcFusioneDI;
	private PreparedStatement stmtDComparcPrimoLivello;
	private PreparedStatement stmtDComparcSottoLivelli;
	private PreparedStatement stmtDComparcConsistenza;
	private PreparedStatement stmtDComparcAltreden;
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
	private DComparcWrapper dw;
	private String siglaIstituto;
	private int numComplesso;

	/*
	 * Questo costruttore richiede solo una connessione (che non tocca a lui chiudere, attenzione) che
	 * usa solo per creare la preparedStatement, così è pronta per essere eseguita da altri metodi
	 */
	public ComplessiArchivistici(Connection conn)
	{
		config = new Properties();
		comparcProp = new Properties();
		fontiMap = new Properties();
		try
		{
			FileReader prop = new FileReader("query.prop");
			config.load(prop);
			prop.close();
			prop = new FileReader("fonti.map");
			fontiMap.load(prop);
			prop.close();
			prop = new FileReader("comparc.prop");
			comparcProp.load(prop);
			prop.close();
			new it.beniculturali.sas.catalogo.commons.ObjectFactory();
			stmtDComparc = conn.prepareStatement(comparcProp.getProperty("query.comparc"));
			stmtDComparcFusioneDI = conn.prepareStatement(comparcProp.getProperty("query.comparc.di"));
			stmtDComparcPrimoLivello = conn.prepareStatement(comparcProp.getProperty("query.comparc.pl"));
			stmtDComparcSottoLivelli = conn.prepareStatement(comparcProp.getProperty("query.comparc.sl"),
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			stmtDComparcAltreden = conn.prepareStatement(comparcProp.getProperty("query.comparc.altreden"));
			stmtDComparcConsistenza = conn.prepareStatement(comparcProp.getProperty("query.comparc.dati_consistenza"));
			stmtIstituto = conn.prepareStatement(config.getProperty("query.istituto"), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			fkFonte = config.getProperty("sogc.fk_fonte");
			log = Logger.getLogger("LOG");
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

	private void popolaDComparc(long idComplesso, long numCorda)
			throws SQLException, IllegalArgumentException, DatatypeConfigurationException
	{
		String temp;

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
 * È opportuno controllare che il resultset abbia delle righe e segnalare il caso contrario. Ma
 * anche in caso positivo va considerato subito il caso di codi_provenienza nullo, nel qual caso si
 * rimedia usando la siglaIstituto per costruire un codi_provenienza plausibile, ovviamente
 * segnalando la cosa
 */

		if(rs.next())
		{
			dw.setTextNumCorda((int) numCorda);
			temp = rs.getString("codi_provenienza");
			if(temp.length() == 0 || temp == null)
			{
				temp = siglaIstituto + "-F" + idComplesso;
				log.warn("Istituto " + siglaIstituto + ", complesso " + idComplesso
						+ ", codi_provenienza nullo o vuoto, sarà impostato a " + temp);
			}
			dw.setCodiProvenienza(temp);
			try
			{
				dw.setFkVocTipoComparc(rs.getLong("fk_voc_tipo_comparc"));
			}
			catch(SiasSasException e)
			{
				log.warn("Istituto " + siglaIstituto + ", complesso " + idComplesso + ": " + e.getMessage());
			}
			dw.setTextDenUniformata(rs.getString("text_den_uniformata"));
			dw.setFkVocStatoDescrizione(rs.getInt("fk_voc_stato_descrizione"));
			dw.setFlagComparcProprietaStatale(rs.getString("flag_comparc_proprieta_statale_tf"));

/*
 * Per evitare errori di validazione delle fonti, non tutte codificate correttamente negli XSD, si
 * usa una fonte fittizia sicuramente valida, presa dal file di configurazione, e solo se questa è
 * valorizzata
 */

			try
			{
				if(fkFonte != null)
				{
					dw.setFkFonte(fkFonte);
				}
				else
				{
					dw.setFkFonte(fontiMap.getProperty(rs.getString("fk_fonte")));
				}
			}
			catch(SiasSasException e)
			{
				log.warn("Istituto " + siglaIstituto + ", complesso " + idComplesso + ": " + e.getMessage());
			}

			dw.setTextEstrCronoTestuali(rs.getString("text_estr_crono_testuali"));
			dw.setTextNoteData(rs.getString("text_note_data"));
			dw.setDateEstremoRemoto(rs.getString("date_estremo_remoto"));
			dw.setDateEstremoRecente(rs.getString("date_estremo_recente"));
			dw.setTextStoriaArchivistica(rs.getString("text_storia_archivistica"));
			dw.setTextNote(rs.getString("text_note_1"));
			dw.addTextNote(rs.getString("text_note_2"));
			dw.setTextUrl(rs.getString("text_url"));
			dw.setNumeMtLineariComplessivi(rs.getBigDecimal("nume_mt_lineari_complessivi"));
			dw.setNumeRipartoMtLineariSottolvl(rs.getBigDecimal("nume_riparto_mt_lineari_sottolvl"));
			dw.setFlagConsultabileConservatore(rs.getInt("flag_consultabile_conservatore_tf"));
			dw.setTextTitolareDiritti(rs.getString("text_titolare_diritti"));

			log.info("Istituto " + siglaIstituto + ", complesso " + rs.getString("ID_ComplessoDoc"));
		}
		else
		{
			log.warn("Istituto " + siglaIstituto + ", complesso " + idComplesso + ", la query non ha prodotto risultati");
		}

	}

/*
 * Questo metodo si occupa di reperire un eventuale sottolivello inventario che può essere usato per
 * integrare i dati di questo comparc. Si assume che la query riporti al più una riga. I metodi del
 * wrapper invocati andranno in sovrascrittura di eventuali dati già creati da popolaDComparc.
 */

	private void popolaDatiInventariali(long idComplesso)
			throws SQLException, IllegalArgumentException, DatatypeConfigurationException
	{
		stmtDComparcFusioneDI.setLong(1, idComplesso);
		stmtDComparcFusioneDI.execute();
		ResultSet rs;
		rs = stmtDComparcFusioneDI.getResultSet();
		if(rs.next())
		{
			try
			{
				dw.setFkVocTipoComparc(rs.getInt("fk_voc_tipo_comparc"));
			}
			catch(SiasSasException e)
			{
				log.warn("Istituto " + siglaIstituto + ", complesso " + idComplesso + ": " + e.getMessage());
			}
			dw.setAltreCronTextEstrCronoTestuali(rs.getString("text_estr_crono_testuali"));
			dw.setDateEstremoRemoto(rs.getString("date_estremo_remoto"));
			dw.setDateEstremoRecente(rs.getString("date_estremo_recente"));
			dw.setTextNote(rs.getString("text_note_1"));
			dw.addTextNote(" " + rs.getString("text_note_2"));
			dw.addTextNote(" " + rs.getString("text_note_3"));
			dw.addTextNote(" " + rs.getString("text_note_4"));
			dw.setTextCriteriOrdinamento(rs.getString("text_criteri_ordinamento"));
			dw.setFlagConsultabileConservatore(rs.getInt("flag_consultabile_conservatore_tf"));
			dw.setTextLimitiConsultazione(rs.getString("text_limiti_consultazione"));
			dw.setTextModoRiproduzione(rs.getString("text_modo_riproduzione"));
			dw.setTextAnticaSegnatura(rs.getString("text_antica_segnatura"));
			log.info("Istituto " + siglaIstituto + ", complesso " + idComplesso + ", elaborati dati inventariali");
		}
	}

	private void popolaConsistenza(long idComplesso) throws SQLException
	{
		stmtDComparcConsistenza.setLong(1, idComplesso);
		stmtDComparcConsistenza.execute();
		ResultSet rs;
		rs = stmtDComparcConsistenza.getResultSet();
		while(rs.next())
		{
			dw.addDatiConsistenza(rs.getBigDecimal("nume_consistenza"), rs.getLong("tipi_oggetti_cons"),
					rs.getString("text_note"));
			log.info("Istituto " + siglaIstituto + ", complesso " + idComplesso + ", elaborata consistenza "
					+ rs.getBigDecimal("nume_consistenza"));
		}

	}

	private void popolaAltreDen(long idComplesso) throws SQLException
	{
		stmtDComparcAltreden.setLong(1, idComplesso);
		stmtDComparcAltreden.execute();
		ResultSet rs;
		rs = stmtDComparcAltreden.getResultSet();
		while(rs.next())
		{
			String t = rs.getString("text_altreden");
			if(t != null && t.length() > 1)
			{
				dw.addAltraDen(t, rs.getString("text_estr_crono_testuali"));
				log.info("Istituto " + siglaIstituto + ", complesso " + idComplesso + ", elaborata altra denominazione " + t);
			}
			else
			{
				log.error("Istituto " + siglaIstituto + ", complesso " + idComplesso + ", altra denominazione non significativa " + t);
			}
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
		ArrayList<DComparc> dwl = null;
		Iterator<long[]> idComplessi;
		dwl = new ArrayList<DComparc>();
		long idComplesso, numCorda;
		long[] coppia;

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
 * Si ricava l'iteratore sull'elenco di tutti gli id dei complessi legati a questo istituto,
 * ciascuno con un "numero di corda" da usare per l'ordinamento, poi si cicla sull'iteratore
 */

		idComplessi = getComparcIterator(idIstituto);
		while(idComplessi.hasNext())
		{
			coppia = idComplessi.next();
			idComplesso = coppia[0];
			numCorda = coppia[1];
			dw = new DComparcWrapper();

/*
 * Si popola prima la gran parte degli elementi del d_comparc, poi le altre denominazioni.
 */

			try
			{
				popolaDComparc(idComplesso, numCorda);
				popolaConsistenza(idComplesso);
				popolaAltreDen(idComplesso);
				popolaDatiInventariali(idComplesso);
			}
			catch(IllegalArgumentException e)
			{
				log.warn("Istituto " + siglaIstituto + ", complesso " + idComplesso + "scartato: " + e.getMessage());
				continue;
			}
			catch(DatatypeConfigurationException e)
			{
				log.warn("Istituto " + siglaIstituto + ", complesso " + idComplesso + "scartato: " + e.getMessage());
				continue;
			}
			catch(SQLServerException e)
			{
				log.warn("Istituto " + siglaIstituto + ", complesso " + idComplesso + ": " + e.getMessage());
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}

/*
 * Si può aggiungere il complesso attuale alla relatia lista e ricominciare col prossimo
 */
			dwl.add(dw.getDComparc());
		}

/*
 * Finiti i complessi, si riporta al chiamante l'iteratore alla lista dei complessi
 */
		log.info("Istituto " + siglaIstituto + ", fine elaborazione");
		return dwl.iterator();
	}
}
