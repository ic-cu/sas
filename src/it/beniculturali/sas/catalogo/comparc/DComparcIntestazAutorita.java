//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.27 at 02:03:47 PM CET 
//


package it.beniculturali.sas.catalogo.comparc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import it.beniculturali.sas.catalogo.vocabolari_trasv.DVocSpecificaSecoli;
import it.beniculturali.sas.catalogo.vocabolari_trasv.DVocTipoLingua;
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
 *         &lt;element name="flg_tipo_denominazione">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="IAU"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_altreden">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="1024"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_tipo_lingua" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_tipo_lingua"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
 *               &lt;enumeration value="IX"/>
 *               &lt;enumeration value="V"/>
 *               &lt;enumeration value="VI"/>
 *               &lt;enumeration value="VII"/>
 *               &lt;enumeration value="VIII"/>
 *               &lt;enumeration value="X"/>
 *               &lt;enumeration value="XI"/>
 *               &lt;enumeration value="XII"/>
 *               &lt;enumeration value="XIII"/>
 *               &lt;enumeration value="XIV"/>
 *               &lt;enumeration value="XIX"/>
 *               &lt;enumeration value="XV"/>
 *               &lt;enumeration value="XVI"/>
 *               &lt;enumeration value="XVII"/>
 *               &lt;enumeration value="XVIII"/>
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
 *               &lt;enumeration value="IX"/>
 *               &lt;enumeration value="V"/>
 *               &lt;enumeration value="VI"/>
 *               &lt;enumeration value="VII"/>
 *               &lt;enumeration value="VIII"/>
 *               &lt;enumeration value="X"/>
 *               &lt;enumeration value="XI"/>
 *               &lt;enumeration value="XII"/>
 *               &lt;enumeration value="XIII"/>
 *               &lt;enumeration value="XIV"/>
 *               &lt;enumeration value="XIX"/>
 *               &lt;enumeration value="XV"/>
 *               &lt;enumeration value="XVI"/>
 *               &lt;enumeration value="XVII"/>
 *               &lt;enumeration value="XVIII"/>
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
    "flgTipoDenominazione",
    "textAltreden",
    "fkVocTipoLingua",
    "textEstrCronoTestuali",
    "dateEstremoRemoto",
    "textSecoloRm",
    "fkVocValiditaDtrm",
    "fkVocSpecificaSerm",
    "dateEstremoRecente",
    "textSecoloRe",
    "fkVocValiditaDtre",
    "fkVocSpecificaSere",
    "textNoteData"
})
@XmlRootElement(name = "d_comparc_intestaz_autorita")
public class DComparcIntestazAutorita {

