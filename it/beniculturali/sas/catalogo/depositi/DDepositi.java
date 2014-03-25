//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.25 at 03:07:39 PM CET 
//


package it.beniculturali.sas.catalogo.depositi;

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
import it.beniculturali.sas.catalogo.commons.DCompilatore;
import it.beniculturali.sas.catalogo.commons.DContatti;
import it.beniculturali.sas.catalogo.commons.DLocalizzazione;
import it.beniculturali.sas.catalogo.commons.DSogcStatoLocali;
import it.beniculturali.sas.catalogo.commons.DUrl;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;
import it.beniculturali.sas.catalogo.vocabolari_sogc.DVocTipoDeposito;
import it.beniculturali.sas.catalogo.vocabolari_trasv.DVocSpecificaSecoli;
import it.beniculturali.sas.catalogo.vocabolari_trasv.DVocValiditaDate;


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
 *         &lt;element name="codi_provenienza">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="256"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_den_deposito">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="1000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_tipo_deposito">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-sogc}d_voc_tipo_deposito"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_fonte">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/fonti}prof_group"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_note" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_estr_crono_testuali">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="date_estremo_remoto" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="-4713-01-01"/>
 *               &lt;maxInclusive value="5874897-12-31"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_secolo_rm" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="I"/>
 *               &lt;enumeration value="II"/>
 *               &lt;enumeration value="III"/>
 *               &lt;enumeration value="IV"/>
 *               &lt;enumeration value="V"/>
 *               &lt;enumeration value="VI"/>
 *               &lt;enumeration value="VII"/>
 *               &lt;enumeration value="VIII"/>
 *               &lt;enumeration value="IX"/>
 *               &lt;enumeration value="X"/>
 *               &lt;enumeration value="XI"/>
 *               &lt;enumeration value="XII"/>
 *               &lt;enumeration value="XIII"/>
 *               &lt;enumeration value="XIV"/>
 *               &lt;enumeration value="XV"/>
 *               &lt;enumeration value="XVI"/>
 *               &lt;enumeration value="XVII"/>
 *               &lt;enumeration value="XVIII"/>
 *               &lt;enumeration value="XIX"/>
 *               &lt;enumeration value="XX"/>
 *               &lt;enumeration value="XXI"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_validita_dtrm" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_validita_date"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_specifica_serm" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_specifica_secoli"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="date_estremo_recente" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="-4713-01-01"/>
 *               &lt;maxInclusive value="5874897-12-31"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_secolo_re" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="I"/>
 *               &lt;enumeration value="II"/>
 *               &lt;enumeration value="III"/>
 *               &lt;enumeration value="IV"/>
 *               &lt;enumeration value="V"/>
 *               &lt;enumeration value="VI"/>
 *               &lt;enumeration value="VII"/>
 *               &lt;enumeration value="VIII"/>
 *               &lt;enumeration value="IX"/>
 *               &lt;enumeration value="X"/>
 *               &lt;enumeration value="XI"/>
 *               &lt;enumeration value="XII"/>
 *               &lt;enumeration value="XIII"/>
 *               &lt;enumeration value="XIV"/>
 *               &lt;enumeration value="XV"/>
 *               &lt;enumeration value="XVI"/>
 *               &lt;enumeration value="XVII"/>
 *               &lt;enumeration value="XVIII"/>
 *               &lt;enumeration value="XIX"/>
 *               &lt;enumeration value="XX"/>
 *               &lt;enumeration value="XXI"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_validita_dtre" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_validita_date"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_specifica_sere" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_specifica_secoli"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_note_data" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/commons}d_sogc_stato_locali" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/commons}d_localizzazione" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/commons}d_contatti" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/commons}d_url" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/commons}d_compilatore" maxOccurs="unbounded" minOccurs="0"/>
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
    "codiProvenienza",
    "textDenDeposito",
    "fkVocTipoDeposito",
    "fkFonte",
    "textNote",
    "textEstrCronoTestuali",
    "dateEstremoRemoto",
    "textSecoloRm",
    "fkVocValiditaDtrm",
    "fkVocSpecificaSerm",
    "dateEstremoRecente",
    "textSecoloRe",
    "fkVocValiditaDtre",
    "fkVocSpecificaSere",
    "textNoteData",
    "dSogcStatoLocali",
    "dLocalizzazione",
    "dContatti",
    "dUrl",
    "dCompilatore"
})
@XmlRootElement(name = "d_depositi")
public class DDepositi {

