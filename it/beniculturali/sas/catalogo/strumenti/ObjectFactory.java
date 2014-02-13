//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.11 at 06:42:47 PM CET 
//


package it.beniculturali.sas.catalogo.strumenti;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.beniculturali.sas.catalogo.strumenti package. 
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

    private final static QName _DStrumentoRicercaTextSecoloRe_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "text_secolo_re");
    private final static QName _DStrumentoRicercaFkVocSpecificaSerm_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "fk_voc_specifica_serm");
    private final static QName _DStrumentoRicercaDateEstremoRemoto_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "date_estremo_remoto");
    private final static QName _DStrumentoRicercaFkVocValiditaDtrm_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "fk_voc_validita_dtrm");
    private final static QName _DStrumentoRicercaDateEstremoRecente_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "date_estremo_recente");
    private final static QName _DStrumentoRicercaTextEstrCronoTestuali_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "text_estr_crono_testuali");
    private final static QName _DStrumentoRicercaFkVocSpecificaSere_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "fk_voc_specifica_sere");
    private final static QName _DStrumentoRicercaTextSecoloRm_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "text_secolo_rm");
    private final static QName _DStrumentoRicercaTextNoteData_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "text_note_data");
    private final static QName _DStrumentoRicercaFkVocValiditaDtre_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "fk_voc_validita_dtre");
    private final static QName _DEditoreStrricTextNote_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "text_note");
    private final static QName _DStrumentoRicercaFkVocTipoStrricFkVocTipoStrricRicerca_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "fk_voc_tipo_strric_ricerca");
    private final static QName _DStrumentoRicercaFkVocTipoStrricFkVocTipoStrricOrganizzazione_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "fk_voc_tipo_strric_organizzazione");
    private final static QName _DAutoreStrricTextLuogoMorte_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "text_luogo_morte");
    private final static QName _DAutoreStrricDateNascita_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "date_nascita");
    private final static QName _DAutoreStrricDateMorte_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "date_morte");
    private final static QName _DAutoreStrricTextLuogoNascita_QNAME = new QName("http://sas.beniculturali.it/catalogo/strumenti", "text_luogo_nascita");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.beniculturali.sas.catalogo.strumenti
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DEditoreStrric }
     * 
     */
    public DEditoreStrric createDEditoreStrric() {
        return new DEditoreStrric();
    }

    /**
     * Create an instance of {@link DStrumentoRicerca.FkVocTipoStrric }
     * 
     */
    public DStrumentoRicerca.FkVocTipoStrric createDStrumentoRicercaFkVocTipoStrric() {
        return new DStrumentoRicerca.FkVocTipoStrric();
    }

    /**
     * Create an instance of {@link DStrumentoRicerca.FkVocSpecificaSere }
     * 
     */
    public DStrumentoRicerca.FkVocSpecificaSere createDStrumentoRicercaFkVocSpecificaSere() {
        return new DStrumentoRicerca.FkVocSpecificaSere();
    }

    /**
     * Create an instance of {@link DStrumentoRicerca.FkVocTipoSuppStrric }
     * 
     */
    public DStrumentoRicerca.FkVocTipoSuppStrric createDStrumentoRicercaFkVocTipoSuppStrric() {
        return new DStrumentoRicerca.FkVocTipoSuppStrric();
    }

    /**
     * Create an instance of {@link DStrumentoRicerca.FkVocValiditaDtrm }
     * 
     */
    public DStrumentoRicerca.FkVocValiditaDtrm createDStrumentoRicercaFkVocValiditaDtrm() {
        return new DStrumentoRicerca.FkVocValiditaDtrm();
    }

    /**
     * Create an instance of {@link DEdizioneStrric }
     * 
     */
    public DEdizioneStrric createDEdizioneStrric() {
        return new DEdizioneStrric();
    }

    /**
     * Create an instance of {@link DStrumentoRicerca.FkVocValiditaDtre }
     * 
     */
    public DStrumentoRicerca.FkVocValiditaDtre createDStrumentoRicercaFkVocValiditaDtre() {
        return new DStrumentoRicerca.FkVocValiditaDtre();
    }

    /**
     * Create an instance of {@link DAutoreStrric.FkFonte }
     * 
     */
    public DAutoreStrric.FkFonte createDAutoreStrricFkFonte() {
        return new DAutoreStrric.FkFonte();
    }

    /**
     * Create an instance of {@link DStrumentoRicerca.FkVocSpecificaSerm }
     * 
     */
    public DStrumentoRicerca.FkVocSpecificaSerm createDStrumentoRicercaFkVocSpecificaSerm() {
        return new DStrumentoRicerca.FkVocSpecificaSerm();
    }

    /**
     * Create an instance of {@link DAutoreStrric }
     * 
     */
    public DAutoreStrric createDAutoreStrric() {
        return new DAutoreStrric();
    }

    /**
     * Create an instance of {@link DStrumentoRicerca }
     * 
     */
    public DStrumentoRicerca createDStrumentoRicerca() {
        return new DStrumentoRicerca();
    }

    /**
     * Create an instance of {@link DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricRicerca }
     * 
     */
    public DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricRicerca createDStrumentoRicercaFkVocTipoStrricFkVocTipoStrricRicerca() {
        return new DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricRicerca();
    }

    /**
     * Create an instance of {@link DEditoreStrric.FkFonte }
     * 
     */
    public DEditoreStrric.FkFonte createDEditoreStrricFkFonte() {
        return new DEditoreStrric.FkFonte();
    }

    /**
     * Create an instance of {@link DStrumentoRicerca.FkFonte }
     * 
     */
    public DStrumentoRicerca.FkFonte createDStrumentoRicercaFkFonte() {
        return new DStrumentoRicerca.FkFonte();
    }

    /**
     * Create an instance of {@link DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricOrganizzazione }
     * 
     */
    public DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricOrganizzazione createDStrumentoRicercaFkVocTipoStrricFkVocTipoStrricOrganizzazione() {
        return new DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricOrganizzazione();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "text_secolo_re", scope = DStrumentoRicerca.class)
    public JAXBElement<String> createDStrumentoRicercaTextSecoloRe(String value) {
        return new JAXBElement<String>(_DStrumentoRicercaTextSecoloRe_QNAME, String.class, DStrumentoRicerca.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DStrumentoRicerca.FkVocSpecificaSerm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "fk_voc_specifica_serm", scope = DStrumentoRicerca.class)
    public JAXBElement<DStrumentoRicerca.FkVocSpecificaSerm> createDStrumentoRicercaFkVocSpecificaSerm(DStrumentoRicerca.FkVocSpecificaSerm value) {
        return new JAXBElement<DStrumentoRicerca.FkVocSpecificaSerm>(_DStrumentoRicercaFkVocSpecificaSerm_QNAME, DStrumentoRicerca.FkVocSpecificaSerm.class, DStrumentoRicerca.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "date_estremo_remoto", scope = DStrumentoRicerca.class)
    public JAXBElement<XMLGregorianCalendar> createDStrumentoRicercaDateEstremoRemoto(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DStrumentoRicercaDateEstremoRemoto_QNAME, XMLGregorianCalendar.class, DStrumentoRicerca.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DStrumentoRicerca.FkVocValiditaDtrm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "fk_voc_validita_dtrm", scope = DStrumentoRicerca.class)
    public JAXBElement<DStrumentoRicerca.FkVocValiditaDtrm> createDStrumentoRicercaFkVocValiditaDtrm(DStrumentoRicerca.FkVocValiditaDtrm value) {
        return new JAXBElement<DStrumentoRicerca.FkVocValiditaDtrm>(_DStrumentoRicercaFkVocValiditaDtrm_QNAME, DStrumentoRicerca.FkVocValiditaDtrm.class, DStrumentoRicerca.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "date_estremo_recente", scope = DStrumentoRicerca.class)
    public JAXBElement<XMLGregorianCalendar> createDStrumentoRicercaDateEstremoRecente(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DStrumentoRicercaDateEstremoRecente_QNAME, XMLGregorianCalendar.class, DStrumentoRicerca.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "text_estr_crono_testuali", scope = DStrumentoRicerca.class)
    public JAXBElement<String> createDStrumentoRicercaTextEstrCronoTestuali(String value) {
        return new JAXBElement<String>(_DStrumentoRicercaTextEstrCronoTestuali_QNAME, String.class, DStrumentoRicerca.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DStrumentoRicerca.FkVocSpecificaSere }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "fk_voc_specifica_sere", scope = DStrumentoRicerca.class)
    public JAXBElement<DStrumentoRicerca.FkVocSpecificaSere> createDStrumentoRicercaFkVocSpecificaSere(DStrumentoRicerca.FkVocSpecificaSere value) {
        return new JAXBElement<DStrumentoRicerca.FkVocSpecificaSere>(_DStrumentoRicercaFkVocSpecificaSere_QNAME, DStrumentoRicerca.FkVocSpecificaSere.class, DStrumentoRicerca.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "text_secolo_rm", scope = DStrumentoRicerca.class)
    public JAXBElement<String> createDStrumentoRicercaTextSecoloRm(String value) {
        return new JAXBElement<String>(_DStrumentoRicercaTextSecoloRm_QNAME, String.class, DStrumentoRicerca.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "text_note_data", scope = DStrumentoRicerca.class)
    public JAXBElement<String> createDStrumentoRicercaTextNoteData(String value) {
        return new JAXBElement<String>(_DStrumentoRicercaTextNoteData_QNAME, String.class, DStrumentoRicerca.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DStrumentoRicerca.FkVocValiditaDtre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "fk_voc_validita_dtre", scope = DStrumentoRicerca.class)
    public JAXBElement<DStrumentoRicerca.FkVocValiditaDtre> createDStrumentoRicercaFkVocValiditaDtre(DStrumentoRicerca.FkVocValiditaDtre value) {
        return new JAXBElement<DStrumentoRicerca.FkVocValiditaDtre>(_DStrumentoRicercaFkVocValiditaDtre_QNAME, DStrumentoRicerca.FkVocValiditaDtre.class, DStrumentoRicerca.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "text_note", scope = DEditoreStrric.class)
    public JAXBElement<String> createDEditoreStrricTextNote(String value) {
        return new JAXBElement<String>(_DEditoreStrricTextNote_QNAME, String.class, DEditoreStrric.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricRicerca }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "fk_voc_tipo_strric_ricerca", scope = DStrumentoRicerca.FkVocTipoStrric.class)
    public JAXBElement<DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricRicerca> createDStrumentoRicercaFkVocTipoStrricFkVocTipoStrricRicerca(DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricRicerca value) {
        return new JAXBElement<DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricRicerca>(_DStrumentoRicercaFkVocTipoStrricFkVocTipoStrricRicerca_QNAME, DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricRicerca.class, DStrumentoRicerca.FkVocTipoStrric.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricOrganizzazione }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "fk_voc_tipo_strric_organizzazione", scope = DStrumentoRicerca.FkVocTipoStrric.class)
    public JAXBElement<DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricOrganizzazione> createDStrumentoRicercaFkVocTipoStrricFkVocTipoStrricOrganizzazione(DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricOrganizzazione value) {
        return new JAXBElement<DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricOrganizzazione>(_DStrumentoRicercaFkVocTipoStrricFkVocTipoStrricOrganizzazione_QNAME, DStrumentoRicerca.FkVocTipoStrric.FkVocTipoStrricOrganizzazione.class, DStrumentoRicerca.FkVocTipoStrric.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "text_luogo_morte", scope = DAutoreStrric.class)
    public JAXBElement<String> createDAutoreStrricTextLuogoMorte(String value) {
        return new JAXBElement<String>(_DAutoreStrricTextLuogoMorte_QNAME, String.class, DAutoreStrric.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "date_nascita", scope = DAutoreStrric.class)
    public JAXBElement<XMLGregorianCalendar> createDAutoreStrricDateNascita(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DAutoreStrricDateNascita_QNAME, XMLGregorianCalendar.class, DAutoreStrric.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "date_morte", scope = DAutoreStrric.class)
    public JAXBElement<XMLGregorianCalendar> createDAutoreStrricDateMorte(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DAutoreStrricDateMorte_QNAME, XMLGregorianCalendar.class, DAutoreStrric.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "text_luogo_nascita", scope = DAutoreStrric.class)
    public JAXBElement<String> createDAutoreStrricTextLuogoNascita(String value) {
        return new JAXBElement<String>(_DAutoreStrricTextLuogoNascita_QNAME, String.class, DAutoreStrric.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/strumenti", name = "text_note", scope = DAutoreStrric.class)
    public JAXBElement<String> createDAutoreStrricTextNote(String value) {
        return new JAXBElement<String>(_DEditoreStrricTextNote_QNAME, String.class, DAutoreStrric.class, value);
    }

}
