//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.25 at 03:07:39 PM CET 
//


package it.beniculturali.sas.catalogo.envelope_catsas;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.beniculturali.sas.catalogo.envelope_catsas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.beniculturali.sas.catalogo.envelope_catsas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Envelope.RecordList }
     * 
     */
    public Envelope.RecordList createEnvelopeRecordList() {
        return new Envelope.RecordList();
    }

    /**
     * Create an instance of {@link Envelope.RecordList.Record.RecordBody }
     * 
     */
    public Envelope.RecordList.Record.RecordBody createEnvelopeRecordListRecordRecordBody() {
        return new Envelope.RecordList.Record.RecordBody();
    }

    /**
     * Create an instance of {@link Envelope.Header.Fonte }
     * 
     */
    public Envelope.Header.Fonte createEnvelopeHeaderFonte() {
        return new Envelope.Header.Fonte();
    }

    /**
     * Create an instance of {@link Envelope }
     * 
     */
    public Envelope createEnvelope() {
        return new Envelope();
    }

    /**
     * Create an instance of {@link Envelope.RecordList.Record.RecordBody.Entity }
     * 
     */
    public Envelope.RecordList.Record.RecordBody.Entity createEnvelopeRecordListRecordRecordBodyEntity() {
        return new Envelope.RecordList.Record.RecordBody.Entity();
    }

    /**
     * Create an instance of {@link Envelope.Response }
     * 
     */
    public Envelope.Response createEnvelopeResponse() {
        return new Envelope.Response();
    }

    /**
     * Create an instance of {@link Envelope.RecordList.Record.RecordHeader }
     * 
     */
    public Envelope.RecordList.Record.RecordHeader createEnvelopeRecordListRecordRecordHeader() {
        return new Envelope.RecordList.Record.RecordHeader();
    }

    /**
     * Create an instance of {@link Envelope.RecordList.Record }
     * 
     */
    public Envelope.RecordList.Record createEnvelopeRecordListRecord() {
        return new Envelope.RecordList.Record();
    }

    /**
     * Create an instance of {@link Envelope.Header }
     * 
     */
    public Envelope.Header createEnvelopeHeader() {
        return new Envelope.Header();
    }

}