    @XmlElement(name = "codi_provenienza", required = true)
    protected String codiProvenienza;
    @XmlElement(name = "text_den_deposito", required = true)
    protected String textDenDeposito;
    @XmlElement(name = "fk_voc_tipo_deposito", required = true)
    protected DDepositi.FkVocTipoDeposito fkVocTipoDeposito;
    @XmlElement(name = "fk_fonte", required = true)
    protected DDepositi.FkFonte fkFonte;
    @XmlElementRef(name = "text_note", namespace = "http://sas.beniculturali.it/catalogo/depositi", type = JAXBElement.class)
    protected JAXBElement<String> textNote;
    @XmlElement(name = "text_estr_crono_testuali", required = true)
    protected String textEstrCronoTestuali;
    @XmlElementRef(name = "date_estremo_remoto", namespace = "http://sas.beniculturali.it/catalogo/depositi", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> dateEstremoRemoto;
    @XmlElementRef(name = "text_secolo_rm", namespace = "http://sas.beniculturali.it/catalogo/depositi", type = JAXBElement.class)
    protected JAXBElement<String> textSecoloRm;
    @XmlElementRef(name = "fk_voc_validita_dtrm", namespace = "http://sas.beniculturali.it/catalogo/depositi", type = JAXBElement.class)
    protected JAXBElement<DDepositi.FkVocValiditaDtrm> fkVocValiditaDtrm;
    @XmlElementRef(name = "fk_voc_specifica_serm", namespace = "http://sas.beniculturali.it/catalogo/depositi", type = JAXBElement.class)
    protected JAXBElement<DDepositi.FkVocSpecificaSerm> fkVocSpecificaSerm;
    @XmlElementRef(name = "date_estremo_recente", namespace = "http://sas.beniculturali.it/catalogo/depositi", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> dateEstremoRecente;
    @XmlElementRef(name = "text_secolo_re", namespace = "http://sas.beniculturali.it/catalogo/depositi", type = JAXBElement.class)
    protected JAXBElement<String> textSecoloRe;
    @XmlElementRef(name = "fk_voc_validita_dtre", namespace = "http://sas.beniculturali.it/catalogo/depositi", type = JAXBElement.class)
    protected JAXBElement<DDepositi.FkVocValiditaDtre> fkVocValiditaDtre;
    @XmlElementRef(name = "fk_voc_specifica_sere", namespace = "http://sas.beniculturali.it/catalogo/depositi", type = JAXBElement.class)
    protected JAXBElement<DDepositi.FkVocSpecificaSere> fkVocSpecificaSere;
    @XmlElementRef(name = "text_note_data", namespace = "http://sas.beniculturali.it/catalogo/depositi", type = JAXBElement.class)
    protected JAXBElement<String> textNoteData;
    @XmlElement(name = "d_sogc_stato_locali", namespace = "http://sas.beniculturali.it/catalogo/commons")
    protected List<DSogcStatoLocali> dSogcStatoLocali;
    @XmlElement(name = "d_localizzazione", namespace = "http://sas.beniculturali.it/catalogo/commons")
    protected List<DLocalizzazione> dLocalizzazione;
    @XmlElement(name = "d_contatti", namespace = "http://sas.beniculturali.it/catalogo/commons")
    protected List<DContatti> dContatti;
    @XmlElement(name = "d_url", namespace = "http://sas.beniculturali.it/catalogo/commons")
    protected List<DUrl> dUrl;
    @XmlElement(name = "d_compilatore", namespace = "http://sas.beniculturali.it/catalogo/commons")
    protected List<DCompilatore> dCompilatore;

    /**
     * Gets the value of the codiProvenienza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienza() {
        return codiProvenienza;
    }

    /**
     * Sets the value of the codiProvenienza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienza(String value) {
        this.codiProvenienza = value;
    }

    /**
     * Gets the value of the textDenDeposito property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextDenDeposito() {
        return textDenDeposito;
    }

    /**
     * Sets the value of the textDenDeposito property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextDenDeposito(String value) {
        this.textDenDeposito = value;
    }

    /**
     * Gets the value of the fkVocTipoDeposito property.
     * 
     * @return
     *     possible object is
     *     {@link DDepositi.FkVocTipoDeposito }
     *     
     */
    public DDepositi.FkVocTipoDeposito getFkVocTipoDeposito() {
        return fkVocTipoDeposito;
    }

    /**
     * Sets the value of the fkVocTipoDeposito property.
     * 
     * @param value
     *     allowed object is
     *     {@link DDepositi.FkVocTipoDeposito }
     *     
     */
    public void setFkVocTipoDeposito(DDepositi.FkVocTipoDeposito value) {
        this.fkVocTipoDeposito = value;
    }

    /**
     * Gets the value of the fkFonte property.
     * 
     * @return
     *     possible object is
     *     {@link DDepositi.FkFonte }
     *     
     */
    public DDepositi.FkFonte getFkFonte() {
        return fkFonte;
    }

    /**
     * Sets the value of the fkFonte property.
     * 
     * @param value
     *     allowed object is
     *     {@link DDepositi.FkFonte }
     *     
     */
    public void setFkFonte(DDepositi.FkFonte value) {
        this.fkFonte = value;
    }

    /**
     * Gets the value of the textNote property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNote() {
        return textNote;
    }

    /**
     * Sets the value of the textNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNote(JAXBElement<String> value) {
        this.textNote = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textEstrCronoTestuali property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextEstrCronoTestuali() {
        return textEstrCronoTestuali;
    }

    /**
     * Sets the value of the textEstrCronoTestuali property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextEstrCronoTestuali(String value) {
        this.textEstrCronoTestuali = value;
    }

    /**
     * Gets the value of the dateEstremoRemoto property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateEstremoRemoto() {
        return dateEstremoRemoto;
    }

    /**
     * Sets the value of the dateEstremoRemoto property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateEstremoRemoto(JAXBElement<XMLGregorianCalendar> value) {
        this.dateEstremoRemoto = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the textSecoloRm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextSecoloRm() {
        return textSecoloRm;
    }

    /**
     * Sets the value of the textSecoloRm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextSecoloRm(JAXBElement<String> value) {
        this.textSecoloRm = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fkVocValiditaDtrm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DDepositi.FkVocValiditaDtrm }{@code >}
     *     
     */
    public JAXBElement<DDepositi.FkVocValiditaDtrm> getFkVocValiditaDtrm() {
        return fkVocValiditaDtrm;
    }

    /**
     * Sets the value of the fkVocValiditaDtrm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DDepositi.FkVocValiditaDtrm }{@code >}
     *     
     */
    public void setFkVocValiditaDtrm(JAXBElement<DDepositi.FkVocValiditaDtrm> value) {
        this.fkVocValiditaDtrm = ((JAXBElement<DDepositi.FkVocValiditaDtrm> ) value);
    }

    /**
     * Gets the value of the fkVocSpecificaSerm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DDepositi.FkVocSpecificaSerm }{@code >}
     *     
     */
    public JAXBElement<DDepositi.FkVocSpecificaSerm> getFkVocSpecificaSerm() {
        return fkVocSpecificaSerm;
    }

    /**
     * Sets the value of the fkVocSpecificaSerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DDepositi.FkVocSpecificaSerm }{@code >}
     *     
     */
    public void setFkVocSpecificaSerm(JAXBElement<DDepositi.FkVocSpecificaSerm> value) {
        this.fkVocSpecificaSerm = ((JAXBElement<DDepositi.FkVocSpecificaSerm> ) value);
    }

    /**
     * Gets the value of the dateEstremoRecente property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateEstremoRecente() {
        return dateEstremoRecente;
    }

    /**
     * Sets the value of the dateEstremoRecente property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateEstremoRecente(JAXBElement<XMLGregorianCalendar> value) {
        this.dateEstremoRecente = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the textSecoloRe property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextSecoloRe() {
        return textSecoloRe;
    }

    /**
     * Sets the value of the textSecoloRe property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextSecoloRe(JAXBElement<String> value) {
        this.textSecoloRe = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fkVocValiditaDtre property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DDepositi.FkVocValiditaDtre }{@code >}
     *     
     */
    public JAXBElement<DDepositi.FkVocValiditaDtre> getFkVocValiditaDtre() {
        return fkVocValiditaDtre;
    }

    /**
     * Sets the value of the fkVocValiditaDtre property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DDepositi.FkVocValiditaDtre }{@code >}
     *     
     */
    public void setFkVocValiditaDtre(JAXBElement<DDepositi.FkVocValiditaDtre> value) {
        this.fkVocValiditaDtre = ((JAXBElement<DDepositi.FkVocValiditaDtre> ) value);
    }

    /**
     * Gets the value of the fkVocSpecificaSere property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DDepositi.FkVocSpecificaSere }{@code >}
     *     
     */
    public JAXBElement<DDepositi.FkVocSpecificaSere> getFkVocSpecificaSere() {
        return fkVocSpecificaSere;
    }

    /**
     * Sets the value of the fkVocSpecificaSere property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DDepositi.FkVocSpecificaSere }{@code >}
     *     
     */
    public void setFkVocSpecificaSere(JAXBElement<DDepositi.FkVocSpecificaSere> value) {
        this.fkVocSpecificaSere = ((JAXBElement<DDepositi.FkVocSpecificaSere> ) value);
    }

    /**
     * Gets the value of the textNoteData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNoteData() {
        return textNoteData;
    }

    /**
     * Sets the value of the textNoteData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNoteData(JAXBElement<String> value) {
        this.textNoteData = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dSogcStatoLocali property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dSogcStatoLocali property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDSogcStatoLocali().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DSogcStatoLocali }
     * 
     * 
     */
    public List<DSogcStatoLocali> getDSogcStatoLocali() {
        if (dSogcStatoLocali == null) {
            dSogcStatoLocali = new ArrayList<DSogcStatoLocali>();
        }
        return this.dSogcStatoLocali;
    }

    /**
     * Gets the value of the dLocalizzazione property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dLocalizzazione property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDLocalizzazione().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DLocalizzazione }
     * 
     * 
     */
    public List<DLocalizzazione> getDLocalizzazione() {
        if (dLocalizzazione == null) {
            dLocalizzazione = new ArrayList<DLocalizzazione>();
        }
        return this.dLocalizzazione;
    }

    /**
     * Gets the value of the dContatti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dContatti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDContatti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DContatti }
     * 
     * 
     */
    public List<DContatti> getDContatti() {
        if (dContatti == null) {
            dContatti = new ArrayList<DContatti>();
        }
        return this.dContatti;
    }

    /**
     * Gets the value of the dUrl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dUrl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDUrl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DUrl }
     * 
     * 
     */
    public List<DUrl> getDUrl() {
        if (dUrl == null) {
            dUrl = new ArrayList<DUrl>();
        }
        return this.dUrl;
    }

    /**
     * Gets the value of the dCompilatore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dCompilatore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDCompilatore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DCompilatore }
     * 
     * 
     */
    public List<DCompilatore> getDCompilatore() {
        if (dCompilatore == null) {
            dCompilatore = new ArrayList<DCompilatore>();
        }
        return this.dCompilatore;
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
     *       &lt;choice>
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/fonti}prof_group"/>
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
        "profGroup"
    })
    public static class FkFonte {

