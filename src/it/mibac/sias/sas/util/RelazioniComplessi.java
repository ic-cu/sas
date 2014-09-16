package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.comparc.FkFonte;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.relazioni.CodiProvenienza;
import it.beniculturali.sas.catalogo.relazioni.DRelComparcComparc;
import it.beniculturali.sas.catalogo.relazioni.DRelComparcSogc;
import it.beniculturali.sas.catalogo.relazioni.Relazioni;
import it.beniculturali.sas.catalogo.relazioni.Relazioni.Dominante;

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

import org.apache.log4j.Logger;

public class RelazioniComplessi
{
	private Properties config;
	private Properties comparcProp;
	private Properties fontiMap;
	private PreparedStatement stmtDComparcPrimoLivello;
	private PreparedStatement stmtDComparcSottoLivelli;
	private PreparedStatement stmtIstituto;
	ResultSet rs, rsad;
	FkFonte fkf;
	String fkFonte = null;
	ProfGroup pg;
	private static Logger log;
	private Relazioni rel = null;
	private String siglaIstituto;
	private it.beniculturali.sas.catalogo.relazioni.ObjectFactory relObjF;

	/*
	 * Questo costruttore richiede solo una connessione (che non tocca a lui chiudere, attenzione) che
	 * usa solo per creare la preparedStatement, così è pronta per essere eseguita da altri metodi
	 */
	public RelazioniComplessi(Connection conn)
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
			conn.prepareStatement(comparcProp.getProperty("query.comparc"));
			conn.prepareStatement(comparcProp.getProperty("query.comparc.di"));
			stmtDComparcPrimoLivello = conn.prepareStatement(comparcProp.getProperty("query.comparc.pl.full"));
			stmtDComparcSottoLivelli = conn.prepareStatement(comparcProp.getProperty("query.comparc.sl.full"),
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			conn.prepareStatement(comparcProp.getProperty("query.comparc.altreden"));
			stmtIstituto = conn.prepareStatement(config.getProperty("query.istituto"), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			fkFonte = config.getProperty("sogc.fk_fonte");
			relObjF = new it.beniculturali.sas.catalogo.relazioni.ObjectFactory();
			log = Logger.getLogger("COMPARC");
			new ArrayList<Relazioni>();
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
 * Questo metodo estrae un iteratore di coppie (idComparc, codiProvenienza). Esso comincia dal primo
 * livello che è quello immediatamente legato ad un istituto il cui id è il parametro; poi invoca un
 * metodo ricorsivo che, per ogni complesso, estrae i suoi figli fino ad arrivare alle foglie,
 * sempre creando coppie (idComparc, codiProvenienza) che saranno accodate all'iteratore.
 */

	public Iterator<String[]> getComparcIterator(int idIstituto, String codiProvenienzaPadre)
	{
		ResultSet rs = null;
		ArrayList<String[]> al;
		al = new ArrayList<String[]>();
		String idComplesso;
		String codiProvenienza;
		String numFigli;
		rel = relObjF.createRelazioni();
		Dominante dom = relObjF.createRelazioniDominante();
		CodiProvenienza cp = relObjF.createCodiProvenienza();
		cp.setValue(codiProvenienzaPadre);
		dom.setCodiProvenienza(cp);
		rel.setDominante(dom);

		try
		{
			stmtDComparcPrimoLivello.setInt(1, idIstituto);
			rs = stmtDComparcPrimoLivello.executeQuery();
			while(rs.next())
			{
				idComplesso = rs.getString("idComplesso");
				codiProvenienza = rs.getString("codi_provenienza");
				numFigli = rs.getString("figli");
				al.add(new String[] { idComplesso, codiProvenienza, numFigli });
				log.info("Complesso " + idComplesso + ", codice provenienza " + codiProvenienza + ", figli " + numFigli);

// Arrivati a questo punto, abbiamo quello che serve per creare una relazione di un soggetto con
// tutti i suoi complessi di primo livello

				DRelComparcSogc drcs = relObjF.createDRelComparcSogc();
				drcs.setCodiProvenienzaSogc(codiProvenienzaPadre);
				drcs.setCodiProvenienzaComparc(codiProvenienza);
				rel.getDRelComparcSogc().add(drcs);

				if(Integer.parseInt(numFigli) > 0)
				{
					al.addAll(getSubComparcList(idComplesso, codiProvenienzaPadre));
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return al.iterator();
	}

	public ArrayList<String[]> getSubComparcList(String idComplesso, String codiProvenienzaPadre)
	{
		ArrayList<String[]> al;
		ArrayList<String[]> pl;
		Iterator<String[]> pli;
		al = new ArrayList<String[]>();
		pl = new ArrayList<String[]>();
		String[] la;
		String idFiglio, codiProvenienzaFiglio, numFigli;
		try
		{
			ResultSet rs = null;
			stmtDComparcSottoLivelli.setLong(1, Integer.parseInt(idComplesso));
			rs = stmtDComparcSottoLivelli.executeQuery();
			log.info("Figli del complesso " + idComplesso);

			// Cicliamo sui figli di questo complesso

			while(rs.next())
			{
				idFiglio = rs.getString("idFiglio");
				codiProvenienzaFiglio = rs.getString("codi_provenienza");
				numFigli = rs.getString("figli");

/*
 * Aggiunge alla lista globale dei complessi questo figlio, ma se esso stesso ha dei figli, lo
 * aggiunge ad una lista locale di padri che sarà scandita dopo la fine del result set
 */
				log.info("Complesso " + idFiglio + ", codice provenienza " + codiProvenienzaFiglio + ", figli " + numFigli);
				al.add(new String[] { idFiglio, codiProvenienzaPadre, codiProvenienzaFiglio, numFigli });
				if(Integer.parseInt(numFigli) > 0) pl.add(new String[] { idFiglio, codiProvenienzaFiglio, numFigli });
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
				codiProvenienzaFiglio = la[1];
				numFigli = la[2];
				al.addAll(getSubComparcList(idFiglio, codiProvenienzaFiglio));
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
	public Iterator<Relazioni> createEntity(int idIstituto)
	{
		ArrayList<Relazioni> rl = null;
		Relazioni rel = null;
		Dominante dominante = null;
		CodiProvenienza codiProvenienzaDominante = null;
		DRelComparcSogc drcs = null;
		Iterator<String[]> idComplessi;
		String[] tripla;
		String codiProvenienzaSogc = null, codiProvenienzaComparc;

// si istanzia una lista di Relazioni in senso SAS. Nella lista ci sarà un oggetto Relazioni
// contenente una lista di oggetti DRelComparcSogc, e poi tanti oggetti Relazioni, solo con liste di
// oggetti DRelComparcComparc, per ciascun Comparc figlio di questo istituto. Si istanziano anche le
// liste di relazioni ComparcSogc e ComparcComparc

		rl = new ArrayList<Relazioni>();
		new ArrayList<DRelComparcSogc>();
		new ArrayList<DRelComparcComparc>();

/*
 * Una prima query serve a reperire informazioni minimali circa un istituto, fra cui il
 * codi_provenienza necessario a costruire correttamente le relazioni
 */

		try
		{
			stmtIstituto.setInt(1, idIstituto);
			stmtIstituto.execute();
			rs = stmtIstituto.getResultSet();
			rs.next();
			siglaIstituto = rs.getString("fk_fonte");
			codiProvenienzaSogc = fontiMap.getProperty(siglaIstituto);
		}
		catch(SQLException e)
		{
			log.warn("Istituto " + siglaIstituto + " (" + idIstituto + ") scartato: " + e.getMessage());
		}
		log.info("Istituto " + siglaIstituto + ", inizio elaborazione");

// Le prime relazioni da considerare sono comparc_sogc, in cui il dominante è il comparc, non il
// sogc come si potrebbe pensare. E siccome ogni comparc ha un solo sogc padre, per ogni comparc di
// primo livello andrà creata una relazione con una lista opportuna contenente un unico elemento.
// Si ricava quindi l'iteratore sull'elenco di tutti gli id dei complessi legati a questo istituto,
// ciascuno con un "codiProvenienza", poi si cicla sull'iteratore
		
		idComplessi = getComparcIterator(idIstituto, codiProvenienzaSogc);
		while(idComplessi.hasNext())
		{
			tripla = idComplessi.next();
			codiProvenienzaComparc = tripla[1];
			log.info("Istituto " + siglaIstituto + ", collego complesso " + codiProvenienzaComparc);
			rel = relObjF.createRelazioni();
			drcs = relObjF.createDRelComparcSogc();
			drcs.setCodiProvenienzaComparc(codiProvenienzaComparc);
			drcs.setCodiProvenienzaSogc(codiProvenienzaSogc);
			dominante = relObjF.createRelazioniDominante();
			codiProvenienzaDominante = relObjF.createCodiProvenienza();
			codiProvenienzaDominante.setValue(codiProvenienzaComparc);
			codiProvenienzaDominante.setTipologia("d_comparc");
			dominante.setCodiProvenienza(codiProvenienzaDominante);
			rel.getDRelComparcSogc().add(drcs);
			rel.setDominante(dominante);
			rel.setRelazione("d_rel_comparc_sogc");
			rl.add(rel);
		}

/*
 * Finiti i complessi, si riporta al chiamante l'iteratore alla lista dei complessi
 */
		log.info("Istituto " + siglaIstituto + ", fine elaborazione");
		return rl.iterator();
	}
}
