package it.mibac.sias.sas.test;

import it.mibac.sias.sas.util.DB;
import it.mibac.sias.sas.util.TelefonoSas;

import java.sql.ResultSet;
import java.sql.SQLException;


// classe di test per verificare il funzionamento della classe Telefono
public class TestTelefono
{
	public static void main(String args[])
	{
		DB db = new DB();
		String query = "select telefono, fax from istituti";
		ResultSet rs = db.executeQuery(query);
		String t, f;
		try
		{
			while(rs.next())
			{
				t = rs.getString("telefono");
				f = rs.getString("fax");
				if(t != null)	System.out.println(t + " ==> " + new TelefonoSas(t).getNumero());
				if(f != null) System.out.println(f + " ==> " + new TelefonoSas(f).getNumero());
			}
		}
		catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
