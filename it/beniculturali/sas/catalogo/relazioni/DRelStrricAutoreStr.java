//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.25 at 03:07:39 PM CET 
//


package it.beniculturali.sas.catalogo.relazioni;

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
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/relazioni}codi_provenienza_strumenti"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/relazioni}codi_provenienza_autore_stric"/>
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
    "codiProvenienzaStrumenti",
    "codiProvenienzaAutoreStric"
})
@XmlRootElement(name = "d_rel_strric_autore_str")
public class DRelStrricAutoreStr {

    @XmlElement(name = "codi_provenienza_strumenti", required = true)
    protected String codiProvenienzaStrumenti;
    @XmlElement(name = "codi_provenienza_autore_stric", required = true)
    protected String codiProvenienzaAutoreStric;

    /**
     * Gets the value of the codiProvenienzaStrumenti property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienzaStrumenti() {
        return codiProvenienzaStrumenti;
    }

    /**
     * Sets the value of the codiProvenienzaStrumenti property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienzaStrumenti(String value) {
        this.codiProvenienzaStrumenti = value;
    }

    /**
     * Gets the value of the codiProvenienzaAutoreStric property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienzaAutoreStric() {
        return codiProvenienzaAutoreStric;
    }

    /**
     * Sets the value of the codiProvenienzaAutoreStric property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienzaAutoreStric(String value) {
        this.codiProvenienzaAutoreStric = value;
    }

}
