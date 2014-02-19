//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.18 at 04:50:28 PM CET 
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
import javax.xml.datatype.XMLGregorianCalendar;
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
 *         &lt;element name="text_anagrafica_autore">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="512"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_luogo_nascita" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="512"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="date_nascita" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="-4713-01-01"/>
 *               &lt;maxInclusive value="5874897-12-31"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_luogo_morte" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="512"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="date_morte" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="-4713-01-01"/>
 *               &lt;maxInclusive value="5874897-12-31"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
    "fkFonte",
    "textAnagraficaAutore",
    "textLuogoNascita",
    "dateNascita",
    "textLuogoMorte",
    "dateMorte",
    "dUrl",
    "dCompilatore"
})
@XmlRootElement(name = "d_autore_bibl")
public class DAutoreBibl {

    @XmlElement(name = "codi_provenienza", required = true)
    protected String codiProvenienza;
    @XmlElement(name = "fk_fonte", required = true, nillable = true)
    protected DAutoreBibl.FkFonte fkFonte;
    @XmlElement(name = "text_anagrafica_autore", required = true, nillable = true)
    protected String textAnagraficaAutore;
    @XmlElementRef(name = "text_luogo_nascita", namespace = "http://sas.beniculturali.it/catalogo/biblio", type = JAXBElement.class)
    protected JAXBElement<String> textLuogoNascita;
    @XmlElementRef(name = "date_nascita", namespace = "http://sas.beniculturali.it/catalogo/biblio", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> dateNascita;
    @XmlElementRef(name = "text_luogo_morte", namespace = "http://sas.beniculturali.it/catalogo/biblio", type = JAXBElement.class)
    protected JAXBElement<String> textLuogoMorte;
    @XmlElementRef(name = "date_morte", namespace = "http://sas.beniculturali.it/catalogo/biblio", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> dateMorte;
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
     * Gets the value of the fkFonte property.
     * 
     * @return
     *     possible object is
     *     {@link DAutoreBibl.FkFonte }
     *     
     */
    public DAutoreBibl.FkFonte getFkFonte() {
        return fkFonte;
    }

    /**
     * Sets the value of the fkFonte property.
     * 
     * @param value
     *     allowed object is
     *     {@link DAutoreBibl.FkFonte }
     *     
     */
    public void setFkFonte(DAutoreBibl.FkFonte value) {
        this.fkFonte = value;
    }

    /**
     * Gets the value of the textAnagraficaAutore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextAnagraficaAutore() {
        return textAnagraficaAutore;
    }

    /**
     * Sets the value of the textAnagraficaAutore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextAnagraficaAutore(String value) {
        this.textAnagraficaAutore = value;
    }

    /**
     * Gets the value of the textLuogoNascita property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextLuogoNascita() {
        return textLuogoNascita;
    }

    /**
     * Sets the value of the textLuogoNascita property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextLuogoNascita(JAXBElement<String> value) {
        this.textLuogoNascita = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dateNascita property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateNascita() {
        return dateNascita;
    }

    /**
     * Sets the value of the dateNascita property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateNascita(JAXBElement<XMLGregorianCalendar> value) {
        this.dateNascita = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the textLuogoMorte property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextLuogoMorte() {
        return textLuogoMorte;
    }

    /**
     * Sets the value of the textLuogoMorte property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextLuogoMorte(JAXBElement<String> value) {
        this.textLuogoMorte = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dateMorte property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateMorte() {
        return dateMorte;
    }

    /**
     * Sets the value of the dateMorte property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateMorte(JAXBElement<XMLGregorianCalendar> value) {
        this.dateMorte = ((JAXBElement<XMLGregorianCalendar> ) value);
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
