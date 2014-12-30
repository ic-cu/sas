package it.mibac.sias.sas.spring;

import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordBody.Entity;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.sogp.DSogp;
import it.beniculturali.sas.catalogo.sogp.DSogp.FkFonte;
import it.beniculturali.sas.catalogo.sogp.DSogp.FkVocTipoSogp;
import it.beniculturali.sas.catalogo.sogp.DSogpAltreDen;
import it.beniculturali.sas.catalogo.sogp.DSogpDenominazioni;
import it.beniculturali.sas.catalogo.sogp.DSogpEnteStoria;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

public class DSogpRowMapper implements RowMapper
{
	private it.beniculturali.sas.catalogo.sogp.ObjectFactory dsogpObf;
	private it.beniculturali.sas.catalogo.vocabolari_sogp.ObjectFactory vocSogpObf;
	private DSogp dsogp;
	private DSogpDenominazioni dsogpDen;
	private static Logger log;
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
	private Properties fontiMap;

	public DSogpRowMapper()
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
		try
		{
			comuIstat.load(new FileReader(new File("comuni-istat.prop")));
			provIstat.load(new FileReader(new File("province-istat.prop")));
			fontiMap = new Properties();
			fontiMap.load(new FileReader("fonti.map"));
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

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		dsogpObf = new it.beniculturali.sas.catalogo.sogp.ObjectFactory();
		vocSogpObf = new it.beniculturali.sas.catalogo.vocabolari_sogp.ObjectFactory();
		dsogp = dsogpObf.createDSogp();
		dsogpDen = dsogpObf.createDSogpDenominazioni();
		dsogp.getDSogpDenominazioni().add(dsogpDen);
		String codiProvenienza = rs.getString("codi_provenienza");
		int count = 0;
		log.info("Soggetto " + codiProvenienza + "(" + ++count + ")");
		setCodiProvenienza(codiProvenienza);
		String fkFonte = rs.getString("fk_fonte");
		setFkFonte(fontiMap.getProperty(fkFonte));
		try
		{
			setDateEstremoRemoto(rs.getString("date_estremo_remoto"));
			setDateEstremoRecente(rs.getString("date_estremo_recente"));
		}
		catch(IllegalArgumentException | DatatypeConfigurationException e)
		{
			e.printStackTrace();
		}
		setTextEstrCronoTestuali(rs.getString("text_estr_crono_testuali"));
		setFkVocTipoSogp(rs.getLong("fk_voc_tipo_sogp"));
		setTextDenominazione(rs.getString("text_denominazione"));
		setTextDenominazioneCoeva(rs.getString("text_denominazione_coeva_sede"));
		setFkVocTipofunzSogp(rs.getLong("fk_voc_tipofunz_sogp"));
		setTextEnteStoria(rs.getString("text_storia"));
		setTextUrl(rs.getString("text_url"));
		setTextNote(rs.getString("text_note"));
		
		it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory envObf;
		envObf = new it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory();
		Entity ent = envObf.createEnvelopeRecordListRecordRecordBodyEntity();
		ent.getContent().add(dsogp);

		return ent;
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
			else if(s.trim().equals("0"))
			{
				msg = "date_estremo_recente = [" + s + "], sarà omesso";
				log.warn(msg);
				return;
			}
			else
			{
				msg = "date_estremo_recente = [" + s + "]";
				log.warn(msg);
			}
		}
		else
		{
			msg = "date_estremo_recente nullo";
			log.warn(msg);
			return;
		}
		try
		{
			DatatypeFactory dtf = DatatypeFactory.newInstance();
			int tz = DatatypeConstants.FIELD_UNDEFINED;
			xgc = dtf.newXMLGregorianCalendarDate(aa, mm, dd, tz);
			JAXBElement<XMLGregorianCalendar> jb;
			jb = dsogpObf.createDSogpDenominazioniDateEstremoRecente(xgc);
			dsogpDen.setDateEstremoRecente(jb);
			dsogp.setDateEstremoRecente(jb);
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
			ee = new IllegalArgumentException("IllegalArgumentException: date_estremo_recente = [" + s + "]");
			throw ee;
		}
	}

	public void setDateEstremoRemoto(String s) throws DatatypeConfigurationException, IllegalArgumentException
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
			else if(s.trim().equals("0"))
			{
				msg = "date_estremo_remoto = [" + s + "], sarà omesso";
				log.warn(msg);
				return;
			}
			else
			{
				msg = "date_estremo_remoto = " + s + "]";
				log.warn(msg);
			}
		}
		else
		{
			msg = "date_estremo_remoto nullo";
			log.warn(msg);
		}
		try
		{
			DatatypeFactory dtf = DatatypeFactory.newInstance();
			int tz = DatatypeConstants.FIELD_UNDEFINED;
			xgc = dtf.newXMLGregorianCalendarDate(aa, mm, dd, tz);
			JAXBElement<XMLGregorianCalendar> jb;
			jb = dsogpObf.createDSogpDenominazioniDateEstremoRemoto(xgc);
			dsogpDen.setDateEstremoRemoto(jb);
			dsogp.setDateEstremoRecente(jb);
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
			ee = new IllegalArgumentException("date_estremo_remoto = " + s + "]");
			throw ee;
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
