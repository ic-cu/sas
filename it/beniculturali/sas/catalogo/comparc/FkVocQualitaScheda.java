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
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocQualitaScheda;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_qualita_scheda"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dVocQualitaScheda"
})
public class FkVocQualitaScheda {

    @XmlElement(name = "d_voc_qualita_scheda", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
    protected DVocQualitaScheda dVocQualitaScheda;

    /**
     * Gets the value of the dVocQualitaScheda property.
     * 
     * @return
     *     possible object is
     *     {@link DVocQualitaScheda }
     *     
     */
    public DVocQualitaScheda getDVocQualitaScheda() {
        return dVocQualitaScheda;
    }

    /**
     * Sets the value of the dVocQualitaScheda property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVocQualitaScheda }
     *     
     */
    public void setDVocQualitaScheda(DVocQualitaScheda value) {
        this.dVocQualitaScheda = value;
    }

}
