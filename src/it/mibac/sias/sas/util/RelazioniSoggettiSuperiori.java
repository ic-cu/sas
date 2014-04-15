package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.relazioni.CodiProvenienza;
import it.beniculturali.sas.catalogo.relazioni.DRelSogcSogc;
import it.beniculturali.sas.catalogo.relazioni.ObjectFactory;
import it.beniculturali.sas.catalogo.relazioni.Relazioni;
import it.beniculturali.sas.catalogo.relazioni.Relazioni.Dominante;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class RelazioniSoggettiSuperiori
{
	Properties queryProp;
	PreparedStatement stmtDSogcSup;
	ResultSet rs;

	public RelazioniSoggettiSuperiori(Connection conn)
	{
		queryProp = new Properties();
		try
		{
			queryProp.load(new FileReader("query.prop"));
			new it.beniculturali.sas.catalogo.commons.ObjectFactory();
			stmtDSogcSup = conn.prepareStatement(queryProp
					.getProperty("query.sezioni"));
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Relazioni createRelazione(int idIstituto)
	{
		it.beniculturali.sas.catalogo.relazioni.ObjectFactory relObf;
		relObf = new ObjectFactory();
		Relazioni rel = relObf.createRelazioni();
		try
		{
			stmtDSogcSup.setInt(1, idIstituto);
			stmtDSogcSup.execute();
			rs = stmtDSogcSup.getResultSet();
			if(rs.next())
			{
				CodiProvenienza codiProvenienza = relObf.createCodiProvenienza();
				codiProvenienza.setValue(rs.getString("codi_provenienza_sogc_sup"));
				codiProvenienza.setTipologia("d_sogc");
				Dominante dominante = relObf.createRelazioniDominante();
				dominante.setCodiProvenienza(codiProvenienza);
				rel.setDominante(dominante);
				rel.setRelazione("d_rel_sogc_sogc");
				DRelSogcSogc drss = relObf.createDRelSogcSogc();
				drss.setCodiProvenienzaSogc(rs.getString("codi_provenienza_sogc"));
				drss.setCodiProvenienzaSogcSup(rs
						.getString("codi_provenienza_sogc_sup"));
				rel.getDRelSogcSogc().add(drss);
			}
			else
				rel = null;
		}
		catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rel;
	}
}
