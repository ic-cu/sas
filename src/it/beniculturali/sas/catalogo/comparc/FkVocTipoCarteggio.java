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
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipoCarteggio;


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
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipo_carteggio"/>
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
    "dVocTipoCarteggio"
})
public class FkVocTipoCarteggio {

    @XmlElement(name = "d_voc_tipo_carteggio", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
    protected DVocTipoCarteggio dVocTipoCarteggio;

    /**
     * Gets the value of the dVocTipoCarteggio property.
     * 
     * @return
     *     possible object is
     *     {@link DVocTipoCarteggio }
     *     
     */
    public DVocTipoCarteggio getDVocTipoCarteggio() {
        return dVocTipoCarteggio;
    }

    /**
     * Sets the value of the dVocTipoCarteggio property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVocTipoCarteggio }
     *     
     */
    public void setDVocTipoCarteggio(DVocTipoCarteggio value) {
        this.dVocTipoCarteggio = value;
    }

}
