//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.25 at 03:07:39 PM CET 
//


package it.beniculturali.sas.catalogo.relazioni;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://sas.beniculturali.it/catalogo/relazioni>restrictedString">
 *       &lt;attribute name="tipologia" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="d_sogc"/>
 *             &lt;enumeration value="d_depositi"/>
 *             &lt;enumeration value="d_sala_studio"/>
 *             &lt;enumeration value="d_sogp"/>
 *             &lt;enumeration value="d_comparc"/>
 *             &lt;enumeration value="d_ambito_territoriale"/>
 *             &lt;enumeration value="d_contesto_storico_ist"/>
 *             &lt;enumeration value="d_profilo_storico_ist"/>
 *             &lt;enumeration value="d_struttura_amministrativa"/>
 *             &lt;enumeration value="d_tipologia_documentaria"/>
 *             &lt;enumeration value="d_strumento_ricerca"/>
 *             &lt;enumeration value="d_autore_strric"/>
 *             &lt;enumeration value="d_editore_strric"/>
 *             &lt;enumeration value="d_bibliografia"/>
 *             &lt;enumeration value="d_autore_bibl"/>
 *             &lt;enumeration value="d_editore_bibl"/>
 *             &lt;enumeration value="d_scheda_vigilanza"/>
 *             &lt;enumeration value="d_titolare_complesso"/>
 *             &lt;enumeration value="d_finanziamenti"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "codi_provenienza")
public class CodiProvenienza {

    @XmlValue
    protected String value;
    @XmlAttribute(required = true)
    protected String tipologia;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the tipologia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipologia() {
        return tipologia;
    }

    /**
     * Sets the value of the tipologia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipologia(String value) {
        this.tipologia = value;
    }

}
