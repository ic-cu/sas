package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.sogp.DSogp.FkFonte;
import it.beniculturali.sas.catalogo.sogp.DSogp.FkVocTipoSogp;
import it.beniculturali.sas.catalogo.sogp.DSogp;
import it.beniculturali.sas.catalogo.sogp.DSogpAltreDen;
import it.beniculturali.sas.catalogo.sogp.DSogpDenominazioni;
import it.beniculturali.sas.catalogo.sogp.DSogpEnteStoria;
// import it.beniculturali.sas.catalogo.sogp.DSogpEnteStoria;
import it.beniculturali.sas.catalogo.sogp.DSogpLuogo;
import it.beniculturali.sas.catalogo.sogp.DSogpLuogo.FkVocTipoLuogo;
import it.beniculturali.sas.catalogo.sogp.DSogpTipologiaFunzionale;
import it.beniculturali.sas.catalogo.sogp.DSogpTipologiaFunzionale.FkVocTipofunzSogp;
import it.beniculturali.sas.catalogo.vocabolari_sogp.DVocTipoLuogo;
import it.beniculturali.sas.catalogo.vocabolari_sogp.DVocTipoSogp;
import it.beniculturali.sas.catalogo.vocabolari_sogp.DVocTipofunzSogp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

/*
 * Classe wrapper attorno ad un DSogc. Non aggiunge quasi niente a DSogc, ma reimplemente alcuni dei
 * metodi di DSogc in modo che accettino tipi primitivi. Viene così nascosta la complessità di certe
 * chiamate, così da rendere il codice invocante più pulito
 */
public class DSogpWrapper
{
	/*
	 * Serviranno spesso alcune object factory, istanziate nel costruttore
	 */
	private it.beniculturali.sas.catalogo.sogp.ObjectFactory dsogpObf;
	private it.beniculturali.sas.catalogo.vocabolari_sogp.ObjectFactory vocSogpObf;
	private Logger log;

/*
 * Il member più importante è un DSogc: tutto quello che fa questa classe impatta su di esso, ma a
 * volte indirettamente, tramite member che gli saranno aggiunti prima nel metodo getWrappedObject
 */

	private DSogp dsogp;
	private DSogpDenominazioni dsogpDen;
	private DSogpLuogo dsogpSede;
	private DSogpTipologiaFunzionale dsogpTipFunz;
	private DSogpEnteStoria dsogpEnteStoria;

	/*
	 * Questa mappa permette di convertire le sigle automobilistiche e i nomi dei comuni nei
	 * corrispondenti codici istat. Ho qualche preoccupazione circa l'encoding, perché sembra che
	 * l'istat esporti in latin1.
	 */
	private Properties comuIstat;
	private Properties provIstat;

