//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.18 at 04:50:28 PM CET 
//


package it.beniculturali.sas.catalogo.comparc;

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
 *         &lt;element name="text_scala_numerica">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_scala_grafica">
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
    "textScalaNumerica",
    "textScalaGrafica"
})
@XmlRootElement(name = "d_comparc_scale_cart")
public class DComparcScaleCart {

    @XmlElement(name = "text_scala_numerica", required = true, nillable = true)
    protected String textScalaNumerica;
    @XmlElement(name = "text_scala_grafica", required = true, nillable = true)
    protected String textScalaGrafica;

    /**
     * Gets the value of the textScalaNumerica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextScalaNumerica() {
        return textScalaNumerica;
    }

    /**
     * Sets the value of the textScalaNumerica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextScalaNumerica(String value) {
        this.textScalaNumerica = value;
    }

    /**
     * Gets the value of the textScalaGrafica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextScalaGrafica() {
        return textScalaGrafica;
    }

    /**
     * Sets the value of the textScalaGrafica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextScalaGrafica(String value) {
        this.textScalaGrafica = value;
    }

}
