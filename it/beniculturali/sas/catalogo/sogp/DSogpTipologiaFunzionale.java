//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.27 at 02:03:47 PM CET 
//


package it.beniculturali.sas.catalogo.sogp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.vocabolari_sogp.DVocTipofunzSogp;


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
 *         &lt;element name="fk_voc_tipofunz_sogp">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-sogp}d_voc_tipofunz_sogp"/>
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
    "fkVocTipofunzSogp"
})
@XmlRootElement(name = "d_sogp_tipologia_funzionale")
public class DSogpTipologiaFunzionale {

    @XmlElement(name = "fk_voc_tipofunz_sogp", required = true, nillable = true)
    protected DSogpTipologiaFunzionale.FkVocTipofunzSogp fkVocTipofunzSogp;

    /**
     * Gets the value of the fkVocTipofunzSogp property.
     * 
     * @return
     *     possible object is
     *     {@link DSogpTipologiaFunzionale.FkVocTipofunzSogp }
     *     
     */
    public DSogpTipologiaFunzionale.FkVocTipofunzSogp getFkVocTipofunzSogp() {
        return fkVocTipofunzSogp;
    }

    /**
     * Sets the value of the fkVocTipofunzSogp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DSogpTipologiaFunzionale.FkVocTipofunzSogp }
     *     
     */
    public void setFkVocTipofunzSogp(DSogpTipologiaFunzionale.FkVocTipofunzSogp value) {
        this.fkVocTipofunzSogp = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-sogp}d_voc_tipofunz_sogp"/>
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
        "dVocTipofunzSogp"
    })
    public static class FkVocTipofunzSogp {

        @XmlElement(name = "d_voc_tipofunz_sogp", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-sogp")
        protected DVocTipofunzSogp dVocTipofunzSogp;

        /**
         * Gets the value of the dVocTipofunzSogp property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipofunzSogp }
         *     
         */
        public DVocTipofunzSogp getDVocTipofunzSogp() {
            return dVocTipofunzSogp;
        }

        /**
         * Sets the value of the dVocTipofunzSogp property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipofunzSogp }
         *     
         */
        public void setDVocTipofunzSogp(DVocTipofunzSogp value) {
            this.dVocTipofunzSogp = value;
        }

    }

}
