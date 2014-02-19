//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.18 at 04:50:28 PM CET 
//


package it.beniculturali.sas.catalogo.gestionale;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *               &lt;maxLength value="1024"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_cognome">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="250"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_nome" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="250"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_telefono" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *               &lt;pattern value="[0-9]+(/[0-9]+)?"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_fax" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *               &lt;pattern value="[0-9]+(/[0-9]+)?"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_mail" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="512"/>
 *               &lt;pattern value="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_descr_intervento" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
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
    "textDenominazione",
    "textCognome",
    "textNome",
    "textTelefono",
    "textFax",
    "textMail",
    "textDescrIntervento",
    "textNote"
})
@XmlRootElement(name = "d_contraente")
public class DContraente {

    @XmlElement(name = "text_denominazione", required = true)
    protected String textDenominazione;
    @XmlElement(name = "text_cognome", required = true)
    protected String textCognome;
    @XmlElementRef(name = "text_nome", namespace = "http://sas.beniculturali.it/catalogo/gestionale", type = JAXBElement.class)
    protected JAXBElement<String> textNome;
    @XmlElementRef(name = "text_telefono", namespace = "http://sas.beniculturali.it/catalogo/gestionale", type = JAXBElement.class)
    protected JAXBElement<String> textTelefono;
    @XmlElementRef(name = "text_fax", namespace = "http://sas.beniculturali.it/catalogo/gestionale", type = JAXBElement.class)
    protected JAXBElement<String> textFax;
    @XmlElementRef(name = "text_mail", namespace = "http://sas.beniculturali.it/catalogo/gestionale", type = JAXBElement.class)
    protected JAXBElement<String> textMail;
    @XmlElementRef(name = "text_descr_intervento", namespace = "http://sas.beniculturali.it/catalogo/gestionale", type = JAXBElement.class)
    protected JAXBElement<String> textDescrIntervento;
    @XmlElementRef(name = "text_note", namespace = "http://sas.beniculturali.it/catalogo/gestionale", type = JAXBElement.class)
    protected JAXBElement<String> textNote;

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
     * Gets the value of the textCognome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextCognome() {
        return textCognome;
    }

    /**
     * Sets the value of the textCognome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextCognome(String value) {
        this.textCognome = value;
    }

    /**
     * Gets the value of the textNome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNome() {
        return textNome;
    }

    /**
     * Sets the value of the textNome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNome(JAXBElement<String> value) {
        this.textNome = ((JAXBElement<String> ) value);
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
     * Gets the value of the textMail property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextMail() {
        return textMail;
    }

    /**
     * Sets the value of the textMail property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextMail(JAXBElement<String> value) {
        this.textMail = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textDescrIntervento property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextDescrIntervento() {
        return textDescrIntervento;
    }

    /**
     * Sets the value of the textDescrIntervento property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextDescrIntervento(JAXBElement<String> value) {
        this.textDescrIntervento = ((JAXBElement<String> ) value);
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

}
