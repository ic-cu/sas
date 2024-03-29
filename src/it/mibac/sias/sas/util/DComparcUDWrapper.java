package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.commons.DUrl;
import it.beniculturali.sas.catalogo.comparc.DAnticheSegnature;
import it.beniculturali.sas.catalogo.comparc.DComparcAltrecron;
import it.beniculturali.sas.catalogo.comparc.DComparcAltreden;
import it.beniculturali.sas.catalogo.comparc.DComparcCondAccesso;
import it.beniculturali.sas.catalogo.comparc.DComparcUa;
import it.beniculturali.sas.catalogo.comparc.FkFonte;
import it.beniculturali.sas.catalogo.comparc.FkVocStatoConservazione;
import it.beniculturali.sas.catalogo.comparc.FkVocStatoDescrizione;
import it.beniculturali.sas.catalogo.comparc.FkVocTipoComparc;
import it.beniculturali.sas.catalogo.comparc.FkVocTipoLinguaContenuto;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocStatoConservazione;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocStatoDescrizione;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipoComparc;
import it.beniculturali.sas.catalogo.vocabolari_trasv.DVocTipoLingua;
import it.beniculturali.sas.catalogo.vocabolari_trasv.ObjectFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
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

public class DComparcUDWrapper
{
/*
 * Serviranno spesso alcune object factory, istanziate nel costruttore
 */
	private it.beniculturali.sas.catalogo.comparc.ObjectFactory							dcomparcObf;
	private it.beniculturali.sas.catalogo.commons.ObjectFactory							comObf;
	private it.beniculturali.sas.catalogo.vocabolari_comparc.ObjectFactory	vocComparcObf;
	private it.beniculturali.sas.catalogo.vocabolari_trasv.ObjectFactory		vocTrasvObf;
	private it.beniculturali.sas.catalogo.fonti.ObjectFactory								fontiObf;

/*
 * Il logger è configurato altrove, e qui viene solo richiamato (vedi costruttore). Non è certo che
 * debbe essere per forza static, altrove non lo è.
 */

	private static Logger																										log;

/*
 * Il member più importante è un DComparc: tutto quello che fa questa classe impatta su di esso.
 */

	private it.beniculturali.sas.catalogo.comparc.DComparcUa									dcomparc_ua;

/*
 * Queste mappe permettono di convertire le sigle automobilistiche e i nomi dei comuni nei
 * corrispondenti codici istat.
 */
	private Properties																											comuIstat;
	private Properties																											provIstat;

