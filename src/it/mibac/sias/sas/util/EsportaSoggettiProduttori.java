package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordBody.Entity;
import it.beniculturali.sas.catalogo.sogp.DSogp;

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

public class EsportaSoggettiProduttori
{

	public Connection connection;
	private DB db;
	private Properties config;
	private Properties fontiMap;
	public static Logger log, valLog;
	private static String logLayout = "%05r %p %C{1}.%M - %m%n";
	String fkFonte = null;

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
			log = Logger.getLogger("SOGP");
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
	}

	/*
	 * Crea una lista di envelope, uno per ogni soggetto produttore. Ritorna un iterator per comodità
	 */
	public Iterator<EnvelopeWrapper> creaMultiEnvelope(int idIstituto)
	{
		RecordList rl = null;
		it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory envObf;
		envObf = new it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory();
				//		String codiProvenienzaDSogp = null;
		EnvelopeWrapper ew;
		ArrayList<EnvelopeWrapper> ewl = null;

		/*
		 * si prova a scaricare l'elenco di tutti gli idIstituto
		 */
		ew = new EnvelopeWrapper();
		ew.setCREATED();
		/*
		 * Si crea una entity in cui metteremo un sogc. Più avanti la entity sarà aggiunta alla
		 * recordlist
		 */
		Entity ent = envObf.createEnvelopeRecordListRecordRecordBodyEntity();
		SoggettiProduttori sp = new SoggettiProduttori(db.getConnection());
		Iterator<DSogp> dsogp = sp.createEntityEnte(idIstituto);
		if(dsogp != null)
		{
// codiProvenienzaDSogp = dsogp.getCodiProvenienza();
			ew.setSource("SIAS");
			/*
			 * Per evitare errori di validazione delle fonti, non tutte codificate correttamente negli
			 * XSD, inizialmente si usava una fonte fittizia sicuramente valida. Grazie alla mappatura fra
			 * le fonti, questo in teoria non è più necessario.
			 */
			if(fkFonte != null)
			{
				ew.setFonte(fkFonte);
			}
			else
			{
// ew.setFonte(dsogp.getFkFonte().getProfGroup().getGroupName());
			}
			ent.getContent().add(dsogp);
			/*
			 * Ora la entity col sogc è pronta. Possiamo aggiungerla a un recordbody, che si aggiunge a un
			 * record, che si aggiunge a una recordlist, che si aggiunge all'envelope, più facile di
			 * così... Si parte da un recordheader, ovviamente
			 */
			ewl = new ArrayList<EnvelopeWrapper>();

			RecordWrapper rw = new RecordWrapper();
			rw.setDIRECTIVE("UPSERT");
// rw.setRecordIdentifier("SC-" + dsogp.getCodiProvenienza());
			rw.setRecordDatestamp();
			rw.setEntity(ent);
			/*
			 * Si crea la recordlist cui si aggiunge il record, e che poi si aggiunge a sua volta
			 * all'envelope
			 */

			rl = envObf.createEnvelopeRecordList();
			rl.getRecord().add(rw.getRecord());

			ew.setRecordList(rl);
			ewl.add(ew);
		}
		return ewl.iterator();
	}
}