package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.commons.DContatti;
import it.beniculturali.sas.catalogo.commons.DLocalizzazione;
import it.beniculturali.sas.catalogo.commons.DContatti.FkVocTipoContatto;
import it.beniculturali.sas.catalogo.commons.DLocalizzazione.FkIstatComune;
import it.beniculturali.sas.catalogo.commons.DLocalizzazione.FkProvincia;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.luoghi.DComune;
import it.beniculturali.sas.catalogo.luoghi.DProvincia;
import it.beniculturali.sas.catalogo.sogc.DSogc;
import it.beniculturali.sas.catalogo.sogc.DSogc.FkFonte;
import it.beniculturali.sas.catalogo.sogc.DSogc.FkVocNaturagiuridica;
import it.beniculturali.sas.catalogo.sogc.DSogc.FkVocTipoSogc;
import it.beniculturali.sas.catalogo.vocabolari_sogc.DVocNaturagiuridica;
import it.beniculturali.sas.catalogo.vocabolari_sogc.DVocTipoContatto;
import it.beniculturali.sas.catalogo.vocabolari_sogc.DVocTipoSogc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;

/*
 * Classe wrapper attorno ad un DSogc. Non aggiunge quasi niente a DSogc, ma
 * reimplemente alcuni dei metodi di DSogc in modo che accettino tipi primitivi.
 * Viene così nascosta la complessità di certe chiamate, così da rendere il
 * codice invocante più pulito
 */
public class DSogcWrapper
{
	/*
	 * Serviranno spesso alcune object factory, istanziate nel costruttore
	 */
	private it.beniculturali.sas.catalogo.sogc.ObjectFactory dsogcObf;
	private it.beniculturali.sas.catalogo.vocabolari_sogc.ObjectFactory vocSogcObf;
	private it.beniculturali.sas.catalogo.commons.ObjectFactory comObf;
	private it.beniculturali.sas.catalogo.luoghi.ObjectFactory luoghiObf;
	private static Logger log;

	/*
	 * Il member più importante è un DSogc: tutto quello che fa questa classe
	 * impatta su di esso.
	 */

	private it.beniculturali.sas.catalogo.sogc.DSogc dsogc;

	/*
	 * Questa mappa permette di convertire le sigle automobilistiche e i nomi dei
	 * comuni nei corrispondenti codici istat. Ho qualche preoccupazione circa
	 * l'encoding, perché sembra che l'istat esporti in latin1.
	 */
	private Properties comuIstat;
	private Properties provIstat;
	private DLocalizzazione dLocalizzazione;
	private DContatti dContatti;

