package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.relazioni.CodiProvenienza;
import it.beniculturali.sas.catalogo.relazioni.DRelSogpComparcDatazione;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class RelazioniProduttoriComplessi
{
	Properties queryProp;
	PreparedStatement stmtRel;
	ResultSet rs;

	public RelazioniProduttoriComplessi(Connection conn)
	{
		queryProp = new Properties();
		try
		{
			queryProp.load(new FileReader("sogp.prop"));
			stmtRel = conn.prepareStatement(queryProp.getProperty("query.sogp.comparc"));
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

	public Iterator<Relazioni> createRelazioni(int idIstituto)
	{
		it.beniculturali.sas.catalogo.relazioni.ObjectFactory relObf;
		relObf = new ObjectFactory();
		Relazioni rel;
		ArrayList<Relazioni> list = null;
		try
		{
			stmtRel.setInt(1, idIstituto);
			stmtRel.execute();
			rs = stmtRel.getResultSet();
			list = new ArrayList<Relazioni>();
			while(rs.next())
			{
				CodiProvenienza codiProvenienzaDominante = relObf.createCodiProvenienza();
				codiProvenienzaDominante.setTipologia("d_comparc");
				Dominante dominante = relObf.createRelazioniDominante();
				codiProvenienzaDominante.setValue(rs.getString("dominante_codi_provenienza"));
				dominante.setCodiProvenienza(codiProvenienzaDominante);
				rel = relObf.createRelazioni();
				rel.setDominante(dominante);
				rel.setRelazione("d_rel_sogp_comparc_datazione");
				DRelSogpComparcDatazione dr = relObf.createDRelSogpComparcDatazione();
				dr.setCodiProvenienzaComparc(rs.getString("codi_provenienza_comparc"));
				dr.setCodiProvenienzaSogp(rs.getString("codi_provenienza_sogp"));
				rel.getDRelSogpComparcDatazione().add(dr);
				list.add(rel);
			}
		}
		catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list.iterator();
	}
}
