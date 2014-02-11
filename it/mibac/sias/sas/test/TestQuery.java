package it.mibac.sias.sas.test;

import it.mibac.sias.sas.util.DB;
import it.mibac.sias.sas.util.TelefonoSas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


// classe di test per verificare il funzionamento della classe Telefono
public class TestQuery
{
	public static void main(String args[])
	{
		Properties config = new Properties();
		try
		{
			config.load(new FileReader(new File("query.prop")));
			DB db = new DB();
			Connection conn = db.getConnection();
			String query = config.getProperty("query.sogc");
			System.out.println(query);
			PreparedStatement stmt;
			stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.setInt(1, 450180000);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			int cols = rs.getMetaData().getColumnCount();
			int rows = 0;
			while(rs.next())
			{
				rows++;
				for(int i = 1; i <= cols; i++)
				{
					System.out.println(rows + " ==> " + rs.getString(i));
				}
			}
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
