//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.11.07 at 10:27:57 AM CET 
//


package it.beniculturali.sas.catalogo.vocabolari_sogc;

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
 *         &lt;element name="last_update" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="27/06/2013"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="readme" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Aggiornamenti vocabolario"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="sequ_voc_tipo_deposito">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
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
    "lastUpdate",
    "readme",
    "sequVocTipoDeposito"
})
@XmlRootElement(name = "d_voc_tipo_deposito")
public class DVocTipoDeposito {

    @XmlElement(name = "last_update")
    protected String lastUpdate;
    protected String readme;
    @XmlElement(name = "sequ_voc_tipo_deposito")
    protected long sequVocTipoDeposito;

    /**
     * Gets the value of the lastUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Sets the value of the lastUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdate(String value) {
        this.lastUpdate = value;
    }

    /**
     * Gets the value of the readme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadme() {
        return readme;
    }

    /**
     * Sets the value of the readme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadme(String value) {
        this.readme = value;
    }

    /**
     * Gets the value of the sequVocTipoDeposito property.
     * 
     */
    public long getSequVocTipoDeposito() {
        return sequVocTipoDeposito;
    }

    /**
     * Sets the value of the sequVocTipoDeposito property.
     * 
     */
    public void setSequVocTipoDeposito(long value) {
        this.sequVocTipoDeposito = value;
    }

}
