//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.18 at 11:10:43 AM CET 
//


package it.beniculturali.sas.catalogo.sogp;

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
 *         &lt;element name="text_codi_ist_resp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_den_codice" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_nome_istituzione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="500"/>
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
    "textCodiIstResp",
    "textDenCodice",
    "textNomeIstituzione"
})
@XmlRootElement(name = "d_codi_isti_resp")
public class DCodiIstiResp {

    @XmlElement(name = "text_codi_ist_resp", required = true, nillable = true)
    protected String textCodiIstResp;
    @XmlElementRef(name = "text_den_codice", namespace = "http://sas.beniculturali.it/catalogo/sogp", type = JAXBElement.class, required = false)
    protected JAXBElement<String> textDenCodice;
    @XmlElementRef(name = "text_nome_istituzione", namespace = "http://sas.beniculturali.it/catalogo/sogp", type = JAXBElement.class, required = false)
    protected JAXBElement<String> textNomeIstituzione;

    /**
     * Gets the value of the textCodiIstResp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextCodiIstResp() {
        return textCodiIstResp;
    }

    /**
     * Sets the value of the textCodiIstResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextCodiIstResp(String value) {
        this.textCodiIstResp = value;
    }

    /**
     * Gets the value of the textDenCodice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextDenCodice() {
        return textDenCodice;
    }

    /**
     * Sets the value of the textDenCodice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextDenCodice(JAXBElement<String> value) {
        this.textDenCodice = value;
    }

    /**
     * Gets the value of the textNomeIstituzione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNomeIstituzione() {
        return textNomeIstituzione;
    }

    /**
     * Sets the value of the textNomeIstituzione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNomeIstituzione(JAXBElement<String> value) {
        this.textNomeIstituzione = value;
    }

}