        @XmlElement(name = "prof_group", namespace = "http://sas.beniculturali.it/catalogo/fonti")
        protected ProfGroup profGroup;

        /**
         * Gets the value of the profGroup property.
         * 
         * @return
         *     possible object is
         *     {@link ProfGroup }
         *     
         */
        public ProfGroup getProfGroup() {
            return profGroup;
        }

        /**
         * Sets the value of the profGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link ProfGroup }
         *     
         */
        public void setProfGroup(ProfGroup value) {
            this.profGroup = value;
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
     *       &lt;choice>
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_specifica_secoli"/>
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
        "dVocSpecificaSecoli"
    })
    public static class FkVocSpecificaSere {

        @XmlElement(name = "d_voc_specifica_secoli", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-trasv")
        protected DVocSpecificaSecoli dVocSpecificaSecoli;

        /**
         * Gets the value of the dVocSpecificaSecoli property.
         * 
         * @return
         *     possible object is
         *     {@link DVocSpecificaSecoli }
         *     
         */
        public DVocSpecificaSecoli getDVocSpecificaSecoli() {
            return dVocSpecificaSecoli;
        }

        /**
         * Sets the value of the dVocSpecificaSecoli property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocSpecificaSecoli }
         *     
         */
        public void setDVocSpecificaSecoli(DVocSpecificaSecoli value) {
            this.dVocSpecificaSecoli = value;
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
     *       &lt;choice>
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_specifica_secoli"/>
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
        "dVocSpecificaSecoli"
    })
    public static class FkVocSpecificaSerm {