	public DSogpWrapper()
	{
		dsogpObf = new it.beniculturali.sas.catalogo.sogp.ObjectFactory();
		dsogp = dsogpObf.createDSogp();
		dsogpDen = dsogpObf.createDSogpDenominazioni();
		dsogpSede = dsogpObf.createDSogpLuogo();
		dsogpTipFunz = dsogpObf.createDSogpTipologiaFunzionale();
		dsogpEnteStoria = dsogpObf.createDSogpEnteStoria();
		vocSogpObf = new it.beniculturali.sas.catalogo.vocabolari_sogp.ObjectFactory();
		new it.beniculturali.sas.catalogo.commons.ObjectFactory();
		new it.beniculturali.sas.catalogo.luoghi.ObjectFactory();
		comuIstat = new Properties();
		provIstat = new Properties();
		// dsogp.getDContatti().add(dContatti);
		try
		{
			comuIstat.load(new FileReader(new File("comuni-istat.prop")));
			provIstat.load(new FileReader(new File("province-istat.prop")));
			log = Logger.getLogger("LOG");
			log.debug("Caricati codici ISTAT");
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
 * Questo metodo è fondamentale: dopo aver lavorato sul wrapper, il chiamante gli deve chiedere il
 * DSogc embedded. Prima di ritornarlo, gli aggiunge vari "pezzi" popolati da opportuni metodi
 */

	public DSogp getWrappedObject()
	{
		dsogp.getDSogpDenominazioni().add(dsogpDen);
		dsogp.getDSogpLuogo().add(dsogpSede);
		dsogp.getDSogpTipologiaFunzionale().add(dsogpTipFunz);
		dsogp.getDSogpEnteStoria().add(dsogpEnteStoria);
		return dsogp;
	}

	public void setCodiProvenienza(String s)
	{
		if(s.trim() == null)
		{
			log.warn("codiProvenienza nullo, sarà impostato a ITASVT");
			s = "ITASVT";
		}
		dsogp.setCodiProvenienza(s.trim());
	}

	public void setTextDenominazione(String s)
	{
		DSogpDenominazioni.Denominazione den;
		den = dsogpObf.createDSogpDenominazioniDenominazione();
		den.setTextDenominazione(s);
		dsogpDen.setDenominazione(den);
	}

	public void setFlagAmmneAttivaTf(boolean b)
	{
// dsogp.setFlagAmmneAttivaTf(b);
	}

	public void setFkFonte(String s)
	{
		FkFonte fkf = dsogpObf.createDSogpFkFonte();
		it.beniculturali.sas.catalogo.fonti.ObjectFactory fontiObf;
		fontiObf = new it.beniculturali.sas.catalogo.fonti.ObjectFactory();
		ProfGroup pg = fontiObf.createProfGroup();
		pg.setGroupName(s);
		fkf.setProfGroup(pg);
		dsogp.setFkFonte(fkf);
	}

	public void setFkVocTipoSogp(long l)
	{
		DVocTipoSogp dVoc = vocSogpObf.createDVocTipoSogp();
		dVoc.setSequVocTipoSogp(l);
		FkVocTipoSogp tipologia = dsogpObf.createDSogpFkVocTipoSogp();
		tipologia.setDVocTipoSogp(dVoc);
		dsogp.setFkVocTipoSogp(tipologia);
	}

	public XMLGregorianCalendar stringToXGC(String s)
			throws DatatypeConfigurationException, IllegalArgumentException, SiasSasException
	{
		int aa = 0;
		int mm = 0;
		int dd = 0;
		XMLGregorianCalendar xgc = null;
		if(s != null)
		{
			// Anno dal 1000
			if(s.length() == 8)
			{
				aa = Integer.parseInt(s.substring(0, 4));
				mm = Integer.parseInt(s.substring(4, 6));
				dd = Integer.parseInt(s.substring(6, 8));
			}
			// Anno prima del 1000
			else if(s != null && s.length() == 7)
			{
				aa = Integer.parseInt(s.substring(0, 3));
				mm = Integer.parseInt(s.substring(3, 5));
				dd = Integer.parseInt(s.substring(5, 7));
			}
			else
			{
				SiasSasException ee;
				ee = new SiasSasException("data non valida");
				throw ee;
			}
		}
		else
		{
			SiasSasException ee;
			ee = new SiasSasException("data nulla");
			throw ee;
		}
		DatatypeFactory dtf = DatatypeFactory.newInstance();
		int tz = DatatypeConstants.FIELD_UNDEFINED;
		xgc = dtf.newXMLGregorianCalendarDate(aa, mm, dd, tz);
		if(xgc.compare(dtf.newXMLGregorianCalendar(new GregorianCalendar())) == DatatypeConstants.GREATER)
		{
			SiasSasException ee;
			ee = new SiasSasException("data futura");
			throw ee;
		}
		return xgc;
	}

	private XMLGregorianCalendar oggi() throws DatatypeConfigurationException
	{
		GregorianCalendar gc = new GregorianCalendar();
		int yy = gc.get(Calendar.YEAR);
		int mm = gc.get(Calendar.MONTH) + 1;
		int dd = gc.get(Calendar.DAY_OF_MONTH);
		int tz = DatatypeConstants.FIELD_UNDEFINED;
		DatatypeFactory dtf = DatatypeFactory.newInstance();
		XMLGregorianCalendar xgc = dtf.newXMLGregorianCalendarDate(yy, mm, dd, tz);
		return xgc;
	}

	public void setDateEstremoRecente(String s) throws DatatypeConfigurationException, IllegalArgumentException
	{
		JAXBElement<XMLGregorianCalendar> jb;
		try
		{
			jb = dsogpObf.createDSogpDenominazioniDateEstremoRecente(stringToXGC(s));
			dsogpDen.setDateEstremoRecente(jb);
			dsogp.setDateEstremoRecente(jb);
		}
		catch(DatatypeConfigurationException e)
		{
			DatatypeConfigurationException ee;
			ee = new DatatypeConfigurationException(e.getMessage());
			throw ee;
		}
		catch(IllegalArgumentException e)
		{
			IllegalArgumentException ee;
			ee = new IllegalArgumentException("IllegalArgumentException: date_estremo_recente = [" + s + "]");
			throw ee;
		}
		catch(SiasSasException e)
		{
			if(e.getMessage().equals("data nulla"))
			{
				log.warn("date_estremo_recente 'null pointer', si lascia nil");
			}
			if(e.getMessage().equals("data non valida"))
			{
				log.warn("date_estremo_recente = " + s + ", si lascia nil");
			}
			if(e.getMessage().equals("data futura"))
			{
				log.warn("date_estremo_recente = " + s + " futuro, si ignora");
//				log.warn("date_estremo_recente = " + s + " futuro, si imposta a oggi");
//				jb = dsogpObf.createDSogpDenominazioniDateEstremoRecente(oggi());
//				dsogpDen.setDateEstremoRecente(jb);
//				dsogp.setDateEstremoRecente(jb);
			}
		}
	}

	public void setDateEstremoRemoto(String s) throws DatatypeConfigurationException, IllegalArgumentException
	{
		JAXBElement<XMLGregorianCalendar> jb;
		try
		{
			jb = dsogpObf.createDSogpDenominazioniDateEstremoRemoto(stringToXGC(s));
			dsogpDen.setDateEstremoRemoto(jb);
			dsogp.setDateEstremoRecente(jb);
		}
		catch(DatatypeConfigurationException e)
		{
			DatatypeConfigurationException ee;
			ee = new DatatypeConfigurationException(e.getMessage());
			throw ee;
		}
		catch(IllegalArgumentException e)
		{
			IllegalArgumentException ee;
			ee = new IllegalArgumentException("date_estremo_remoto = " + s + "]");
			throw ee;
		}
		catch(SiasSasException e)
		{
			if(e.getMessage().equals("data nulla"))
			{
				log.warn("date_estremo_remoto 'null pointer', si lascia nil");
			}
			if(e.getMessage().equals("data non valida"))
			{
				log.warn("date_estremo_remoto = " + s + ", si lascia nil");
			}
			if(e.getMessage().equals("data futura"))
			{
				log.warn("date_estremo_remoto = " + s + " futuro, si ignora");
//				log.warn("date_estremo_remoto = " + s + " futuro, si imposta a oggi");
//				jb = dsogpObf.createDSogpDenominazioniDateEstremoRemoto(oggi());
//				dsogpDen.setDateEstremoRemoto(jb);
//				dsogp.setDateEstremoRecente(jb);
			}
		}
	}

	public void setTextEstrCronoTestuali(String s)
	{
		JAXBElement<String> je;
		je = dsogpObf.createDSogpDenominazioniTextEstrCronoTestuali(s);
		dsogpDen.setTextEstrCronoTestuali(je);
		dsogp.setTextEstrCronoTestuali(je);
	}

/*
 * Questo metodo dovrebbe solo impostare la denominazione testuale della sede, ma il tipo "sede" è
 * specificato come voce di vocabolario, ed è fisso in SIAS, per cui viene implicitamente impostato
 * qui, senza creare un metodo apposito.
 */

	public void setTextDenominazioneCoeva(String s)
	{
		DVocTipoLuogo dVoc;
		dVoc = vocSogpObf.createDVocTipoLuogo();
		dVoc.setSequVocTipoLuogo(2);
		FkVocTipoLuogo fkVoc;
		fkVoc = dsogpObf.createDSogpLuogoFkVocTipoLuogo();
		fkVoc.setDVocTipoLuogo(dVoc);
		JAXBElement<FkVocTipoLuogo> je;
		je = dsogpObf.createDSogpLuogoFkVocTipoLuogo(fkVoc);
		dsogpSede.setFkVocTipoLuogo(je);
		dsogpSede.setTextDenominazioneCoeva(s);
	}

	public void setFkVocTipofunzSogp(long l)
	{
		if(l == 0)
		{
			l = 1;
			log.error("Tipologia funziona 0, si imposta a 1");
		}
		DVocTipofunzSogp dVoc;
		dVoc = vocSogpObf.createDVocTipofunzSogp();
		dVoc.setSequVocTipofunzSogp(l);
		FkVocTipofunzSogp fkVoc;
		fkVoc = dsogpObf.createDSogpTipologiaFunzionaleFkVocTipofunzSogp();
		fkVoc.setDVocTipofunzSogp(dVoc);
		dsogpTipFunz.setFkVocTipofunzSogp(fkVoc);
	}

	public void setTextEnteStoria(String s)
	{
		if(s != null && s.trim() != "") dsogpEnteStoria.setTextStoria(s);
	}

	public void setTextNote(String s)
	{
		if(s != null && ! s.trim().equals(""))
		{
			JAXBElement<String> je;
			je = dsogpObf.createDSogpTextNote(s.trim());
			dsogp.setTextNote(je);
		}
	}
	
	public void setTextUrl(String s)
	{
		if(s != null && ! s.trim().equals(""))
		{
			dsogpEnteStoria.setTextUrl(s);
			log.warn("text_url = [" +s + "]");
		}
		else
		{
			dsogpEnteStoria.setTextUrl("non disponibile");
		}
	}
	
	public void addAltreDen(String s)
	{
		DSogpAltreDen ad;
		ad = dsogpObf.createDSogpAltreDen();
		ad.setTextAltraDen(s);
		dsogp.getDSogpAltreDen().add(ad);
	}
}