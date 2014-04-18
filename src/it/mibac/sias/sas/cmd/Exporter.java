package it.mibac.sias.sas.cmd;

import it.beniculturali.sas.catalogo.depositi.DDepositi;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordBody.Entity;
import it.beniculturali.sas.catalogo.relazioni.CodiProvenienza;
import it.beniculturali.sas.catalogo.relazioni.DRelSogcDepositi;
import it.beniculturali.sas.catalogo.relazioni.ObjectFactory;
import it.beniculturali.sas.catalogo.relazioni.Relazioni;
import it.beniculturali.sas.catalogo.relazioni.Relazioni.Dominante;
import it.beniculturali.sas.catalogo.sogc.DSogc;
import it.mibac.sias.sas.util.DB;
import it.mibac.sias.sas.util.Depositi;
import it.mibac.sias.sas.util.EnvelopeWrapper;
import it.mibac.sias.sas.util.RecordWrapper;
import it.mibac.sias.sas.util.RelazioniSoggettiSuperiori;
import it.mibac.sias.sas.util.SoggettiConservatori;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Exporter
{
	public Connection connection;
	private DB db;
	private Properties config;

	/*
	 * Questo costruttore prepara la connessione, impostando qualche parametro.
	 * Sarebbe opportuno esternalizzare i parametri.
	 */
	public Exporter()
	{
		db = new DB();
		config = new Properties();
		try
		{
			config.load(new FileReader(new File("query.prop")));
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

	public static XMLGregorianCalendar now()
	{
		// È frequente l'uso di XMLGregorianCalendar, così macchinoso da rendere
		// sicuramente auspicabile la creazione di metodi ausiliari opportuni

		GregorianCalendar gc = new GregorianCalendar();
		XMLGregorianCalendar xgc = null;
		// gc.setTime(new
		// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse("2013-10-17T00:00:00"));
		// gc.getTime();
		// System.err.println(new
		// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(gc.getTime()));
		try
		{
			xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		}
		catch(DatatypeConfigurationException e)
		{
			e.printStackTrace();
		}
		return xgc;
	}

	public static void main(String[] args)
	{
		int idIstituto = Integer.parseInt(args[0]);
		Exporter sse = new Exporter();
		String codiProvenienzaDeposito = null;
		/*
		 * Si costruisce pezzo pezzo l'envelope, per ora sensato solo nel record
		 * vero e proprio. Cerchiamo di usare sempre le objectFactory opportune,
		 * anche se questo comporta il ricorso a FQDN di lunghezza disarmante
		 */
		it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory envObf;
		envObf = new it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory();
		EnvelopeWrapper ew = new EnvelopeWrapper();

		ew.setCREATED(Exporter.now().toGregorianCalendar().getTime());
		ew.setSource("SIAS");
		ew.setFonte("ARCHIVI_DI_STATO");

		/*
		 * Sistemato l'header dell'envelope, veniamo alla sostanza: si crea una
		 * entity in cui metteremo un sogc e si aggiunge la entity alla
		 * recordlist. Anche questo ricorrendo ad un'opportuna obf, quella dei
		 * sogc.
		 */
		Entity ent = envObf.createEnvelopeRecordListRecordRecordBodyEntity();
		// più avanti serve anche una Relazioni
		it.beniculturali.sas.catalogo.relazioni.ObjectFactory relObf;
		relObf = new ObjectFactory();
		Relazioni rel = relObf.createRelazioni();
		SoggettiConservatori sc = new SoggettiConservatori(sse.db.getConnection());
		// ent.getContent().add(sc.createEntity(987800000)); // viterbo
		// ent.getContent().add(sc.createEntity(90110000)); // genova
		// ent.getContent().add(sc.createEntity(605000000)); // napoli
		// ent.getContent().add(sc.createEntity(70010000)); // palermo
		// DSogc dsogc = sc.createEntity(131400000); // ancona
		DSogc dsogc = sc.createEntity(idIstituto);

		/*
		 * Il codi_provenienza del dsogc va messo via in un oggetto Dominante che
		 * poi servirà nella relazione. C'è qualche dubbio sulla tipologia.
		 */

		Dominante dominante = relObf.createRelazioniDominante();
		CodiProvenienza codiProvenienzaDominante = relObf.createCodiProvenienza();
		codiProvenienzaDominante.setValue(dsogc.getCodiProvenienza());
		codiProvenienzaDominante.setTipologia("d_sogc");
		dominante.setCodiProvenienza(codiProvenienzaDominante);
		rel.setDominante(dominante);

		// Finalmente si aggiunge il dsogc alla entity
		ent.getContent().add(dsogc); // ancona
		/*
		 * Ora la entity col sogc è pronta. Possiamo aggiungerla a un recordbody,
		 * che si aggiunge a un record, che si aggiunge a una recordlist, che si
		 * aggiunge all'envelope, più facile di così... Si parte da un
		 * recordheader, ovviamente
		 */


		RecordWrapper rw = new RecordWrapper();
		rw.setDIRECTIVE("DELETE");
		rw.setRecordIdentifier("recordIdProva");
		rw.setRecordDatestamp(Exporter.now().toGregorianCalendar().getTime());
		rw.setEntity(ent);
/*
 * Si crea la recordlist cui si aggiunge il record, e che poi si aggiunge a sua
 * volta all'envelope
 */
		RecordList rl = envObf.createEnvelopeRecordList();
		rl.getRecord().add(rw.getRecord());

		Depositi depositi = new Depositi(sse.db.getConnection());
		ent = envObf.createEnvelopeRecordListRecordRecordBodyEntity();
		Iterator<DDepositi> i = depositi.createEntity(idIstituto); // ancona
		// Iterator<DDepositi> i = dep.createEntity(70010000); // palermo

/*
 * Se ci sono depositi li estrae. Vanno in record separati.
 */

		if(i.hasNext())
		{
			while(i.hasNext())
			{
				DDepositi ddep = i.next();
				codiProvenienzaDeposito = ddep.getCodiProvenienza();
				ent.getContent().add(ddep);
			}
/*
 * si crea la struttura del record per questo deposito
 */
			rw = new RecordWrapper();
			rw.setRecordIdentifier("id-" + Exporter.now().getMillisecond());
			rw.setRecordDatestamp(Exporter.now().toGregorianCalendar().getTime());
			rw.setDIRECTIVE("DELETE");
			rw.setEntity(ent);
			rl.getRecord().add(rw.getRecord());

			/*
			 * Adesso va aggiunto anche un record relazioni per legare questo
			 * deposito al dominante. Proviamo a riciclare rb ed rh, ma non r.
			 */
			rel.setRelazione("d_rel_sogc_depositi");
			DRelSogcDepositi drelSogcDepositi = relObf.createDRelSogcDepositi();
			drelSogcDepositi.setCodiProvenienzaSogc(dsogc.getCodiProvenienza());
			drelSogcDepositi.setCodiProvenienzaDepositi(codiProvenienzaDeposito);
			rel.getDRelSogcDepositi().add(drelSogcDepositi);

			/*
			 * per adesso proviamo a creare header univoci di fantasia
			 */
			/*
			 * anche il body è parzialmente di fantasia
			 */
			rw = new RecordWrapper();
			rw.setRecordIdentifier("id-" + Exporter.now().getMillisecond());
			rw.setRecordDatestamp();
			rw.setDIRECTIVE("DELETE");
			rw.setRelazioni(rel);
			rl.getRecord().add(rw.getRecord());
		}

/*
 * Solo se questo soggetto ha un superiore si crea la corretta relazione con
 * esso. Si potrebbe fare molto meglio di così, evitando una query
 * potenzialmente inutile quando potremmo sapere già se questo istituto è una
 * sezione o no
 */
		RelazioniSoggettiSuperiori relSup = new RelazioniSoggettiSuperiori(sse.db
				.getConnection());
		rel = relSup.createRelazione(idIstituto);
		if(rel != null)
		{
			rw = new RecordWrapper();
			rw.setRecordIdentifier("id-" + Exporter.now().getMillisecond());
			rw.setRecordDatestamp();
			rw.setDIRECTIVE("DELETE");
			rw.setRelazioni(rel);
			rl.getRecord().add(rw.getRecord());
		}
		// env.setRecordList(rl);
		ew.setRecordList(rl);
		ew.marshall();
	}
}