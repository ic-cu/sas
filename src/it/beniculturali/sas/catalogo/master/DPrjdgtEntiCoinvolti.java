//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.27 at 02:03:47 PM CET 
//


package it.beniculturali.sas.catalogo.master;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.fonti.ProfGroup;


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
 *         &lt;element name="codi_provenienza">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="256"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_fonte">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/fonti}prof_group"/>
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
    "codiProvenienza",
    "fkFonte"
})
@XmlRootElement(name = "d_prjdgt_enti_coinvolti")
public class DPrjdgtEntiCoinvolti {

    @XmlElement(name = "codi_provenienza", required = true)
    protected String codiProvenienza;
    @XmlElement(name = "fk_fonte", required = true)
    protected DPrjdgtEntiCoinvolti.FkFonte fkFonte;

    /**
     * Gets the value of the codiProvenienza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienza() {
        return codiProvenienza;
    }

    /**
     * Sets the value of the codiProvenienza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienza(String value) {
        this.codiProvenienza = value;
    }

    /**
     * Gets the value of the fkFonte property.
     * 
     * @return
     *     possible object is
     *     {@link DPrjdgtEntiCoinvolti.FkFonte }
     *     
     */
    public DPrjdgtEntiCoinvolti.FkFonte getFkFonte() {
        return fkFonte;
    }

    /**
     * Sets the value of the fkFonte property.
     * 
     * @param value
     *     allowed object is
     *     {@link DPrjdgtEntiCoinvolti.FkFonte }
     *     
     */
    public void setFkFonte(DPrjdgtEntiCoinvolti.FkFonte value) {
        this.fkFonte = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/fonti}prof_group"/>
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
        "profGroup"
    })
    public static class FkFonte {

        @XmlElement(name = "prof_group", namespace = "http://sas.beniculturali.it/catalogo/fonti")
        protected ProfGroup profGroup;

        /**
         * Gets the value of the profGroup property.
         * 
         * @return
         *     possible object is
         *     {@link ProfGroup }
         *     
         */
        public ProfGroup getProfGroup() {
            return profGroup;
        }

        /**
         * Sets the value of the profGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link ProfGroup }
         *     
         */
        public void setProfGroup(ProfGroup value) {
            this.profGroup = value;
        }

    }

}
