package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.envelope_catsas.Envelope;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.Header;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.Header.Fonte;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.mibac.sias.sas.cmd.Exporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

/*
 * Wrapper per mascherare complessità evitabili nell'Envelope
 */
public class EnvelopeWrapper
{
	private Envelope env;
	private Header envh;
	private Properties config;
	private it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory envObf;
	private it.beniculturali.sas.catalogo.fonti.ObjectFactory fontiObf;
	private ProfGroup profGroup;
	private Fonte fonte;
	/*
 * Costruttore che inizializza le factory necessarie e i pezzi dell'envelope,
 * legandoli subito fra di loro
 */
	public EnvelopeWrapper()
	{
		envObf = new it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory();
		fontiObf = new it.beniculturali.sas.catalogo.fonti.ObjectFactory();
		env = envObf.createEnvelope();
		envh = envObf.createEnvelopeHeader();
		env.setHeader(envh);
		profGroup = fontiObf.createProfGroup();
		fonte = envObf.createEnvelopeHeaderFonte();
		config = new Properties();
		try
		{
			FileReader prop = new FileReader(new File("query.prop"));
			config.load(prop);
			prop.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

	/* 
	 * Un ovvio getter
	 */
	public Envelope getEnvelope()
	{
		return env;
	}
/*
 * Metodi corrispondenti ad altrettanti metodi o dell'envelope o del suo header
 */
	public void setCREATED(Date d)
	{
		envh.setCREATED(Exporter.now());
	}
	
	public void setCREATED()
	{
		envh.setCREATED(Exporter.now());
	}

	public void setSource(String s)
	{
		envh.setSource(s);
	}

	public void setFonte(String s)
	{
		profGroup.setGroupName(s);
		fonte.setProfGroup(profGroup);
		envh.setFonte(fonte);
	}

	public String getSource()
	{
		return envh.getSource();
	}

	public String getFonte()
	{
		return envh.getFonte().getProfGroup().getGroupName();
	}
	
	public void setRecordList(RecordList rl)
	{
		env.setRecordList(rl);
	}

	public void marshall()
	{
		/*
		 * Si istanza e si applica il marshaller, con poche opzioni
		 */
		JAXBContext jc = null;
		try
		{
			jc = JAXBContext
					.newInstance("it.beniculturali.sas.catalogo.envelope_catsas");
			Marshaller m = jc.createMarshaller();
			Unmarshaller u = jc.createUnmarshaller();
			m.setProperty("jaxb.formatted.output", true);

			/*
			 * Per validare l'output occorre prima istanziare un'oggetto Schema.
			 * Inoltre il marshaller deve avere un eventhandler per evitare che ogni
			 * errore di validazione sia gestito come exception. Tutto però se non è
			 * nulla la location dello schema, altrimenti non si effettua la
			 * validazione
			 */
			if(config.getProperty("xml.schema.location") != null)
			{
				SchemaFactory sf = SchemaFactory
						.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				Schema schema = sf.newSchema(new URL(config
						.getProperty("xml.schema.location")));
				m.setSchema(schema);
				u.setSchema(schema);
//				m.setEventHandler(new SasValidationEventHandler());
				u.setEventHandler(new SasValidationEventHandler());
			}

			/*
			 * Il marshaller creato così ha il difetto di dare ai namespace che
			 * incontra dei nomi non parlanti, tipicamente "nsXX" dove XX è un
			 * progressivo numerico. Il risultato resta un XML valido, ma non è
			 * pratico da leggere, specie in una fase di sviluppo codice. È necessario
			 * allora un mappatore che è appunto quello creato qui sotto. Gli va
			 * indicata una mappa, e poi va indicato a sua volta come prperty del
			 * marshaller.
			 */

			SasNamespacePrefixMapper mapper = new SasNamespacePrefixMapper();

			Properties mapping = new Properties();
			mapping.load(new FileReader(new File("sas-namespace.map")));
			mapper.setMapping(mapping);
			m.setProperty("com.sun.xml.bind.namespacePrefixMapper", mapper);
			m.setProperty("jaxb.schemaLocation", config
					.getProperty("xml.jaxb.schemaLocation"));

			// m.marshal(env, new PrintWriter(new File(config
			// .getProperty("xml.output.filename"))));
			String fileName;
			fileName = config.getProperty("xml.output.directory");
			fileName+= "/" + getSource() + ".xml";
			m.marshal(env, new PrintWriter(new File(fileName)));
			u.unmarshal(new File(fileName));
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(SAXException e)
		{
			e.printStackTrace();
		}
	}

	public void marshall(String fileName)
	{
		/*
		 * Si istanza e si applica il marshaller, con poche opzioni
		 */
		JAXBContext jc = null;
		try
		{
			jc = JAXBContext
					.newInstance("it.beniculturali.sas.catalogo.envelope_catsas");
			Marshaller m = jc.createMarshaller();
			Unmarshaller u = jc.createUnmarshaller();
			m.setProperty("jaxb.formatted.output", true);

			/*
			 * Il marshaller creato così ha il difetto di dare ai namespace che
			 * incontra dei nomi non parlanti, tipicamente "nsXX" dove XX è un
			 * progressivo numerico. Il risultato resta un XML valido, ma non è
			 * pratico da leggere, specie in una fase di sviluppo codice. È necessario
			 * allora un mappatore che è appunto quello creato qui sotto. Gli va
			 * indicata una mappa, e poi va indicato a sua volta come prperty del
			 * marshaller.
			 */

			SasNamespacePrefixMapper mapper = new SasNamespacePrefixMapper();

			Properties mapping = new Properties();
			mapping.load(new FileReader(new File("sas-namespace.map")));
			mapper.setMapping(mapping);
			m.setProperty("com.sun.xml.bind.namespacePrefixMapper", mapper);
			m.setProperty("jaxb.schemaLocation", config
					.getProperty("xml.jaxb.schemaLocation"));

			/*
			 * Per validare l'output occorre prima istanziare un'oggetto Schema.
			 * Inoltre il marshaller deve avere un eventhandler per evitare che ogni
			 * errore di validazione sia gestito come exception. Tutto però se non è
			 * nulla la location dello schema, altrimenti non si effettua la
			 * validazione
			 */
			if(config.getProperty("xml.schema.location") != null)
			{
				SchemaFactory sf = SchemaFactory
						.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				Schema schema = sf.newSchema(new URL(config
						.getProperty("xml.schema.location")));
//				m.setSchema(schema);
				u.setSchema(schema);
				m.setEventHandler(new SasValidationEventHandler());
				u.setEventHandler(new SasValidationEventHandler());
			}
			m.marshal(env, new PrintWriter(new File(fileName)));
			u.unmarshal(new File(fileName));
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(SAXException e)
		{
			e.printStackTrace();
		}
	}

	public void marshall(PrintWriter pw)
	{
		/*
		 * Si istanza e si applica il marshaller, con poche opzioni
		 */
		JAXBContext jc = null;
		try
		{
			jc = JAXBContext
					.newInstance("it.beniculturali.sas.catalogo.envelope_catsas");
			Marshaller m = jc.createMarshaller();
			m.setProperty("jaxb.formatted.output", true);
	
			/*
			 * Per validare l'output occorre prima istanziare un'oggetto Schema.
			 * Inoltre il marshaller deve avere un eventhandler per evitare che ogni
			 * errore di validazione sia gestito come exception. Tutto però se non è
			 * nulla la location dello schema, altrimenti non si effettua la
			 * validazione
			 */
			if(config.getProperty("xml.schema.location") != null)
			{
				SchemaFactory sf = SchemaFactory
						.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				Schema schema = sf.newSchema(new URL(config
						.getProperty("xml.schema.location")));
				m.setSchema(schema);
				m.setEventHandler(new SasValidationEventHandler());
			}
			
			/*
			 * Il marshaller creato così ha il difetto di dare ai namespace che
			 * incontra dei nomi non parlanti, tipicamente "nsXX" dove XX è un
			 * progressivo numerico. Il risultato resta un XML valido, ma non è
			 * pratico da leggere, specie in una fase di sviluppo codice. È necessario
			 * allora un mappatore che è appunto quello creato qui sotto. Gli va
			 * indicata una mappa, e poi va indicato a sua volta come prperty del
			 * marshaller.
			 */
	
			SasNamespacePrefixMapper mapper = new SasNamespacePrefixMapper();
	
			Properties mapping = new Properties();
			mapping.load(new FileReader(new File("sas-namespace.map")));
			mapper.setMapping(mapping);
			m.setProperty("com.sun.xml.bind.namespacePrefixMapper", mapper);
			m.setProperty("jaxb.schemaLocation", config
					.getProperty("xml.jaxb.schemaLocation"));
			m.marshal(env, pw);
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(SAXException e)
		{
			e.printStackTrace();
		}
	}
}
