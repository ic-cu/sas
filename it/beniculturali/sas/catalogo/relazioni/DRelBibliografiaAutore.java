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
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/relazioni}codi_provenienza_risorse_bibl"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/relazioni}codi_provenienza_autore_bibl"/>
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
    "codiProvenienzaRisorseBibl",
    "codiProvenienzaAutoreBibl"
})
@XmlRootElement(name = "d_rel_bibliografia_autore")
public class DRelBibliografiaAutore {

    @XmlElement(name = "codi_provenienza_risorse_bibl", required = true)
    protected String codiProvenienzaRisorseBibl;
    @XmlElement(name = "codi_provenienza_autore_bibl", required = true)
    protected String codiProvenienzaAutoreBibl;

    /**
     * Gets the value of the codiProvenienzaRisorseBibl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienzaRisorseBibl() {
        return codiProvenienzaRisorseBibl;
    }

    /**
     * Sets the value of the codiProvenienzaRisorseBibl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienzaRisorseBibl(String value) {
        this.codiProvenienzaRisorseBibl = value;
    }

    /**
     * Gets the value of the codiProvenienzaAutoreBibl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienzaAutoreBibl() {
        return codiProvenienzaAutoreBibl;
    }

    /**
     * Sets the value of the codiProvenienzaAutoreBibl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienzaAutoreBibl(String value) {
        this.codiProvenienzaAutoreBibl = value;
    }

}
