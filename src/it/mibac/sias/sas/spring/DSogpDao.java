package it.mibac.sias.sas.spring;

import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordBody.Entity;
import it.beniculturali.sas.catalogo.sogp.DSogp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/*
 * Classe wrapper attorno ad un DSogc. Non aggiunge quasi niente a DSogc, ma reimplemente alcuni dei
 * metodi di DSogc in modo che accettino tipi primitivi. Viene così nascosta la complessità di certe
 * chiamate, così da rendere il codice invocante più pulito
 */
public class DSogpDao
{
	private Properties config;
	private JdbcTemplate jdbcTemplate;
	private Properties query;

	public DSogpDao()
	{
		config = new Properties();
		query = new Properties();
		try
		{
			config.load(new FileReader("db.prop"));
			query.load(new FileReader("sogp.prop"));
			Class.forName(config.getProperty("database.driver"));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		SimpleDriverDataSource ds = new SimpleDriverDataSource();
    ds.setDriverClass(com.microsoft.sqlserver.jdbc.SQLServerDriver.class);
    ds.setUsername(config.getProperty("database.username"));
    ds.setUrl("jdbc:sqlserver://194.242.226.19;databaseName=archivista_na;user=sias");
		ds.setPassword(config.getProperty("database.password"));
//		ds.setServerName(config.getProperty("database.host"));
//		ds.setInstanceName(config.getProperty("database.instancename"));
//		ds.setDatabaseName(config.getProperty("database.name"));
//		ds.setSelectMethod("direct");
//		ds.setUser(config.getProperty("database.username"));

    jdbcTemplate = new JdbcTemplate(ds);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public Iterator<Entity> getAllDSogp(int idIstituto)
	{
		List<Entity> l = jdbcTemplate.query(query.getProperty("query.sogp.enti"), new Object[] { idIstituto }, new DSogpRowMapper());
		
		return (Iterator<Entity>) jdbcTemplate.query(query.getProperty("query.sogp.enti"), new Object[] { idIstituto }, new DSogpRowMapper()).iterator();
		
	}
}