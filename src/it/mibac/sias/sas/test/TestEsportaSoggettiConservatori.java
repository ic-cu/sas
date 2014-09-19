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
		//FileOutputStream fos;
		//ZipOutputStream zos;
		//ZipEntry ze;
		//FileInputStream fis;
		//BufferedInputStream bis = null;
		PrintWriter pw = null;
		File tDir = null;

		// si creano le directory temporanee, caso mai non esistessero

		String tmpDir = config.getProperty("xml.output.directory");
		String sep = config.getProperty("xml.output.separator");
		tDir = new File(tmpDir + "/sc/xml");
		tDir.mkdirs();
		tDir = new File(tmpDir + "/sc/zip");
		tDir.mkdirs();

		Iterator<EnvelopeWrapper> ewi = esc.creaMultiEnvelope();
		EnvelopeWrapper ew;
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyyMMdd");
		String fileName;
		DecimalFormat df;
		df = new DecimalFormat("000");
		int i = 0;
		try
		{
			
			//fos = new FileOutputStream(zipFileName);
			//zos = new ZipOutputStream(fos);
			byte[] data = new byte[2048];
			while(ewi.hasNext())
			{
				ew = ewi.next();
				fileName = "SIAS" + sep;
				fileName += ew.getFonte() + sep;
				fileName += sdf.format(new Date()) + sep;
				fileName += df.format(++i);
				fileName += ".xml";
				pw = new PrintWriter(new File(tmpDir + "/sc/xml/" + fileName));
				ew.marshall(pw);
				//ze = new ZipEntry(fileName);
				//fis = new FileInputStream(tmpDir + "/sc/xml/" + fileName);
				//bis = new BufferedInputStream(fis, 2048);
				// zos.putNextEntry(ze);
				//int count;
				//while((count = bis.read(data, 0, 2048)) != -1)
				//{
				//	zos.write(data, 0, count);
				//	zos.flush();
				//}
				//zos.closeEntry();
				String zipFileName = tmpDir; 
				zipFileName += "/sc/zip/SIAS" + sep;
				zipFileName += ew.getFonte() + sep;
				zipFileName += sdf.format(new Date())+sep+df.format(i) + ".zip";
				Spedizione sped=new Spedizione(fileName, zipFileName);
				sped.comprimiFile();
				// vorrei distruggere sped=nothing
			}
			
			//bis.close();
			//zos.flush();
			//zos.close();
			//fos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
