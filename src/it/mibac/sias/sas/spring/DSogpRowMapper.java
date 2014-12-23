package it.mibac.sias.sas.spring;

import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.sogp.DSogp;
import it.beniculturali.sas.catalogo.sogp.DSogp.FkFonte;
import it.beniculturali.sas.catalogo.sogp.DSogp.FkVocTipoSogp;
import it.beniculturali.sas.catalogo.sogp.DSogpDenominazioni;
import it.beniculturali.sas.catalogo.vocabolari_sogp.DVocTipoSogp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DSogpRowMapper implements RowMapper
{
	private it.beniculturali.sas.catalogo.sogp.ObjectFactory dsogpObf;
	private it.beniculturali.sas.catalogo.vocabolari_sogp.ObjectFactory vocSogpObf;
	private DSogp dsogp;
	private DSogpDenominazioni dsogpDen;

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		dsogpObf = new it.beniculturali.sas.catalogo.sogp.ObjectFactory();
		vocSogpObf = new it.beniculturali.sas.catalogo.vocabolari_sogp.ObjectFactory();
		dsogp = dsogpObf.createDSogp();
		dsogpDen = dsogpObf.createDSogpDenominazioni();
		dsogp.getDSogpDenominazioni().add(dsogpDen);
		String s = null;
		long l = 0;

// codi_provenienza		
		
		s = rs.getString("codi_provenienza");
		if(s.trim() == null)
		{
			s = "ITASVT";
		}
		dsogp.setCodiProvenienza(s.trim());
		
// denominazioni		
		
		s = rs.getString("text_denominazione");
		DSogpDenominazioni.Denominazione den;
		den = dsogpObf.createDSogpDenominazioniDenominazione();
		den.setTextDenominazione(s);
		dsogpDen.setDenominazione(den);

// fonte
		
		s = rs.getString("fk_fonte");
		FkFonte fkf = dsogpObf.createDSogpFkFonte();
		it.beniculturali.sas.catalogo.fonti.ObjectFactory fontiObf;
		fontiObf = new it.beniculturali.sas.catalogo.fonti.ObjectFactory();
		ProfGroup pg = fontiObf.createProfGroup();
		pg.setGroupName(s);
		fkf.setProfGroup(pg);
		dsogp.setFkFonte(fkf);

// tipo soggetto		

		l = rs.getLong("fk_voc_tipo_sogp");
		DVocTipoSogp dVoc = vocSogpObf.createDVocTipoSogp();
		dVoc.setSequVocTipoSogp(l);
		FkVocTipoSogp tipologia = dsogpObf.createDSogpFkVocTipoSogp();
		tipologia.setDVocTipoSogp(dVoc);
		dsogp.setFkVocTipoSogp(tipologia);
		
		return dsogp;
	}
}
