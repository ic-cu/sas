package it.mibac.sias.sas.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import it.mibac.sias.sas.util.DB;
import it.mibac.sias.sas.util.EnvelopeWrapper;
import it.mibac.sias.sas.util.EsportaComplessiArchivistici;
import it.mibac.sias.sas.util.EsportaSoggettiConservatori;

/*
 * Classe per provare l'esportazione dei soggetti conservatori. Si limita a
 * qualche inizializzazione e a invocare poi il metodo opportuno
 */

public class TestEsportaComplessiArchivistici
{

	public static void main(String[] args)
	{
		Properties config = new Properties();
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

		int idIstituto;
		String fonte;
		DB db = new DB();
		Connection connection = db.getConnection();
		PreparedStatement stmtIstituti = null;
		FileOutputStream fos;
		ZipOutputStream zos;
		ZipEntry ze;
		FileInputStream fis;
		BufferedInputStream bis = null;
		try
		{
			stmtIstituti = connection.prepareStatement(config
					.getProperty("query.istituti"), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		ResultSet rs;
		int rows;
		int maxIstituti = 1;
		EsportaComplessiArchivistici eca = new EsportaComplessiArchivistici();
		try
		{
			stmtIstituti.execute();
			rs = stmtIstituti.getResultSet();
			// if(rows > max)
			// {
			// log.info("Estratti " + rows + " id di istituti, ne saranno lavorati "
			// + max);
			// }
			// else
			// {
			// log.info("Estratti " + rows + " id di istituti");
			// }

			while(rs.next() && (maxIstituti-- > 0))
			{
				idIstituto = rs.getInt("ID_Istituto");
				fonte = rs.getString("fk_fonte");
//				idIstituto = 794000000;
				idIstituto = 228200000;
				fonte = "ITASBO";
				Iterator<EnvelopeWrapper> ewi = eca.creaMultiEnvelope(idIstituto);
				EnvelopeWrapper ew = null;
				SimpleDateFormat sdf;
				sdf = new SimpleDateFormat("yyyyMMdd");
				String fileName;
				DecimalFormat df;
				df = new DecimalFormat("000");
				int i = 0;
				String zipFileName = "tmp/ca/zip/SIAS-" + fonte + "-"
						+ sdf.format(new Date()) + ".zip";
				fos = new FileOutputStream(zipFileName);
				zos = new ZipOutputStream(fos);
				byte[] data = new byte[2048];
				while(ewi.hasNext())
				{
					ew = ewi.next();
					// fileName = "SIAS-ITASVT-";
					fileName = ew.getSource() + "-" + ew.getFonte() + "-";
					fileName += sdf.format(new Date()) + "-";
					fileName += df.format(++i);
					fileName += ".xml";
					System.err.println("Envelope numero " + i);
					ew.marshall("tmp/ca/xml/" + fileName);
					ze = new ZipEntry(fileName);
					fis = new FileInputStream("tmp/ca/xml/" + fileName);
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
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		// esc.creaEnvelope().marshall();
	}
}
