//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.11 at 06:42:47 PM CET 
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
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/relazioni}codi_provenienza_sala_studio"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/relazioni}codi_provenienza_depositi"/>
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
    "codiProvenienzaSalaStudio",
    "codiProvenienzaDepositi"
})
@XmlRootElement(name = "d_rel_sala_studio_deposito")
public class DRelSalaStudioDeposito {

    @XmlElement(name = "codi_provenienza_sala_studio", required = true)
    protected String codiProvenienzaSalaStudio;
    @XmlElement(name = "codi_provenienza_depositi", required = true)
    protected String codiProvenienzaDepositi;

    /**
     * Gets the value of the codiProvenienzaSalaStudio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienzaSalaStudio() {
        return codiProvenienzaSalaStudio;
    }

    /**
     * Sets the value of the codiProvenienzaSalaStudio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienzaSalaStudio(String value) {
        this.codiProvenienzaSalaStudio = value;
    }

    /**
     * Gets the value of the codiProvenienzaDepositi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienzaDepositi() {
        return codiProvenienzaDepositi;
    }

    /**
     * Sets the value of the codiProvenienzaDepositi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienzaDepositi(String value) {
        this.codiProvenienzaDepositi = value;
    }

}
