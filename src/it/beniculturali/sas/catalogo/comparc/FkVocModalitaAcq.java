//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.18 at 11:10:43 AM CET 
//


package it.beniculturali.sas.catalogo.comparc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocModalitaAcq;


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
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_modalita_acq"/>
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
    "dVocModalitaAcq"
})
public class FkVocModalitaAcq {

    @XmlElement(name = "d_voc_modalita_acq", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
    protected DVocModalitaAcq dVocModalitaAcq;

    /**
     * Gets the value of the dVocModalitaAcq property.
     * 
     * @return
     *     possible object is
     *     {@link DVocModalitaAcq }
     *     
     */
    public DVocModalitaAcq getDVocModalitaAcq() {
        return dVocModalitaAcq;
    }

    /**
     * Sets the value of the dVocModalitaAcq property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVocModalitaAcq }
     *     
     */
    public void setDVocModalitaAcq(DVocModalitaAcq value) {
        this.dVocModalitaAcq = value;
    }

}
