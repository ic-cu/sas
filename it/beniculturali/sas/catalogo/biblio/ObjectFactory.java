//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.27 at 02:03:47 PM CET 
//


package it.beniculturali.sas.catalogo.biblio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.beniculturali.sas.catalogo.biblio package. 
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

    private final static QName _DEditoreBiblTextNote_QNAME = new QName("http://sas.beniculturali.it/catalogo/biblio", "text_note");
    private final static QName _DAutoreBiblTextLuogoMorte_QNAME = new QName("http://sas.beniculturali.it/catalogo/biblio", "text_luogo_morte");
    private final static QName _DAutoreBiblDateNascita_QNAME = new QName("http://sas.beniculturali.it/catalogo/biblio", "date_nascita");
    private final static QName _DAutoreBiblDateMorte_QNAME = new QName("http://sas.beniculturali.it/catalogo/biblio", "date_morte");
    private final static QName _DAutoreBiblTextLuogoNascita_QNAME = new QName("http://sas.beniculturali.it/catalogo/biblio", "text_luogo_nascita");
    private final static QName _DBibliografiaTextBiblioteca_QNAME = new QName("http://sas.beniculturali.it/catalogo/biblio", "text_biblioteca");
    private final static QName _DBibliografiaCodiIsbn_QNAME = new QName("http://sas.beniculturali.it/catalogo/biblio", "codi_isbn");
    private final static QName _DBibliografiaCodiOpacSbn_QNAME = new QName("http://sas.beniculturali.it/catalogo/biblio", "codi_opac_sbn");
    private final static QName _DBibliografiaTextMetadatiOpac_QNAME = new QName("http://sas.beniculturali.it/catalogo/biblio", "text_metadati_opac");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.beniculturali.sas.catalogo.biblio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DEditoreBibl }
     * 
     */
    public DEditoreBibl createDEditoreBibl() {
        return new DEditoreBibl();
    }

    /**
     * Create an instance of {@link DSoggettiBibl }
     * 
     */
    public DSoggettiBibl createDSoggettiBibl() {
        return new DSoggettiBibl();
    }

    /**
     * Create an instance of {@link DEditoreBibl.FkFonte }
     * 
     */
    public DEditoreBibl.FkFonte createDEditoreBiblFkFonte() {
        return new DEditoreBibl.FkFonte();
    }

    /**
     * Create an instance of {@link DBibliografia.FkFonte }
     * 
     */
    public DBibliografia.FkFonte createDBibliografiaFkFonte() {
        return new DBibliografia.FkFonte();
    }

    /**
     * Create an instance of {@link DBibliografia }
     * 
     */
    public DBibliografia createDBibliografia() {
        return new DBibliografia();
    }

    /**
     * Create an instance of {@link DAutoreBibl.FkFonte }
     * 
     */
    public DAutoreBibl.FkFonte createDAutoreBiblFkFonte() {
        return new DAutoreBibl.FkFonte();
    }

    /**
     * Create an instance of {@link DAutoreBibl }
     * 
     */
    public DAutoreBibl createDAutoreBibl() {
        return new DAutoreBibl();
    }

    /**
     * Create an instance of {@link DEdizioneBibl }
     * 
     */
    public DEdizioneBibl createDEdizioneBibl() {
        return new DEdizioneBibl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/biblio", name = "text_note", scope = DEditoreBibl.class)
    public JAXBElement<String> createDEditoreBiblTextNote(String value) {
        return new JAXBElement<String>(_DEditoreBiblTextNote_QNAME, String.class, DEditoreBibl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/biblio", name = "text_luogo_morte", scope = DAutoreBibl.class)
    public JAXBElement<String> createDAutoreBiblTextLuogoMorte(String value) {
        return new JAXBElement<String>(_DAutoreBiblTextLuogoMorte_QNAME, String.class, DAutoreBibl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/biblio", name = "date_nascita", scope = DAutoreBibl.class)
    public JAXBElement<XMLGregorianCalendar> createDAutoreBiblDateNascita(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DAutoreBiblDateNascita_QNAME, XMLGregorianCalendar.class, DAutoreBibl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/biblio", name = "date_morte", scope = DAutoreBibl.class)
    public JAXBElement<XMLGregorianCalendar> createDAutoreBiblDateMorte(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DAutoreBiblDateMorte_QNAME, XMLGregorianCalendar.class, DAutoreBibl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/biblio", name = "text_luogo_nascita", scope = DAutoreBibl.class)
    public JAXBElement<String> createDAutoreBiblTextLuogoNascita(String value) {
        return new JAXBElement<String>(_DAutoreBiblTextLuogoNascita_QNAME, String.class, DAutoreBibl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/biblio", name = "text_biblioteca", scope = DBibliografia.class)
    public JAXBElement<String> createDBibliografiaTextBiblioteca(String value) {
        return new JAXBElement<String>(_DBibliografiaTextBiblioteca_QNAME, String.class, DBibliografia.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/biblio", name = "codi_isbn", scope = DBibliografia.class)
    public JAXBElement<String> createDBibliografiaCodiIsbn(String value) {
        return new JAXBElement<String>(_DBibliografiaCodiIsbn_QNAME, String.class, DBibliografia.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/biblio", name = "codi_opac_sbn", scope = DBibliografia.class)
    public JAXBElement<String> createDBibliografiaCodiOpacSbn(String value) {
        return new JAXBElement<String>(_DBibliografiaCodiOpacSbn_QNAME, String.class, DBibliografia.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/biblio", name = "text_metadati_opac", scope = DBibliografia.class)
    public JAXBElement<String> createDBibliografiaTextMetadatiOpac(String value) {
        return new JAXBElement<String>(_DBibliografiaTextMetadatiOpac_QNAME, String.class, DBibliografia.class, value);
    }

}
