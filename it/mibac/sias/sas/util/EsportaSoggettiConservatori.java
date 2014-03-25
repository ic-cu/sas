package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.depositi.DDepositi;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordBody.Entity;
import it.beniculturali.sas.catalogo.relazioni.CodiProvenienza;
import it.beniculturali.sas.catalogo.relazioni.DRelSogcDepositi;
import it.beniculturali.sas.catalogo.relazioni.ObjectFactory;
import it.beniculturali.sas.catalogo.relazioni.Relazioni;
import it.beniculturali.sas.catalogo.relazioni.Relazioni.Dominante;
import it.beniculturali.sas.catalogo.sogc.DSogc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;

public class EsportaSoggettiConservatori
{

	public Connection					connection;
	private DB								db;
	private Properties				config;
	private Properties				fontiMap;
	private PreparedStatement	stmtIstituti;
	public static Logger			log, valLog;
	private static String			logLayout	= "%05r %p %C{1}.%M - %m%n";
	String										fkFonte		= null;

	// private static PatternLayout pl;

	/*
	 * Questo costruttore prepara la connessione, impostando qualche parametro. Sarebbe opportuno
	 * esternalizzare i parametri.
	 */
	public EsportaSoggettiConservatori()
	{
		try
		{
			db = new DB();

			// logger generico
			log = Logger.getLogger("SOGC");
			log.setLevel(Level.INFO);
			PatternLayout pl = new PatternLayout(logLayout);
			File lf = new File("log");
			PrintWriter pw = new PrintWriter(lf);
			WriterAppender wa = new WriterAppender(pl, pw);
			log.addAppender(wa);
			wa = new WriterAppender(pl, System.out);
			log.addAppender(wa);
			// BasicConfigurator.configure(wa);

			// serve un logger per la validazione
			valLog = Logger.getLogger("VALIDATE");
			pl = new PatternLayout("%m%n");
			lf = new File("validate.log");
			pw = new PrintWriter(lf);
			wa = new WriterAppender(pl, pw);
			valLog.addAppender(wa);
			wa = new WriterAppender(pl, System.out);
			valLog.addAppender(wa);
			// BasicConfigurator.configure(wa);

			config = new Properties();
			fontiMap = new Properties();
			connection = db.getConnection();
			config.load(new FileReader(new File("query.prop")));
			fontiMap.load(new FileReader(new File("fonti.map")));
			stmtIstituti = connection.prepareStatement(config.getProperty("query.istituti"),
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			log.info("Inizio esportazione soggetti conservatori");
			fkFonte = config.getProperty("sogc.fk_fonte");
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

	public static XMLGregorianCalendar now()
	{
		// È frequente l'uso di XMLGregorianCalendar, così macchinoso da rendere
		// sicuramente auspicabile la creazione di metodi ausiliari opportuni

		GregorianCalendar gc = new GregorianCalendar();
		XMLGregorianCalendar xgc = null;
		try
		{
			xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		}
		catch(DatatypeConfigurationException e)
		{
			e.printStackTrace();
		}
		return xgc;
	}

	/*
	 * Crea un envelope contenente tutto quello che può dei soggetti conservatori
	 */
	public EnvelopeWrapper creaEnvelope()
	{
		int idIstituto;
		RecordList rl = null;
		it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory envObf;
		envObf = new it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory();
		rl = envObf.createEnvelopeRecordList();

		String codiProvenienzaDeposito = null;

		/*
		 * Si costruisce pezzo pezzo l'envelope, per ora sensato solo nel record vero e proprio.
		 * Cerchiamo di usare sempre le objectFactory opportune, anche se questo comporta il ricorso a
		 * FQDN di lunghezza disarmante
		 */
		EnvelopeWrapper ew = new EnvelopeWrapper();

		ew.setCREATED(EsportaSoggettiConservatori.now().toGregorianCalendar().getTime());
		ew.setSource("SIAS");
		ew.setFonte("ARCHIVI_DI_STATO");

		try
		{
			stmtIstituti.execute();
			ResultSet rs = stmtIstituti.getResultSet();
			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();
			int max = 1000;
			log.info("Estratti " + rows + " id di istituti, ne saranno lavorati " + max);
			while(rs.next() && (max-- > 0))
			{

				idIstituto = rs.getInt("ID_Istituto");
				/*
				 * Si crea una entity in cui metteremo un sogc. Più avanti la entity sarà aggiunta alla
				 * recordlist
				 */
				Entity ent = envObf.createEnvelopeRecordListRecordRecordBodyEntity();
				// più avanti serve anche una Relazioni
				it.beniculturali.sas.catalogo.relazioni.ObjectFactory relObf;
				relObf = new ObjectFactory();
				Relazioni rel = relObf.createRelazioni();
				SoggettiConservatori sc = new SoggettiConservatori(db.getConnection());
				DSogc dsogc = sc.createEntity(idIstituto);

				/*
				 * Il codi_provenienza del dsogc va messo via in un oggetto Dominante che poi servirà nella
				 * relazione. C'è qualche dubbio sulla tipologia.
				 */

				Dominante dominante;
				dominante = relObf.createRelazioniDominante();
				CodiProvenienza codiProvenienzaDominante;
				codiProvenienzaDominante = relObf.createCodiProvenienza();
				codiProvenienzaDominante.setValue(dsogc.getCodiProvenienza());
				codiProvenienzaDominante.setTipologia("d_sogc");
				dominante.setCodiProvenienza(codiProvenienzaDominante);
				rel.setDominante(dominante);

				// Finalmente si aggiunge il dsogc alla entity
				ent.getContent().add(dsogc); // ancona
				/*
				 * Ora la entity col sogc è pronta. Possiamo aggiungerla a un recordbody, che si aggiunge a
				 * un record, che si aggiunge a una recordlist, che si aggiunge all'envelope, più facile di
				 * così... Si parte da un recordheader, ovviamente
				 */

				RecordWrapper rw = new RecordWrapper();
				rw.setDIRECTIVE("UPSERT");
				rw.setRecordIdentifier(dsogc.getCodiProvenienza());
				// rw.setRecordIdentifier("" + idIstituto);
				rw.setRecordDatestamp();
				rw.setEntity(ent);
/*
 * Si crea la recordlist cui si aggiunge il record, e che poi si aggiunge a sua volta all'envelope
 */

				rl.getRecord().add(rw.getRecord());

				Depositi depositi = new Depositi(db.getConnection());
				Iterator<DDepositi> i = depositi.createEntity(idIstituto);

/*
 * Se ci sono depositi li estrae. Vanno in record separati.
 */
				log.info("elaborazione depositi di " + codiProvenienzaDominante);

				if(i.hasNext())
				{
					while(i.hasNext())
					{
						DDepositi ddep = i.next();
						codiProvenienzaDeposito = ddep.getCodiProvenienza();
						log.info("elaborazione deposito: " + codiProvenienzaDeposito);
						ent = envObf.createEnvelopeRecordListRecordRecordBodyEntity();
						ent.getContent().add(ddep);
						/*
						 * si crea la struttura del record per questo deposito
						 */
						rw = new RecordWrapper();
						long id = new Random().nextLong();
						log.info("Deposito idrecord: " + id);
						rw.setRecordIdentifier(codiProvenienzaDeposito);
						rw.setRecordDatestamp();
						rw.setDIRECTIVE("UPSERT");
						rw.setEntity(ent);
						rl.getRecord().add(rw.getRecord());
					}

					/*
					 * Adesso va aggiunto anche un record relazioni per legare questo deposito al dominante.
					 * Proviamo a riciclare rb ed rh, ma non r.
					 */
					rel.setRelazione("d_rel_sogc_depositi");
					DRelSogcDepositi drelSogcDepositi = relObf.createDRelSogcDepositi();
					drelSogcDepositi.setCodiProvenienzaSogc(dsogc.getCodiProvenienza());
					drelSogcDepositi.setCodiProvenienzaDepositi(codiProvenienzaDeposito);
					rel.getDRelSogcDepositi().add(drelSogcDepositi);

					/*
					 * per adesso proviamo a creare header univoci di fantasia
					 */
					/*
					 * anche il body è parzialmente di fantasia
					 */
					rw = new RecordWrapper();
					rw.setRecordIdentifier("id-" + EsportaSoggettiConservatori.now().getMillisecond());
					rw.setRecordDatestamp();
					rw.setDIRECTIVE("UPSERT");
					rw.setRelazioni(rel);
					rl.getRecord().add(rw.getRecord());
				}

/*
 * Solo se questo soggetto ha un superiore si crea la corretta relazione con esso. Si potrebbe fare
 * molto meglio di così, evitando una query potenzialmente inutile quando potremmo sapere già se
 * questo istituto è una sezione o no
 */
				RelazioniSoggettiSuperiori relSup = new RelazioniSoggettiSuperiori(db.getConnection());
				rel = relSup.createRelazione(idIstituto);
				if(rel != null)
				{
					rw = new RecordWrapper();
					rw.setRecordIdentifier("id-" + new Random().nextLong());
					rw.setRecordDatestamp();
					rw.setDIRECTIVE("UPSERT");
					rw.setRelazioni(rel);
					rl.getRecord().add(rw.getRecord());
				}
			}
		}
		catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// env.setRecordList(rl);
		ew.setRecordList(rl);
		return ew;
	}

	/*
	 * Crea una lista di envelope, uno per ogni soggetto conservatore. Ritorna un iterator per
	 * comodità
	 */
	public Iterator<EnvelopeWrapper> creaMultiEnvelope()
	{
		RecordList rl = null;
		it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory envObf;
		envObf = new it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory();
		it.beniculturali.sas.catalogo.relazioni.ObjectFactory relObf;
		relObf = new ObjectFactory();
		ResultSet rs;
		String codiProvenienzaDeposito = null;
		String codiProvenienzaDSogc = null;
		EnvelopeWrapper ew;
		ArrayList<EnvelopeWrapper> ewl = null;
		int max = 1000;
		int rows;
		int idIstituto;

		/*
		 * si prova a scaricare l'elenco di tutti gli idIstituto
		 */
		try
		{
			stmtIstituti.execute();
			rs = stmtIstituti.getResultSet();
			rs.last();
			rows = rs.getRow();
			rs.beforeFirst();
			if(rows > max)
			{
				log.info("Estratti " + rows + " id di istituti, ne saranno lavorati " + max);
			}
			else
			{
				log.info("Estratti " + rows + " id di istituti");
			}
			ewl = new ArrayList<EnvelopeWrapper>();
			/*
			 * si cicla sugli id trovati, creando un envelope per ciascuno
			 */
			while(rs.next() && (max-- > 0))
			{
				idIstituto = rs.getInt("ID_Istituto");
				ew = new EnvelopeWrapper();
				ew.setCREATED();
				/*
				 * Si crea una entity in cui metteremo un sogc. Più avanti la entity sarà aggiunta alla
				 * recordlist
				 */
				Entity ent = envObf.createEnvelopeRecordListRecordRecordBodyEntity();
				// più avanti serve anche una Relazioni
				Relazioni rel = relObf.createRelazioni();
				SoggettiConservatori sc = new SoggettiConservatori(db.getConnection());
				DSogc dsogc = sc.createEntity(idIstituto);
				codiProvenienzaDSogc = dsogc.getCodiProvenienza();
				ew.setSource("SIAS");
				/*
				 * Per evitare errori di validazione delle fonti, non tutte codificate correttamente negli
				 * XSD, inizialmente si usava una fonte fittizia sicuramente valida. Grazie alla mappatura
				 * fra le fonti, questo in teoria non è più necessario.
				 */
				if(fkFonte != null)
				{
					ew.setFonte(fkFonte);
				}
				else
				{
					ew.setFonte(codiProvenienzaDSogc);
				}

				/*
				 * Il codi_provenienza del dsogc va messo via in un oggetto Dominante che poi servirà nella
				 * relazione. C'è qualche dubbio sulla tipologia.
				 */

				Dominante dominante = relObf.createRelazioniDominante();
				CodiProvenienza codiProvenienzaDominante;
				codiProvenienzaDominante = relObf.createCodiProvenienza();
				codiProvenienzaDominante.setValue(dsogc.getCodiProvenienza());
				codiProvenienzaDominante.setTipologia("d_sogc");
				dominante.setCodiProvenienza(codiProvenienzaDominante);
				rel.setDominante(dominante);

				// Finalmente si aggiunge il dsogc alla entity
				ent.getContent().add(dsogc);
				/*
				 * Ora la entity col sogc è pronta. Possiamo aggiungerla a un recordbody, che si aggiunge a
				 * un record, che si aggiunge a una recordlist, che si aggiunge all'envelope, più facile di
				 * così... Si parte da un recordheader, ovviamente
				 */

				RecordWrapper rw = new RecordWrapper();
				rw.setDIRECTIVE("UPSERT");
				rw.setRecordIdentifier("SC-" + dsogc.getCodiProvenienza());
				rw.setRecordDatestamp();
				rw.setEntity(ent);
				/*
				 * Si crea la recordlist cui si aggiunge il record, e che poi si aggiunge a sua volta
				 * all'envelope
				 */

				rl = envObf.createEnvelopeRecordList();
				rl.getRecord().add(rw.getRecord());

				Depositi depositi = new Depositi(db.getConnection());
				Iterator<DDepositi> i = depositi.createEntity(idIstituto);

				/*
				 * Se ci sono depositi li estrae. Vanno in record separati.
				 */

				if(i.hasNext())
				{
					while(i.hasNext())
					{
						DDepositi ddep = i.next();
						codiProvenienzaDeposito = ddep.getCodiProvenienza();
						System.err.println(codiProvenienzaDeposito);
						ent = envObf.createEnvelopeRecordListRecordRecordBodyEntity();
						ent.getContent().add(ddep);
						/*
						 * si crea la struttura del record per questo deposito
						 */
						rw = new RecordWrapper();
						rw.setRecordIdentifier("DEP-" + codiProvenienzaDeposito);
						rw.setRecordDatestamp();
						rw.setDIRECTIVE("UPSERT");
						rw.setEntity(ent);
						rl.getRecord().add(rw.getRecord());

						/*
						 * Adesso va aggiunto anche un record relazioni per legare questo deposito al dominante.
						 * Proviamo a riciclare rb ed rh, ma non r.
						 */
						rel = relObf.createRelazioni();
						rel.setRelazione("d_rel_sogc_depositi");
						DRelSogcDepositi drelSogcDepositi = relObf.createDRelSogcDepositi();
						drelSogcDepositi.setCodiProvenienzaSogc(dsogc.getCodiProvenienza());
						drelSogcDepositi.setCodiProvenienzaDepositi(codiProvenienzaDeposito);
						rel.getDRelSogcDepositi().add(drelSogcDepositi);

						/*
						 * per adesso proviamo a creare header univoci di fantasia
						 */
						/*
						 * anche il body è parzialmente di fantasia
						 */
						rw = new RecordWrapper();
						rw.setRecordIdentifier("REL-" + codiProvenienzaDeposito + "-" + codiProvenienzaDominante.getValue());
						// + EsportaSoggettiConservatori.now().getMillisecond());
						rw.setRecordDatestamp();
						rw.setDIRECTIVE("UPSERT");
						rw.setRelazioni(rel);
						rl.getRecord().add(rw.getRecord());
					}
				}

				/*
				 * Solo se questo soggetto ha un superiore si crea la corretta relazione con esso. Si
				 * potrebbe fare molto meglio di così, evitando una query potenzialmente inutile quando
				 * potremmo sapere già se questo istituto è una sezione o no
				 */
				RelazioniSoggettiSuperiori relSup;
				relSup = new RelazioniSoggettiSuperiori(db.getConnection());
				rel = relSup.createRelazione(idIstituto);
				if(rel != null)
				{
					String codiProvenienzaSup;
					codiProvenienzaSup = rel.getDominante().getCodiProvenienza().getValue();
					rw = new RecordWrapper();
					// rw.setRecordIdentifier("id-" + new Random().nextLong());
					rw.setRecordIdentifier("REL-" + codiProvenienzaDSogc + "-" + codiProvenienzaSup);
					rw.setRecordDatestamp();
					rw.setDIRECTIVE("UPSERT");
					rw.setRelazioni(rel);
					rl.getRecord().add(rw.getRecord());
				}
				ew.setRecordList(rl);
				ewl.add(ew);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ewl.iterator();
	}
}