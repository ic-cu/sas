package it.mibac.sias.sas.test;

import it.mibac.sias.sas.util.EnvelopeWrapper;
import it.mibac.sias.sas.util.EsportaSoggettiConservatori;
import it.mibac.sias.sas.util.Spedizione;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

/*
 * Classe per provare l'esportazione dei soggetti conservatori. Si limita a
 * qualche inizializzazione e a invocare poi il metodo opportuno
 */
/* DEVO LAVORARE QUI */
public class TestEsportaSoggettiConservatori
{
	private static Logger log;

	public static void main(String[] args)
	{
		Properties config = new Properties();
		log = Logger.getLogger("SOGC");
		try
		{
			config.load(new FileReader(new File("query.prop")));
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}

		EsportaSoggettiConservatori esc = new EsportaSoggettiConservatori();
		PrintWriter pw = null;
		File tDir = null;

		// si creano le directory temporanee, caso mai non esistessero

		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(new Date());
		String tmpDir = config.getProperty("xml.output.directory");
		String sep = config.getProperty("xml.output.separator");
		tDir = new File(tmpDir + "/sc/xml/" + today);
		tDir.mkdirs();
		tDir = new File(tmpDir + "/sc/zip/" + today);
		tDir.mkdirs();

		Iterator<EnvelopeWrapper> ewi = esc.creaMultiEnvelope();
		EnvelopeWrapper ew;
		String fileName;
		DecimalFormat df;
		df = new DecimalFormat("000");
		int i = 0;
		try
		{
			while(ewi.hasNext())
			{
				ew = ewi.next();
				fileName = "SIAS" + sep;
				fileName += ew.getFonte() + sep;
				fileName += today + sep;
				fileName += df.format(++i);
				fileName += ".xml";
				pw = new PrintWriter(new File(tmpDir + "/sc/xml/" + today + "/" + fileName));
				ew.marshall(pw);
				String zipFileName = tmpDir; 
				zipFileName += "/sc/zip/" + today + "/SIAS" + sep;
				zipFileName += ew.getFonte() + sep;
				zipFileName += today + sep + df.format(i) + ".zip";
				Spedizione sped=new Spedizione(fileName, zipFileName);
				sped.comprimiFile();
				// vorrei distruggere sped=nothing
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
