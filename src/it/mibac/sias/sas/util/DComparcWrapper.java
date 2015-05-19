package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.commons.DUrl;
import it.beniculturali.sas.catalogo.comparc.DAnticheSegnature;
import it.beniculturali.sas.catalogo.comparc.DComparc;
import it.beniculturali.sas.catalogo.comparc.DComparcAltrecron;
import it.beniculturali.sas.catalogo.comparc.DComparcAltreden;
import it.beniculturali.sas.catalogo.comparc.DComparcCondAccesso;
import it.beniculturali.sas.catalogo.comparc.DComparcDatiConsistenza;
import it.beniculturali.sas.catalogo.comparc.DComparcDatiConsistenza.FkVocTipoOggettiCons;
import it.beniculturali.sas.catalogo.comparc.FkFonte;
import it.beniculturali.sas.catalogo.comparc.FkVocStatoDescrizione;
import it.beniculturali.sas.catalogo.comparc.FkVocTipoComparc;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocStatoDescrizione;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipoComparc;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipoOggettiCons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

/*
 * Classe wrapper attorno ad un DComparc. Non aggiunge quasi niente a DComparc, ma reimplementa
 * quasi tutti i metodi di DComparc corrispondenti a dati Sias in modo che accettino i tipi
 * primitivi provenienti da Sias. Viene così nascosta la complessità di certe chiamate, così da
 * rendere il codice invocante più pulito. La soluzione giusta sarebbe derivare una classe da
 * DComparc, ma questo non è possibile se si usano le factory.
 */

public class DComparcWrapper
{
/*
 * Serviranno spesso alcune object factory, istanziate nel costruttore
 */
	private it.beniculturali.sas.catalogo.comparc.ObjectFactory dcomparcObf;
	private it.beniculturali.sas.catalogo.commons.ObjectFactory comObf;
	private it.beniculturali.sas.catalogo.vocabolari_comparc.ObjectFactory vocComparcObf;
	private it.beniculturali.sas.catalogo.fonti.ObjectFactory fontiObf;

/*
 * Il logger è configurato altrove, e qui viene solo richiamato (vedi costruttore). Non è certo che
 * debbe essere per forza static, altrove non lo è.
 */

	private Logger log;

/*
 * Il member più importante è un DComparc: tutto quello che fa questa classe impatta su di esso.
 */

	private it.beniculturali.sas.catalogo.comparc.DComparc dcomparc;

/*
 * Queste mappe permettono di convertire le sigle automobilistiche e i nomi dei comuni nei
 * corrispondenti codici istat.
 */
	private Properties comuIstat;
	private Properties provIstat;

	public DComparcWrapper()
	{
		dcomparc = new DComparc();
		dcomparcObf = new it.beniculturali.sas.catalogo.comparc.ObjectFactory();
		vocComparcObf = new it.beniculturali.sas.catalogo.vocabolari_comparc.ObjectFactory();
		comObf = new it.beniculturali.sas.catalogo.commons.ObjectFactory();
		fontiObf = new it.beniculturali.sas.catalogo.fonti.ObjectFactory();
		log = Logger.getLogger("LOG");
		loadConfig();
	}

