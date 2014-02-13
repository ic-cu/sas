package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.commons.DUrl;
import it.beniculturali.sas.catalogo.comparc.DComparc;
import it.beniculturali.sas.catalogo.comparc.DComparcAltreden;
import it.beniculturali.sas.catalogo.comparc.FkFonte;
import it.beniculturali.sas.catalogo.comparc.FkVocTipoComparc;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipoComparc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

/*
 * Classe wrapper attorno ad un DSogc. Non aggiunge quasi niente a DSogc, ma
 * reimplemente alcuni dei metodi di DSogc in modo che accettino tipi primitivi.
 * Viene così nascosta la complessità di certe chiamate, così da rendere il
 * codice invocante più pulito
 */
public class DComparcWrapper
{
	/*
	 * Serviranno spesso alcune object factory, istanziate nel costruttore
	 */
	private it.beniculturali.sas.catalogo.comparc.ObjectFactory dcomparcObf;
	private it.beniculturali.sas.catalogo.commons.ObjectFactory comObf;
	private it.beniculturali.sas.catalogo.vocabolari_comparc.ObjectFactory vocComparcObf;
	private static Logger log;

	/*
	 * Il member più importante è un DSogc: tutto quello che fa questa classe
	 * impatta su di esso.
	 */

	private it.beniculturali.sas.catalogo.comparc.DComparc dcomparc;

	/*
	 * Questa mappa permette di convertire le sigle automobilistiche e i nomi dei
	 * comuni nei corrispondenti codici istat. Ho qualche preoccupazione circa
	 * l'encoding, perché sembra che l'istat esporti in latin1.
	 */
	private Properties comuIstat;
	private Properties provIstat;

	public DComparcWrapper()
	{
		dcomparc = new DComparc();
		dcomparcObf = new it.beniculturali.sas.catalogo.comparc.ObjectFactory();
		vocComparcObf = new it.beniculturali.sas.catalogo.vocabolari_comparc.ObjectFactory();
		comObf = new it.beniculturali.sas.catalogo.commons.ObjectFactory();
		new it.beniculturali.sas.catalogo.commons.ObjectFactory();
		new it.beniculturali.sas.catalogo.luoghi.ObjectFactory();
		comuIstat = new Properties();
		provIstat = new Properties();
		try
		{
			comuIstat.load(new FileReader(new File("comuni-istat.prop")));
			provIstat.load(new FileReader(new File("province-istat.prop")));
			log = Logger.getLogger("COMPARC");
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
	 * Questo metodo è fondamentale: dopo aver lavorato sul wrapper, il chiamante
	 * gli deve chiedere il DSogc embedded
	 */

	public DComparc getDComparc()
	{
		return dcomparc;
	}

	public void setCodiProvenienza(String s)
	{
		if(s.trim() == null)
		{
			log.warn("codiProvenienza nullo, sarà impostato a ITASVT");
			s = "ITASVT";
		}
		dcomparc.setCodiProvenienza(s.trim());
	}

	public void setFkVocTipoComparc(long l)
	{
		DVocTipoComparc dVoc = vocComparcObf.createDVocTipoComparc();
		dVoc.setSequVocTipoComparc(l);
		FkVocTipoComparc fkVoc = dcomparcObf.createFkVocTipoComparc();
		// fkVoc.getDVocTipoComparc().add(dVoc);
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
		it.beniculturali.sas.catalogo.fonti.ObjectFactory fontiObf;
		fontiObf = new it.beniculturali.sas.catalogo.fonti.ObjectFactory();
		ProfGroup pg = fontiObf.createProfGroup();
		pg.setGroupName(s);
		fkf.setProfGroup(pg);
		dcomparc.setFkFonte(fkf);
	}

	public void setTextEstrCronoTestuali(String s)
	{
		dcomparc.setTextEstrCronoTestuali(s);
	}

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

	public void setTextUrl(String s)
	{
		if(s == null || s.trim() == null)
		{
			s = "http://nessuna.url.it";
			log.warn("url nulla, avrà un valore fittizio");
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

	public void addAltraDen(String s)
	{
		DComparcAltreden da;
		da = dcomparcObf.createDComparcAltreden();
		da.setTextAltreden(s);
		dcomparc.getDComparcAltreden().add(da);
	}
}
