//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.11 at 06:42:47 PM CET 
//


package it.beniculturali.sas.catalogo.strumenti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="text_luogo_edizione">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="512"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="anno_edizione">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
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
    "textLuogoEdizione",
    "annoEdizione"
})
@XmlRootElement(name = "d_edizione_strric")
public class DEdizioneStrric {

    @XmlElement(name = "text_luogo_edizione", required = true, nillable = true)
    protected String textLuogoEdizione;
    @XmlElement(name = "anno_edizione", required = true, nillable = true)
    protected String annoEdizione;

    /**
     * Gets the value of the textLuogoEdizione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextLuogoEdizione() {
        return textLuogoEdizione;
    }

    /**
     * Sets the value of the textLuogoEdizione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextLuogoEdizione(String value) {
        this.textLuogoEdizione = value;
    }

    /**
     * Gets the value of the annoEdizione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoEdizione() {
        return annoEdizione;
    }

    /**
     * Sets the value of the annoEdizione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoEdizione(String value) {
        this.annoEdizione = value;
    }

}
