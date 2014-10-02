package it.mibac.sias.sas.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

public class XSD
{
	private Properties config;
	private String baseUrl;
	private Vector<String> elenco;

	public XSD()
	{
		Properties config = new Properties();
		try
		{
			config.load(new FileReader(new File("xsd.prop")));
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		baseUrl = config.getProperty("xsd.baseurl");
		elenco = new Vector<String>();
		String parole = config.getProperty("xsd.list");
		StringTokenizer st = new StringTokenizer(parole, " \t");
		while(st.hasMoreTokens())
		{
			String parola = st.nextToken();
			elenco.add(parola + ".xsd");
		}
	}
	
	private String downloadXSD(String url, String fileName)
	{
		InputStream is = null;
		try
		{
			System.err.println(url);
			is = new URL(url).openStream();
		}
		catch(MalformedURLException e2)
		{
			e2.printStackTrace();
		}
		catch(IOException e2)
		{
			e2.printStackTrace();
		}
		ByteArrayOutputStream os = null;
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(fileName);
		}
		catch(FileNotFoundException e1)
		{
		}
		try
		{
			byte[] chunk = new byte[4096];
			int bytesRead;
			os = new ByteArrayOutputStream();
			while((bytesRead = is.read(chunk)) > 0)
			{
				os.write(chunk, 0, bytesRead);
				fos.write(chunk, 0, bytesRead);
			}
			fos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return os.toString();
	}
	
	public void download()
	{
		Iterator<String> is = elenco.iterator();
		while(is.hasNext())
		{
			String fileName = is.next();
			downloadXSD(baseUrl + "/" + fileName, "xsd/new-" + fileName);
		}		
	}
	
	public static void main(String args[])
	{
		XSD xsd = new XSD();
		xsd.download();
	}
}
