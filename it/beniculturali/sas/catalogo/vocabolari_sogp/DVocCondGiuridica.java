//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.27 at 02:03:47 PM CET 
//


package it.beniculturali.sas.catalogo.vocabolari_sogp;

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
 *               &lt;enumeration value="08/01/2014"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="readme" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Storico vocabolario"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="sequ_voc_cond_giuridica">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="7"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="9"/>
 *               &lt;enumeration value="10"/>
 *               &lt;enumeration value="11"/>
 *               &lt;enumeration value="12"/>
 *               &lt;enumeration value="13"/>
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
    "sequVocCondGiuridica"
})
@XmlRootElement(name = "d_voc_cond_giuridica")
public class DVocCondGiuridica {

    @XmlElement(name = "last_update")
    protected String lastUpdate;
    protected String readme;
    @XmlElement(name = "sequ_voc_cond_giuridica")
    protected long sequVocCondGiuridica;

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
     * Gets the value of the sequVocCondGiuridica property.
     * 
     */
    public long getSequVocCondGiuridica() {
        return sequVocCondGiuridica;
    }

    /**
     * Sets the value of the sequVocCondGiuridica property.
     * 
     */
    public void setSequVocCondGiuridica(long value) {
        this.sequVocCondGiuridica = value;
    }

}