        @XmlElement(name = "d_voc_specifica_secoli", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-trasv")
        protected DVocSpecificaSecoli dVocSpecificaSecoli;

        /**
         * Gets the value of the dVocSpecificaSecoli property.
         * 
         * @return
         *     possible object is
         *     {@link DVocSpecificaSecoli }
         *     
         */
        public DVocSpecificaSecoli getDVocSpecificaSecoli() {
            return dVocSpecificaSecoli;
        }

        /**
         * Sets the value of the dVocSpecificaSecoli property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocSpecificaSecoli }
         *     
         */
        public void setDVocSpecificaSecoli(DVocSpecificaSecoli value) {
            this.dVocSpecificaSecoli = value;
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
     *       &lt;choice>
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-sogc}d_voc_tipo_deposito"/>
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
        "dVocTipoDeposito"
    })
    public static class FkVocTipoDeposito {

        @XmlElement(name = "d_voc_tipo_deposito", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-sogc")
        protected DVocTipoDeposito dVocTipoDeposito;

        /**
         * Gets the value of the dVocTipoDeposito property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipoDeposito }
         *     
         */
        public DVocTipoDeposito getDVocTipoDeposito() {
            return dVocTipoDeposito;
        }

        /**
         * Sets the value of the dVocTipoDeposito property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipoDeposito }
         *     
         */
        public void setDVocTipoDeposito(DVocTipoDeposito value) {
            this.dVocTipoDeposito = value;
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
     *       &lt;choice>
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_validita_date"/>
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
        "dVocValiditaDate"
    })
    public static class FkVocValiditaDtre {

