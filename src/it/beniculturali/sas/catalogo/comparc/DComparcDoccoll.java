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
 *         &lt;element name="flg_info_originali_copie_oc">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *               &lt;enumeration value="O"/>
 *               &lt;enumeration value="C"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_descr_doccoll">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_loc_doccoll" minOccurs="0">
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
    "flgInfoOriginaliCopieOc",
    "textDescrDoccoll",
    "textLocDoccoll"
})
@XmlRootElement(name = "d_comparc_doccoll")
public class DComparcDoccoll {

    @XmlElement(name = "flg_info_originali_copie_oc", required = true, nillable = true)
    protected String flgInfoOriginaliCopieOc;
    @XmlElement(name = "text_descr_doccoll", required = true, nillable = true)
    protected String textDescrDoccoll;
    @XmlElementRef(name = "text_loc_doccoll", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textLocDoccoll;

    /**
     * Gets the value of the flgInfoOriginaliCopieOc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgInfoOriginaliCopieOc() {
        return flgInfoOriginaliCopieOc;
    }

    /**
     * Sets the value of the flgInfoOriginaliCopieOc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgInfoOriginaliCopieOc(String value) {
        this.flgInfoOriginaliCopieOc = value;
    }

    /**
     * Gets the value of the textDescrDoccoll property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextDescrDoccoll() {
        return textDescrDoccoll;
    }

    /**
     * Sets the value of the textDescrDoccoll property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextDescrDoccoll(String value) {
        this.textDescrDoccoll = value;
    }

    /**
     * Gets the value of the textLocDoccoll property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextLocDoccoll() {
        return textLocDoccoll;
    }

    /**
     * Sets the value of the textLocDoccoll property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextLocDoccoll(JAXBElement<String> value) {
        this.textLocDoccoll = ((JAXBElement<String> ) value);
    }

}