package it.mibac.sias.sas.test;

import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordBody.Entity;
import it.beniculturali.sas.catalogo.sogp.DSogp;
import it.mibac.sias.sas.spring.DSogpDao;
import it.mibac.sias.sas.util.EnvelopeWrapper;
import it.mibac.sias.sas.util.EsportaComplessiArchivistici;
import it.mibac.sias.sas.util.EsportaSoggettiConservatori;
import it.mibac.sias.sas.util.Istituto;
import it.mibac.sias.sas.util.Seleziona;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;

/*
 * Classe per provare l'esportazione dei complessi archivistici. Si limita a qualche
 * inizializzazione e a invocare poi il metodo opportuno. Inoltre gestisce la creazione degli
 * envelope limitando il numero di record per ciascuno.
 */

public class TestSpringProduttori
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

	public static void export()
	{
		String ISAD = sel.getSelectedItem();
		int index = sel.getSelectedIndex();
		System.err.println("Selezionato l'istituto " + ISAD);
		int idIstituto = istituti.get(index).getId();
		String action = sel.getSelectedAction();
		System.err.println("Hai selezionato l'istituto " + idIstituto);
		String fonte = istituti.get(index).getFonte();
// String fonte = istitutiFontiMap.get(String.valueOf(idIstituto));
		String tmpDir = config.getProperty("xml.output.directory");
		String dateOffset = config.getProperty("xml.date.offset");
		String sep = config.getProperty("xml.output.separator");
		PrintWriter pw = null;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, Integer.parseInt(dateOffset));
		Date todayDate = cal.getTime();
		String today = new SimpleDateFormat("yyyyMMdd").format(todayDate);
		String fileName;
		DecimalFormat df;
		df = new DecimalFormat("000");

		try
		{
			Iterator<EnvelopeWrapper> ewi = null;
			switch(action)
			{
				case "complessi archivistici":
					ewi = new EsportaComplessiArchivistici().creaMultiEnvelope(idIstituto);
					break;
				case "soggetti conservatori":
					ewi = new EsportaSoggettiConservatori().creaMultiEnvelope();
					break;
				case "soggetti produttori":
					ewi = new EsportaSoggettiConservatori().creaMultiEnvelope();
					break;
				default:
					break;
			}
			EnvelopeWrapper ew = null;
			int i = 0;

			String percorsoXML = tmpDir + "/sp/" + today + "/" + fonte;
			new File(percorsoXML).mkdirs();
			while(ewi.hasNext())
			{
				ew = ewi.next();
				fileName = ew.getSource() + sep;
				fileName += fonte + sep;
				fileName += today + sep;
				fileName += df.format(++i);
				fileName += ".xml";

// col marshall viene effettivamente creato un file XML (a meno di flush)

				log.info("Istituto " + fonte + ", envelope numero " + i);
				pw = new PrintWriter(new File(percorsoXML + "/" + fileName));
				ew.marshall(pw);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		config = new Properties();
		fontiMap = new Properties();
		log = Logger.getLogger("LOG");
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
		DSogpDao dao = new DSogpDao();
		Iterator<Entity> i = dao.getAllDSogp(120170000);
		while(i.hasNext())
		{
			Entity e = i.next();
			System.out.println(((DSogp) e.getContent().get(0)).getCodiProvenienza());
		}

//		sel = new Seleziona(ISADList.iterator());
//		sel.showListDemo();
//		sel.addListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e)
//			{
//				System.err.println("Sono qui!");
//				export();
//			}
//		});
	}

}
