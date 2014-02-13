//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.11 at 06:42:47 PM CET 
//


package it.beniculturali.sas.catalogo.sala_studio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.beniculturali.sas.catalogo.sala_studio package. 
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

    private final static QName _DSalaStudioDateEstremoRecente_QNAME = new QName("http://sas.beniculturali.it/catalogo/sala_studio", "date_estremo_recente");
    private final static QName _DSalaStudioFkVocValiditaDtrm_QNAME = new QName("http://sas.beniculturali.it/catalogo/sala_studio", "fk_voc_validita_dtrm");
    private final static QName _DSalaStudioFkVocSpecificaSerm_QNAME = new QName("http://sas.beniculturali.it/catalogo/sala_studio", "fk_voc_specifica_serm");
    private final static QName _DSalaStudioDateEstremoRemoto_QNAME = new QName("http://sas.beniculturali.it/catalogo/sala_studio", "date_estremo_remoto");
    private final static QName _DSalaStudioTextSecoloRe_QNAME = new QName("http://sas.beniculturali.it/catalogo/sala_studio", "text_secolo_re");
    private final static QName _DSalaStudioFkVocValiditaDtre_QNAME = new QName("http://sas.beniculturali.it/catalogo/sala_studio", "fk_voc_validita_dtre");
    private final static QName _DSalaStudioTextNoteData_QNAME = new QName("http://sas.beniculturali.it/catalogo/sala_studio", "text_note_data");
    private final static QName _DSalaStudioTextNote_QNAME = new QName("http://sas.beniculturali.it/catalogo/sala_studio", "text_note");
    private final static QName _DSalaStudioTextSecoloRm_QNAME = new QName("http://sas.beniculturali.it/catalogo/sala_studio", "text_secolo_rm");
    private final static QName _DSalaStudioTextNoteSalaStudio_QNAME = new QName("http://sas.beniculturali.it/catalogo/sala_studio", "text_note_sala_studio");
    private final static QName _DSalaStudioFkVocSpecificaSere_QNAME = new QName("http://sas.beniculturali.it/catalogo/sala_studio", "fk_voc_specifica_sere");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.beniculturali.sas.catalogo.sala_studio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DSalaStudio.FkVocSpecificaSerm }
     * 
     */
    public DSalaStudio.FkVocSpecificaSerm createDSalaStudioFkVocSpecificaSerm() {
        return new DSalaStudio.FkVocSpecificaSerm();
    }

    /**
     * Create an instance of {@link DSalaStudio.FkVocSpecificaSere }
     * 
     */
    public DSalaStudio.FkVocSpecificaSere createDSalaStudioFkVocSpecificaSere() {
        return new DSalaStudio.FkVocSpecificaSere();
    }

    /**
     * Create an instance of {@link DSalaStudio.FkVocValiditaDtrm }
     * 
     */
    public DSalaStudio.FkVocValiditaDtrm createDSalaStudioFkVocValiditaDtrm() {
        return new DSalaStudio.FkVocValiditaDtrm();
    }

    /**
     * Create an instance of {@link DSalaStudio.FkFonte }
     * 
     */
    public DSalaStudio.FkFonte createDSalaStudioFkFonte() {
        return new DSalaStudio.FkFonte();
    }

    /**
     * Create an instance of {@link DAccessoSalaStudio }
     * 
     */
    public DAccessoSalaStudio createDAccessoSalaStudio() {
        return new DAccessoSalaStudio();
    }

    /**
     * Create an instance of {@link DSalaStudio.FkVocValiditaDtre }
     * 
     */
    public DSalaStudio.FkVocValiditaDtre createDSalaStudioFkVocValiditaDtre() {
        return new DSalaStudio.FkVocValiditaDtre();
    }

    /**
     * Create an instance of {@link DSalaStudio }
     * 
     */
    public DSalaStudio createDSalaStudio() {
        return new DSalaStudio();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/sala_studio", name = "date_estremo_recente", scope = DSalaStudio.class)
    public JAXBElement<XMLGregorianCalendar> createDSalaStudioDateEstremoRecente(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DSalaStudioDateEstremoRecente_QNAME, XMLGregorianCalendar.class, DSalaStudio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DSalaStudio.FkVocValiditaDtrm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/sala_studio", name = "fk_voc_validita_dtrm", scope = DSalaStudio.class)
    public JAXBElement<DSalaStudio.FkVocValiditaDtrm> createDSalaStudioFkVocValiditaDtrm(DSalaStudio.FkVocValiditaDtrm value) {
        return new JAXBElement<DSalaStudio.FkVocValiditaDtrm>(_DSalaStudioFkVocValiditaDtrm_QNAME, DSalaStudio.FkVocValiditaDtrm.class, DSalaStudio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DSalaStudio.FkVocSpecificaSerm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/sala_studio", name = "fk_voc_specifica_serm", scope = DSalaStudio.class)
    public JAXBElement<DSalaStudio.FkVocSpecificaSerm> createDSalaStudioFkVocSpecificaSerm(DSalaStudio.FkVocSpecificaSerm value) {
        return new JAXBElement<DSalaStudio.FkVocSpecificaSerm>(_DSalaStudioFkVocSpecificaSerm_QNAME, DSalaStudio.FkVocSpecificaSerm.class, DSalaStudio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/sala_studio", name = "date_estremo_remoto", scope = DSalaStudio.class)
    public JAXBElement<XMLGregorianCalendar> createDSalaStudioDateEstremoRemoto(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DSalaStudioDateEstremoRemoto_QNAME, XMLGregorianCalendar.class, DSalaStudio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/sala_studio", name = "text_secolo_re", scope = DSalaStudio.class)
    public JAXBElement<String> createDSalaStudioTextSecoloRe(String value) {
        return new JAXBElement<String>(_DSalaStudioTextSecoloRe_QNAME, String.class, DSalaStudio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DSalaStudio.FkVocValiditaDtre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/sala_studio", name = "fk_voc_validita_dtre", scope = DSalaStudio.class)
    public JAXBElement<DSalaStudio.FkVocValiditaDtre> createDSalaStudioFkVocValiditaDtre(DSalaStudio.FkVocValiditaDtre value) {
        return new JAXBElement<DSalaStudio.FkVocValiditaDtre>(_DSalaStudioFkVocValiditaDtre_QNAME, DSalaStudio.FkVocValiditaDtre.class, DSalaStudio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/sala_studio", name = "text_note_data", scope = DSalaStudio.class)
    public JAXBElement<String> createDSalaStudioTextNoteData(String value) {
        return new JAXBElement<String>(_DSalaStudioTextNoteData_QNAME, String.class, DSalaStudio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/sala_studio", name = "text_note", scope = DSalaStudio.class)
    public JAXBElement<String> createDSalaStudioTextNote(String value) {
        return new JAXBElement<String>(_DSalaStudioTextNote_QNAME, String.class, DSalaStudio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/sala_studio", name = "text_secolo_rm", scope = DSalaStudio.class)
    public JAXBElement<String> createDSalaStudioTextSecoloRm(String value) {
        return new JAXBElement<String>(_DSalaStudioTextSecoloRm_QNAME, String.class, DSalaStudio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/sala_studio", name = "text_note_sala_studio", scope = DSalaStudio.class)
    public JAXBElement<String> createDSalaStudioTextNoteSalaStudio(String value) {
        return new JAXBElement<String>(_DSalaStudioTextNoteSalaStudio_QNAME, String.class, DSalaStudio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DSalaStudio.FkVocSpecificaSere }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/sala_studio", name = "fk_voc_specifica_sere", scope = DSalaStudio.class)
    public JAXBElement<DSalaStudio.FkVocSpecificaSere> createDSalaStudioFkVocSpecificaSere(DSalaStudio.FkVocSpecificaSere value) {
        return new JAXBElement<DSalaStudio.FkVocSpecificaSere>(_DSalaStudioFkVocSpecificaSere_QNAME, DSalaStudio.FkVocSpecificaSere.class, DSalaStudio.class, value);
    }

}
