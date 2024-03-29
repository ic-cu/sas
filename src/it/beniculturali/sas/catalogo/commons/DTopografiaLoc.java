//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.18 at 11:10:43 AM CET 
//


package it.beniculturali.sas.catalogo.commons;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.vocabolari_trasv.DVocTipoContenitore;


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
 *         &lt;element name="codi_provenienza" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="256"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_tipo_contenitore">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_tipo_contenitore"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_nome_contenitore">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="250"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nume_visualizzazione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nume_metri_lineari_disp" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="30"/>
 *               &lt;fractionDigits value="6"/>
 *               &lt;minExclusive value="-999999999999999980000000.0000"/>
 *               &lt;maxExclusive value="999999999999999980000000.0000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/commons}d_topografia_loc" maxOccurs="unbounded" minOccurs="0"/>
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
    "fkVocTipoContenitore",
    "textNomeContenitore",
    "numeVisualizzazione",
    "numeMetriLineariDisp",
    "dTopografiaLoc"
})
@XmlRootElement(name = "d_topografia_loc")
public class DTopografiaLoc {

    @XmlElement(name = "codi_provenienza")
    protected String codiProvenienza;
    @XmlElement(name = "fk_voc_tipo_contenitore", required = true, nillable = true)
    protected DTopografiaLoc.FkVocTipoContenitore fkVocTipoContenitore;
    @XmlElement(name = "text_nome_contenitore", required = true, nillable = true)
    protected String textNomeContenitore;
    @XmlElementRef(name = "nume_visualizzazione", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> numeVisualizzazione;
    @XmlElementRef(name = "nume_metri_lineari_disp", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> numeMetriLineariDisp;
    @XmlElement(name = "d_topografia_loc")
    protected List<DTopografiaLoc> dTopografiaLoc;

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
     * Gets the value of the fkVocTipoContenitore property.
     * 
     * @return
     *     possible object is
     *     {@link DTopografiaLoc.FkVocTipoContenitore }
     *     
     */
    public DTopografiaLoc.FkVocTipoContenitore getFkVocTipoContenitore() {
        return fkVocTipoContenitore;
    }

    /**
     * Sets the value of the fkVocTipoContenitore property.
     * 
     * @param value
     *     allowed object is
     *     {@link DTopografiaLoc.FkVocTipoContenitore }
     *     
     */
    public void setFkVocTipoContenitore(DTopografiaLoc.FkVocTipoContenitore value) {
        this.fkVocTipoContenitore = value;
    }

    /**
     * Gets the value of the textNomeContenitore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextNomeContenitore() {
        return textNomeContenitore;
    }

    /**
     * Sets the value of the textNomeContenitore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextNomeContenitore(String value) {
        this.textNomeContenitore = value;
    }

    /**
     * Gets the value of the numeVisualizzazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getNumeVisualizzazione() {
        return numeVisualizzazione;
    }

    /**
     * Sets the value of the numeVisualizzazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setNumeVisualizzazione(JAXBElement<Integer> value) {
        this.numeVisualizzazione = value;
    }

    /**
     * Gets the value of the numeMetriLineariDisp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getNumeMetriLineariDisp() {
        return numeMetriLineariDisp;
    }

    /**
     * Sets the value of the numeMetriLineariDisp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setNumeMetriLineariDisp(JAXBElement<BigDecimal> value) {
        this.numeMetriLineariDisp = value;
    }

    /**
     * Gets the value of the dTopografiaLoc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dTopografiaLoc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDTopografiaLoc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DTopografiaLoc }
     * 
     * 
     */
    public List<DTopografiaLoc> getDTopografiaLoc() {
        if (dTopografiaLoc == null) {
            dTopografiaLoc = new ArrayList<DTopografiaLoc>();
        }
        return this.dTopografiaLoc;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_tipo_contenitore"/>
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
        "dVocTipoContenitore"
    })
    public static class FkVocTipoContenitore {

        @XmlElement(name = "d_voc_tipo_contenitore", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-trasv")
        protected DVocTipoContenitore dVocTipoContenitore;

        /**
         * Gets the value of the dVocTipoContenitore property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipoContenitore }
         *     
         */
        public DVocTipoContenitore getDVocTipoContenitore() {
            return dVocTipoContenitore;
        }

        /**
         * Sets the value of the dVocTipoContenitore property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipoContenitore }
         *     
         */
        public void setDVocTipoContenitore(DVocTipoContenitore value) {
            this.dVocTipoContenitore = value;
        }

    }

}
