//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.11.07 at 10:27:57 AM CET 
//


package it.beniculturali.sas.catalogo.commons;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import it.beniculturali.sas.catalogo.luoghi.DComune;
import it.beniculturali.sas.catalogo.luoghi.DProvincia;
import it.beniculturali.sas.catalogo.luoghi.DRegione;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="text_indirizzo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="500"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_regione" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice minOccurs="0">
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/luoghi}d_regione"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_provincia" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice minOccurs="0">
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/luoghi}d_provincia"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_den_prov_parallela" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_istat_comune" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice minOccurs="0">
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/luoghi}d_comune"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_den_comune_parallela" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_cap" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="5"/>
 *               &lt;pattern value="[0-9]{5}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="flag_loc_principale_tf">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_note_localizzazione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_telefono" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *               &lt;pattern value="[0-9]+(/[0-9]+)?"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_den_edificio" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="500"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="flg_immobile_vincolati_iny" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="I"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_fax" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *               &lt;pattern value="[0-9]+(/[0-9]+)?"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_email" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *               &lt;pattern value="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_urlweb" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1000"/>
 *               &lt;minLength value="8"/>
 *               &lt;pattern value="http://.*"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_orari_apertura" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_cond_req_accesso" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_accessibilita" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_servizi_ricerca" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_servizi_riproduzione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_spazi_pubblico" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="flg_localizzazione_attiva_ny" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="flg_loc_attrezzata_consultazione_iny" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="I"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_note_loc_attrezzata_cons" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="flg_loc_attrezzata_didattica_iny" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="I"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_note_attrezzata_didattica" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="data_accertamento" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="-4713-01-01"/>
 *               &lt;maxInclusive value="5874897-12-31"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/commons}d_topografia_loc" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "textIndirizzo",
    "fkRegione",
    "fkProvincia",
    "textDenProvParallela",
    "fkIstatComune",
    "textDenComuneParallela",
    "textCap",
    "flagLocPrincipaleTf",
    "textNoteLocalizzazione",
    "textTelefono",
    "textDenEdificio",
    "flgImmobileVincolatiIny",
    "textFax",
    "textEmail",
    "textUrlweb",
    "textOrariApertura",
    "textCondReqAccesso",
    "textAccessibilita",
    "textServiziRicerca",
    "textServiziRiproduzione",
    "textSpaziPubblico",
    "flgLocalizzazioneAttivaNy",
    "flgLocAttrezzataConsultazioneIny",
    "textNoteLocAttrezzataCons",
    "flgLocAttrezzataDidatticaIny",
    "textNoteAttrezzataDidattica",
    "dataAccertamento",
    "dTopografiaLoc"
})
@XmlRootElement(name = "d_localizzazione")
public class DLocalizzazione {