	public DSogcWrapper()
	{
		dsogc = new DSogc();
		dsogcObf = new it.beniculturali.sas.catalogo.sogc.ObjectFactory();
		vocSogcObf = new it.beniculturali.sas.catalogo.vocabolari_sogc.ObjectFactory();
		comObf = new it.beniculturali.sas.catalogo.commons.ObjectFactory();
		luoghiObf = new it.beniculturali.sas.catalogo.luoghi.ObjectFactory();
		comuIstat = new Properties();
		provIstat = new Properties();
		dLocalizzazione = comObf.createDLocalizzazione();
		dContatti = comObf.createDContatti();
		dsogc.getDContatti().add(dContatti);
		try
		{
			comuIstat.load(new FileReader(new File("comuni-istat.prop")));
			provIstat.load(new FileReader(new File("province-istat.prop")));
			log = Logger.getLogger("SOGC");
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

	public DSogc getDSogc()
	{
		return dsogc;
	}

	public void setCodiProvenienza(String s)
	{
		if(s.trim() == null)
		{
			log.warn("codiProvenienza nullo, sarà impostato a ITASVT");
			s = "ITASVT";
		}
		dsogc.setCodiProvenienza(s.trim());
	}

	public void setTextDenominazione(String s)
	{
		dsogc.setTextDenominazione(s);
	}

	public void setFlagAmmneAttivaTf(boolean b)
	{
		dsogc.setFlagAmmneAttivaTf(b);
	}

	public void setFkFonte(String s)
	{
		FkFonte fkf = dsogcObf.createDSogcFkFonte();
		it.beniculturali.sas.catalogo.fonti.ObjectFactory fontiObf;
		fontiObf = new it.beniculturali.sas.catalogo.fonti.ObjectFactory();
		ProfGroup pg = fontiObf.createProfGroup();
		pg.setGroupName(s);
		fkf.setProfGroup(pg);
		dsogc.setFkFonte(fkf);
	}

	public void setTextNazioneIsad(String s)
	{
		JAXBElement<String> je = dsogcObf.createDSogcTextNazioneIsad(s);
		dsogc.setTextNazioneIsad(je);
	}

	public void setTextCodiceIsad(String s)
	{
		JAXBElement<String> je;
		je = dsogcObf.createDSogcTextCodiceIsad(s);
		dsogc.setTextCodiceIsad(je);
	}

	public void setTextSiglaIsad(String s)
	{
		JAXBElement<String> je;
		je = dsogcObf.createDSogcTextSiglaIsad(s);
		dsogc.setTextSiglaIsad(je);
	}

	public void setTextAcronimo(String s)
	{
		JAXBElement<String> je;
		je = dsogcObf.createDSogcTextAcronimo(s);
		dsogc.setTextAcronimo(je);
	}

	public void setFkVocTipoSogc(long l)
	{
		DVocTipoSogc dVoc = vocSogcObf.createDVocTipoSogc();
		dVoc.setSequVocTipoSogc(l);
		FkVocTipoSogc tipologia = dsogcObf.createDSogcFkVocTipoSogc();
		tipologia.setDVocTipoSogc(dVoc);
		dsogc.setFkVocTipoSogc(tipologia);
	}

	public void setFkVocNaturagiuridica(long l)
	{
		DVocNaturagiuridica dVoc = vocSogcObf.createDVocNaturagiuridica();
		dVoc.setSequVocNaturagiuridica(l);
		FkVocNaturagiuridica fkVoc = dsogcObf.createDSogcFkVocNaturagiuridica();
		fkVoc.setDVocNaturagiuridica(dVoc);
		JAXBElement<FkVocNaturagiuridica> je;
		je = dsogcObf.createDSogcFkVocNaturagiuridica(fkVoc);
		dsogc.setFkVocNaturagiuridica(je);
	}

	public void setTextEstrCronoTestuali(String s)
	{
		dsogc.setTextEstrCronoTestuali(s);
	}

	public void addDLocalizzazione()
	{
		dsogc.getDLocalizzazione().add(dLocalizzazione);
		dLocalizzazione = comObf.createDLocalizzazione();
	}

	public void setDLocalizzazioneIndirizzo(String s)
	{
		dLocalizzazione.setTextIndirizzo(s);
	}

	public void setDLocalizzazioneProvincia(String s)
	{
		DProvincia dPro = luoghiObf.createDProvincia();
		// A volte la provincia ISTAT è nulla
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
		JAXBElement<FkProvincia> je;
		je = comObf.createDLocalizzazioneFkProvincia(fkPro);
		dLocalizzazione.setFkProvincia(je);
	}

	public void setDLocalizzazioneComune(String s)
	{
		if(s.trim() == null)
		{
			s = "ROMA";
			log.warn("Comune " + s + " non valido, sarà impostato il codice di Roma");
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
		JAXBElement<FkIstatComune> je;
		je = comObf.createDLocalizzazioneFkIstatComune(fk);
		dLocalizzazione.setFkIstatComune(je);
	}

	public void setDLocalizzazioneCap(String s)
	{
		if(s != null)
		{
			JAXBElement<String> je;
			je = comObf.createDLocalizzazioneTextCap(s.trim());
			dLocalizzazione.setTextCap(je);
		}
		else
			log.warn("Localizzazione, cap nullo");
	}

	public void setDLocalizzazioneFlgLocPrincipale(boolean b)
	{
		dLocalizzazione.setFlagLocPrincipaleTf(b);
	}

	public void setDLocalizzazioneTextTelefono(String s)
	{
		TelefonoSas t = new TelefonoSas(s);
		if(t.getNumero() != null)
		{
			JAXBElement<String> je;
			je = comObf.createDLocalizzazioneTextTelefono(t.getNumero());
			dLocalizzazione.setTextTelefono(je);
		}
		else
			log.warn("Localizzazione, telefono nullo");
	}

	public void setDLocalizzazioneTextFax(String s)
	{
		TelefonoSas t = new TelefonoSas(s);
		if(t.getNumero() != null)
		{
			JAXBElement<String> je;
			je = comObf.createDLocalizzazioneTextFax(t.getNumero());
			dLocalizzazione.setTextFax(je);
		}
		else
			log.warn("Localizzazione, fax nullo");
	}

	public void setDLocalizzazioneTextEmail(String s)
	{
		if(s != null)
		{
			JAXBElement<String> je;
			je = comObf.createDLocalizzazioneTextEmail(s.trim());
			dLocalizzazione.setTextEmail(je);
		}
		else
			log.warn("Localizzazione, mail nulla");
	}

	public void setDLocalizzazioneTextUrlweb(String s)
	{
		if(s != null)
		{
			if(!s.startsWith("http://"))
			{
				s = "http://" + s;
				log.warn("Url senza http://, si aggiunge");
			}
			JAXBElement<String> je;
			je = comObf.createDLocalizzazioneTextUrlweb(s.trim());
			dLocalizzazione.setTextUrlweb(je);
		}
		else
			log.warn("Localizzazione, url nulla");
	}

	public void setDLocalizzazioneOrariApertura(String s)
	{
		if(s != null)
		{
			JAXBElement<String> je;
			je = comObf.createDLocalizzazioneTextOrariApertura(s.trim());
			dLocalizzazione.setTextOrariApertura(je);
		}
		else
			log.warn("Localizzazione, orari di apertura nulli");
	}

	public void setDContattiTextAnagrafica(String s)
	{
		if(s != null)
		{
			dContatti.setTextAnagrafica(s.trim());
		}
		else
		{
			dContatti.setTextAnagrafica("anagrafica assente");
			log.warn("Contatti, anagrafica nulla");
		}
	}

	public void setFkVocTipoContatto(long l)
	{
		DVocTipoContatto d = vocSogcObf.createDVocTipoContatto();
		d.setSequVocTipoContatto(l);
		FkVocTipoContatto f = new FkVocTipoContatto();
		f.setDVocTipoContatto(d);
		dContatti.setFkVocTipoContatto(f);
	}

/*
 * Metodo modello, mai usato e da non usare
 */
	
	public void setTemplate(DLocalizzazione d, String s)
	{
		JAXBElement<String> je;
		je = comObf.createDContattiTextCap(s.trim());
		d.setTextCap(je);
	}
}
