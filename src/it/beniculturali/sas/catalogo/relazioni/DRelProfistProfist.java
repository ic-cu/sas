//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.27 at 02:03:47 PM CET 
//


package it.beniculturali.sas.catalogo.relazioni;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.vocabolari_elmctx.DVocTiporelProfist;


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
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/relazioni}codi_provenienza_profist"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/relazioni}codi_provenienza_profist_sup"/>
 *         &lt;element name="fk_voc_tiporel_profist" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-elmctx}d_voc_tiporel_profist"/>
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
    "codiProvenienzaProfist",
    "codiProvenienzaProfistSup",
    "fkVocTiporelProfist"
})
@XmlRootElement(name = "d_rel_profist_profist")
public class DRelProfistProfist {

    @XmlElement(name = "codi_provenienza_profist", required = true)
    protected String codiProvenienzaProfist;
    @XmlElement(name = "codi_provenienza_profist_sup", required = true)
    protected String codiProvenienzaProfistSup;
    @XmlElementRef(name = "fk_voc_tiporel_profist", namespace = "http://sas.beniculturali.it/catalogo/relazioni", type = JAXBElement.class)
    protected JAXBElement<DRelProfistProfist.FkVocTiporelProfist> fkVocTiporelProfist;

    /**
     * Gets the value of the codiProvenienzaProfist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienzaProfist() {
        return codiProvenienzaProfist;
    }

    /**
     * Sets the value of the codiProvenienzaProfist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienzaProfist(String value) {
        this.codiProvenienzaProfist = value;
    }

    /**
     * Gets the value of the codiProvenienzaProfistSup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProvenienzaProfistSup() {
        return codiProvenienzaProfistSup;
    }

    /**
     * Sets the value of the codiProvenienzaProfistSup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProvenienzaProfistSup(String value) {
        this.codiProvenienzaProfistSup = value;
    }

    /**
     * Gets the value of the fkVocTiporelProfist property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DRelProfistProfist.FkVocTiporelProfist }{@code >}
     *     
     */
    public JAXBElement<DRelProfistProfist.FkVocTiporelProfist> getFkVocTiporelProfist() {
        return fkVocTiporelProfist;
    }

    /**
     * Sets the value of the fkVocTiporelProfist property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DRelProfistProfist.FkVocTiporelProfist }{@code >}
     *     
     */
    public void setFkVocTiporelProfist(JAXBElement<DRelProfistProfist.FkVocTiporelProfist> value) {
        this.fkVocTiporelProfist = ((JAXBElement<DRelProfistProfist.FkVocTiporelProfist> ) value);
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
     *       &lt;choice maxOccurs="unbounded" minOccurs="0">
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-elmctx}d_voc_tiporel_profist"/>
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
        "dVocTiporelProfist"
    })
    public static class FkVocTiporelProfist {

        @XmlElement(name = "d_voc_tiporel_profist", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-elmctx")
        protected List<DVocTiporelProfist> dVocTiporelProfist;

        /**
         * Gets the value of the dVocTiporelProfist property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dVocTiporelProfist property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDVocTiporelProfist().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DVocTiporelProfist }
         * 
         * 
         */
        public List<DVocTiporelProfist> getDVocTiporelProfist() {
            if (dVocTiporelProfist == null) {
                dVocTiporelProfist = new ArrayList<DVocTiporelProfist>();
            }
            return this.dVocTiporelProfist;
        }

    }

}