    @XmlElement(name = "text_indirizzo", required = true)
    protected String textIndirizzo;
    @XmlElementRef(name = "fk_regione", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<DLocalizzazione.FkRegione> fkRegione;
    @XmlElementRef(name = "fk_provincia", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<DLocalizzazione.FkProvincia> fkProvincia;
    @XmlElementRef(name = "text_den_prov_parallela", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textDenProvParallela;
    @XmlElementRef(name = "fk_istat_comune", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<DLocalizzazione.FkIstatComune> fkIstatComune;
    @XmlElementRef(name = "text_den_comune_parallela", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textDenComuneParallela;
    @XmlElementRef(name = "text_cap", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textCap;
    @XmlElement(name = "flag_loc_principale_tf", defaultValue = "false")
    protected boolean flagLocPrincipaleTf;
    @XmlElementRef(name = "text_note_localizzazione", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textNoteLocalizzazione;
    @XmlElementRef(name = "text_telefono", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textTelefono;
    @XmlElementRef(name = "text_den_edificio", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textDenEdificio;
    @XmlElementRef(name = "flg_immobile_vincolati_iny", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> flgImmobileVincolatiIny;
    @XmlElementRef(name = "text_fax", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textFax;
    @XmlElementRef(name = "text_email", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textEmail;
    @XmlElementRef(name = "text_urlweb", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textUrlweb;
    @XmlElementRef(name = "text_orari_apertura", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textOrariApertura;
    @XmlElementRef(name = "text_cond_req_accesso", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textCondReqAccesso;
    @XmlElementRef(name = "text_accessibilita", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textAccessibilita;
    @XmlElementRef(name = "text_servizi_ricerca", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textServiziRicerca;
    @XmlElementRef(name = "text_servizi_riproduzione", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textServiziRiproduzione;
    @XmlElementRef(name = "text_spazi_pubblico", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textSpaziPubblico;
    @XmlElementRef(name = "flg_localizzazione_attiva_ny", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> flgLocalizzazioneAttivaNy;
    @XmlElementRef(name = "flg_loc_attrezzata_consultazione_iny", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> flgLocAttrezzataConsultazioneIny;
    @XmlElementRef(name = "text_note_loc_attrezzata_cons", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textNoteLocAttrezzataCons;
    @XmlElementRef(name = "flg_loc_attrezzata_didattica_iny", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> flgLocAttrezzataDidatticaIny;
    @XmlElementRef(name = "text_note_attrezzata_didattica", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textNoteAttrezzataDidattica;
    @XmlElementRef(name = "data_accertamento", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> dataAccertamento;
    @XmlElement(name = "d_topografia_loc")
    protected List<DTopografiaLoc> dTopografiaLoc;

    /**
     * Gets the value of the textIndirizzo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextIndirizzo() {
        return textIndirizzo;
    }

    /**
     * Sets the value of the textIndirizzo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextIndirizzo(String value) {
        this.textIndirizzo = value;
    }

    /**
     * Gets the value of the fkRegione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DLocalizzazione.FkRegione }{@code >}
     *     
     */
    public JAXBElement<DLocalizzazione.FkRegione> getFkRegione() {
        return fkRegione;
    }

    /**
     * Sets the value of the fkRegione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DLocalizzazione.FkRegione }{@code >}
     *     
     */
    public void setFkRegione(JAXBElement<DLocalizzazione.FkRegione> value) {
        this.fkRegione = ((JAXBElement<DLocalizzazione.FkRegione> ) value);
    }

    /**
     * Gets the value of the fkProvincia property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DLocalizzazione.FkProvincia }{@code >}
     *     
     */
    public JAXBElement<DLocalizzazione.FkProvincia> getFkProvincia() {
        return fkProvincia;
    }

    /**
     * Sets the value of the fkProvincia property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DLocalizzazione.FkProvincia }{@code >}
     *     
     */
    public void setFkProvincia(JAXBElement<DLocalizzazione.FkProvincia> value) {
        this.fkProvincia = ((JAXBElement<DLocalizzazione.FkProvincia> ) value);
    }

    /**
     * Gets the value of the textDenProvParallela property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextDenProvParallela() {
        return textDenProvParallela;
    }

    /**
     * Sets the value of the textDenProvParallela property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextDenProvParallela(JAXBElement<String> value) {
        this.textDenProvParallela = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fkIstatComune property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DLocalizzazione.FkIstatComune }{@code >}
     *     
     */
    public JAXBElement<DLocalizzazione.FkIstatComune> getFkIstatComune() {
        return fkIstatComune;
    }

    /**
     * Sets the value of the fkIstatComune property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DLocalizzazione.FkIstatComune }{@code >}
     *     
     */
    public void setFkIstatComune(JAXBElement<DLocalizzazione.FkIstatComune> value) {
        this.fkIstatComune = ((JAXBElement<DLocalizzazione.FkIstatComune> ) value);
    }

    /**
     * Gets the value of the textDenComuneParallela property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextDenComuneParallela() {
        return textDenComuneParallela;
    }

    /**
     * Sets the value of the textDenComuneParallela property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextDenComuneParallela(JAXBElement<String> value) {
        this.textDenComuneParallela = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textCap property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextCap() {
        return textCap;
    }

    /**
     * Sets the value of the textCap property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextCap(JAXBElement<String> value) {
        this.textCap = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the flagLocPrincipaleTf property.
     * 
     */
    public boolean isFlagLocPrincipaleTf() {
        return flagLocPrincipaleTf;
    }

    /**
     * Sets the value of the flagLocPrincipaleTf property.
     * 
     */
    public void setFlagLocPrincipaleTf(boolean value) {
        this.flagLocPrincipaleTf = value;
    }

    /**
     * Gets the value of the textNoteLocalizzazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNoteLocalizzazione() {
        return textNoteLocalizzazione;
    }

    /**
     * Sets the value of the textNoteLocalizzazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNoteLocalizzazione(JAXBElement<String> value) {
        this.textNoteLocalizzazione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textTelefono property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextTelefono() {
        return textTelefono;
    }

    /**
     * Sets the value of the textTelefono property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextTelefono(JAXBElement<String> value) {
        this.textTelefono = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textDenEdificio property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextDenEdificio() {
        return textDenEdificio;
    }

    /**
     * Sets the value of the textDenEdificio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextDenEdificio(JAXBElement<String> value) {
        this.textDenEdificio = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the flgImmobileVincolatiIny property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlgImmobileVincolatiIny() {
        return flgImmobileVincolatiIny;
    }

    /**
     * Sets the value of the flgImmobileVincolatiIny property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlgImmobileVincolatiIny(JAXBElement<String> value) {
        this.flgImmobileVincolatiIny = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textFax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextFax() {
        return textFax;
    }

    /**
     * Sets the value of the textFax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextFax(JAXBElement<String> value) {
        this.textFax = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textEmail property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextEmail() {
        return textEmail;
    }

    /**
     * Sets the value of the textEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextEmail(JAXBElement<String> value) {
        this.textEmail = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textUrlweb property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextUrlweb() {
        return textUrlweb;
    }

    /**
     * Sets the value of the textUrlweb property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextUrlweb(JAXBElement<String> value) {
        this.textUrlweb = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textOrariApertura property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextOrariApertura() {
        return textOrariApertura;
    }

    /**
     * Sets the value of the textOrariApertura property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextOrariApertura(JAXBElement<String> value) {
        this.textOrariApertura = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textCondReqAccesso property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextCondReqAccesso() {
        return textCondReqAccesso;
    }

    /**
     * Sets the value of the textCondReqAccesso property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextCondReqAccesso(JAXBElement<String> value) {
        this.textCondReqAccesso = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textAccessibilita property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextAccessibilita() {
        return textAccessibilita;
    }

    /**
     * Sets the value of the textAccessibilita property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextAccessibilita(JAXBElement<String> value) {
        this.textAccessibilita = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textServiziRicerca property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextServiziRicerca() {
        return textServiziRicerca;
    }

    /**
     * Sets the value of the textServiziRicerca property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextServiziRicerca(JAXBElement<String> value) {
        this.textServiziRicerca = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textServiziRiproduzione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextServiziRiproduzione() {
        return textServiziRiproduzione;
    }

    /**
     * Sets the value of the textServiziRiproduzione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextServiziRiproduzione(JAXBElement<String> value) {
        this.textServiziRiproduzione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textSpaziPubblico property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextSpaziPubblico() {
        return textSpaziPubblico;
    }

    /**
     * Sets the value of the textSpaziPubblico property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextSpaziPubblico(JAXBElement<String> value) {
        this.textSpaziPubblico = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the flgLocalizzazioneAttivaNy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlgLocalizzazioneAttivaNy() {
        return flgLocalizzazioneAttivaNy;
    }

    /**
     * Sets the value of the flgLocalizzazioneAttivaNy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlgLocalizzazioneAttivaNy(JAXBElement<String> value) {
        this.flgLocalizzazioneAttivaNy = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the flgLocAttrezzataConsultazioneIny property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlgLocAttrezzataConsultazioneIny() {
        return flgLocAttrezzataConsultazioneIny;
    }

    /**
     * Sets the value of the flgLocAttrezzataConsultazioneIny property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlgLocAttrezzataConsultazioneIny(JAXBElement<String> value) {
        this.flgLocAttrezzataConsultazioneIny = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textNoteLocAttrezzataCons property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNoteLocAttrezzataCons() {
        return textNoteLocAttrezzataCons;
    }

    /**
     * Sets the value of the textNoteLocAttrezzataCons property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNoteLocAttrezzataCons(JAXBElement<String> value) {
        this.textNoteLocAttrezzataCons = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the flgLocAttrezzataDidatticaIny property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlgLocAttrezzataDidatticaIny() {
        return flgLocAttrezzataDidatticaIny;
    }

    /**
     * Sets the value of the flgLocAttrezzataDidatticaIny property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlgLocAttrezzataDidatticaIny(JAXBElement<String> value) {
        this.flgLocAttrezzataDidatticaIny = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textNoteAttrezzataDidattica property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNoteAttrezzataDidattica() {
        return textNoteAttrezzataDidattica;
    }

    /**
     * Sets the value of the textNoteAttrezzataDidattica property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNoteAttrezzataDidattica(JAXBElement<String> value) {
        this.textNoteAttrezzataDidattica = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dataAccertamento property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDataAccertamento() {
        return dataAccertamento;
    }

    /**
     * Sets the value of the dataAccertamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDataAccertamento(JAXBElement<XMLGregorianCalendar> value) {
        this.dataAccertamento = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the dTopografiaLoc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dTopografiaLoc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDTopografiaLoc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DTopografiaLoc }
     * 
     * 
     */
    public List<DTopografiaLoc> getDTopografiaLoc() {
        if (dTopografiaLoc == null) {
            dTopografiaLoc = new ArrayList<DTopografiaLoc>();
        }
        return this.dTopografiaLoc;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice minOccurs="0">
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/luoghi}d_comune"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dComune"
    })
    public static class FkIstatComune {

        @XmlElement(name = "d_comune", namespace = "http://sas.beniculturali.it/catalogo/luoghi")
        protected DComune dComune;

        /**
         * Gets the value of the dComune property.
         * 
         * @return
         *     possible object is
         *     {@link DComune }
         *     
         */
        public DComune getDComune() {
            return dComune;
        }

        /**
         * Sets the value of the dComune property.
         * 
         * @param value
         *     allowed object is
         *     {@link DComune }
         *     
         */
        public void setDComune(DComune value) {
            this.dComune = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice minOccurs="0">
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/luoghi}d_provincia"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dProvincia"
    })
    public static class FkProvincia {

        @XmlElement(name = "d_provincia", namespace = "http://sas.beniculturali.it/catalogo/luoghi")
        protected DProvincia dProvincia;

        /**
         * Gets the value of the dProvincia property.
         * 
         * @return
         *     possible object is
         *     {@link DProvincia }
         *     
         */
        public DProvincia getDProvincia() {
            return dProvincia;
        }

        /**
         * Sets the value of the dProvincia property.
         * 
         * @param value
         *     allowed object is
         *     {@link DProvincia }
         *     
         */
        public void setDProvincia(DProvincia value) {
            this.dProvincia = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice minOccurs="0">
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/luoghi}d_regione"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dRegione"
    })
    public static class FkRegione {

        @XmlElement(name = "d_regione", namespace = "http://sas.beniculturali.it/catalogo/luoghi")
        protected DRegione dRegione;

        /**
         * Gets the value of the dRegione property.
         * 
         * @return
         *     possible object is
         *     {@link DRegione }
         *     
         */
        public DRegione getDRegione() {
            return dRegione;
        }

        /**
         * Sets the value of the dRegione property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRegione }
         *     
         */
        public void setDRegione(DRegione value) {
            this.dRegione = value;
        }

    }

}