	public DComparcUDWrapper()
	{
		dcomparc_ua = new DComparcUa();
		dcomparcObf = new it.beniculturali.sas.catalogo.comparc.ObjectFactory();
		vocComparcObf = new it.beniculturali.sas.catalogo.vocabolari_comparc.ObjectFactory();
		comObf = new it.beniculturali.sas.catalogo.commons.ObjectFactory();
		fontiObf = new it.beniculturali.sas.catalogo.fonti.ObjectFactory();
		vocTrasvObf = new it.beniculturali.sas.catalogo.vocabolari_trasv.ObjectFactory();
		initLogger();
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

	private void initLogger()
	{
		log = Logger.getLogger("COMPARC");
	}

/*
 * Questo metodo è fondamentale: dopo aver lavorato sul wrapper, il chiamante gli deve chiedere il
 * DComparc embedded
 */

	public DComparcUa getDComparc()
	{
		return dcomparc_ua;
	}

/*
 * Comincia qui una serie di metodi che sono di solito omonimi di quelli di DComparc, ma richiedono
 * tipi primitivi poi opportunamente inseriti nel DComparc.
 */

	public void setCodiProvenienza(String s)
	{
		dcomparc_ua.setCodiProvenienza(s.trim());
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
		dcomparc_ua.setFkVocTipoComparc(fkVoc);
		if(e != null) throw e;
	}

	public void setTextDenUniformata(String s)
	{
		dcomparc_ua.setTextDenUniformata(s);
	}

	public void setTextDenCritica(String s)
	{
		dcomparc_ua.setTextDenCritica(s);
	}

	public void setFkVocTipoLinguaContenuto(long l)
	{
		DVocTipoLingua dVoc;
		dVoc = vocTrasvObf.createDVocTipoLingua();
		dVoc.setSequVocTipoLingua(l);
		FkVocTipoLinguaContenuto fkVoc;
		fkVoc = dcomparcObf.createFkVocTipoLinguaContenuto();
		fkVoc.setDVocTipoLingua(dVoc);
		
		dcomparc_ua.setFkVocTipoLinguaContenuto(fkVoc);
	}
	
	public void setFkFonte(String s) throws SiasSasException
	{
		if(s != null && s.trim() != null)
		{
			FkFonte fkf = dcomparcObf.createFkFonte();
			ProfGroup pg = fontiObf.createProfGroup();
			pg.setGroupName(s);
			fkf.setProfGroup(pg);
			dcomparc_ua.setFkFonte(fkf);
		}
		else
			throw new SiasSasException("fonte nulla");
	}

	public void setTextEstrCronoTestuali(String s)
	{
		dcomparc_ua.setTextEstrCronoTestuali(s);
	}

	public void setTextNoteData(String s)
	{
		dcomparc_ua.setTextNoteData(s);
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
// log.warn("date_estremo_remoto = " + s + ", il complesso sarà scartato");
			}
		}
		else
		{
			SiasSasException ee;
			ee = new SiasSasException("data nulla");
			throw ee;
// log.warn("date_estremo_remoto nullo, il complesso sarà scartato");
		}
		DatatypeFactory dtf = DatatypeFactory.newInstance();
		int tz = DatatypeConstants.FIELD_UNDEFINED;
		xgc = dtf.newXMLGregorianCalendarDate(aa, mm, dd, tz);
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
			dcomparc_ua.setDateEstremoRemoto(stringToXGC(s));
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
			if(e.getMessage().equals("data nulla")) log.warn("date_estremo_remoto nullo, il complesso sarà scartato");
			if(e.getMessage().equals("data non valida"))
				log.warn("date_estremo_remoto = " + s + ", il complesso sarà scartato");
		}
	}

	public void setDateEstremoRecente(String s) throws DatatypeConfigurationException, IllegalArgumentException
	{
		int aa = 0;
		int mm = 0;
		int dd = 0;
		String msg = null;
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
			else if(s.length() == 7)
			{
				aa = Integer.parseInt(s.substring(0, 3));
				mm = Integer.parseInt(s.substring(3, 5));
				dd = Integer.parseInt(s.substring(5, 7));
			}
			else
			{
				msg = "date_estremo_recente = " + s + ", il complesso sarà scartato";
				log.warn(msg);
			}
		}
		else
		{
			msg = "date_estremo_recente nullo, il complesso sarà scartato";
			log.warn(msg);
		}
		try
		{
			DatatypeFactory dtf = DatatypeFactory.newInstance();
			int tz = DatatypeConstants.FIELD_UNDEFINED;
			xgc = dtf.newXMLGregorianCalendarDate(aa, mm, dd, tz);
		}
		catch(DatatypeConfigurationException e)
		{
			DatatypeConfigurationException ee;
			ee = new DatatypeConfigurationException(msg);
			throw ee;
		}
		catch(IllegalArgumentException e)
		{
			IllegalArgumentException ee;
			ee = new IllegalArgumentException("date_estremo_recente = " + s);
			throw ee;
		}
		dcomparc_ua.setDateEstremoRecente(xgc);
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
		dcomparc_ua.setTextStoriaArchivistica(s);
	}

	public void setTextUrl(String s)
	{
		if(s != null && s.trim() != null)
		{
			DUrl du;
			du = comObf.createDUrl();
			du.setTextUrl(s);
			dcomparc_ua.getDUrl().add(du);
		}
	}

	public void setTextNumCorda(int i)
	{
		dcomparc_ua.setTextNumCorda(i);
	}

	public void setNumeMtLineariComplessivi(BigDecimal bd)
	{
		dcomparc_ua.setNumeMtLineariComplessivi(bd);
	}

	public void setNumeRipartoMtLineariSottolvl(BigDecimal bd)
	{
		dcomparc_ua.setNumeRipartoMtLineariSottolvl(bd);
	}

	public void addAltraDen(String s, String t)
	{
		DComparcAltreden da;
		da = dcomparcObf.createDComparcAltreden();
		da.setTextAltreden(s);
		da.setTextEstrCronoTestuali(t);
		dcomparc_ua.getDComparcAltreden().add(da);
	}

	public void setFkVocStatoDescrizione(int i)
	{
		DVocStatoDescrizione dVoc;
		dVoc = vocComparcObf.createDVocStatoDescrizione();
		dVoc.setSequVocStatoDescrizione(i);
		FkVocStatoDescrizione fkVoc;
		fkVoc = dcomparcObf.createFkVocStatoDescrizione();
		fkVoc.setDVocStatoDescrizione(dVoc);
		dcomparc_ua.setFkVocStatoDescrizione(fkVoc);
	}

	public void setFlagComparcProprietaStatale(String s)
	{
		dcomparc_ua.setFlagComparcProprietaStataleTf(s);
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
			dcomparc_ua.setTextNote(s);
		}
	}

	public void addTextNote(String s)
	{
		if(s != null && s.trim() != null && s.length() != 0)
		{
			String tmp = dcomparc_ua.getTextNote();
			if(tmp != null)
			{
				tmp += s;
			}
			else
			{
				tmp = s;
			}
			dcomparc_ua.setTextNote(tmp);
		}
	}

	public void setFlagConsultabileConservatore(int i)
	{
		DComparcCondAccesso ca;
		ca = dcomparcObf.createDComparcCondAccesso();
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
		dcomparc_ua.getDComparcCondAccesso().add(ca);
	}

	public void setTextTitolareDiritti(String s)
	{
		DComparcCondAccesso ca;
		ca = dcomparcObf.createDComparcCondAccesso();
		JAXBElement<String> je;
		je = dcomparcObf.createDComparcCondAccessoTextTitolareDiritti(s);
		ca.setTextTitolareDiritti(je);
		dcomparc_ua.getDComparcCondAccesso().add(ca);
	}

	public void setTextCriteriOrdinamento(String s)
	{
		dcomparc_ua.setTextCriteriOrdinamento(s);
	}

	public void setTextLimitiConsultazione(String s)
	{
		DComparcCondAccesso ca;
		ca = dcomparcObf.createDComparcCondAccesso();
		JAXBElement<String> je;
		je = dcomparcObf.createDComparcCondAccessoTextLimitiConsultazione(s);
		ca.setTextLimitiConsultazione(je);
		dcomparc_ua.getDComparcCondAccesso().add(ca);
	}

	public void setTextModoRiproduzione(String s)
	{
		DComparcCondAccesso ca;
		ca = dcomparcObf.createDComparcCondAccesso();
		JAXBElement<String> je;
		je = dcomparcObf.createDComparcCondAccessoTextModoRiproduzione(s);
		ca.setTextModoRiproduzione(je);
		dcomparc_ua.getDComparcCondAccesso().add(ca);
	}
	
	public void setFkVocStatoConservazione(long l)
	{
		DVocStatoConservazione dVoc;
		dVoc = vocComparcObf.createDVocStatoConservazione();
		dVoc.setSequVocStatoConservazione(l);
		FkVocStatoConservazione fkVoc;
		fkVoc = dcomparcObf.createFkVocStatoConservazione();
		fkVoc.setDVocStatoConservazione(dVoc);
		dcomparc_ua.setFkVocStatoConservazione(fkVoc);
	}

	public void setTextAnticaSegnatura(String s)
	{
		DAnticheSegnature as;
		as = dcomparcObf.createDAnticheSegnature();
		as.setTextAnticaSegnatura(s);
		dcomparc_ua.getDAnticheSegnature().add(as);
	}
}
