//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.27 at 02:03:47 PM CET 
//


package it.beniculturali.sas.catalogo.comparc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.vocabolario_voci_indice.DVocTipoVociIndice;


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
 *         &lt;element name="fk_voc_tipo_voci_indice">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-voci_indice}d_voc_tipo_voci_indice"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "fkVocTipoVociIndice"
})
@XmlRootElement(name = "d_comparc_voci_indice")
public class DComparcVociIndice {

    @XmlElement(name = "fk_voc_tipo_voci_indice", required = true, nillable = true)
    protected DComparcVociIndice.FkVocTipoVociIndice fkVocTipoVociIndice;

    /**
     * Gets the value of the fkVocTipoVociIndice property.
     * 
     * @return
     *     possible object is
     *     {@link DComparcVociIndice.FkVocTipoVociIndice }
     *     
     */
    public DComparcVociIndice.FkVocTipoVociIndice getFkVocTipoVociIndice() {
        return fkVocTipoVociIndice;
    }

    /**
     * Sets the value of the fkVocTipoVociIndice property.
     * 
     * @param value
     *     allowed object is
     *     {@link DComparcVociIndice.FkVocTipoVociIndice }
     *     
     */
    public void setFkVocTipoVociIndice(DComparcVociIndice.FkVocTipoVociIndice value) {
        this.fkVocTipoVociIndice = value;
    }


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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-voci_indice}d_voc_tipo_voci_indice"/>
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
        "dVocTipoVociIndice"
    })
    public static class FkVocTipoVociIndice {

        @XmlElement(name = "d_voc_tipo_voci_indice", namespace = "http://sas.beniculturali.it/catalogo/vocabolario-voci_indice")
        protected DVocTipoVociIndice dVocTipoVociIndice;

        /**
         * Gets the value of the dVocTipoVociIndice property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipoVociIndice }
         *     
         */
        public DVocTipoVociIndice getDVocTipoVociIndice() {
            return dVocTipoVociIndice;
        }

        /**
         * Sets the value of the dVocTipoVociIndice property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipoVociIndice }
         *     
         */
        public void setDVocTipoVociIndice(DVocTipoVociIndice value) {
            this.dVocTipoVociIndice = value;
        }

    }

}
