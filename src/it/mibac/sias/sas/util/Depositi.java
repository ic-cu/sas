package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.depositi.DDepositi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class Depositi
{
	Properties queryProp;
	Properties fontiMap;
	PreparedStatement stmtDDepositi;
	PreparedStatement stmtDLocalizzazione;
	ResultSet rs;
	DDepositi dDep;
	it.beniculturali.sas.catalogo.sogc.ObjectFactory dsogcObf;
	it.beniculturali.sas.catalogo.fonti.ObjectFactory fontiObf;
	it.beniculturali.sas.catalogo.depositi.ObjectFactory depObf;
	String fkFonte = null;

	public Depositi(Connection conn)
	{
		queryProp = new Properties();
		fontiMap = new Properties();
		depObf = new it.beniculturali.sas.catalogo.depositi.ObjectFactory();
		fontiObf = new it.beniculturali.sas.catalogo.fonti.ObjectFactory();
		try
		{
			queryProp.load(new FileReader("query.prop"));
			fontiMap.load(new FileReader("fonti.map"));
			stmtDDepositi = conn.prepareStatement(queryProp
					.getProperty("query.depositi"));
			stmtDLocalizzazione = conn.prepareStatement(queryProp
					.getProperty("query.depositi.localizzazioni"));
			fkFonte = queryProp.getProperty("sogc.fk_fonte");
		}
		catch(FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public Iterator<DDepositi> createEntity(int idIstituto)
	{
		List<DDepositi> depList = new ArrayList<DDepositi>();
		try
		{
			stmtDDepositi.setInt(1, idIstituto);
			stmtDDepositi.execute();

			stmtDLocalizzazione.setInt(1, idIstituto);
			stmtDLocalizzazione.execute();

			/*
			 * rs elenca i depositi e le rispettive localizzazioni, che però vanno
			 * separate in elementi distinti
			 */

			rs = stmtDDepositi.getResultSet();
			DDepositiWrapper ddepw;

			while(rs.next())
			{
				ddepw = new DDepositiWrapper();
				ddepw.setCodiProvenienza(rs.getString("codi_provenienza"));
				ddepw.setTextDenDeposito(rs.getString("text_den_deposito"));
				/*
				 * Per evitare errori di validazione delle fonti, non tutte codificate
				 * correttamente negli XSD, si usa una fonte fittizia sicuramente
				 * valida, ma solo se il valore, ricavato dalle properties, non è nullo
				 */
				if(fkFonte != null)
				{
					ddepw.setFkFonte(fkFonte);
				}
				else
				{
					ddepw.setFkFonte(fontiMap.getProperty(rs.getString("fk_fonte")));
				}
				ddepw.setFkVocTipoDeposito(rs.getLong("fk_voc_tipo_deposito"));
				ddepw
						.setTextEstrCronoTestuali(rs.getString("text_estr_crono_testuali"));

				/*
				 * Ora ci occupiamo della localizzazione di questo deposito
				 */
				ddepw.setDLocalizzazioneIndirizzo(rs.getString("text_indirizzo"));
				ddepw.setDLocalizzazioneProvincia(rs.getString("codi_provincia"));
				ddepw.setDLocalizzazioneComune(rs.getString("codi_comune"));
				ddepw.setDLocalizzazioneCap(rs.getString("text_cap"));
				ddepw.setDLocalizzazioneTextTelefono(rs.getString("text_telefono"));
				ddepw.setDLocalizzazioneTextEmail(rs.getString("text_email"));
				ddepw.setDLocalizzazioneOrariApertura(rs
						.getString("text_orari_apertura"));

				/*
				 * Le localizzazioni dei depositi vanno aggiunte al singolo
				 */
				depList.add(ddepw.getDDepositi());
			}
		}
		catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return depList.iterator();
	}

}
