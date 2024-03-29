package it.mibac.sias.sas.util;

import java.util.Date;

import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordBody;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordHeader;
import it.beniculturali.sas.catalogo.envelope_catsas.Envelope.RecordList.Record.RecordBody.Entity;
import it.beniculturali.sas.catalogo.relazioni.Relazioni;
import it.mibac.sias.sas.cmd.Exporter;

/*
 * Classe wrapper attorno a un envelope/recordlist/record. Maschera l'header e il body e alcune
 * altre complicazioni evitabili
 */
public class RecordWrapper
{
	private it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory	envObf;

	private Record																											r		= null;
	private RecordHeader																								rh	= null;
	private RecordBody																									rb	= null;

/*
 * Costruttore che inizializza il record e le sue parti, legandole subito fra loro
 */
	public RecordWrapper()
	{
		envObf = new it.beniculturali.sas.catalogo.envelope_catsas.ObjectFactory();
		r = envObf.createEnvelopeRecordListRecord();
		rh = envObf.createEnvelopeRecordListRecordRecordHeader();
		rb = envObf.createEnvelopeRecordListRecordRecordBody();
		r.setRecordBody(rb);
		r.setRecordHeader(rh);
	}

/*
 * Come in altri wrapper, occorre poter tirar fuori il vero record da fornire a oggetti che ne hanno
 * bisogno
 */

	public Record getRecord()
	{
		return r;
	}

/*
 * Serie di metodi che si limitano a invocare metodi omonimi per head e body. Il primo merita
 * attenzione: elimina eventuali punti dal recordId, perché essi non sono permessi dal pattern
 * dell'elemento finale. Questo non è un problema, perché non introduce conflitti, e il recordId
 * serve appunto solo come identificativo univoco del singolo record.
 */
	public void setRecordIdentifier(String s)
	{
		rh.setRecordIdentifier(s.replaceAll("\\.", ""));
	}

	public void setRecordDatestamp(Date d)
	{
		rh.setRecordDatestamp(Exporter.now());
	}

	public void setRecordDatestamp()
	{
		rh.setRecordDatestamp(Exporter.now());
	}

	public void setDIRECTIVE(String s)
	{
		rh.setDIRECTIVE(s);
	}

	public void setCASCADE(boolean b)
	{
		rh.setCASCADE(b);
	}

	public void setEntity(Entity e)
	{
		rb.setEntity(e);
	}

	public void setEntity(EntityWrapper ew)
	{
		rb.setEntity(ew.getEntity());
	}

	public void setRelazioni(Relazioni rel)
	{
		rb.setRelazioni(rel);
	}
}