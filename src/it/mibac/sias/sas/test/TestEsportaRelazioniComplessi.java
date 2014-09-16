package it.mibac.sias.sas.test;

import it.mibac.sias.sas.util.DB;
import it.mibac.sias.sas.util.EnvelopeWrapper;
import it.mibac.sias.sas.util.EsportaRelazioniComplessi;
import it.mibac.sias.sas.util.Spedizione;

import java.io.File;
import java.io.FileNotFoundException;
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

import org.apache.log4j.Logger;

/*
 * Classe per provare l'esportazione dei complessi archivistici. Si limita a qualche
 * inizializzazione e a invocare poi il metodo opportuno. Inoltre gestisce la creazione degli
 * envelope limitando il numero di record per ciascuno.
 */

public class TestEsportaRelazioniComplessi
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
		PrintWriter pw = null;
		File tDir = null;

		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(new Date());
		String fileName;
		DecimalFormat df;
		df = new DecimalFormat("000");

		// si creano le directory temporanee, caso mai non esistessero

		tDir = new File(tmpDir + "/rc/xml/" + today);
		tDir.mkdirs();
		tDir = new File(tmpDir + "/rc/zip/" + today);
		tDir.mkdirs();

		try
		{
			stmtIstituti = connection.prepareStatement(config.getProperty("query.istituti"),
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		ResultSet rs;
		int maxIstituti = 1;
		EsportaRelazioniComplessi erc = new EsportaRelazioniComplessi();
		try
		{
			stmtIstituti.execute();
			rs = stmtIstituti.getResultSet();

			while(rs.next() && (maxIstituti-- > 0))
			{
				idIstituto = rs.getInt("ID_Istituto");
				fonte = rs.getString("fk_fonte");
// idIstituto = 794000000; fonte = "ITASRM";
// idIstituto = 228200000; fonte = "ITASBO";
// idIstituto = 180900000; fonte = "ITASBL";
// idIstituto = 450180000; fonte = "ITASIM";
// idIstituto = 940220003; fonte = "ITSASVARAL";
// idIstituto = 480800000;
// fonte = "ITASAQ";
				idIstituto = 450180000;
				fonte = "ITASIM";
				Iterator<EnvelopeWrapper> ewi = erc.creaMultiEnvelope(idIstituto, fonte);
				EnvelopeWrapper ew = null;
				int i = 0;

				// si crea il necessario alla gestione del file ZIP

				String zipFileName = tmpDir + "/rc/zip/" + today + "/SIAS-" + fonte + "-" + sdf.format(new Date()) + ".zip";
				String percorsoXML = tmpDir + "/rc/xml/" + today;
				while(ewi.hasNext())
				{
					ew = ewi.next();
					// fileName = "SIAS-ITASVT-";
					fileName = ew.getSource() + "-";
					fileName += fonte + "-";
// fileName += ew.getFonte() + "-";
					fileName += sdf.format(new Date()) + "-";
					fileName += df.format(++i);
					fileName += ".xml";

// col marshall viene effettivamente creato un file XML (a meno di flush)

					log.info("Istituto " + fonte + ", envelope numero " + i);
					pw = new PrintWriter(new File(percorsoXML + "/" + fileName));
					ew.marshall(pw);
				}
				
// si comprimono tutti gli envelope in un unico file zip
				
				Spedizione sped = new Spedizione(percorsoXML, zipFileName);
				sped.comprimi();
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

		// esc.creaEnvelope().marshall();
	}
}
