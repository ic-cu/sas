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
import it.beniculturali.sas.catalogo.vocabolario_qualifica_toponimo.DVocQualificaToponimo;
import it.beniculturali.sas.catalogo.vocabolario_ruolo_toponimo.DVocRuoloToponimo;
import it.beniculturali.sas.catalogo.vocabolario_toponimi.DVocToponimo;


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
 *         &lt;element name="fk_voc_toponimo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-toponimi}d_voc_toponimo"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_qualifica_toponimo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-qualifica_toponimo}d_voc_qualifica_toponimo"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_ruolo_toponimo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-ruolo_toponimo}d_voc_ruolo_toponimo"/>
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
    "fkVocToponimo",
    "fkVocQualificaToponimo",
    "fkVocRuoloToponimo"
})
@XmlRootElement(name = "d_rel_comparc_toponimi")
public class DRelComparcToponimi {

    @XmlElement(name = "fk_voc_toponimo", required = true, nillable = true)
    protected DRelComparcToponimi.FkVocToponimo fkVocToponimo;
    @XmlElementRef(name = "fk_voc_qualifica_toponimo", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DRelComparcToponimi.FkVocQualificaToponimo> fkVocQualificaToponimo;
    @XmlElementRef(name = "fk_voc_ruolo_toponimo", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DRelComparcToponimi.FkVocRuoloToponimo> fkVocRuoloToponimo;

    /**
     * Gets the value of the fkVocToponimo property.
     * 
     * @return
     *     possible object is
     *     {@link DRelComparcToponimi.FkVocToponimo }
     *     
     */
    public DRelComparcToponimi.FkVocToponimo getFkVocToponimo() {
        return fkVocToponimo;
    }

    /**
     * Sets the value of the fkVocToponimo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DRelComparcToponimi.FkVocToponimo }
     *     
     */
    public void setFkVocToponimo(DRelComparcToponimi.FkVocToponimo value) {
        this.fkVocToponimo = value;
    }

    /**
     * Gets the value of the fkVocQualificaToponimo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DRelComparcToponimi.FkVocQualificaToponimo }{@code >}
     *     
     */
    public JAXBElement<DRelComparcToponimi.FkVocQualificaToponimo> getFkVocQualificaToponimo() {
        return fkVocQualificaToponimo;
    }

    /**
     * Sets the value of the fkVocQualificaToponimo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DRelComparcToponimi.FkVocQualificaToponimo }{@code >}
     *     
     */
    public void setFkVocQualificaToponimo(JAXBElement<DRelComparcToponimi.FkVocQualificaToponimo> value) {
        this.fkVocQualificaToponimo = ((JAXBElement<DRelComparcToponimi.FkVocQualificaToponimo> ) value);
    }

    /**
     * Gets the value of the fkVocRuoloToponimo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DRelComparcToponimi.FkVocRuoloToponimo }{@code >}
     *     
     */
    public JAXBElement<DRelComparcToponimi.FkVocRuoloToponimo> getFkVocRuoloToponimo() {
        return fkVocRuoloToponimo;
    }

    /**
     * Sets the value of the fkVocRuoloToponimo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DRelComparcToponimi.FkVocRuoloToponimo }{@code >}
     *     
     */
    public void setFkVocRuoloToponimo(JAXBElement<DRelComparcToponimi.FkVocRuoloToponimo> value) {
        this.fkVocRuoloToponimo = ((JAXBElement<DRelComparcToponimi.FkVocRuoloToponimo> ) value);
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-qualifica_toponimo}d_voc_qualifica_toponimo"/>
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
        "dVocQualificaToponimo"
    })
    public static class FkVocQualificaToponimo {

        @XmlElement(name = "d_voc_qualifica_toponimo", namespace = "http://sas.beniculturali.it/catalogo/vocabolario-qualifica_toponimo")
        protected DVocQualificaToponimo dVocQualificaToponimo;

        /**
         * Gets the value of the dVocQualificaToponimo property.
         * 
         * @return
         *     possible object is
         *     {@link DVocQualificaToponimo }
         *     
         */
        public DVocQualificaToponimo getDVocQualificaToponimo() {
            return dVocQualificaToponimo;
        }

        /**
         * Sets the value of the dVocQualificaToponimo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocQualificaToponimo }
         *     
         */
        public void setDVocQualificaToponimo(DVocQualificaToponimo value) {
            this.dVocQualificaToponimo = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-ruolo_toponimo}d_voc_ruolo_toponimo"/>
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
        "dVocRuoloToponimo"
    })
    public static class FkVocRuoloToponimo {

        @XmlElement(name = "d_voc_ruolo_toponimo", namespace = "http://sas.beniculturali.it/catalogo/vocabolario-ruolo_toponimo")
        protected DVocRuoloToponimo dVocRuoloToponimo;

        /**
         * Gets the value of the dVocRuoloToponimo property.
         * 
         * @return
         *     possible object is
         *     {@link DVocRuoloToponimo }
         *     
         */
        public DVocRuoloToponimo getDVocRuoloToponimo() {
            return dVocRuoloToponimo;
        }

        /**
         * Sets the value of the dVocRuoloToponimo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocRuoloToponimo }
         *     
         */
        public void setDVocRuoloToponimo(DVocRuoloToponimo value) {
            this.dVocRuoloToponimo = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolario-toponimi}d_voc_toponimo"/>
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
        "dVocToponimo"
    })
    public static class FkVocToponimo {

        @XmlElement(name = "d_voc_toponimo", namespace = "http://sas.beniculturali.it/catalogo/vocabolario-toponimi")
        protected DVocToponimo dVocToponimo;

        /**
         * Gets the value of the dVocToponimo property.
         * 
         * @return
         *     possible object is
         *     {@link DVocToponimo }
         *     
         */
        public DVocToponimo getDVocToponimo() {
            return dVocToponimo;
        }

        /**
         * Sets the value of the dVocToponimo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocToponimo }
         *     
         */
        public void setDVocToponimo(DVocToponimo value) {
            this.dVocToponimo = value;
        }

    }

}