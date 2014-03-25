//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.25 at 03:07:39 PM CET 
//


package it.beniculturali.sas.catalogo.comparc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocQualificaCommittente;


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
 *         &lt;element name="flg_autore_editore_committente_aec">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="E"/>
 *               &lt;enumeration value="C"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_denominazione">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1024"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_qualifica_committente" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_qualifica_committente"/>
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
    "flgAutoreEditoreCommittenteAec",
    "textDenominazione",
    "fkVocQualificaCommittente",
    "textNote"
})
@XmlRootElement(name = "d_comparc_autori_editori_comm")
public class DComparcAutoriEditoriComm {

    @XmlElement(name = "flg_autore_editore_committente_aec", required = true, nillable = true)
    protected String flgAutoreEditoreCommittenteAec;
    @XmlElement(name = "text_denominazione", required = true, nillable = true)
    protected String textDenominazione;
    @XmlElementRef(name = "fk_voc_qualifica_committente", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcAutoriEditoriComm.FkVocQualificaCommittente> fkVocQualificaCommittente;
    @XmlElementRef(name = "text_note", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textNote;

    /**
     * Gets the value of the flgAutoreEditoreCommittenteAec property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgAutoreEditoreCommittenteAec() {
        return flgAutoreEditoreCommittenteAec;
    }

    /**
     * Sets the value of the flgAutoreEditoreCommittenteAec property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgAutoreEditoreCommittenteAec(String value) {
        this.flgAutoreEditoreCommittenteAec = value;
    }

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
     * Gets the value of the fkVocQualificaCommittente property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcAutoriEditoriComm.FkVocQualificaCommittente }{@code >}
     *     
     */
    public JAXBElement<DComparcAutoriEditoriComm.FkVocQualificaCommittente> getFkVocQualificaCommittente() {
        return fkVocQualificaCommittente;
    }

    /**
     * Sets the value of the fkVocQualificaCommittente property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcAutoriEditoriComm.FkVocQualificaCommittente }{@code >}
     *     
     */
    public void setFkVocQualificaCommittente(JAXBElement<DComparcAutoriEditoriComm.FkVocQualificaCommittente> value) {
        this.fkVocQualificaCommittente = ((JAXBElement<DComparcAutoriEditoriComm.FkVocQualificaCommittente> ) value);
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_qualifica_committente"/>
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
        "dVocQualificaCommittente"
    })
    public static class FkVocQualificaCommittente {

        @XmlElement(name = "d_voc_qualifica_committente", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocQualificaCommittente dVocQualificaCommittente;

        /**
         * Gets the value of the dVocQualificaCommittente property.
         * 
         * @return
         *     possible object is
         *     {@link DVocQualificaCommittente }
         *     
         */
        public DVocQualificaCommittente getDVocQualificaCommittente() {
            return dVocQualificaCommittente;
        }

        /**
         * Sets the value of the dVocQualificaCommittente property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocQualificaCommittente }
         *     
         */
        public void setDVocQualificaCommittente(DVocQualificaCommittente value) {
            this.dVocQualificaCommittente = value;
        }

    }

}
