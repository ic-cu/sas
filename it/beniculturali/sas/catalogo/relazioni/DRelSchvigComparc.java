//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.18 at 04:50:28 PM CET 
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
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/relazioni}codi_provenienza_scheda_vigilanza"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/relazioni}codi_provenienza_comparc"/>
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
    "codiProvenienzaSchedaVigilanza",
    "codiProvenienzaComparc"
})
@XmlRootElement(name = "d_rel_schvig_comparc")
public class DRelSchvigComparc {

    @XmlElement(name = "codi_provenienza_scheda_vigilanza", required = true)
    protected String codiProvenienzaSchedaVigilanza;
    @XmlElement(name = "codi_provenienza_comparc", required = true)
    protected String codiProvenienzaComparc;

    /**
     * Gets the value of the codiProvenienzaSchedaVigilanza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienzaSchedaVigilanza() {
        return codiProvenienzaSchedaVigilanza;
    }

    /**
     * Sets the value of the codiProvenienzaSchedaVigilanza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienzaSchedaVigilanza(String value) {
        this.codiProvenienzaSchedaVigilanza = value;
    }

    /**
     * Gets the value of the codiProvenienzaComparc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienzaComparc() {
        return codiProvenienzaComparc;
    }

    /**
     * Sets the value of the codiProvenienzaComparc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienzaComparc(String value) {
        this.codiProvenienzaComparc = value;
    }

}
