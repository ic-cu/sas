//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.11 at 06:42:47 PM CET 
//


package it.beniculturali.sas.catalogo.comparc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipoComparc;


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
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipo_comparc"/>
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
    "dVocTipoComparc"
})
@XmlRootElement(name = "fk_voc_tipo_comparc")
public class FkVocTipoComparc {

    @XmlElement(name = "d_voc_tipo_comparc", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
    protected DVocTipoComparc dVocTipoComparc;

    /**
     * Gets the value of the dVocTipoComparc property.
     * 
     * @return
     *     possible object is
     *     {@link DVocTipoComparc }
     *     
     */
    public DVocTipoComparc getDVocTipoComparc() {
        return dVocTipoComparc;
    }

    /**
     * Sets the value of the dVocTipoComparc property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVocTipoComparc }
     *     
     */
    public void setDVocTipoComparc(DVocTipoComparc value) {
        this.dVocTipoComparc = value;
    }

}
