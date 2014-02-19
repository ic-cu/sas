//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.18 at 04:50:28 PM CET 
//


package it.beniculturali.sas.catalogo.comparc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipologiaConservatore;


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
 *         &lt;element name="flag_consultabile_conservatore_tf" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_denominazione_consultabile" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1024"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_tipologia_conservatore" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipologia_conservatore"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_modalita_consultazione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_limiti_consultazione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_motivo_limitazione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_modo_riproduzione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_tipologia_riproduzione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_limiti_riproduzione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_autorizzazione_pubblicazione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_titolare_diritti" minOccurs="0">
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
    "flagConsultabileConservatoreTf",
    "textDenominazioneConsultabile",
    "fkVocTipologiaConservatore",
    "textModalitaConsultazione",
    "textLimitiConsultazione",
    "textMotivoLimitazione",
    "textModoRiproduzione",
    "textTipologiaRiproduzione",
    "textLimitiRiproduzione",
    "textAutorizzazionePubblicazione",
    "textTitolareDiritti"
})
@XmlRootElement(name = "d_comparc_cond_accesso")
public class DComparcCondAccesso {

    @XmlElementRef(name = "flag_consultabile_conservatore_tf", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<Boolean> flagConsultabileConservatoreTf;
    @XmlElementRef(name = "text_denominazione_consultabile", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textDenominazioneConsultabile;
    @XmlElementRef(name = "fk_voc_tipologia_conservatore", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcCondAccesso.FkVocTipologiaConservatore> fkVocTipologiaConservatore;
    @XmlElementRef(name = "text_modalita_consultazione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textModalitaConsultazione;
    @XmlElementRef(name = "text_limiti_consultazione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textLimitiConsultazione;
    @XmlElementRef(name = "text_motivo_limitazione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textMotivoLimitazione;
    @XmlElementRef(name = "text_modo_riproduzione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textModoRiproduzione;
    @XmlElementRef(name = "text_tipologia_riproduzione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textTipologiaRiproduzione;
    @XmlElementRef(name = "text_limiti_riproduzione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textLimitiRiproduzione;
    @XmlElementRef(name = "text_autorizzazione_pubblicazione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textAutorizzazionePubblicazione;
    @XmlElementRef(name = "text_titolare_diritti", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textTitolareDiritti;

    /**
     * Gets the value of the flagConsultabileConservatoreTf property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getFlagConsultabileConservatoreTf() {
        return flagConsultabileConservatoreTf;
    }

    /**
     * Sets the value of the flagConsultabileConservatoreTf property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setFlagConsultabileConservatoreTf(JAXBElement<Boolean> value) {
        this.flagConsultabileConservatoreTf = ((JAXBElement<Boolean> ) value);
    }

    /**
     * Gets the value of the textDenominazioneConsultabile property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextDenominazioneConsultabile() {
        return textDenominazioneConsultabile;
    }

    /**
     * Sets the value of the textDenominazioneConsultabile property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextDenominazioneConsultabile(JAXBElement<String> value) {
        this.textDenominazioneConsultabile = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fkVocTipologiaConservatore property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcCondAccesso.FkVocTipologiaConservatore }{@code >}
     *     
     */
    public JAXBElement<DComparcCondAccesso.FkVocTipologiaConservatore> getFkVocTipologiaConservatore() {
        return fkVocTipologiaConservatore;
    }

    /**
     * Sets the value of the fkVocTipologiaConservatore property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcCondAccesso.FkVocTipologiaConservatore }{@code >}
     *     
     */
    public void setFkVocTipologiaConservatore(JAXBElement<DComparcCondAccesso.FkVocTipologiaConservatore> value) {
        this.fkVocTipologiaConservatore = ((JAXBElement<DComparcCondAccesso.FkVocTipologiaConservatore> ) value);
    }

    /**
     * Gets the value of the textModalitaConsultazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextModalitaConsultazione() {
        return textModalitaConsultazione;
    }

    /**
     * Sets the value of the textModalitaConsultazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextModalitaConsultazione(JAXBElement<String> value) {
        this.textModalitaConsultazione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textLimitiConsultazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextLimitiConsultazione() {
        return textLimitiConsultazione;
    }

    /**
     * Sets the value of the textLimitiConsultazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextLimitiConsultazione(JAXBElement<String> value) {
        this.textLimitiConsultazione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textMotivoLimitazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextMotivoLimitazione() {
        return textMotivoLimitazione;
    }

    /**
     * Sets the value of the textMotivoLimitazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextMotivoLimitazione(JAXBElement<String> value) {
        this.textMotivoLimitazione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textModoRiproduzione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextModoRiproduzione() {
        return textModoRiproduzione;
    }

    /**
     * Sets the value of the textModoRiproduzione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextModoRiproduzione(JAXBElement<String> value) {
        this.textModoRiproduzione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textTipologiaRiproduzione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextTipologiaRiproduzione() {
        return textTipologiaRiproduzione;
    }

    /**
     * Sets the value of the textTipologiaRiproduzione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextTipologiaRiproduzione(JAXBElement<String> value) {
        this.textTipologiaRiproduzione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textLimitiRiproduzione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextLimitiRiproduzione() {
        return textLimitiRiproduzione;
    }

    /**
     * Sets the value of the textLimitiRiproduzione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextLimitiRiproduzione(JAXBElement<String> value) {
        this.textLimitiRiproduzione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textAutorizzazionePubblicazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextAutorizzazionePubblicazione() {
        return textAutorizzazionePubblicazione;
    }

    /**
     * Sets the value of the textAutorizzazionePubblicazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextAutorizzazionePubblicazione(JAXBElement<String> value) {
        this.textAutorizzazionePubblicazione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textTitolareDiritti property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextTitolareDiritti() {
        return textTitolareDiritti;
    }

    /**
     * Sets the value of the textTitolareDiritti property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextTitolareDiritti(JAXBElement<String> value) {
        this.textTitolareDiritti = ((JAXBElement<String> ) value);
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipologia_conservatore"/>
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
        "dVocTipologiaConservatore"
    })
    public static class FkVocTipologiaConservatore {

        @XmlElement(name = "d_voc_tipologia_conservatore", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocTipologiaConservatore dVocTipologiaConservatore;

        /**
         * Gets the value of the dVocTipologiaConservatore property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipologiaConservatore }
         *     
         */
        public DVocTipologiaConservatore getDVocTipologiaConservatore() {
            return dVocTipologiaConservatore;
        }

        /**
         * Sets the value of the dVocTipologiaConservatore property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipologiaConservatore }
         *     
         */
        public void setDVocTipologiaConservatore(DVocTipologiaConservatore value) {
            this.dVocTipologiaConservatore = value;
        }

    }

}
