//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.18 at 04:50:28 PM CET 
//


package it.beniculturali.sas.catalogo.commons;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import it.beniculturali.sas.catalogo.vocabolari_sogc.DVocStatoLocali;
import it.beniculturali.sas.catalogo.vocabolari_sogc.DVocTipoUsoLocali;


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
 *         &lt;element name="date_accertamento" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="-4713-01-01"/>
 *               &lt;maxInclusive value="5874897-12-31"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="date_rilevamento" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="-4713-01-01"/>
 *               &lt;maxInclusive value="5874897-12-31"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_descrizione_locali">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_tipo_uso_locali" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-sogc}d_voc_tipo_uso_locali"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="nume_metri_lineari" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="10"/>
 *               &lt;fractionDigits value="3"/>
 *               &lt;minExclusive value="-10000000.0000"/>
 *               &lt;maxExclusive value="10000000.0000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="descr_stato_rischio" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_stato_locali" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-sogc}d_voc_stato_locali"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_stato_locali" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="descr_stato_impianto_elettrico" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="descr_stato_antincendio" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="descr_stato_antintrusione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="descr_stato_climatizzazione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="descr_stato_attrezzature" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="flag_spazi_incrementi_tf" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *               &lt;enumeration value="t"/>
 *               &lt;enumeration value="f"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="flag_stato_rischio_tf" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *               &lt;enumeration value="t"/>
 *               &lt;enumeration value="f"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="flag_idoneita_ambientale_tf" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *               &lt;enumeration value="t"/>
 *               &lt;enumeration value="f"/>
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
    "dateAccertamento",
    "dateRilevamento",
    "textDescrizioneLocali",
    "fkVocTipoUsoLocali",
    "numeMetriLineari",
    "descrStatoRischio",
    "fkVocStatoLocali",
    "textStatoLocali",
    "descrStatoImpiantoElettrico",
    "descrStatoAntincendio",
    "descrStatoAntintrusione",
    "descrStatoClimatizzazione",
    "descrStatoAttrezzature",
    "flagSpaziIncrementiTf",
    "flagStatoRischioTf",
    "flagIdoneitaAmbientaleTf"
})
@XmlRootElement(name = "d_sogc_stato_locali")
public class DSogcStatoLocali {