	private void loadConfig()
	{
		comuIstat = new Properties();
		provIstat = new Properties();
		try
		{
			comuIstat.load(new FileReader(new File("comuni-istat.prop")));
			provIstat.load(new FileReader(new File("province-istat.prop")));
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
 * DComparc embedded
 */

	public DComparc getDComparc()
	{
		return dcomparc;
	}

/*
 * Comincia qui una serie di metodi che sono di solito omonimi di quelli di DComparc, ma richiedono
 * tipi primitivi poi opportunamente inseriti nel DComparc.
 */

	public void setCodiProvenienza(String s)
	{
		dcomparc.setCodiProvenienza(s.trim());
	}

	public void setFkVocTipoComparc(long l) throws SiasSasException
	{
		SiasSasException e = null;
		if(l < 1 || l > 18)
		{
			e = new SiasSasException("tipologia complesso " + l + " errata, impostata a 1");
			l = 1;
		}
		DVocTipoComparc dVoc = vocComparcObf.createDVocTipoComparc();
		dVoc.setSequVocTipoComparc(l);
		FkVocTipoComparc fkVoc = dcomparcObf.createFkVocTipoComparc();
		fkVoc.setDVocTipoComparc(dVoc);
		dcomparc.setFkVocTipoComparc(fkVoc);
		if(e != null) throw e;
	}

	public void setTextDenUniformata(String s)
	{
		dcomparc.setTextDenUniformata(s);
	}

	public void setFkFonte(String s) throws SiasSasException
	{
		if(s != null && s.trim() != null)
		{
			FkFonte fkf = dcomparcObf.createFkFonte();
			ProfGroup pg = fontiObf.createProfGroup();
			pg.setGroupName(s);
			fkf.setProfGroup(pg);
			dcomparc.setFkFonte(fkf);
		}
		else
			throw new SiasSasException("fonte nulla");
	}

	public void setTextEstrCronoTestuali(String s)
	{
		log.debug("text_estr_crono_testuali: [" + s + "]");

		if(s != null && s.length() > 0 && !s.equals("null"))
		{
			log.debug("text_estr_crono_testuali: [" + s + "]");
			dcomparc.setTextEstrCronoTestuali(s);
		}
		else
		{
			log.warn("text_estr_crono_testuali = [" + s + "], si imposta 0000-9999");
			dcomparc.setTextEstrCronoTestuali("0000-9999");
		}
	}

	public void setTextNoteData(String s)
	{
		dcomparc.setTextNoteData(s);
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

	/*
	 * Questi due metodi relativi agli estremi cronologici vanno uniformati, perché il codice è quasi
	 * interamente duplicato
	 */

	public void setDateEstremoRemoto(String s) throws DatatypeConfigurationException, IllegalArgumentException
	{
		try
		{
			dcomparc.setDateEstremoRemoto(stringToXGC(s));
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
			ee = new IllegalArgumentException("date_estremo_remoto = " + s);
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
				log.warn("date_estremo_remoto = " + s + " futuro, si imposta a oggi");
				dcomparc.setDateEstremoRemoto(oggi());
			}
		}
	}

	public void setDateEstremoRecente(String s) throws DatatypeConfigurationException, IllegalArgumentException
	{
		try
		{
			dcomparc.setDateEstremoRecente(stringToXGC(s));
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
			ee = new IllegalArgumentException("date_estremo_recente = " + s);
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
				log.warn("date_estremo_recente = " + s + " futuro, si imposta a oggi");
				dcomparc.setDateEstremoRemoto(oggi());
			}
		}
	}

	// public void setDComparcDatiConsistenza(long l)
	// {
	// DVocTipoOggettiCons dVoc;
	// dVoc = vocComparcObf.createDVocTipoOggettiCons();
	// dVoc.setSequVocTipoOggettiCons(l);
	// FkVocTipoOggettiCons fkVoc;
	// fkVoc = dcomparcObf.createDComparcDatiConsistenzaFkVocTipoOggettiCons();
	// fkVoc.setDVocTipoOggettiCons(dVoc);
	// DComparcDatiConsistenza dc;
	// dc = dcomparcObf.createDComparcDatiConsistenza();
	// dc.setFkVocTipoOggettiCons(fkVoc);
	// dcomparc.getDComparcDatiConsistenza().add(dc);
	// }

	public void setTextStoriaArchivistica(String s)
	{
		dcomparc.setTextStoriaArchivistica(s);
	}

	public void setTextUrl(String s)
	{
		if(s != null && s.trim() != null)
		{
			DUrl du;
			du = comObf.createDUrl();
			if(!s.startsWith("http://"))
			{
				s = "http://" + s;
			}
			du.setTextUrl(s);
			dcomparc.getDUrl().add(du);
		}
	}

	public void setTextNumCorda(int i)
	{
		dcomparc.setTextNumCorda(i);
	}

	public void setNumeMtLineariComplessivi(BigDecimal bd)
	{
		dcomparc.setNumeMtLineariComplessivi(bd);
	}

	public void setNumeRipartoMtLineariSottolvl(BigDecimal bd)
	{
		dcomparc.setNumeRipartoMtLineariSottolvl(bd);
	}

	public void addDatiConsistenza(BigDecimal nume, long tipi, String note)
	{
		DComparcDatiConsistenza dc;
		dc = dcomparcObf.createDComparcDatiConsistenza();
		dc.setNumeConsistenza(nume);
		DVocTipoOggettiCons dVoc;
		dVoc = vocComparcObf.createDVocTipoOggettiCons();
		dVoc.setSequVocTipoOggettiCons(tipi);
		FkVocTipoOggettiCons fkVoc;
		fkVoc = dcomparcObf.createDComparcDatiConsistenzaFkVocTipoOggettiCons();
		fkVoc.setDVocTipoOggettiCons(dVoc);
		dc.setFkVocTipoOggettiCons(fkVoc);
		JAXBElement<String> je;
		je = dcomparcObf.createDComparcDatiConsistenzaTextNote(note);
		dc.setTextNote(je);
		dcomparc.getDComparcDatiConsistenza().add(dc);
	}

	public void addAltraDen(String s, String t)
	{
		DComparcAltreden da;
		da = dcomparcObf.createDComparcAltreden();
		da.setFlgTipoDenominazione("ADN");
		da.setTextAltreden(s);
		da.setTextEstrCronoTestuali(t);
		dcomparc.getDComparcAltreden().add(da);
	}

	public void setFkVocStatoDescrizione(int i)
	{
		DVocStatoDescrizione dVoc;
		dVoc = vocComparcObf.createDVocStatoDescrizione();
		dVoc.setSequVocStatoDescrizione(i);
		FkVocStatoDescrizione fkVoc;
		fkVoc = dcomparcObf.createFkVocStatoDescrizione();
		fkVoc.setDVocStatoDescrizione(dVoc);
		dcomparc.setFkVocStatoDescrizione(fkVoc);
	}

	public void setFlagComparcProprietaStatale(String s)
	{
		dcomparc.setFlagComparcProprietaStataleTf(s);
	}

/*
 * Questi due metodi agiscono sull'unico elemento text_note, ma siccome esso può alimentarsi da
 * diversi campi SIAS, il secondo metodo permette di aggiungere pezzi all'unica stringa.
 * Punteggiatura e spaziatura sono a carico del chiamante: il metodo si limita ad un append
 */
	public void setTextNote(String s)
	{
		if(s != null && s.trim() != null && s.length() != 0)
		{
			dcomparc.setTextNote("Note gestionali: " + s);
		}
	}

	public void addTextNote(String s)
	{
		if(s != null && s.trim() != null && s.length() != 0)
		{
			String tmp = dcomparc.getTextNote();
			if(tmp != null)
			{
				tmp += " Note direzione: " + s;
			}
			else
			{
				tmp = s;
			}
			dcomparc.setTextNote(tmp);
		}
	}

	public void setFlagConsultabileConservatore(int i)
	{
		List<DComparcCondAccesso> cal;
		cal = dcomparc.getDComparcCondAccesso();
		DComparcCondAccesso ca;
		if(cal.isEmpty())
		{
			ca = dcomparcObf.createDComparcCondAccesso();
		}
		else
		{
			ca = cal.get(0);
			cal.clear();
		}
		JAXBElement<Boolean> je;
		if(i == 1)
		{
			je = dcomparcObf.createDComparcCondAccessoFlagConsultabileConservatoreTf(true);
		}
		else
		{
			je = dcomparcObf.createDComparcCondAccessoFlagConsultabileConservatoreTf(false);
		}
		ca.setFlagConsultabileConservatoreTf(je);
		cal.add(ca);
	}

	public void setTextTitolareDiritti(String s)
	{
		List<DComparcCondAccesso> cal;
		cal = dcomparc.getDComparcCondAccesso();
		DComparcCondAccesso ca;
		if(cal.isEmpty())
		{
			ca = dcomparcObf.createDComparcCondAccesso();
		}
		else
		{
			ca = cal.get(0);
			cal.clear();
		}
		JAXBElement<String> je;
		je = dcomparcObf.createDComparcCondAccessoTextTitolareDiritti(s);
		ca.setTextTitolareDiritti(je);
		cal.add(ca);
	}

	public void setAltreCronTextEstrCronoTestuali(String s)
	{
		DComparcAltrecron ac;
		ac = dcomparcObf.createDComparcAltrecron();
		ac.setTextEstrCronoTestuali(s);
		dcomparc.getDComparcAltrecron().add(ac);
	}

	public void setAltreCronDateEstremoRecente(String s)
			throws IllegalArgumentException, DatatypeConfigurationException, SiasSasException
	{
		DComparcAltrecron ac;
		ac = dcomparcObf.createDComparcAltrecron();
		JAXBElement<XMLGregorianCalendar> je;
		je = dcomparcObf.createDateEstremoRecente(stringToXGC(s));
		ac.setDateEstremoRecente(je);
		dcomparc.getDComparcAltrecron().add(ac);
	}

	public void setAltreCronDateEstremoRemoto(String s)
			throws IllegalArgumentException, DatatypeConfigurationException, SiasSasException
	{
		DComparcAltrecron ac;
		ac = dcomparcObf.createDComparcAltrecron();
		JAXBElement<XMLGregorianCalendar> je;
		je = dcomparcObf.createDateEstremoRemoto(stringToXGC(s));
		ac.setDateEstremoRemoto(je);
		dcomparc.getDComparcAltrecron().add(ac);
	}

	public void setTextCriteriOrdinamento(String s)
	{
		dcomparc.setTextCriteriOrdinamento(s);
	}

	public void setTextLimitiConsultazione(String s)
	{
		List<DComparcCondAccesso> cal;
		cal = dcomparc.getDComparcCondAccesso();
		DComparcCondAccesso ca;
		if(cal.isEmpty())
		{
			ca = dcomparcObf.createDComparcCondAccesso();
		}
		else
		{
			ca = cal.get(0);
			cal.clear();
		}
		JAXBElement<String> je;
		je = dcomparcObf.createDComparcCondAccessoTextLimitiConsultazione(s);
		ca.setTextLimitiConsultazione(je);
		cal.add(ca);
	}

	public void setTextModoRiproduzione(String s)
	{
		List<DComparcCondAccesso> cal;
		cal = dcomparc.getDComparcCondAccesso();
		DComparcCondAccesso ca;
		if(cal.isEmpty())
		{
			ca = dcomparcObf.createDComparcCondAccesso();
		}
		else
		{
			ca = cal.get(0);
			cal.clear();
		}
		JAXBElement<String> je;
		je = dcomparcObf.createDComparcCondAccessoTextModoRiproduzione(s);
		ca.setTextModoRiproduzione(je);
		cal.add(ca);
	}

	public void setTextAnticaSegnatura(String s)
	{
		DAnticheSegnature as;
		as = dcomparcObf.createDAnticheSegnature();
		as.setTextAnticaSegnatura(s);
		dcomparc.getDAnticheSegnature().add(as);
	}
}
