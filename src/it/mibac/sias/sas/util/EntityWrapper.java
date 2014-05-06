package it.mibac.sias.sas.util;

import it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordBody.Entity;

import java.util.List;

/*
 * Classe wrapper attorno a una Entity. Necessaria per aggiungere a una Entity alcuni attributi come
 * il codi_provenienza, la fonte e poco altro. Ci sono infatti situazioni in cui non è possibile
 * sapere quale tipo di oggetto è contenuto nella Entity, ma è proprio a tale oggetto che andrebbero
 * chiesti tali attributi.
 */


public class EntityWrapper
{
	private ObjectFactory envelopeObjF;
	private Entity entity;
	private String codiProvenienza;
	private String fonte;

	public EntityWrapper()
	{
		envelopeObjF = new ObjectFactory();
		entity = envelopeObjF.createEnvelopeRecordListRecordRecordBodyEntity();
		codiProvenienza = null;
		fonte = null;
	}
	
	public EntityWrapper(Entity ent)
	{
		envelopeObjF = new ObjectFactory();
		entity = ent;
		codiProvenienza = null;
		fonte = null;
	}
	
	public void setCodiProvenienza(String cp)
	{
		codiProvenienza = cp;
	}

	public String getCodiProvenienza()
	{
		return codiProvenienza;
	}

	public void setFonte(String fonte)
	{
		this.fonte = fonte;
	}

	public String getFonte()
	{
		return fonte;
	}

	public Entity getEntity()
	{
		return entity;
	}
	
	public List<Object> getContent()
	{
		return entity.getContent();
	}
}