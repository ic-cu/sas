package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.comparc.DComparc;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordBody.Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;

/*
 * Classe per la creazione degli envelope dei comlessi archivistici. A parte inizializzazioni varie,
 * il metodo importante è creaMultiEnvelope, che ritorna un Iterator di EnvelopeWrapper. Scorrendo
 * questo iteratore, un chiamante può decidere cosa fare di tutti gli envelope ottenuti.
 */
public class EsportaComplessiArchivistici
{

	public Connection			connection;
	private DB						db;
	private Properties		config;
	public Logger					log, valLog;
	private static String	logLayout	= "%05r %p %C{1}.%M - %m%n";
	String								fkFonte		= null;
	private int						maxRecords;

	/*
	 * Questo costruttore prepara la connessione, impostando qualche parametro. Sarebbe opportuno
	 * esternalizzare i parametri.
	 */
	public EsportaComplessiArchivistici()
	{
		try
		{
			loadConfig();
			initLogger();
			db = new DB();
			connection = db.getConnection();
			log.info("Inizio esportazione complessi archivistici");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	// carica la configurazione sotto forma di Properties

	private void loadConfig() throws FileNotFoundException, IOException
	{
		config = new Properties();
		FileReader prop = new FileReader("query.prop");
		config.load(prop);
		prop.close();
		maxRecords = Integer.parseInt(config.getProperty("xml.output.maxrecords"));
		fkFonte = config.getProperty("sogc.fk_fonte");
	}

	// inizializza il logger

	private void initLogger() throws FileNotFoundException
	{
		// logger generico
		log = Logger.getLogger("LOG");
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
	}

/*
 * Crea una lista di envelope, ognuno contenente al massimo maxRecords entity dcomparc. Ritorna un
 * iterator per comodità.
 */

	public Iterator<EnvelopeWrapper> creaMultiEnvelope(int idIstituto)
	{
		it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory envObf;
		envObf = new it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory();
		RecordList rl = null;
		EnvelopeWrapper ew = null;
		ArrayList<EnvelopeWrapper> ewl = null;
		DComparc dcomparc = null;
		Entity ent = null;
		ComplessiArchivistici ca = null;
		Iterator<DComparc> di = null;
		RecordWrapper rw = null;
		int i = 0;

/*
 * Si istanzia la lista di envelope ewl e la lista dei complessi di, passando per la classe
 * ComplessiArchivistici. Il metodo createEntity ha un nome improprio, perché in realtà ritorna una
 * lista, e andrebbe cambiato.
 */
		ewl = new ArrayList<EnvelopeWrapper>();
		ca = new ComplessiArchivistici(db.getConnection());
		di = ca.createEntity(idIstituto);

/*
 * Si cicla sui dcomparc ottenuti, tutti quelli dell'istituto attuale
 */

		while(di.hasNext())
		{
			dcomparc = di.next();

/*
 * Se il contatore è un multiplo del massimo numero di record per envelope, si crea un nuovo
 * envelope, anche se nascosto dentro un wrapper. All'enveloper va aggiunta una nuova recordlist, e
 * poi si può aggiungere l'envelope alla lista degli envelope. I prossimi maxRecords dcomparc
 * saranno aggiunti a questa recordlist, poi se ne farà una nuova. Il test è positivo anche alla
 * prima iterazione, quando il contatore è nullo.
 */

			if(i++ % maxRecords == 0)
			{
				ew = new EnvelopeWrapper();
				ew.setCREATED();
				ew.setSource("SIAS");
				rl = envObf.createEnvelopeRecordList();
				ew.setRecordList(rl);
				ewl.add(ew);
			}

/*
 * Arrivati qui, una recordlist è pronta, nuova o già parzialmente popolata. Possiamo aggiungere
 * record. Per evitare errori di validazione delle fonti, non tutte codificate correttamente negli
 * XSD, si usa una fonte fittizia sicuramente valida, inclusa nella configurazione, ma solo se
 * questa è non nulla, altrimenti si usa quella risultante dal dcomparc attuale
 */

			if(fkFonte != null)
			{
				ew.setFonte(fkFonte);
			}
			else
			{
				ew.setFonte(dcomparc.getFkFonte().getProfGroup().getGroupName());
			}

/*
 * Si inserisce il dcomparc attuale in una nuova entity, poi questa ad un nuovo record, e il nuovo
 * record alla recordlist dell'envelope attuale
 */

			ent = envObf.createEnvelopeRecordListRecordRecordBodyEntity();
			ent.getContent().add(dcomparc);
			rw = new RecordWrapper();
			rw.setDIRECTIVE("UPSERT");
			rw.setCASCADE(true);
			rw.setRecordIdentifier("CA-" + dcomparc.getCodiProvenienza());
			rw.setRecordDatestamp();
			rw.setEntity(ent);
			rl.getRecord().add(rw.getRecord());
		}
		return ewl.iterator();
	}
}