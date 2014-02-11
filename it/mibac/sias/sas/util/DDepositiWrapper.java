package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.commons.DLocalizzazione;
import it.beniculturali.sas.catalogo.commons.DLocalizzazione.FkIstatComune;
import it.beniculturali.sas.catalogo.commons.DLocalizzazione.FkProvincia;
import it.beniculturali.sas.catalogo.depositi.DDepositi;
import it.beniculturali.sas.catalogo.depositi.DDepositi.FkFonte;
import it.beniculturali.sas.catalogo.depositi.DDepositi.FkVocTipoDeposito;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.luoghi.DComune;
import it.beniculturali.sas.catalogo.luoghi.DProvincia;
import it.beniculturali.sas.catalogo.vocabolari_sogc.DVocTipoDeposito;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DDepositiWrapper
{
	private it.beniculturali.sas.catalogo.vocabolari_sogc.ObjectFactory vocSogcObf;
	private it.beniculturali.sas.catalogo.commons.ObjectFactory comObf;
	private it.beniculturali.sas.catalogo.luoghi.ObjectFactory luoghiObf;
	private it.beniculturali.sas.catalogo.depositi.ObjectFactory depObf;
	it.beniculturali.sas.catalogo.fonti.ObjectFactory fontiObf;
	private Properties comuIstat;
	private Properties provIstat;
	private static Logger log;

	private DDepositi dDepositi;
	private DLocalizzazione dLocalizzazione;

	public DDepositiWrapper()
	{
		depObf = new it.beniculturali.sas.catalogo.depositi.ObjectFactory();
		new it.beniculturali.sas.catalogo.sogc.ObjectFactory();
		vocSogcObf = new it.beniculturali.sas.catalogo.vocabolari_sogc.ObjectFactory();
		comObf = new it.beniculturali.sas.catalogo.commons.ObjectFactory();
		luoghiObf = new it.beniculturali.sas.catalogo.luoghi.ObjectFactory();
		fontiObf = new it.beniculturali.sas.catalogo.fonti.ObjectFactory();
		dDepositi = depObf.createDDepositi();
		dLocalizzazione = comObf.createDLocalizzazione();
		comuIstat = new Properties();
		provIstat = new Properties();
		log = Logger.getLogger("SOGC");
		try
		{
			comuIstat.load(new FileReader(new File("comuni-istat.prop")));
			provIstat.load(new FileReader(new File("province-istat.prop")));
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

	public void setCodiProvenienza(String s)
	{
		if(s.trim() == null)
		{
			s = "ITASVT";
		}
		dDepositi.setCodiProvenienza(s);
	}

	public void setTextDenDeposito(String s)
	{
		dDepositi.setTextDenDeposito(s);
	}

	public void setFkFonte(String s)
	{
		ProfGroup p = fontiObf.createProfGroup();
		p.setGroupName(s);
		FkFonte f = depObf.createDDepositiFkFonte();
		f.setProfGroup(p);
		dDepositi.setFkFonte(f);
	}

	public void setFkVocTipoDeposito(long l)
	{
		DVocTipoDeposito d = vocSogcObf.createDVocTipoDeposito();
		d.setSequVocTipoDeposito(l);
		FkVocTipoDeposito f = depObf.createDDepositiFkVocTipoDeposito();
		f.setDVocTipoDeposito(d);
		dDepositi.setFkVocTipoDeposito(f);
	}

	public void setTextEstrCronoTestuali(String s)
	{
		dDepositi.setTextEstrCronoTestuali(s);
	}

	public void setDLocalizzazioneIndirizzo(String s)
	{
		dLocalizzazione.setTextIndirizzo(s);
	}

	public void setDLocalizzazioneProvincia(String s)
	{
		DProvincia dPro = luoghiObf.createDProvincia();
		if(s.trim() == null)
		{
			s = "RM";
			log.warn("Sigla provincia " + s
					+ " non valida, sarà impostato il codice di RM");
		}
		else
		{
			if(s.trim().equalsIgnoreCase("PS"))
			{
				s = "PU";
			}
			if(s.trim().equalsIgnoreCase("FO"))
			{
				s = "FC";
			}
		}
		dPro.setCodiProvincia(provIstat.getProperty(s.trim()));
		FkProvincia fkPro = comObf.createDLocalizzazioneFkProvincia();
		fkPro.setDProvincia(dPro);
		dLocalizzazione.setFkProvincia(comObf
				.createDLocalizzazioneFkProvincia(fkPro));
	}

	public void setDLocalizzazioneComune(String s)
	{
		if(s.trim() == null)
		{
			s = "ROMA";
			log.warn("Comune " + s + " non valido, sarà impostat il codice di Roma");
		}
		else
		{
			if(s.trim().equalsIgnoreCase("REGGIO CALABRIA"))
			{
				s = "REGGIO\u0020CALABRIA";
			}
		}
		s = s.toUpperCase();
		DComune d = luoghiObf.createDComune();
		d.setCodiIstatComune(comuIstat.getProperty(s.trim()));
		FkIstatComune fk = comObf.createDLocalizzazioneFkIstatComune();
		fk.setDComune(d);
		dLocalizzazione.setFkIstatComune(comObf
				.createDLocalizzazioneFkIstatComune(fk));
	}

	public void setDLocalizzazioneCap(String s)
	{
		if(s != null)
			dLocalizzazione.setTextCap(comObf.createDLocalizzazioneTextCap(s.trim()));
		else
			log.warn("Localizzazione, cap nullo");
	}

	public void setDLocalizzazioneTextTelefono(String s)
	{
		TelefonoSas t = new TelefonoSas(s);
		if(t.getNumero() != null)
		{
			dLocalizzazione.setTextTelefono(comObf
					.createDLocalizzazioneTextTelefono(t.getNumero()));
		}
		else
			log.warn("Localizzazione, telefono nullo");
	}

	public void setDLocalizzazioneTextEmail(String s)
	{
		if(s != null)
			dLocalizzazione.setTextEmail(comObf.createDLocalizzazioneTextEmail(s
					.trim()));
		else
			log.warn("Localizzazione, mail nulla");
	}

	public void setDLocalizzazioneOrariApertura(String s)
	{
		if(s != null)
			dLocalizzazione.setTextOrariApertura(comObf
					.createDLocalizzazioneTextOrariApertura(s.trim()));
		else
			log.warn("Localizzazione, orari di apertura nulli");
	}

	public DDepositi getDDepositi()
	{
		dDepositi.getDLocalizzazione().add(dLocalizzazione);
		return dDepositi;
	}
}
