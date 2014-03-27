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
import it.beniculturali.sas.catalogo.vocabolario_qualifica_antroponimo.DVocQualificaAntroponimo;
import it.beniculturali.sas.catalogo.vocabolario_ruolo_antroponimo.DVocRuoloAntroponimo;
import it.beniculturali.sas.catalogo.vocabolario_titolo_antroponimo.DVocTitoloAntroponimo;


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
 *         &lt;element name="text_denominazione">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_titolo_antroponimo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-titolo_antroponimo}d_voc_titolo_antroponimo"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_predicato_titolo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="512"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_qualifica_antroponimo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-qualifica_antroponimo}d_voc_qualifica_antroponimo"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_ruolo_antroponimo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-ruolo_antroponimo}d_voc_ruolo_antroponimo"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
    "textDenominazione",
    "fkVocTitoloAntroponimo",
    "textPredicatoTitolo",
    "fkVocQualificaAntroponimo",
    "fkVocRuoloAntroponimo"
})
@XmlRootElement(name = "d_comparc_antroponimi")
public class DComparcAntroponimi {

    @XmlElement(name = "text_denominazione", required = true, nillable = true)
    protected String textDenominazione;
    @XmlElementRef(name = "fk_voc_titolo_antroponimo", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcAntroponimi.FkVocTitoloAntroponimo> fkVocTitoloAntroponimo;
    @XmlElementRef(name = "text_predicato_titolo", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textPredicatoTitolo;
    @XmlElementRef(name = "fk_voc_qualifica_antroponimo", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcAntroponimi.FkVocQualificaAntroponimo> fkVocQualificaAntroponimo;
    @XmlElementRef(name = "fk_voc_ruolo_antroponimo", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcAntroponimi.FkVocRuoloAntroponimo> fkVocRuoloAntroponimo;

    /**
     * Gets the value of the textDenominazione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextDenominazione() {
        return textDenominazione;
    }

    /**
     * Sets the value of the textDenominazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextDenominazione(String value) {
        this.textDenominazione = value;
    }

    /**
     * Gets the value of the fkVocTitoloAntroponimo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcAntroponimi.FkVocTitoloAntroponimo }{@code >}
     *     
     */
    public JAXBElement<DComparcAntroponimi.FkVocTitoloAntroponimo> getFkVocTitoloAntroponimo() {
        return fkVocTitoloAntroponimo;
    }

    /**
     * Sets the value of the fkVocTitoloAntroponimo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcAntroponimi.FkVocTitoloAntroponimo }{@code >}
     *     
     */
    public void setFkVocTitoloAntroponimo(JAXBElement<DComparcAntroponimi.FkVocTitoloAntroponimo> value) {
        this.fkVocTitoloAntroponimo = ((JAXBElement<DComparcAntroponimi.FkVocTitoloAntroponimo> ) value);
    }

    /**
     * Gets the value of the textPredicatoTitolo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextPredicatoTitolo() {
        return textPredicatoTitolo;
    }

    /**
     * Sets the value of the textPredicatoTitolo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextPredicatoTitolo(JAXBElement<String> value) {
        this.textPredicatoTitolo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fkVocQualificaAntroponimo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcAntroponimi.FkVocQualificaAntroponimo }{@code >}
     *     
     */
    public JAXBElement<DComparcAntroponimi.FkVocQualificaAntroponimo> getFkVocQualificaAntroponimo() {
        return fkVocQualificaAntroponimo;
    }

    /**
     * Sets the value of the fkVocQualificaAntroponimo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcAntroponimi.FkVocQualificaAntroponimo }{@code >}
     *     
     */
    public void setFkVocQualificaAntroponimo(JAXBElement<DComparcAntroponimi.FkVocQualificaAntroponimo> value) {
        this.fkVocQualificaAntroponimo = ((JAXBElement<DComparcAntroponimi.FkVocQualificaAntroponimo> ) value);
    }

    /**
     * Gets the value of the fkVocRuoloAntroponimo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcAntroponimi.FkVocRuoloAntroponimo }{@code >}
     *     
     */
    public JAXBElement<DComparcAntroponimi.FkVocRuoloAntroponimo> getFkVocRuoloAntroponimo() {
        return fkVocRuoloAntroponimo;
    }

    /**
     * Sets the value of the fkVocRuoloAntroponimo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcAntroponimi.FkVocRuoloAntroponimo }{@code >}
     *     
     */
    public void setFkVocRuoloAntroponimo(JAXBElement<DComparcAntroponimi.FkVocRuoloAntroponimo> value) {
        this.fkVocRuoloAntroponimo = ((JAXBElement<DComparcAntroponimi.FkVocRuoloAntroponimo> ) value);
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-qualifica_antroponimo}d_voc_qualifica_antroponimo"/>
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
        "dVocQualificaAntroponimo"
    })
    public static class FkVocQualificaAntroponimo {

        @XmlElement(name = "d_voc_qualifica_antroponimo", namespace = "http://sas.beniculturali.it/catalogo/vocabolario-qualifica_antroponimo")
        protected DVocQualificaAntroponimo dVocQualificaAntroponimo;

        /**
         * Gets the value of the dVocQualificaAntroponimo property.
         * 
         * @return
         *     possible object is
         *     {@link DVocQualificaAntroponimo }
         *     
         */
        public DVocQualificaAntroponimo getDVocQualificaAntroponimo() {
            return dVocQualificaAntroponimo;
        }

        /**
         * Sets the value of the dVocQualificaAntroponimo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocQualificaAntroponimo }
         *     
         */
        public void setDVocQualificaAntroponimo(DVocQualificaAntroponimo value) {
            this.dVocQualificaAntroponimo = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-ruolo_antroponimo}d_voc_ruolo_antroponimo"/>
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
        "dVocRuoloAntroponimo"
    })
    public static class FkVocRuoloAntroponimo {

        @XmlElement(name = "d_voc_ruolo_antroponimo", namespace = "http://sas.beniculturali.it/catalogo/vocabolario-ruolo_antroponimo")
        protected DVocRuoloAntroponimo dVocRuoloAntroponimo;

        /**
         * Gets the value of the dVocRuoloAntroponimo property.
         * 
         * @return
         *     possible object is
         *     {@link DVocRuoloAntroponimo }
         *     
         */
        public DVocRuoloAntroponimo getDVocRuoloAntroponimo() {
            return dVocRuoloAntroponimo;
        }

        /**
         * Sets the value of the dVocRuoloAntroponimo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocRuoloAntroponimo }
         *     
         */
        public void setDVocRuoloAntroponimo(DVocRuoloAntroponimo value) {
            this.dVocRuoloAntroponimo = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-titolo_antroponimo}d_voc_titolo_antroponimo"/>
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
        "dVocTitoloAntroponimo"
    })
    public static class FkVocTitoloAntroponimo {

        @XmlElement(name = "d_voc_titolo_antroponimo", namespace = "http://sas.beniculturali.it/catalogo/vocabolario-titolo_antroponimo")
        protected DVocTitoloAntroponimo dVocTitoloAntroponimo;

        /**
         * Gets the value of the dVocTitoloAntroponimo property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTitoloAntroponimo }
         *     
         */
        public DVocTitoloAntroponimo getDVocTitoloAntroponimo() {
            return dVocTitoloAntroponimo;
        }

        /**
         * Sets the value of the dVocTitoloAntroponimo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTitoloAntroponimo }
         *     
         */
        public void setDVocTitoloAntroponimo(DVocTitoloAntroponimo value) {
            this.dVocTitoloAntroponimo = value;
        }

    }

}
