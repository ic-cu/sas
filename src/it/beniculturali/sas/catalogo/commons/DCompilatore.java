//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.27 at 02:03:47 PM CET 
//


package it.beniculturali.sas.catalogo.commons;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import it.beniculturali.sas.catalogo.vocabolari_trasv.DVocTipoIntervento;
import it.beniculturali.sas.catalogo.vocabolari_trasv.DVocTipoLingua;
import it.beniculturali.sas.catalogo.vocabolari_trasv.DVocTipoScrittura;


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
 *         &lt;element name="text_username">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="256"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="date_intervento">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="-4713-01-01"/>
 *               &lt;maxInclusive value="5874897-12-31"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_tipo_intervento">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_tipo_intervento"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_note" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_tipo_lingua" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_tipo_lingua"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_tipo_scrittura" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_tipo_scrittura"/>
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
    "textUsername",
    "dateIntervento",
    "fkVocTipoIntervento",
    "textNote",
    "fkVocTipoLingua",
    "fkVocTipoScrittura"
})
@XmlRootElement(name = "d_compilatore")
public class DCompilatore {

    @XmlElement(name = "text_username", required = true, nillable = true)
    protected String textUsername;
    @XmlElement(name = "date_intervento", required = true, nillable = true)
    protected XMLGregorianCalendar dateIntervento;
    @XmlElement(name = "fk_voc_tipo_intervento", required = true, nillable = true)
    protected DCompilatore.FkVocTipoIntervento fkVocTipoIntervento;
    @XmlElementRef(name = "text_note", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<String> textNote;
    @XmlElementRef(name = "fk_voc_tipo_lingua", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<DCompilatore.FkVocTipoLingua> fkVocTipoLingua;
    @XmlElementRef(name = "fk_voc_tipo_scrittura", namespace = "http://sas.beniculturali.it/catalogo/commons", type = JAXBElement.class)
    protected JAXBElement<DCompilatore.FkVocTipoScrittura> fkVocTipoScrittura;

    /**
     * Gets the value of the textUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextUsername() {
        return textUsername;
    }

    /**
     * Sets the value of the textUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextUsername(String value) {
        this.textUsername = value;
    }

    /**
     * Gets the value of the dateIntervento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateIntervento() {
        return dateIntervento;
    }

    /**
     * Sets the value of the dateIntervento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateIntervento(XMLGregorianCalendar value) {
        this.dateIntervento = value;
    }

    /**
     * Gets the value of the fkVocTipoIntervento property.
     * 
     * @return
     *     possible object is
     *     {@link DCompilatore.FkVocTipoIntervento }
     *     
     */
    public DCompilatore.FkVocTipoIntervento getFkVocTipoIntervento() {
        return fkVocTipoIntervento;
    }

    /**
     * Sets the value of the fkVocTipoIntervento property.
     * 
     * @param value
     *     allowed object is
     *     {@link DCompilatore.FkVocTipoIntervento }
     *     
     */
    public void setFkVocTipoIntervento(DCompilatore.FkVocTipoIntervento value) {
        this.fkVocTipoIntervento = value;
    }

    /**
     * Gets the value of the textNote property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNote() {
        return textNote;
    }

    /**
     * Sets the value of the textNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNote(JAXBElement<String> value) {
        this.textNote = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fkVocTipoLingua property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DCompilatore.FkVocTipoLingua }{@code >}
     *     
     */
    public JAXBElement<DCompilatore.FkVocTipoLingua> getFkVocTipoLingua() {
        return fkVocTipoLingua;
    }

    /**
     * Sets the value of the fkVocTipoLingua property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DCompilatore.FkVocTipoLingua }{@code >}
     *     
     */
    public void setFkVocTipoLingua(JAXBElement<DCompilatore.FkVocTipoLingua> value) {
        this.fkVocTipoLingua = ((JAXBElement<DCompilatore.FkVocTipoLingua> ) value);
    }

    /**
     * Gets the value of the fkVocTipoScrittura property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DCompilatore.FkVocTipoScrittura }{@code >}
     *     
     */
    public JAXBElement<DCompilatore.FkVocTipoScrittura> getFkVocTipoScrittura() {
        return fkVocTipoScrittura;
    }

    /**
     * Sets the value of the fkVocTipoScrittura property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DCompilatore.FkVocTipoScrittura }{@code >}
     *     
     */
    public void setFkVocTipoScrittura(JAXBElement<DCompilatore.FkVocTipoScrittura> value) {
        this.fkVocTipoScrittura = ((JAXBElement<DCompilatore.FkVocTipoScrittura> ) value);
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_tipo_intervento"/>
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
        "dVocTipoIntervento"
    })
    public static class FkVocTipoIntervento {

        @XmlElement(name = "d_voc_tipo_intervento", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-trasv")
        protected DVocTipoIntervento dVocTipoIntervento;

        /**
         * Gets the value of the dVocTipoIntervento property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipoIntervento }
         *     
         */
        public DVocTipoIntervento getDVocTipoIntervento() {
            return dVocTipoIntervento;
        }

        /**
         * Sets the value of the dVocTipoIntervento property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipoIntervento }
         *     
         */
        public void setDVocTipoIntervento(DVocTipoIntervento value) {
            this.dVocTipoIntervento = value;
        }

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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_tipo_lingua"/>
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
        "dVocTipoLingua"
    })
    public static class FkVocTipoLingua {

        @XmlElement(name = "d_voc_tipo_lingua", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-trasv")
        protected DVocTipoLingua dVocTipoLingua;

        /**
         * Gets the value of the dVocTipoLingua property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipoLingua }
         *     
         */
        public DVocTipoLingua getDVocTipoLingua() {
            return dVocTipoLingua;
        }

        /**
         * Sets the value of the dVocTipoLingua property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipoLingua }
         *     
         */
        public void setDVocTipoLingua(DVocTipoLingua value) {
            this.dVocTipoLingua = value;
        }

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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-trasv}d_voc_tipo_scrittura"/>
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
        "dVocTipoScrittura"
    })
    public static class FkVocTipoScrittura {

        @XmlElement(name = "d_voc_tipo_scrittura", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-trasv")
        protected DVocTipoScrittura dVocTipoScrittura;

        /**
         * Gets the value of the dVocTipoScrittura property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipoScrittura }
         *     
         */
        public DVocTipoScrittura getDVocTipoScrittura() {
            return dVocTipoScrittura;
        }

        /**
         * Sets the value of the dVocTipoScrittura property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipoScrittura }
         *     
         */
        public void setDVocTipoScrittura(DVocTipoScrittura value) {
            this.dVocTipoScrittura = value;
        }

    }

}