package it.mibac.sias.sas.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import it.mibac.sias.sas.util.EnvelopeWrapper;
import it.mibac.sias.sas.util.EsportaSoggettiConservatori;

/*
 * Classe per provare l'esportazione dei soggetti conservatori. Si limita a
 * qualche inizializzazione e a invocare poi il metodo opportuno
 */

public class TestEsportaSoggettiConservatori
{

	public static void main(String[] args)
	{
		EsportaSoggettiConservatori esc = new EsportaSoggettiConservatori();
		// esc.creaEnvelope().marshall();
		FileOutputStream fos;
		ZipOutputStream zos;
		ZipEntry ze;
		FileInputStream fis;
		BufferedInputStream bis = null;

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
			String zipFileName = "tmp/sc/zip/SIAS-ITASVT-" + sdf.format(new Date())
					+ ".zip";
			fos = new FileOutputStream(zipFileName);
			zos = new ZipOutputStream(fos);
			byte[] data = new byte[2048];
			while(ewi.hasNext())
			{
				ew = ewi.next();
				fileName = "SIAS-ITASVT-";
				fileName += sdf.format(new Date()) + "-";
				fileName += df.format(++i);
				fileName += ".xml";
				ew.marshall("tmp/sc/xml/" + fileName);
				ze = new ZipEntry(fileName);
				fis = new FileInputStream("tmp/sc/xml/" + fileName);
				bis = new BufferedInputStream(fis, 2048);
				zos.putNextEntry(ze);
				int count;
				while((count = bis.read(data, 0, 2048)) != -1)
				{
					zos.write(data, 0, count);
					zos.flush();
				}
				zos.closeEntry();
			}
			bis.close();
			zos.flush();
			zos.close();
			fos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		// esc.creaEnvelope().marshall();
	}
}
