//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.11 at 06:42:47 PM CET 
//


package it.beniculturali.sas.catalogo.comparc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="text_matrice" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_altre_impronte_sigillo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_altre_impronte_titolare" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_edizione_esemplare" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_bibliografia" minOccurs="0">
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
    "textMatrice",
    "textAltreImpronteSigillo",
    "textAltreImpronteTitolare",
    "textEdizioneEsemplare",
    "textBibliografia"
})
@XmlRootElement(name = "d_comparc_sigillo_fonti")
public class DComparcSigilloFonti {

    @XmlElementRef(name = "text_matrice", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textMatrice;
    @XmlElementRef(name = "text_altre_impronte_sigillo", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textAltreImpronteSigillo;
    @XmlElementRef(name = "text_altre_impronte_titolare", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textAltreImpronteTitolare;
    @XmlElementRef(name = "text_edizione_esemplare", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textEdizioneEsemplare;
    @XmlElementRef(name = "text_bibliografia", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textBibliografia;

    /**
     * Gets the value of the textMatrice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextMatrice() {
        return textMatrice;
    }

    /**
     * Sets the value of the textMatrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextMatrice(JAXBElement<String> value) {
        this.textMatrice = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textAltreImpronteSigillo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextAltreImpronteSigillo() {
        return textAltreImpronteSigillo;
    }

    /**
     * Sets the value of the textAltreImpronteSigillo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextAltreImpronteSigillo(JAXBElement<String> value) {
        this.textAltreImpronteSigillo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textAltreImpronteTitolare property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextAltreImpronteTitolare() {
        return textAltreImpronteTitolare;
    }

    /**
     * Sets the value of the textAltreImpronteTitolare property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextAltreImpronteTitolare(JAXBElement<String> value) {
        this.textAltreImpronteTitolare = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textEdizioneEsemplare property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextEdizioneEsemplare() {
        return textEdizioneEsemplare;
    }

    /**
     * Sets the value of the textEdizioneEsemplare property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextEdizioneEsemplare(JAXBElement<String> value) {
        this.textEdizioneEsemplare = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textBibliografia property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextBibliografia() {
        return textBibliografia;
    }

    /**
     * Sets the value of the textBibliografia property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextBibliografia(JAXBElement<String> value) {
        this.textBibliografia = ((JAXBElement<String> ) value);
    }

}