    @XmlElement(name = "flg_tipo_denominazione", required = true, nillable = true)
    protected String flgTipoDenominazione;
    @XmlElement(name = "text_altreden", required = true)
    protected String textAltreden;
    @XmlElementRef(name = "fk_voc_tipo_lingua", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcIntestazAutorita.FkVocTipoLingua> fkVocTipoLingua;
    @XmlElement(name = "text_estr_crono_testuali", required = true)
    protected String textEstrCronoTestuali;
    @XmlElementRef(name = "date_estremo_remoto", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> dateEstremoRemoto;
    @XmlElementRef(name = "text_secolo_rm", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textSecoloRm;
    @XmlElementRef(name = "fk_voc_validita_dtrm", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcIntestazAutorita.FkVocValiditaDtrm> fkVocValiditaDtrm;
    @XmlElementRef(name = "fk_voc_specifica_serm", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcIntestazAutorita.FkVocSpecificaSerm> fkVocSpecificaSerm;
    @XmlElementRef(name = "date_estremo_recente", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> dateEstremoRecente;
    @XmlElementRef(name = "text_secolo_re", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textSecoloRe;
    @XmlElementRef(name = "fk_voc_validita_dtre", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcIntestazAutorita.FkVocValiditaDtre> fkVocValiditaDtre;
    @XmlElementRef(name = "fk_voc_specifica_sere", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcIntestazAutorita.FkVocSpecificaSere> fkVocSpecificaSere;
    @XmlElementRef(name = "text_note_data", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textNoteData;

    /**
     * Gets the value of the flgTipoDenominazione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgTipoDenominazione() {
        return flgTipoDenominazione;
    }

    /**
     * Sets the value of the flgTipoDenominazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgTipoDenominazione(String value) {
        this.flgTipoDenominazione = value;
    }

    /**
     * Gets the value of the textAltreden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextAltreden() {
        return textAltreden;
    }

    /**
     * Sets the value of the textAltreden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextAltreden(String value) {
        this.textAltreden = value;
    }

    /**
     * Gets the value of the fkVocTipoLingua property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcIntestazAutorita.FkVocTipoLingua }{@code >}
     *     
     */
    public JAXBElement<DComparcIntestazAutorita.FkVocTipoLingua> getFkVocTipoLingua() {
        return fkVocTipoLingua;
    }

    /**
     * Sets the value of the fkVocTipoLingua property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcIntestazAutorita.FkVocTipoLingua }{@code >}
     *     
     */
    public void setFkVocTipoLingua(JAXBElement<DComparcIntestazAutorita.FkVocTipoLingua> value) {
        this.fkVocTipoLingua = ((JAXBElement<DComparcIntestazAutorita.FkVocTipoLingua> ) value);
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
     *     {@link JAXBElement }{@code <}{@link DComparcIntestazAutorita.FkVocValiditaDtrm }{@code >}
     *     
     */
    public JAXBElement<DComparcIntestazAutorita.FkVocValiditaDtrm> getFkVocValiditaDtrm() {
        return fkVocValiditaDtrm;
    }

    /**
     * Sets the value of the fkVocValiditaDtrm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcIntestazAutorita.FkVocValiditaDtrm }{@code >}
     *     
     */
    public void setFkVocValiditaDtrm(JAXBElement<DComparcIntestazAutorita.FkVocValiditaDtrm> value) {
        this.fkVocValiditaDtrm = ((JAXBElement<DComparcIntestazAutorita.FkVocValiditaDtrm> ) value);
    }

    /**
     * Gets the value of the fkVocSpecificaSerm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcIntestazAutorita.FkVocSpecificaSerm }{@code >}
     *     
     */
    public JAXBElement<DComparcIntestazAutorita.FkVocSpecificaSerm> getFkVocSpecificaSerm() {
        return fkVocSpecificaSerm;
    }

    /**
     * Sets the value of the fkVocSpecificaSerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcIntestazAutorita.FkVocSpecificaSerm }{@code >}
     *     
     */
    public void setFkVocSpecificaSerm(JAXBElement<DComparcIntestazAutorita.FkVocSpecificaSerm> value) {
        this.fkVocSpecificaSerm = ((JAXBElement<DComparcIntestazAutorita.FkVocSpecificaSerm> ) value);
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
     *     {@link JAXBElement }{@code <}{@link DComparcIntestazAutorita.FkVocValiditaDtre }{@code >}
     *     
     */
    public JAXBElement<DComparcIntestazAutorita.FkVocValiditaDtre> getFkVocValiditaDtre() {
        return fkVocValiditaDtre;
    }

    /**
     * Sets the value of the fkVocValiditaDtre property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcIntestazAutorita.FkVocValiditaDtre }{@code >}
     *     
     */
    public void setFkVocValiditaDtre(JAXBElement<DComparcIntestazAutorita.FkVocValiditaDtre> value) {
        this.fkVocValiditaDtre = ((JAXBElement<DComparcIntestazAutorita.FkVocValiditaDtre> ) value);
    }

    /**
     * Gets the value of the fkVocSpecificaSere property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcIntestazAutorita.FkVocSpecificaSere }{@code >}
     *     
     */
    public JAXBElement<DComparcIntestazAutorita.FkVocSpecificaSere> getFkVocSpecificaSere() {
        return fkVocSpecificaSere;
    }

    /**
     * Sets the value of the fkVocSpecificaSere property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcIntestazAutorita.FkVocSpecificaSere }{@code >}
     *     
     */
    public void setFkVocSpecificaSere(JAXBElement<DComparcIntestazAutorita.FkVocSpecificaSere> value) {
        this.fkVocSpecificaSere = ((JAXBElement<DComparcIntestazAutorita.FkVocSpecificaSere> ) value);
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_tipo_lingua"/>
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
        "dVocTipoLingua"
    })
    public static class FkVocTipoLingua {

        @XmlElement(name = "d_voc_tipo_lingua", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-trasv")
        protected DVocTipoLingua dVocTipoLingua;

        /**
         * Gets the value of the dVocTipoLingua property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipoLingua }
         *     
         */
        public DVocTipoLingua getDVocTipoLingua() {
            return dVocTipoLingua;
        }

        /**
         * Sets the value of the dVocTipoLingua property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipoLingua }
         *     
         */
        public void setDVocTipoLingua(DVocTipoLingua value) {
            this.dVocTipoLingua = value;
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
