package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.sogc.DSogc;
import it.beniculturali.sas.catalogo.sogc.DSogc.FkFonte;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class SoggettiConservatori
{
	Properties queryProp;
	PreparedStatement stmtDSogc;
	PreparedStatement stmtDLocalizzazionePrincipale;
	PreparedStatement stmtDLocalizzazioneSecondaria;
	ResultSet rs;
	FkFonte fkf;
	String fkFonte = null;
	ProfGroup pg;
	private static Logger log;

	/*
	 * Questo costruttore richiede solo una connessione (che non tocca a lui
	 * chiudere, attenzione) che usa solo per creare la preparedStatement, così è
	 * pronta per essere eseguita da altri metodi
	 */
	public SoggettiConservatori(Connection conn)
	{
		queryProp = new Properties();
		try
		{
			queryProp.load(new FileReader("query.prop"));
			new it.beniculturali.sas.catalogo.commons.ObjectFactory();
			stmtDSogc = conn.prepareStatement(queryProp.getProperty("query.sogc"));
			stmtDLocalizzazionePrincipale = conn.prepareStatement(queryProp
					.getProperty("query.localizzazione.principale"));
			stmtDLocalizzazioneSecondaria = conn.prepareStatement(queryProp
					.getProperty("query.localizzazione.secondaria"));
			fkFonte = queryProp.getProperty("sogc.fk_fonte");
			log = Logger.getLogger("SOGC");
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
	 * Nuova versione del createEntity. Questa è più autonoma rispetto alla
	 * precedente, qui rimossa, perché ha bisogno solo di una connessione e di un
	 * idIstituto, poi pensa lei a trovare la query da eseguire e ad usare i
	 * risultati come avveniva in quella rimossa, che invece richiedeva già un
	 * resultset
	 */
	public DSogc createEntity(int idIstituto)
	{
		DSogcWrapper dsogcw = null;
		log.info("Istituto " + idIstituto + ", inizio elaborazione");
		try
		{
			/*
			 * A questo punto la connessione è stabilita. Si prepara una query e si
			 * esegue con id_istituto
			 */
			stmtDSogc.setInt(1, idIstituto);
			stmtDSogc.execute();

			/*
			 * rs è il resultset che, per ora, dovrebbe contenere un solo record, per
			 * cui si passa subito a next()
			 */
			rs = stmtDSogc.getResultSet();
			rs.next();

			dsogcw = new DSogcWrapper();
			dsogcw.setCodiProvenienza(rs.getString("codi_provenienza"));
			dsogcw.setTextNazioneIsad(rs.getString("text_nazione_isad"));
			dsogcw.setTextDenominazione(rs.getString("text_denominazione"));
			/*
			 * Per evitare errori di validazione delle fonti, non tutte codificate
			 * correttamente negli XSD, si usa una fonte fittizia sicuramente valida
			 */
			if(fkFonte != null)
			{
				dsogcw.setFkFonte(fkFonte);
			}
			else
			{
				dsogcw.setFkFonte(rs.getString("fk_fonte"));
			}
			dsogcw.setFlagAmmneAttivaTf(rs.getBoolean("amm_attiva"));

			dsogcw.setTextCodiceIsad(rs.getString("text_codice_isad"));
			dsogcw.setTextSiglaIsad(rs.getString("text_sigla_isad"));
			dsogcw.setTextAcronimo(rs.getString("text_acronimo"));
			dsogcw.setFkVocTipoSogc(rs.getLong("tipologia"));
			dsogcw.setFkVocNaturagiuridica(rs.getLong("fk_natura_giuridica"));
			dsogcw.setDContattiTextAnagrafica(rs.getString("text_anagrafica"));
			dsogcw.setFkVocTipoContatto(1);
			dsogcw.setTextEstrCronoTestuali(rs.getString("text_estr_crono_testuali"));
			log.info("Istituto " + idIstituto + ", elaborata anagrafica");

			/*
			 * Popoliamo le localizzazioni. Si usa ovviamente un'altra statement, ma
			 * si ricicla il resultset rs. Le localizzazioni secondarie sono
			 * ripetibili, per cui si dovrà ciclare sul resultset, diversamente da
			 * prima.
			 */

			stmtDLocalizzazionePrincipale.setInt(1, idIstituto);
			stmtDLocalizzazionePrincipale.execute();
			rs = stmtDLocalizzazionePrincipale.getResultSet();
			rs.next();

			dsogcw.setDLocalizzazioneIndirizzo(rs.getString("text_indirizzo"));
			dsogcw.setDLocalizzazioneProvincia(rs.getString("codi_provincia"));
			dsogcw.setDLocalizzazioneComune(rs.getString("codi_comune"));
			dsogcw.setDLocalizzazioneCap(rs.getString("text_cap"));
			dsogcw.setDLocalizzazioneFlgLocPrincipale(rs
					.getBoolean("flag_loc_principale_tf"));
			dsogcw.setDLocalizzazioneTextTelefono(rs.getString("text_telefono"));
			dsogcw.setDLocalizzazioneTextFax(rs.getString("text_fax"));
			dsogcw.setDLocalizzazioneTextEmail(rs.getString("text_email"));
			dsogcw.setDLocalizzazioneTextUrlweb(rs.getString("text_urlweb"));
			dsogcw.setDLocalizzazioneOrariApertura(rs
					.getString("text_orari_apertura"));
			dsogcw.addDLocalizzazione();
			log.info("Istituto " + idIstituto
					+ ", elaborata localizzazione principale "
					+ rs.getString("text_indirizzo"));

			stmtDLocalizzazioneSecondaria.setInt(1, idIstituto);
			stmtDLocalizzazioneSecondaria.execute();
			rs = stmtDLocalizzazioneSecondaria.getResultSet();

			while(rs.next())
			{
				dsogcw.setDLocalizzazioneIndirizzo(rs.getString("text_indirizzo"));
				dsogcw.setDLocalizzazioneProvincia(rs.getString("codi_provincia"));
				dsogcw.setDLocalizzazioneComune(rs.getString("codi_comune"));
				dsogcw.setDLocalizzazioneCap(rs.getString("text_cap"));
				dsogcw.setDLocalizzazioneFlgLocPrincipale(rs
						.getBoolean("flag_loc_principale_tf"));
				dsogcw.setDLocalizzazioneTextTelefono(rs.getString("text_telefono"));
				dsogcw.setDLocalizzazioneTextFax(rs.getString("text_fax"));
				dsogcw.setDLocalizzazioneTextEmail(rs.getString("text_email"));
				dsogcw.setDLocalizzazioneTextUrlweb(rs.getString("text_urlweb"));
				dsogcw.setDLocalizzazioneOrariApertura(rs
						.getString("text_orari_apertura"));
				dsogcw.addDLocalizzazione();
				log.info("Istituto " + idIstituto
						+ ", elaborata localizzazione secondaria "
						+ rs.getString("text_indirizzo"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		log.info("Istituto " + idIstituto + ", fine elaborazione");
		return dsogcw.getDSogc();
	}
}
