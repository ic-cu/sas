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
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/relazioni}codi_provenienza_risorse_bibl"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/relazioni}codi_provenienza_editore_bibl"/>
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
    "codiProvenienzaEditoreBibl"
})
@XmlRootElement(name = "d_rel_bibliografia_editore")
public class DRelBibliografiaEditore {

    @XmlElement(name = "codi_provenienza_risorse_bibl", required = true)
    protected String codiProvenienzaRisorseBibl;
    @XmlElement(name = "codi_provenienza_editore_bibl", required = true)
    protected String codiProvenienzaEditoreBibl;

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
     * Gets the value of the codiProvenienzaEditoreBibl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienzaEditoreBibl() {
        return codiProvenienzaEditoreBibl;
    }

    /**
     * Sets the value of the codiProvenienzaEditoreBibl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienzaEditoreBibl(String value) {
        this.codiProvenienzaEditoreBibl = value;
    }

}
