package it.mibac.sias.sas.test;

import it.mibac.sias.sas.util.DB;
import it.mibac.sias.sas.util.EnvelopeWrapper;
import it.mibac.sias.sas.util.EsportaComplessiArchivistici;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

/*
 * Classe per provare l'esportazione dei complessi archivistici. Si limita a
 * qualche inizializzazione e a invocare poi il metodo opportuno. Inoltre
 * gestisce la creazione degli envelope limitando il numero di record per
 * ciascuno.
 */

public class TestEsportaComplessiArchivistici
{
	private static Logger log;

	public static void main(String[] args)
	{
		Properties config = new Properties();
		log = Logger.getLogger("COMPARC");
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
		String tmpDir = config.getProperty("xml.output.directory");
		DB db = new DB();
		Connection connection = db.getConnection();
		PreparedStatement stmtIstituti = null;
		FileOutputStream fos;
		ZipOutputStream zos;
		ZipEntry ze;
		FileInputStream fis;
		BufferedInputStream bis = null;
		PrintWriter pw = null;
		File tDir = null;

		// si creano le directory temporanee, caso mai non esistessero

		tDir = new File(tmpDir + "/ca/xml");
		tDir.mkdirs();
		tDir = new File(tmpDir + "/ca/zip");
		tDir.mkdirs();

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
		int maxIstituti = 1000;
		EsportaComplessiArchivistici eca = new EsportaComplessiArchivistici();
		try
		{
			stmtIstituti.execute();
			rs = stmtIstituti.getResultSet();

			while(rs.next() && (maxIstituti-- > 0))
			{
				idIstituto = rs.getInt("ID_Istituto");
				fonte = rs.getString("fk_fonte");
//				idIstituto = 794000000; fonte = "ITASRM";
//				idIstituto = 228200000; fonte = "ITASBO";
//				idIstituto = 180900000; fonte = "ITASBL";
//				idIstituto = 450180000; fonte = "ITASIM";
//				idIstituto = 940220003; fonte = "ITSASVARAL";
				Iterator<EnvelopeWrapper> ewi = eca.creaMultiEnvelope(idIstituto);
				EnvelopeWrapper ew = null;
				SimpleDateFormat sdf;
				sdf = new SimpleDateFormat("yyyyMMdd");
				String fileName;
				DecimalFormat df;
				df = new DecimalFormat("000");
				int i = 0;

				// si crea il necessario alla gestione del file ZIP

				String zipFileName = tmpDir + "/ca/zip/SIAS-" + fonte + "-"
						+ sdf.format(new Date()) + ".zip";
				fos = new FileOutputStream(zipFileName);
				zos = new ZipOutputStream(fos);
				byte[] data = new byte[2048];
				while(ewi.hasNext())
				{
					ew = ewi.next();
					// fileName = "SIAS-ITASVT-";
					fileName = ew.getSource() + "-";
					fileName += fonte + "-";
//					fileName += ew.getFonte() + "-";
					fileName += sdf.format(new Date()) + "-";
					fileName += df.format(++i);
					fileName += ".xml";
					log.info("Istituto " + fonte + ", envelope numero " + i);
					pw = new PrintWriter(new File(tmpDir + "/ca/xml/" + fileName));
					ew.marshall(pw);
					ze = new ZipEntry(fileName);
					fis = new FileInputStream(tmpDir + "/ca/xml/" + fileName);
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
				try
				{
					bis.close();
					zos.flush();
					zos.close();
					fos.close();
				}
				catch(ZipException e)
				{
					log.warn("Istituto " + idIstituto + "(" + fonte
							+ "), nessun complesso valido, ZIP non creato");
					// e.printStackTrace();
				}
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
