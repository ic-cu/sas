package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.sogc.DSogc.FkFonte;
import it.beniculturali.sas.catalogo.sogp.DSogp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Properties;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.log4j.Logger;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class SoggettiProduttori
{
	Properties queryProp;
	Properties fontiMap;
	PreparedStatement stmtDSogPEnti;
	PreparedStatement stmtDSogPEntiAltreDen;
	PreparedStatement stmtDSogPPersone;
	PreparedStatement stmtDSogPFamiglie;
	ResultSet rs, rsad;
	FkFonte fkf;
	String fkFonte = null;
	ProfGroup pg;
	private static Logger log;

/*
 * Questo costruttore richiede solo una connessione (che non tocca a lui chiudere, attenzione) che
 * usa solo per creare la preparedStatement, così è pronta per essere eseguita da altri metodi.
 * Molti parametri sono ricavati da file di configurazione. Inoltre è caricata la mappatura fra
 * fonti SIAS e fonti SAS.
 */
	public SoggettiProduttori(Connection conn)
	{
		queryProp = new Properties();
		fontiMap = new Properties();
		try
		{
			queryProp.load(new FileReader("sogp.prop"));
			fontiMap.load(new FileReader("fonti.map"));
			new it.beniculturali.sas.catalogo.commons.ObjectFactory();
			stmtDSogPEnti = conn.prepareStatement(queryProp.getProperty("query.sogp.enti"));
			stmtDSogPPersone = conn.prepareStatement(queryProp.getProperty("query.sogp.persone"));
			stmtDSogPFamiglie = conn.prepareStatement(queryProp.getProperty("query.sogp.famiglie"));
			stmtDSogPEntiAltreDen = conn.prepareStatement(queryProp.getProperty("query.sogp.enti.altreden"));
			log = Logger.getLogger("LOG");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * Nuova versione del createEntity. Questa è più autonoma rispetto alla precedente, qui rimossa,
	 * perché ha bisogno solo di una connessione e di un idIstituto, poi pensa lei a trovare la query
	 * da eseguire e ad usare i risultati come avveniva in quella rimossa, che invece richiedeva già
	 * un resultset
	 */
	public Iterator<DSogp> createEntityEnte(int idIstituto)
	{
		DSogpWrapper dsogpw = null;
		log.info("Istituto " + idIstituto + ", inizio elaborazione soggetti produttori");
		String codiProvenienza = null;
		ArrayList<DSogp> dwl = new ArrayList<DSogp>();
		int idProduttore = 0;
		String fkFonte = null;
		int count = 0;
		try
		{
/*
 * A questo punto la connessione è stabilita. Si prepara una query e si esegue con id_istituto
 */
			stmtDSogPEnti.setInt(1, idIstituto);
			stmtDSogPEnti.execute();

/*
 * rs è il resultset che, per ora, dovrebbe contenere un solo record, per cui si passa subito a
 * next()
 */
			rs = stmtDSogPEnti.getResultSet();
			while(rs.next())
			{
				try
				{
					dsogpw = new DSogpWrapper();
					idProduttore = rs.getInt("id_soggetto");
					codiProvenienza = rs.getString("codi_provenienza");
					log.info("Soggetto " + codiProvenienza + "(" + ++count + ")");
					dsogpw.setCodiProvenienza(codiProvenienza);
					fkFonte = rs.getString("fk_fonte");
					dsogpw.setFkFonte(fontiMap.getProperty(fkFonte));
					dsogpw.setDateEstremoRemoto(rs.getString("date_estremo_remoto"));
					dsogpw.setDateEstremoRecente(rs.getString("date_estremo_recente"));
					dsogpw.setTextEstrCronoTestuali(rs.getString("text_estr_crono_testuali"));
					dsogpw.setTextDenominazione(rs.getString("text_denominazione"));
					dsogpw.setTextDenominazioneCoeva(rs.getString("text_denominazione_coeva_sede"));
					dsogpw.setTextEnteStoria(rs.getString("text_storia"));
					dsogpw.setTextUrl(rs.getString("text_url"));
					stmtDSogPEntiAltreDen.setInt(1, idProduttore);
					stmtDSogPEntiAltreDen.execute();
					rsad = stmtDSogPEntiAltreDen.getResultSet();
					while(rsad.next())
					{
						dsogpw.addAltreDen(rsad.getString(1));
					}
					log.info("Soggetto " + idProduttore + " elaborato");
					dwl.add(dsogpw.getWrappedObject());
				}
				catch(IllegalArgumentException e)
				{
					log.warn("Soggetto " + idProduttore + " scartato: " + e.getMessage());
					continue;
				}
				catch(DatatypeConfigurationException e)
				{
					log.warn("Istituto " + fkFonte + ", soggetto " + idProduttore + " scartato: " + e.getMessage());
					continue;
				}
			}
		}
		catch(SQLException e)
		{
			log.warn("Soggetto " + codiProvenienza + " (" + idIstituto + "): " + e.getMessage() + ", istituto scartato");
			return null;
		}
		log.info("Istituto " + idIstituto + ", fine elaborazione");
		return dwl.iterator();
	}
}
