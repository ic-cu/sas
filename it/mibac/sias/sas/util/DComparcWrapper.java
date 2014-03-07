package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.commons.DUrl;
import it.beniculturali.sas.catalogo.comparc.DComparc;
import it.beniculturali.sas.catalogo.comparc.DComparcAltreden;
import it.beniculturali.sas.catalogo.comparc.DComparcCondAccesso;
import it.beniculturali.sas.catalogo.comparc.FkFonte;
import it.beniculturali.sas.catalogo.comparc.FkVocStatoDescrizione;
import it.beniculturali.sas.catalogo.comparc.FkVocTipoComparc;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocStatoDescrizione;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipoComparc;

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
 * Classe wrapper attorno ad un DComparc. Non aggiunge quasi niente a DComparc,
 * ma reimplementa quasi tutti i metodi di DComparc corrispondenti a dati Sias
 * in modo che accettino i tipi primitivi provenienti da Sias. Viene così
 * nascosta la complessità di certe chiamate, così da rendere il codice
 * invocante più pulito. La soluzione giusta sarebbe derivare una classe da
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
 * Il logger è configurato altrove, e qui viene solo richiamato (vedi
 * costruttore). Non è certo che debbe essere per forza static, altrove non lo
 * è.
 */

	private static Logger log;

/*
 * Il member più importante è un DComparc: tutto quello che fa questa classe
 * impatta su di esso.
 */

	private it.beniculturali.sas.catalogo.comparc.DComparc dcomparc;

/*
 * Queste mappe permettono di convertire le sigle automobilistiche e i nomi dei
 * comuni nei corrispondenti codici istat.
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
 * Questo metodo è fondamentale: dopo aver lavorato sul wrapper, il chiamante
 * gli deve chiedere il DComparc embedded
 */

	public DComparc getDComparc()
	{
		return dcomparc;
	}

/*
 * Comincia qui una serie di metodi che sono di solito omonimi di quelli di
 * DComparc, ma richiedono tipi primitivi poi opportunamente inseriti nel
 * DComparc.
 */

	public void setCodiProvenienza(String s)
	{
		dcomparc.setCodiProvenienza(s.trim());
	}

	public void setFkVocTipoComparc(long l)
	{
		DVocTipoComparc dVoc = vocComparcObf.createDVocTipoComparc();
		dVoc.setSequVocTipoComparc(l);
		FkVocTipoComparc fkVoc = dcomparcObf.createFkVocTipoComparc();
		fkVoc.setDVocTipoComparc(dVoc);
		dcomparc.setFkVocTipoComparc(fkVoc);
	}

	public void setTextDenUniformata(String s)
	{
		dcomparc.setTextDenUniformata(s);
	}

	public void setFkFonte(String s)
	{
		FkFonte fkf = dcomparcObf.createFkFonte();
		ProfGroup pg = fontiObf.createProfGroup();
		pg.setGroupName(s);
		fkf.setProfGroup(pg);
		dcomparc.setFkFonte(fkf);
	}

	public void setTextEstrCronoTestuali(String s)
	{
		dcomparc.setTextEstrCronoTestuali(s);
	}

/*
 * Questi due metodi relativi agli estremi cronologici vanno uniformati, perché
 * il codice è quasi interamente duplicato
 */

	public void setDateEstremoRemoto(String s)
			throws DatatypeConfigurationException, IllegalArgumentException
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
			else if(s != null && s.length() == 7)
			{
				aa = Integer.parseInt(s.substring(0, 3));
				mm = Integer.parseInt(s.substring(3, 5));
				dd = Integer.parseInt(s.substring(5, 7));
			}
			else
			{
				log.warn("date_estremo_remoto = " + s + ", il complesso sarà scartato");
			}
		}
		else
		{
			log.warn("date_estremo_remoto nullo, il complesso sarà scartato");
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
		dcomparc.setDateEstremoRemoto(xgc);
	}

	public void setDateEstremoRecente(String s)
			throws DatatypeConfigurationException, IllegalArgumentException
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
		dcomparc.setDateEstremoRecente(xgc);
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

	public void setTextUrl(String s) throws SiasSasException
	{
		SiasSasException se;
		if(s == null || s.trim() == null)
		{
			s = "http://localhost";
			se = new SiasSasException("url nulla, sarà impostata a " + s);
			throw se;
		}
		DUrl du;
		du = comObf.createDUrl();
		du.setTextUrl(s);
		dcomparc.getDUrl().add(du);
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

	public void addAltraDen(String s, String t)
	{
		DComparcAltreden da;
		da = dcomparcObf.createDComparcAltreden();
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
	
	public void setTextNote(String s)
	{
		dcomparc.setTextNote(s);
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
		dcomparc.getDComparcCondAccesso().add(ca);
	}

	public void setTextTitolareDiritti(String s)
	{
		DComparcCondAccesso ca;
		ca = dcomparcObf.createDComparcCondAccesso();
		JAXBElement<String> je;
		je = dcomparcObf.createDComparcCondAccessoTextTitolareDiritti(s);
		ca.setTextTitolareDiritti(je);
		dcomparc.getDComparcCondAccesso().add(ca);
	}
}
