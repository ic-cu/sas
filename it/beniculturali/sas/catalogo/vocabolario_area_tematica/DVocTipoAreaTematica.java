//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.11 at 06:42:47 PM CET 
//


package it.beniculturali.sas.catalogo.vocabolario_area_tematica;

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
 *         &lt;element name="sequ_voc_tipo_area_tematica">
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
 *               &lt;enumeration value="14"/>
 *               &lt;enumeration value="15"/>
 *               &lt;enumeration value="16"/>
 *               &lt;enumeration value="17"/>
 *               &lt;enumeration value="18"/>
 *               &lt;enumeration value="19"/>
 *               &lt;enumeration value="20"/>
 *               &lt;enumeration value="21"/>
 *               &lt;enumeration value="22"/>
 *               &lt;enumeration value="23"/>
 *               &lt;enumeration value="24"/>
 *               &lt;enumeration value="25"/>
 *               &lt;enumeration value="26"/>
 *               &lt;enumeration value="27"/>
 *               &lt;enumeration value="28"/>
 *               &lt;enumeration value="29"/>
 *               &lt;enumeration value="30"/>
 *               &lt;enumeration value="31"/>
 *               &lt;enumeration value="32"/>
 *               &lt;enumeration value="33"/>
 *               &lt;enumeration value="34"/>
 *               &lt;enumeration value="35"/>
 *               &lt;enumeration value="36"/>
 *               &lt;enumeration value="37"/>
 *               &lt;enumeration value="38"/>
 *               &lt;enumeration value="39"/>
 *               &lt;enumeration value="40"/>
 *               &lt;enumeration value="41"/>
 *               &lt;enumeration value="1000"/>
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
    "sequVocTipoAreaTematica"
})
@XmlRootElement(name = "d_voc_tipo_area_tematica")
public class DVocTipoAreaTematica {

    @XmlElement(name = "last_update")
    protected String lastUpdate;
    protected String readme;
    @XmlElement(name = "sequ_voc_tipo_area_tematica")
    protected long sequVocTipoAreaTematica;

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
     * Gets the value of the sequVocTipoAreaTematica property.
     * 
     */
    public long getSequVocTipoAreaTematica() {
        return sequVocTipoAreaTematica;
    }

    /**
     * Sets the value of the sequVocTipoAreaTematica property.
     * 
     */
    public void setSequVocTipoAreaTematica(long value) {
        this.sequVocTipoAreaTematica = value;
    }

}
