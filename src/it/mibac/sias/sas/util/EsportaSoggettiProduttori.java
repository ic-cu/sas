package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordBody.Entity;
import it.beniculturali.sas.catalogo.sogp.DSogp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;

public class EsportaSoggettiProduttori
{

	public Connection connection;
	private DB db;
	private Properties config;
	private Properties fontiMap;
	public Logger log;
//	private static String logLayout = "%05r %p %C{1}.%M - %m%n";
	String fkFonte = null;
	private int maxRecords;

	// private static PatternLayout pl;

	/*
	 * Questo costruttore prepara la connessione, impostando qualche parametro. Sarebbe opportuno
	 * esternalizzare i parametri.
	 */
	public EsportaSoggettiProduttori()
	{
		try
		{
			db = new DB();

			// logger generico
			log = Logger.getLogger("LOG");
//			log.setLevel(Level.INFO);
//			PatternLayout pl = new PatternLayout(logLayout);
//			File lf = new File("log");
//			PrintWriter pw = new PrintWriter(lf);
//			WriterAppender wa = new WriterAppender(pl, pw);
//			log.addAppender(wa);
//			wa = new WriterAppender(pl, System.out);
//			log.addAppender(wa);
//			// BasicConfigurator.configure(wa);
//
//			// serve un logger per la validazione
//			valLog = Logger.getLogger("VALIDATE");
//			pl = new PatternLayout("%m%n");
//			lf = new File("validate.log");
//			pw = new PrintWriter(lf);
//			wa = new WriterAppender(pl, pw);
//			valLog.addAppender(wa);
//			wa = new WriterAppender(pl, System.out);
//			valLog.addAppender(wa);
//			// BasicConfigurator.configure(wa);

			config = new Properties();
			fontiMap = new Properties();
			connection = db.getConnection();
			config.load(new FileReader(new File("query.prop")));
			fontiMap.load(new FileReader(new File("fonti.map")));
			maxRecords = Integer.parseInt(config.getProperty("xml.output.maxrecords"));
			log.info("Inizio esportazione soggetti produttori");
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
	}

/*
 * Crea una lista di envelope, uno per ogni soggetto produttore. Ritorna un iterator per comodità
 */
	public Iterator<EnvelopeWrapper> creaMultiEnvelope(int idIstituto)
	{
		RecordList rl = null;
		it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory envObf;
		envObf = new it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory();
		// String codiProvenienzaDSogp = null;
		EnvelopeWrapper ew = null;
		RecordWrapper rw = null;
		SoggettiProduttori sp = null;
		Iterator<DSogp> di = null;
		ArrayList<EnvelopeWrapper> ewl = null;
		Entity ent = null;
		DSogp dsogp = null;
		int i = 0;

/*
 * Si crea una entity in cui metteremo un sogc. Più avanti la entity sarà aggiunta alla recordlist
 */
		ewl = new ArrayList<EnvelopeWrapper>();
		sp = new SoggettiProduttori(db.getConnection());
		di = sp.createEntityEnte(idIstituto);
		while(di.hasNext())
		{
			dsogp = di.next();
			log.info("Istituto " + idIstituto + ", soggetto " + dsogp.getCodiProvenienza());
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
				ew.setFonte(dsogp.getFkFonte().getProfGroup().getGroupName());
			}

/*
 * Si inserisce il dcomparc attuale in una nuova entity, poi questa ad un nuovo record, e il nuovo
 * record alla recordlist dell'envelope attuale
 */

			ent = envObf.createEnvelopeRecordListRecordRecordBodyEntity();
			ent.getContent().add(dsogp);
			rw = new RecordWrapper();
			rw.setDIRECTIVE("UPSERT");
			rw.setCASCADE(true);
			rw.setRecordIdentifier("SP-" + dsogp.getCodiProvenienza());
			rw.setRecordDatestamp();
			rw.setEntity(ent);
			rl.getRecord().add(rw.getRecord());
		}
		return ewl.iterator();
	}
}