    @XmlElementRef(name = "date_accertamento", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> dateAccertamento;
    @XmlElementRef(name = "date_rilevamento", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> dateRilevamento;
    @XmlElement(name = "text_descrizione_locali", required = true)
    protected String textDescrizioneLocali;
    @XmlElementRef(name = "fk_voc_tipo_uso_locali", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<DSogcStatoLocali.FkVocTipoUsoLocali> fkVocTipoUsoLocali;
    @XmlElementRef(name = "nume_metri_lineari", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> numeMetriLineari;
    @XmlElementRef(name = "descr_stato_rischio", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> descrStatoRischio;
    @XmlElementRef(name = "fk_voc_stato_locali", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<DSogcStatoLocali.FkVocStatoLocali> fkVocStatoLocali;
    @XmlElementRef(name = "text_stato_locali", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textStatoLocali;
    @XmlElementRef(name = "descr_stato_impianto_elettrico", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> descrStatoImpiantoElettrico;
    @XmlElementRef(name = "descr_stato_antincendio", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> descrStatoAntincendio;
    @XmlElementRef(name = "descr_stato_antintrusione", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> descrStatoAntintrusione;
    @XmlElementRef(name = "descr_stato_climatizzazione", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> descrStatoClimatizzazione;
    @XmlElementRef(name = "descr_stato_attrezzature", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> descrStatoAttrezzature;
    @XmlElementRef(name = "flag_spazi_incrementi_tf", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> flagSpaziIncrementiTf;
    @XmlElementRef(name = "flag_stato_rischio_tf", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> flagStatoRischioTf;
    @XmlElementRef(name = "flag_idoneita_ambientale_tf", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> flagIdoneitaAmbientaleTf;

    /**
     * Gets the value of the dateAccertamento property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateAccertamento() {
        return dateAccertamento;
    }

    /**
     * Sets the value of the dateAccertamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateAccertamento(JAXBElement<XMLGregorianCalendar> value) {
        this.dateAccertamento = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the dateRilevamento property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateRilevamento() {
        return dateRilevamento;
    }

    /**
     * Sets the value of the dateRilevamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateRilevamento(JAXBElement<XMLGregorianCalendar> value) {
        this.dateRilevamento = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the textDescrizioneLocali property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextDescrizioneLocali() {
        return textDescrizioneLocali;
    }

    /**
     * Sets the value of the textDescrizioneLocali property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextDescrizioneLocali(String value) {
        this.textDescrizioneLocali = value;
    }

    /**
     * Gets the value of the fkVocTipoUsoLocali property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DSogcStatoLocali.FkVocTipoUsoLocali }{@code >}
     *     
     */
    public JAXBElement<DSogcStatoLocali.FkVocTipoUsoLocali> getFkVocTipoUsoLocali() {
        return fkVocTipoUsoLocali;
    }

    /**
     * Sets the value of the fkVocTipoUsoLocali property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DSogcStatoLocali.FkVocTipoUsoLocali }{@code >}
     *     
     */
    public void setFkVocTipoUsoLocali(JAXBElement<DSogcStatoLocali.FkVocTipoUsoLocali> value) {
        this.fkVocTipoUsoLocali = ((JAXBElement<DSogcStatoLocali.FkVocTipoUsoLocali> ) value);
    }

    /**
     * Gets the value of the numeMetriLineari property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getNumeMetriLineari() {
        return numeMetriLineari;
    }

    /**
     * Sets the value of the numeMetriLineari property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setNumeMetriLineari(JAXBElement<BigDecimal> value) {
        this.numeMetriLineari = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the descrStatoRischio property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescrStatoRischio() {
        return descrStatoRischio;
    }

    /**
     * Sets the value of the descrStatoRischio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescrStatoRischio(JAXBElement<String> value) {
        this.descrStatoRischio = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fkVocStatoLocali property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DSogcStatoLocali.FkVocStatoLocali }{@code >}
     *     
     */
    public JAXBElement<DSogcStatoLocali.FkVocStatoLocali> getFkVocStatoLocali() {
        return fkVocStatoLocali;
    }

    /**
     * Sets the value of the fkVocStatoLocali property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DSogcStatoLocali.FkVocStatoLocali }{@code >}
     *     
     */
    public void setFkVocStatoLocali(JAXBElement<DSogcStatoLocali.FkVocStatoLocali> value) {
        this.fkVocStatoLocali = ((JAXBElement<DSogcStatoLocali.FkVocStatoLocali> ) value);
    }

    /**
     * Gets the value of the textStatoLocali property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextStatoLocali() {
        return textStatoLocali;
    }

    /**
     * Sets the value of the textStatoLocali property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextStatoLocali(JAXBElement<String> value) {
        this.textStatoLocali = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the descrStatoImpiantoElettrico property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescrStatoImpiantoElettrico() {
        return descrStatoImpiantoElettrico;
    }

    /**
     * Sets the value of the descrStatoImpiantoElettrico property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescrStatoImpiantoElettrico(JAXBElement<String> value) {
        this.descrStatoImpiantoElettrico = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the descrStatoAntincendio property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescrStatoAntincendio() {
        return descrStatoAntincendio;
    }

    /**
     * Sets the value of the descrStatoAntincendio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescrStatoAntincendio(JAXBElement<String> value) {
        this.descrStatoAntincendio = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the descrStatoAntintrusione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescrStatoAntintrusione() {
        return descrStatoAntintrusione;
    }

    /**
     * Sets the value of the descrStatoAntintrusione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescrStatoAntintrusione(JAXBElement<String> value) {
        this.descrStatoAntintrusione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the descrStatoClimatizzazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescrStatoClimatizzazione() {
        return descrStatoClimatizzazione;
    }

    /**
     * Sets the value of the descrStatoClimatizzazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescrStatoClimatizzazione(JAXBElement<String> value) {
        this.descrStatoClimatizzazione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the descrStatoAttrezzature property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescrStatoAttrezzature() {
        return descrStatoAttrezzature;
    }

    /**
     * Sets the value of the descrStatoAttrezzature property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescrStatoAttrezzature(JAXBElement<String> value) {
        this.descrStatoAttrezzature = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the flagSpaziIncrementiTf property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlagSpaziIncrementiTf() {
        return flagSpaziIncrementiTf;
    }

    /**
     * Sets the value of the flagSpaziIncrementiTf property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlagSpaziIncrementiTf(JAXBElement<String> value) {
        this.flagSpaziIncrementiTf = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the flagStatoRischioTf property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlagStatoRischioTf() {
        return flagStatoRischioTf;
    }

    /**
     * Sets the value of the flagStatoRischioTf property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlagStatoRischioTf(JAXBElement<String> value) {
        this.flagStatoRischioTf = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the flagIdoneitaAmbientaleTf property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlagIdoneitaAmbientaleTf() {
        return flagIdoneitaAmbientaleTf;
    }

    /**
     * Sets the value of the flagIdoneitaAmbientaleTf property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlagIdoneitaAmbientaleTf(JAXBElement<String> value) {
        this.flagIdoneitaAmbientaleTf = ((JAXBElement<String> ) value);
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-sogc}d_voc_stato_locali"/>
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
        "dVocStatoLocali"
    })
    public static class FkVocStatoLocali {

        @XmlElement(name = "d_voc_stato_locali", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-sogc")
        protected DVocStatoLocali dVocStatoLocali;

        /**
         * Gets the value of the dVocStatoLocali property.
         * 
         * @return
         *     possible object is
         *     {@link DVocStatoLocali }
         *     
         */
        public DVocStatoLocali getDVocStatoLocali() {
            return dVocStatoLocali;
        }

        /**
         * Sets the value of the dVocStatoLocali property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocStatoLocali }
         *     
         */
        public void setDVocStatoLocali(DVocStatoLocali value) {
            this.dVocStatoLocali = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-sogc}d_voc_tipo_uso_locali"/>
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
        "dVocTipoUsoLocali"
    })
    public static class FkVocTipoUsoLocali {

        @XmlElement(name = "d_voc_tipo_uso_locali", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-sogc")
        protected DVocTipoUsoLocali dVocTipoUsoLocali;

        /**
         * Gets the value of the dVocTipoUsoLocali property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipoUsoLocali }
         *     
         */
        public DVocTipoUsoLocali getDVocTipoUsoLocali() {
            return dVocTipoUsoLocali;
        }

        /**
         * Sets the value of the dVocTipoUsoLocali property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipoUsoLocali }
         *     
         */
        public void setDVocTipoUsoLocali(DVocTipoUsoLocali value) {
            this.dVocTipoUsoLocali = value;
        }

    }

}
