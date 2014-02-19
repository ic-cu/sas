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
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;

import org.pmw.tinylog.*;

public class EsportaComplessiArchivistici
{

	public Connection connection;
	private DB db;
	private Properties config;
	public Logger log, valLog;
	private static String logLayout = "%05r %p %C{1}.%M - %m%n";
	String fkFonte = null;

	// private static PatternLayout pl;

	/*
	 * Questo costruttore prepara la connessione, impostando qualche parametro.
	 * Sarebbe opportuno esternalizzare i parametri.
	 */
	public EsportaComplessiArchivistici()
	{
		try
		{
			db = new DB();
			config = new Properties();
			FileReader prop = new FileReader("query.prop");
			config.load(prop);
			prop.close();

			// logger generico
			log = Logger.getLogger("COMPARC");
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

			connection = db.getConnection();
			log.info("Inizio esportazione complessi archivistici");
			org.pmw.tinylog.Logger.info("Inizio esportazione complessi archivistici");
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
	 * Crea una lista di envelope, uno per ogni soggetto conservatore. Ritorna un
	 * iterator per comodità
	 */
	public Iterator<EnvelopeWrapper> creaMultiEnvelope(int idIstituto)
	{
		RecordList rl = null;
		it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory envObf;
		envObf = new it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory();
		String codiProvenienzaDComparc = null;
		EnvelopeWrapper ew = null;
		ArrayList<EnvelopeWrapper> ewl = null;
		int maxRecords = 100;

		ewl = new ArrayList<EnvelopeWrapper>();
		/*
		 * Si crea una entity in cui metteremo un sogc. Più avanti la entity sarà
		 * aggiunta alla recordlist
		 */
		Entity ent = null;
		ComplessiArchivistici ca;
		ca = new ComplessiArchivistici(idIstituto, db.getConnection());
		Iterator<DComparc> di = ca.createEntity(idIstituto);
		DComparc dcomparc = null;
		int i = 0;
		while(di.hasNext())
		{
			/*
			 * si cicla sugli id trovati, creando un envelope per ciascuno
			 */
			dcomparc = di.next();
			System.err.println("complesso numero " + i);
			codiProvenienzaDComparc = dcomparc.getCodiProvenienza();
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
			 * Per evitare errori di validazione delle fonti, non tutte codificate
			 * correttamente negli XSD, si usa una fonte fittizia sicuramente valida
			 */
			if(fkFonte != null)
			{
				ew.setFonte(fkFonte);
			}
			else
			{
				// ew.setFonte(codiProvenienzaDComparc);
				ew.setFonte(dcomparc.getFkFonte().getProfGroup().getGroupName());
			}

			// Si crea una entity a cui si aggiunge il comparc e che poi si aggiunge
			// al recordbody più avanti
			ent = envObf.createEnvelopeRecordListRecordRecordBodyEntity();
			ent.getContent().add(dcomparc); // ancona

			RecordWrapper rw = new RecordWrapper();
			rw.setDIRECTIVE("UPSERT");
			rw.setRecordIdentifier("CA-" + dcomparc.getCodiProvenienza());
			rw.setRecordDatestamp();
			rw.setEntity(ent);
			rl.getRecord().add(rw.getRecord());
		}
		return ewl.iterator();
	}
}