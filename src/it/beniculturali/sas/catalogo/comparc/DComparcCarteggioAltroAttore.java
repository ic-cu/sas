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
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocQualificaAttoreCarteggio;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocRuoloAttoreCarteggio;


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
 *         &lt;element name="text_nome_altro_attore_carteggio">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1024"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_qualifica_attore_carteggio" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_qualifica_attore_carteggio"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_ruolo_attore_carteggio" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_ruolo_attore_carteggio"/>
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
    "textNomeAltroAttoreCarteggio",
    "fkVocQualificaAttoreCarteggio",
    "fkVocRuoloAttoreCarteggio",
    "textNote"
})
@XmlRootElement(name = "d_comparc_carteggio_altro_attore")
public class DComparcCarteggioAltroAttore {

    @XmlElement(name = "text_nome_altro_attore_carteggio", required = true, nillable = true)
    protected String textNomeAltroAttoreCarteggio;
    @XmlElementRef(name = "fk_voc_qualifica_attore_carteggio", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcCarteggioAltroAttore.FkVocQualificaAttoreCarteggio> fkVocQualificaAttoreCarteggio;
    @XmlElementRef(name = "fk_voc_ruolo_attore_carteggio", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcCarteggioAltroAttore.FkVocRuoloAttoreCarteggio> fkVocRuoloAttoreCarteggio;
    @XmlElementRef(name = "text_note", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textNote;

    /**
     * Gets the value of the textNomeAltroAttoreCarteggio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextNomeAltroAttoreCarteggio() {
        return textNomeAltroAttoreCarteggio;
    }

    /**
     * Sets the value of the textNomeAltroAttoreCarteggio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextNomeAltroAttoreCarteggio(String value) {
        this.textNomeAltroAttoreCarteggio = value;
    }

    /**
     * Gets the value of the fkVocQualificaAttoreCarteggio property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcCarteggioAltroAttore.FkVocQualificaAttoreCarteggio }{@code >}
     *     
     */
    public JAXBElement<DComparcCarteggioAltroAttore.FkVocQualificaAttoreCarteggio> getFkVocQualificaAttoreCarteggio() {
        return fkVocQualificaAttoreCarteggio;
    }

    /**
     * Sets the value of the fkVocQualificaAttoreCarteggio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcCarteggioAltroAttore.FkVocQualificaAttoreCarteggio }{@code >}
     *     
     */
    public void setFkVocQualificaAttoreCarteggio(JAXBElement<DComparcCarteggioAltroAttore.FkVocQualificaAttoreCarteggio> value) {
        this.fkVocQualificaAttoreCarteggio = ((JAXBElement<DComparcCarteggioAltroAttore.FkVocQualificaAttoreCarteggio> ) value);
    }

    /**
     * Gets the value of the fkVocRuoloAttoreCarteggio property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcCarteggioAltroAttore.FkVocRuoloAttoreCarteggio }{@code >}
     *     
     */
    public JAXBElement<DComparcCarteggioAltroAttore.FkVocRuoloAttoreCarteggio> getFkVocRuoloAttoreCarteggio() {
        return fkVocRuoloAttoreCarteggio;
    }

    /**
     * Sets the value of the fkVocRuoloAttoreCarteggio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcCarteggioAltroAttore.FkVocRuoloAttoreCarteggio }{@code >}
     *     
     */
    public void setFkVocRuoloAttoreCarteggio(JAXBElement<DComparcCarteggioAltroAttore.FkVocRuoloAttoreCarteggio> value) {
        this.fkVocRuoloAttoreCarteggio = ((JAXBElement<DComparcCarteggioAltroAttore.FkVocRuoloAttoreCarteggio> ) value);
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_qualifica_attore_carteggio"/>
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
        "dVocQualificaAttoreCarteggio"
    })
    public static class FkVocQualificaAttoreCarteggio {

        @XmlElement(name = "d_voc_qualifica_attore_carteggio", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocQualificaAttoreCarteggio dVocQualificaAttoreCarteggio;

        /**
         * Gets the value of the dVocQualificaAttoreCarteggio property.
         * 
         * @return
         *     possible object is
         *     {@link DVocQualificaAttoreCarteggio }
         *     
         */
        public DVocQualificaAttoreCarteggio getDVocQualificaAttoreCarteggio() {
            return dVocQualificaAttoreCarteggio;
        }

        /**
         * Sets the value of the dVocQualificaAttoreCarteggio property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocQualificaAttoreCarteggio }
         *     
         */
        public void setDVocQualificaAttoreCarteggio(DVocQualificaAttoreCarteggio value) {
            this.dVocQualificaAttoreCarteggio = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_ruolo_attore_carteggio"/>
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
        "dVocRuoloAttoreCarteggio"
    })
    public static class FkVocRuoloAttoreCarteggio {

        @XmlElement(name = "d_voc_ruolo_attore_carteggio", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocRuoloAttoreCarteggio dVocRuoloAttoreCarteggio;

        /**
         * Gets the value of the dVocRuoloAttoreCarteggio property.
         * 
         * @return
         *     possible object is
         *     {@link DVocRuoloAttoreCarteggio }
         *     
         */
        public DVocRuoloAttoreCarteggio getDVocRuoloAttoreCarteggio() {
            return dVocRuoloAttoreCarteggio;
        }

        /**
         * Sets the value of the dVocRuoloAttoreCarteggio property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocRuoloAttoreCarteggio }
         *     
         */
        public void setDVocRuoloAttoreCarteggio(DVocRuoloAttoreCarteggio value) {
            this.dVocRuoloAttoreCarteggio = value;
        }

    }

}
