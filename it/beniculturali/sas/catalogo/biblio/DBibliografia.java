//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.25 at 03:07:39 PM CET 
//


package it.beniculturali.sas.catalogo.biblio;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.commons.DCompilatore;
import it.beniculturali.sas.catalogo.commons.DUrl;
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
 *         &lt;element name="text_titolo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2048"/>
 *               &lt;minLength value="1"/>
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
 *         &lt;element name="codi_isbn" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codi_opac_sbn" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="250"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_metadati_opac" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_biblioteca" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1024"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/biblio}d_soggetti_bibl" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/biblio}d_edizione_bibl" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/commons}d_url" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/commons}d_compilatore" maxOccurs="unbounded" minOccurs="0"/>
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
    "textTitolo",
    "fkFonte",
    "codiIsbn",
    "codiOpacSbn",
    "textMetadatiOpac",
    "textBiblioteca",
    "dSoggettiBibl",
    "dEdizioneBibl",
    "dUrl",
    "dCompilatore"
})
@XmlRootElement(name = "d_bibliografia")
public class DBibliografia {

    @XmlElement(name = "codi_provenienza", required = true)
    protected String codiProvenienza;
    @XmlElement(name = "text_titolo", required = true)
    protected String textTitolo;
    @XmlElement(name = "fk_fonte", required = true, nillable = true)
    protected DBibliografia.FkFonte fkFonte;
    @XmlElementRef(name = "codi_isbn", namespace = "http://sas.beniculturali.it/catalogo/biblio", type = JAXBElement.class)
    protected JAXBElement<String> codiIsbn;
    @XmlElementRef(name = "codi_opac_sbn", namespace = "http://sas.beniculturali.it/catalogo/biblio", type = JAXBElement.class)
    protected JAXBElement<String> codiOpacSbn;
    @XmlElementRef(name = "text_metadati_opac", namespace = "http://sas.beniculturali.it/catalogo/biblio", type = JAXBElement.class)
    protected JAXBElement<String> textMetadatiOpac;
    @XmlElementRef(name = "text_biblioteca", namespace = "http://sas.beniculturali.it/catalogo/biblio", type = JAXBElement.class)
    protected JAXBElement<String> textBiblioteca;
    @XmlElement(name = "d_soggetti_bibl")
    protected List<DSoggettiBibl> dSoggettiBibl;
    @XmlElement(name = "d_edizione_bibl")
    protected List<DEdizioneBibl> dEdizioneBibl;
    @XmlElement(name = "d_url", namespace = "http://sas.beniculturali.it/catalogo/commons")
    protected List<DUrl> dUrl;
    @XmlElement(name = "d_compilatore", namespace = "http://sas.beniculturali.it/catalogo/commons")
    protected List<DCompilatore> dCompilatore;

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
     * Gets the value of the textTitolo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextTitolo() {
        return textTitolo;
    }

    /**
     * Sets the value of the textTitolo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextTitolo(String value) {
        this.textTitolo = value;
    }

    /**
     * Gets the value of the fkFonte property.
     * 
     * @return
     *     possible object is
     *     {@link DBibliografia.FkFonte }
     *     
     */
    public DBibliografia.FkFonte getFkFonte() {
        return fkFonte;
    }

    /**
     * Sets the value of the fkFonte property.
     * 
     * @param value
     *     allowed object is
     *     {@link DBibliografia.FkFonte }
     *     
     */
    public void setFkFonte(DBibliografia.FkFonte value) {
        this.fkFonte = value;
    }

    /**
     * Gets the value of the codiIsbn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiIsbn() {
        return codiIsbn;
    }

    /**
     * Sets the value of the codiIsbn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiIsbn(JAXBElement<String> value) {
        this.codiIsbn = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the codiOpacSbn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiOpacSbn() {
        return codiOpacSbn;
    }

    /**
     * Sets the value of the codiOpacSbn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiOpacSbn(JAXBElement<String> value) {
        this.codiOpacSbn = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textMetadatiOpac property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextMetadatiOpac() {
        return textMetadatiOpac;
    }

    /**
     * Sets the value of the textMetadatiOpac property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextMetadatiOpac(JAXBElement<String> value) {
        this.textMetadatiOpac = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textBiblioteca property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextBiblioteca() {
        return textBiblioteca;
    }

    /**
     * Sets the value of the textBiblioteca property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextBiblioteca(JAXBElement<String> value) {
        this.textBiblioteca = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dSoggettiBibl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dSoggettiBibl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDSoggettiBibl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DSoggettiBibl }
     * 
     * 
     */
    public List<DSoggettiBibl> getDSoggettiBibl() {
        if (dSoggettiBibl == null) {
            dSoggettiBibl = new ArrayList<DSoggettiBibl>();
        }
        return this.dSoggettiBibl;
    }

    /**
     * Gets the value of the dEdizioneBibl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dEdizioneBibl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDEdizioneBibl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DEdizioneBibl }
     * 
     * 
     */
    public List<DEdizioneBibl> getDEdizioneBibl() {
        if (dEdizioneBibl == null) {
            dEdizioneBibl = new ArrayList<DEdizioneBibl>();
        }
        return this.dEdizioneBibl;
    }

    /**
     * Gets the value of the dUrl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dUrl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDUrl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DUrl }
     * 
     * 
     */
    public List<DUrl> getDUrl() {
        if (dUrl == null) {
            dUrl = new ArrayList<DUrl>();
        }
        return this.dUrl;
    }

    /**
     * Gets the value of the dCompilatore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dCompilatore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDCompilatore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DCompilatore }
     * 
     * 
     */
    public List<DCompilatore> getDCompilatore() {
        if (dCompilatore == null) {
            dCompilatore = new ArrayList<DCompilatore>();
        }
        return this.dCompilatore;
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
