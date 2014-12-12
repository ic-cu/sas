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

import org.apache.log4j.Logger;

public class SoggettiProduttori
{
	Properties queryProp;
	Properties fontiMap;
	PreparedStatement stmtDSogPEnti;
	PreparedStatement stmtDSogPPersone;
	PreparedStatement stmtDSogPFamiglie;
	ResultSet rs;
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
// fkFonte = queryProp.getProperty("sogc.fk_fonte");
			log = Logger.getLogger("SOGP");
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
		log.info("Istituto " + idIstituto + ", inizio elaborazione");
		String codiProvenienza = null;
		ArrayList<DSogp> dwl = new ArrayList<DSogp>();
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

				dsogpw = new DSogpWrapper();
				codiProvenienza = rs.getString("codi_provenienza");
				dsogpw.setCodiProvenienza(codiProvenienza);
				dsogpw.setFkFonte(fontiMap.getProperty(rs.getString("fk_fonte")));

// dsogpw.setTextCodiceIsad(rs.getString("text_codice_isad"));
// dsogpw.setTextSiglaIsad(rs.getString("text_sigla_isad"));
// dsogpw.setTextAcronimo(rs.getString("text_acronimo"));
// dsogpw.setFkVocTipoSogc(rs.getLong("tipologia"));
// dsogpw.setFkVocNaturagiuridica(rs.getLong("fk_natura_giuridica"));
// dsogpw.setDContattiTextAnagrafica(rs.getString("text_anagrafica"));
// dsogpw.setFkVocTipoContatto(1);
// dsogpw.setTextEstrCronoTestuali(rs.getString("text_estr_crono_testuali"));
				log.info("Istituto " + idIstituto + ", elaborata anagrafica");
			}
		}
		catch(SQLException e)
		{
			log.warn("Istituto " + codiProvenienza + " (" + idIstituto + "): " + e.getMessage() + ", istituto scartato");
			return null;
		}

		log.info("Istituto " + idIstituto + ", fine elaborazione");
		return dwl.iterator();
	}
}
