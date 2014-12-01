package it.mibac.sias.sas.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class Istituti
{
	private PreparedStatement stmtIstituti;
	private Properties config;
	private ArrayList<String> fonti;
	private HashMap<String, String> fontiIstituti, istitutiFonti;

	public Istituti(Connection connection)
	{
		config = new Properties();
		try
		{
			config.load(new FileReader(new File("istituti.prop")));
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		fonti = new ArrayList<String>();
		fontiIstituti = new HashMap<String, String>();
		istitutiFonti = new HashMap<String, String>();
		ResultSet rs;
		try
		{
			stmtIstituti = connection.prepareStatement(config.getProperty("query.istituti"),
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmtIstituti.execute();
			rs = stmtIstituti.getResultSet();
			String idIstituto, fonte;
			while(rs.next())
			{
				idIstituto = rs.getString("ID_Istituto");
				fonte = rs.getString("fk_fonte");
				fonti.add(fonte);
				fontiIstituti.put(idIstituto, fonte);
				istitutiFonti.put(fonte, idIstituto);
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}
	
	public String idIstituto(String fonte)
	{
		return fontiIstituti.get(fonte);		
	}
	
	public int idIstitutoInt(String fonte)
	{
		return Integer.parseInt(idIstituto(fonte));		
	}
	
	public String fonte(String idIstituto)
	{
		return istitutiFonti.get(idIstituto);
	}
	
	public String fonte(int idIstituto)
	{
		return istitutiFonti.get(idIstituto);
	}
	
	public String[] fonti()
	{
		String[] temp = new String[fonti.size()];
		for(int i = 0; i < temp.length; i++)
		{
			temp[i] = fonti.get(i);
		}
		return temp;
	}
}
