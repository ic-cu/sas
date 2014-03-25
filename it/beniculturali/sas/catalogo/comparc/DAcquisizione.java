//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.25 at 03:07:39 PM CET 
//


package it.beniculturali.sas.catalogo.comparc;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipoAcquisizione;


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
 *         &lt;element name="nume_rpc">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="18"/>
 *               &lt;fractionDigits value="0"/>
 *               &lt;minInclusive value="0.000000"/>
 *               &lt;maxExclusive value="1000000000000000000.0000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_soggetto_versatore">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="1024"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_tipo_acquisizione" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipo_acquisizione"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="date_acquisizione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="-4713-01-01"/>
 *               &lt;maxInclusive value="5874897-12-31"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_note_acquisizione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_note_direzione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
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
    "numeRpc",
    "textSoggettoVersatore",
    "fkVocTipoAcquisizione",
    "dateAcquisizione",
    "textNoteAcquisizione",
    "textNoteDirezione"
})
@XmlRootElement(name = "d_acquisizione")
public class DAcquisizione {

    @XmlElement(name = "nume_rpc", required = true, nillable = true)
    protected BigDecimal numeRpc;
    @XmlElement(name = "text_soggetto_versatore", required = true)
    protected String textSoggettoVersatore;
    @XmlElementRef(name = "fk_voc_tipo_acquisizione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DAcquisizione.FkVocTipoAcquisizione> fkVocTipoAcquisizione;
    @XmlElementRef(name = "date_acquisizione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> dateAcquisizione;
    @XmlElementRef(name = "text_note_acquisizione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textNoteAcquisizione;
    @XmlElementRef(name = "text_note_direzione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textNoteDirezione;

    /**
     * Gets the value of the numeRpc property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNumeRpc() {
        return numeRpc;
    }

    /**
     * Sets the value of the numeRpc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNumeRpc(BigDecimal value) {
        this.numeRpc = value;
    }

    /**
     * Gets the value of the textSoggettoVersatore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextSoggettoVersatore() {
        return textSoggettoVersatore;
    }

    /**
     * Sets the value of the textSoggettoVersatore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextSoggettoVersatore(String value) {
        this.textSoggettoVersatore = value;
    }

    /**
     * Gets the value of the fkVocTipoAcquisizione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DAcquisizione.FkVocTipoAcquisizione }{@code >}
     *     
     */
    public JAXBElement<DAcquisizione.FkVocTipoAcquisizione> getFkVocTipoAcquisizione() {
        return fkVocTipoAcquisizione;
    }

    /**
     * Sets the value of the fkVocTipoAcquisizione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DAcquisizione.FkVocTipoAcquisizione }{@code >}
     *     
     */
    public void setFkVocTipoAcquisizione(JAXBElement<DAcquisizione.FkVocTipoAcquisizione> value) {
        this.fkVocTipoAcquisizione = ((JAXBElement<DAcquisizione.FkVocTipoAcquisizione> ) value);
    }

    /**
     * Gets the value of the dateAcquisizione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateAcquisizione() {
        return dateAcquisizione;
    }

    /**
     * Sets the value of the dateAcquisizione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateAcquisizione(JAXBElement<XMLGregorianCalendar> value) {
        this.dateAcquisizione = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the textNoteAcquisizione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNoteAcquisizione() {
        return textNoteAcquisizione;
    }

    /**
     * Sets the value of the textNoteAcquisizione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNoteAcquisizione(JAXBElement<String> value) {
        this.textNoteAcquisizione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textNoteDirezione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNoteDirezione() {
        return textNoteDirezione;
    }

    /**
     * Sets the value of the textNoteDirezione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNoteDirezione(JAXBElement<String> value) {
        this.textNoteDirezione = ((JAXBElement<String> ) value);
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipo_acquisizione"/>
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
        "dVocTipoAcquisizione"
    })
    public static class FkVocTipoAcquisizione {

        @XmlElement(name = "d_voc_tipo_acquisizione", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocTipoAcquisizione dVocTipoAcquisizione;

        /**
         * Gets the value of the dVocTipoAcquisizione property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipoAcquisizione }
         *     
         */
        public DVocTipoAcquisizione getDVocTipoAcquisizione() {
            return dVocTipoAcquisizione;
        }

        /**
         * Sets the value of the dVocTipoAcquisizione property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipoAcquisizione }
         *     
         */
        public void setDVocTipoAcquisizione(DVocTipoAcquisizione value) {
            this.dVocTipoAcquisizione = value;
        }

    }

}
