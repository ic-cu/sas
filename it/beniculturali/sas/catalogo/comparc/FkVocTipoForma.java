//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.25 at 03:07:39 PM CET 
//


package it.beniculturali.sas.catalogo.comparc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipoForma;


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
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipo_forma"/>
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
    "dVocTipoForma"
})
public class FkVocTipoForma {

    @XmlElement(name = "d_voc_tipo_forma", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
    protected DVocTipoForma dVocTipoForma;

    /**
     * Gets the value of the dVocTipoForma property.
     * 
     * @return
     *     possible object is
     *     {@link DVocTipoForma }
     *     
     */
    public DVocTipoForma getDVocTipoForma() {
        return dVocTipoForma;
    }

    /**
     * Sets the value of the dVocTipoForma property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVocTipoForma }
     *     
     */
    public void setDVocTipoForma(DVocTipoForma value) {
        this.dVocTipoForma = value;
    }

}
