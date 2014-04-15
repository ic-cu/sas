//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.27 at 02:03:47 PM CET 
//


package it.beniculturali.sas.catalogo.comparc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="text_incrementi_previsti">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nume_complessivo_unita" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nume_metri_lineari_complessivi" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="date_data_caricamento" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="-4713-01-01"/>
 *               &lt;maxInclusive value="5874897-12-31"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}"/>
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
    "textIncrementiPrevisti",
    "numeComplessivoUnita",
    "numeMetriLineariComplessivi",
    "dateDataCaricamento"
})
@XmlRootElement(name = "d_comparc_incrementi")
public class DComparcIncrementi {

    @XmlElement(name = "text_incrementi_previsti", required = true)
    protected String textIncrementiPrevisti;
    @XmlElementRef(name = "nume_complessivo_unita", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<Integer> numeComplessivoUnita;
    @XmlElementRef(name = "nume_metri_lineari_complessivi", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<Integer> numeMetriLineariComplessivi;
    @XmlElementRef(name = "date_data_caricamento", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> dateDataCaricamento;

    /**
     * Gets the value of the textIncrementiPrevisti property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextIncrementiPrevisti() {
        return textIncrementiPrevisti;
    }

    /**
     * Sets the value of the textIncrementiPrevisti property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextIncrementiPrevisti(String value) {
        this.textIncrementiPrevisti = value;
    }

    /**
     * Gets the value of the numeComplessivoUnita property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getNumeComplessivoUnita() {
        return numeComplessivoUnita;
    }

    /**
     * Sets the value of the numeComplessivoUnita property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setNumeComplessivoUnita(JAXBElement<Integer> value) {
        this.numeComplessivoUnita = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the numeMetriLineariComplessivi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getNumeMetriLineariComplessivi() {
        return numeMetriLineariComplessivi;
    }

    /**
     * Sets the value of the numeMetriLineariComplessivi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setNumeMetriLineariComplessivi(JAXBElement<Integer> value) {
        this.numeMetriLineariComplessivi = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the dateDataCaricamento property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateDataCaricamento() {
        return dateDataCaricamento;
    }

    /**
     * Sets the value of the dateDataCaricamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateDataCaricamento(JAXBElement<XMLGregorianCalendar> value) {
        this.dateDataCaricamento = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

}
