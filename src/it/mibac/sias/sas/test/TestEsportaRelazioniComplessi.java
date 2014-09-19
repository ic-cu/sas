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
		Properties fontiMap = new Properties();

/*
 * Questa stringa serve come separatore delle varie componenti dei nomi dei file ZML e ZIP, e
 * andrebbe esternalizzata.
 */

		String sep = "_";
		log = Logger.getLogger("COMPARC");
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

		int idIstituto;
		String fonte;
		String tmpDir = config.getProperty("xml.output.directory");
		DB db = new DB();
		Connection connection = db.getConnection();
		PreparedStatement stmtIstituti = null;
		PrintWriter pw = null;
		File tDir = null;

/*
 * Si ricava la data di oggi nel formato giusto. Questo formato andrebbe esternalizzato in un file
 * di Properties.
 */

		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());

		// si creano le directory temporanee, caso mai non esistessero

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
		EsportaRelazioniComplessi erc = new EsportaRelazioniComplessi();
		try
		{
			stmtIstituti.execute();
			rs = stmtIstituti.getResultSet();

/*
 * Serve un formato per il numero progressivo da aggiungere ad ogni file XML prima dell'estensione.
 * Anche questo formato dovrebbe andare in un file di Properties
 */

			DecimalFormat df;
			df = new DecimalFormat("000");

/*
 * Si comincia a iterare su tutti gli istituti. C'è un valore di taglio a solo scopo di debugging.
 */

			int maxIstituti = 1000;
			while(rs.next() && (maxIstituti-- > 0))
			{
				idIstituto = rs.getInt("ID_Istituto");

// La fonte è ricavata dalla query, ma tramite una mappa che funziona solo per fonti senza "-".
// Altrove è invece estratta con il "-" e questo comportamento andrebbe uniformato.

				fonte = fontiMap.getProperty(rs.getString("fk_fonte"));

// idIstituto = 794000000; fonte = "ITASRM";
// idIstituto = 228200000; fonte = "ITASBO";
// idIstituto = 180900000; fonte = "ITASBL";
// idIstituto = 450180000; fonte = "ITASIM";
// idIstituto = 940220003; fonte = "ITSASVARAL";
//				idIstituto = 480800000;
//				fonte = fontiMap.getProperty("ITASAQ");
// idIstituto = 450180000; fonte = "ITASIM";

/*
 * Si ricava l'iteratore sulle relazioni di questo istituto con i suoi complessi e fra i complessi
 * stessi. Serve anche un contatore per numerare i diversi file XML della stessa fonte.
 */

				if(fonte != null && !fonte.equals(""))
				{
					log.info("Istituto " + idIstituto + "(" + fonte + "), preparazione degli envelope relazioni complessi");
					Iterator<EnvelopeWrapper> ewi = erc.creaMultiEnvelope(idIstituto, fonte);
					EnvelopeWrapper ew = null;
					int i = 0;

/*
 * Si crea il necessario alla gestione del file ZIP. Tutti i file ZIP di oggi vanno nella stessa
 * directory, ma ovviamente hanno nomi diversi a seconda della fonte e della data.
 */
					String zipFileName = tmpDir + "/rc/zip/" + today + "/SIAS" + sep + fonte + sep + today + ".zip";

/*
 * I percorsi dei file XML di oggi vanno distinti in base alla fonte
 */

					String percorsoXML = tmpDir + "/rc/xml/" + today + "/" + fonte;
					tDir = new File(percorsoXML);
					tDir.mkdirs();

					while(ewi.hasNext())
					{
						ew = ewi.next();
						String fileName;
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

// si comprimono tutti gli envelope in un unico file zip

					Spedizione sped = new Spedizione(percorsoXML, zipFileName);
					sped.comprimi();
				}
				else
				{
					log.warn("Istituto " + idIstituto + " con fonte \'" + fonte + "\' scartato");
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
	}
}