        @XmlElement(name = "d_voc_validita_date", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-trasv")
        protected DVocValiditaDate dVocValiditaDate;

        /**
         * Gets the value of the dVocValiditaDate property.
         * 
         * @return
         *     possible object is
         *     {@link DVocValiditaDate }
         *     
         */
        public DVocValiditaDate getDVocValiditaDate() {
            return dVocValiditaDate;
        }

        /**
         * Sets the value of the dVocValiditaDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocValiditaDate }
         *     
         */
        public void setDVocValiditaDate(DVocValiditaDate value) {
            this.dVocValiditaDate = value;
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
     *       &lt;choice>
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_validita_date"/>
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
        "dVocValiditaDate"
    })
    public static class FkVocValiditaDtrm {

        @XmlElement(name = "d_voc_validita_date", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-trasv")
        protected DVocValiditaDate dVocValiditaDate;

        /**
         * Gets the value of the dVocValiditaDate property.
         * 
         * @return
         *     possible object is
         *     {@link DVocValiditaDate }
         *     
         */
        public DVocValiditaDate getDVocValiditaDate() {
            return dVocValiditaDate;
        }

        /**
         * Sets the value of the dVocValiditaDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocValiditaDate }
         *     
         */
        public void setDVocValiditaDate(DVocValiditaDate value) {
            this.dVocValiditaDate = value;
        }

    }

}
