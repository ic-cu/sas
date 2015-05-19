package it.mibac.sias.sas.cmd;

import it.mibac.sias.sas.util.DB;
import it.mibac.sias.sas.util.EnvelopeWrapper;
import it.mibac.sias.sas.util.EsportaComplessiArchivistici;
import it.mibac.sias.sas.util.EsportaRelazioniComplessi;
import it.mibac.sias.sas.util.EsportaRelazioniProduttoriComplessi;
import it.mibac.sias.sas.util.EsportaSoggettiConservatori;
import it.mibac.sias.sas.util.EsportaSoggettiProduttori;
import it.mibac.sias.sas.util.Istituto;
import it.mibac.sias.sas.util.Seleziona;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;

/*
 * Classe per provare l'esportazione dei complessi archivistici. Si limita a qualche
 * inizializzazione e a invocare poi il metodo opportuno. Inoltre gestisce la creazione degli
 * envelope limitando il numero di record per ciascuno.
 */

public class Esporta
{
	private static Logger log;
	private static Properties config;
	private static Seleziona sel;
	private static ArrayList<Istituto> istituti = new ArrayList<Istituto>();
	private static ArrayList<String> fontiList = new ArrayList<String>();
	private static ArrayList<String> ISADList = new ArrayList<String>();
	private static HashMap<String, String> fontiIstitutiMap = new HashMap<String, String>();
	private static HashMap<String, String> istitutiFontiMap = new HashMap<String, String>();
	private static Properties fontiMap;
	private static String logLayout = "%05r %p %C{1}.%M - %m%n";
	private static String tmpTopDir;
	private static String tmpDir;
	private static String dateOffset;
	private static String sep;
	private static String logLevel;

	// inizializza il logger

	private static void initLogger()
	{
		// logger generico
		log = Logger.getLogger("LOG");
		switch(logLevel)
		{
			case "error":
				log.setLevel(Level.ERROR);
				break;
			case "warn":
				log.setLevel(Level.WARN);
				break;
			case "info":
				log.setLevel(Level.INFO);
				break;
			case "debug":
				log.setLevel(Level.DEBUG);
				break;
			case "trace":
				log.setLevel(Level.TRACE);
				break;
			default:
				log.setLevel(Level.INFO);
				break;
		}
		PatternLayout pl = new PatternLayout(logLayout);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, Integer.parseInt(dateOffset));
		String now = new SimpleDateFormat("yyyyMMddHHmmss").format(cal.getTime());
		File lf = new File(now + ".log");
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(lf);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		WriterAppender wa = new WriterAppender(pl, pw);
		log.addAppender(wa);
		wa = new WriterAppender(pl, System.out);
		wa.setThreshold(Level.INFO);
		log.addAppender(wa);
	}

	public static void export()
	{
		String ISAD = sel.getSelectedItem();
		int index = sel.getSelectedIndex();
		int idIstituto = istituti.get(index).getId();
		String action = sel.getSelectedAction();
		String fonte = istituti.get(index).getFonte();
		log.debug("Selezionato l'istituto " + ISAD + " (" +  fonte + ", " + idIstituto +  ")");
		PrintWriter pw = null;
		BufferedWriter bw = null;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, Integer.parseInt(dateOffset));
		Date todayDate = cal.getTime();
		String today = new SimpleDateFormat("yyyyMMdd").format(todayDate);
		String fileName;
		sel.dispose();

		try
		{
			Iterator<EnvelopeWrapper> ewi = null;
			switch(action)
			{
				case "complessi archivistici":
					ewi = new EsportaComplessiArchivistici().creaMultiEnvelope(idIstituto);
					tmpDir = "ca";
					break;
				case "soggetti conservatori":
					ewi = new EsportaSoggettiConservatori().creaMultiEnvelope();
					tmpDir = "sc";
					break;
				case "soggetti produttori":
					ewi = new EsportaSoggettiProduttori().creaMultiEnvelope(idIstituto);
					tmpDir = "sp";
					break;
				case "relazioni produttori-complessi":
					ewi = new EsportaRelazioniProduttoriComplessi().creaMultiEnvelope(idIstituto, fonte);
					tmpDir = "rpc";
					break;
				case "relazioni conservatori-complessi":
					ewi = new EsportaRelazioniComplessi().creaMultiEnvelope(idIstituto, fonte);
					tmpDir = "rcc";
					break;
				default:
					break;
			}
			EnvelopeWrapper ew = null;
			int i = 0;

			String percorsoXML = tmpTopDir + "/" + tmpDir + "/" + today + "/" + fonte;
			new File(percorsoXML).mkdirs();
			log.info("Istituto " + fonte + ", esportazione " + action);
			if(!ewi.hasNext())
			{
				log.warn("Istituto " + fonte + ", non c'è niente da esportare");
			}
			while(ewi.hasNext())
			{
				ew = ewi.next();
				fileName = ew.getSource() + sep;
				fileName += fonte + sep;
				fileName += today + sep;
				fileName += new DecimalFormat("000").format(++i);
				fileName += ".xml";

// col marshall viene effettivamente creato un file XML (a meno di flush)

				log.info("Istituto " + fonte + ", envelope numero " + i);
				bw = new BufferedWriter(new FileWriter(percorsoXML + "/" + fileName), 4096);
				pw = new PrintWriter(bw);
				ew.marshall(pw);
			}
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

	public static void main(String[] args)
	{
		config = new Properties();
		fontiMap = new Properties();
		try
		{
			config.load(new FileReader(new File("query.prop")));
			fontiMap.load(new FileReader(new File("fonti.map")));
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		tmpTopDir = config.getProperty("xml.output.directory");
		tmpDir = null;
		dateOffset = config.getProperty("xml.date.offset");
		sep = config.getProperty("xml.output.separator");
		logLayout = config.getProperty("log.layout");
		logLevel = config.getProperty("log.level");
		initLogger();
		log = Logger.getLogger("LOG");
		DB db = new DB();
		Connection connection = db.getConnection();
		try
		{
			config.load(new FileReader(new File("istituti.prop")));
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		ResultSet rs;
		try
		{
			PreparedStatement stmtIstituti = connection.prepareStatement(config.getProperty("query.istituti"),
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmtIstituti.execute();
			rs = stmtIstituti.getResultSet();
			String id, fonte, ISAD;
			Istituto istituto;
			while(rs.next())
			{
				istituto = new Istituto();
				id = rs.getString("ID_Istituto");
				ISAD = rs.getString("fk_fonte");
				fonte = fontiMap.getProperty(ISAD);
				istituto.setId(Integer.parseInt(id));
				istituto.setFonte(fonte);
				istituto.setISAD(ISAD);
				istituti.add(istituto);
				fontiList.add(fonte);
				ISADList.add(ISAD);
				fontiIstitutiMap.put(id, fonte);
				istitutiFontiMap.put(fonte, id);
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}

		sel = new Seleziona(ISADList.iterator());
		sel.showListDemo();
		sel.addListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				log.debug("Sono qui!");
				export();
			}
		});
	}
}
