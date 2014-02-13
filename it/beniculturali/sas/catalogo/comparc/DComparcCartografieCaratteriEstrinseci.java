//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.11 at 06:42:47 PM CET 
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
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocMediazioniGrafiche;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocProcGrafico;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipoMateriale;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipoNumerazione;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocTipoSupportoCart;


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
 *         &lt;element name="fk_voc_proc_grafico" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_proc_grafico"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_mediazioni_grafiche" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_mediazioni_grafiche"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_tipo_supporto_cart" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipo_supporto_cart"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_note_supporto" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nume_altezza" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *               &lt;minExclusive value="-1.0000"/>
 *               &lt;maxExclusive value="1.0000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nume_larghezza" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *               &lt;minExclusive value="-1.0000"/>
 *               &lt;maxExclusive value="1.0000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nume_spessore" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *               &lt;minExclusive value="-1.0000"/>
 *               &lt;maxExclusive value="1.0000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_dimensioni_raffigurazione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_tipo_materiale" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipo_materiale"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_tipo_numerazione" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipo_numerazione"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_note_numerazione" minOccurs="0">
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
    "fkVocProcGrafico",
    "fkVocMediazioniGrafiche",
    "fkVocTipoSupportoCart",
    "textNoteSupporto",
    "numeAltezza",
    "numeLarghezza",
    "numeSpessore",
    "textDimensioniRaffigurazione",
    "fkVocTipoMateriale",
    "fkVocTipoNumerazione",
    "textNoteNumerazione"
})
@XmlRootElement(name = "d_comparc_cartografie_caratteri_estrinseci")
public class DComparcCartografieCaratteriEstrinseci {

    @XmlElementRef(name = "fk_voc_proc_grafico", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocProcGrafico> fkVocProcGrafico;
    @XmlElementRef(name = "fk_voc_mediazioni_grafiche", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocMediazioniGrafiche> fkVocMediazioniGrafiche;
    @XmlElementRef(name = "fk_voc_tipo_supporto_cart", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocTipoSupportoCart> fkVocTipoSupportoCart;
    @XmlElementRef(name = "text_note_supporto", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textNoteSupporto;
    @XmlElementRef(name = "nume_altezza", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> numeAltezza;
    @XmlElementRef(name = "nume_larghezza", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> numeLarghezza;
    @XmlElementRef(name = "nume_spessore", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> numeSpessore;
    @XmlElementRef(name = "text_dimensioni_raffigurazione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textDimensioniRaffigurazione;
    @XmlElementRef(name = "fk_voc_tipo_materiale", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocTipoMateriale> fkVocTipoMateriale;
    @XmlElementRef(name = "fk_voc_tipo_numerazione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocTipoNumerazione> fkVocTipoNumerazione;
    @XmlElementRef(name = "text_note_numerazione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textNoteNumerazione;

    /**
     * Gets the value of the fkVocProcGrafico property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcCartografieCaratteriEstrinseci.FkVocProcGrafico }{@code >}
     *     
     */
    public JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocProcGrafico> getFkVocProcGrafico() {
        return fkVocProcGrafico;
    }

    /**
     * Sets the value of the fkVocProcGrafico property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcCartografieCaratteriEstrinseci.FkVocProcGrafico }{@code >}
     *     
     */
    public void setFkVocProcGrafico(JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocProcGrafico> value) {
        this.fkVocProcGrafico = ((JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocProcGrafico> ) value);
    }

    /**
     * Gets the value of the fkVocMediazioniGrafiche property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcCartografieCaratteriEstrinseci.FkVocMediazioniGrafiche }{@code >}
     *     
     */
    public JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocMediazioniGrafiche> getFkVocMediazioniGrafiche() {
        return fkVocMediazioniGrafiche;
    }

    /**
     * Sets the value of the fkVocMediazioniGrafiche property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcCartografieCaratteriEstrinseci.FkVocMediazioniGrafiche }{@code >}
     *     
     */
    public void setFkVocMediazioniGrafiche(JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocMediazioniGrafiche> value) {
        this.fkVocMediazioniGrafiche = ((JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocMediazioniGrafiche> ) value);
    }

    /**
     * Gets the value of the fkVocTipoSupportoCart property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcCartografieCaratteriEstrinseci.FkVocTipoSupportoCart }{@code >}
     *     
     */
    public JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocTipoSupportoCart> getFkVocTipoSupportoCart() {
        return fkVocTipoSupportoCart;
    }

    /**
     * Sets the value of the fkVocTipoSupportoCart property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcCartografieCaratteriEstrinseci.FkVocTipoSupportoCart }{@code >}
     *     
     */
    public void setFkVocTipoSupportoCart(JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocTipoSupportoCart> value) {
        this.fkVocTipoSupportoCart = ((JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocTipoSupportoCart> ) value);
    }

    /**
     * Gets the value of the textNoteSupporto property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNoteSupporto() {
        return textNoteSupporto;
    }

    /**
     * Sets the value of the textNoteSupporto property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNoteSupporto(JAXBElement<String> value) {
        this.textNoteSupporto = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the numeAltezza property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getNumeAltezza() {
        return numeAltezza;
    }

    /**
     * Sets the value of the numeAltezza property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setNumeAltezza(JAXBElement<BigDecimal> value) {
        this.numeAltezza = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the numeLarghezza property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getNumeLarghezza() {
        return numeLarghezza;
    }

    /**
     * Sets the value of the numeLarghezza property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setNumeLarghezza(JAXBElement<BigDecimal> value) {
        this.numeLarghezza = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the numeSpessore property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getNumeSpessore() {
        return numeSpessore;
    }

    /**
     * Sets the value of the numeSpessore property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setNumeSpessore(JAXBElement<BigDecimal> value) {
        this.numeSpessore = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the textDimensioniRaffigurazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextDimensioniRaffigurazione() {
        return textDimensioniRaffigurazione;
    }

    /**
     * Sets the value of the textDimensioniRaffigurazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextDimensioniRaffigurazione(JAXBElement<String> value) {
        this.textDimensioniRaffigurazione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fkVocTipoMateriale property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcCartografieCaratteriEstrinseci.FkVocTipoMateriale }{@code >}
     *     
     */
    public JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocTipoMateriale> getFkVocTipoMateriale() {
        return fkVocTipoMateriale;
    }

    /**
     * Sets the value of the fkVocTipoMateriale property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcCartografieCaratteriEstrinseci.FkVocTipoMateriale }{@code >}
     *     
     */
    public void setFkVocTipoMateriale(JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocTipoMateriale> value) {
        this.fkVocTipoMateriale = ((JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocTipoMateriale> ) value);
    }

    /**
     * Gets the value of the fkVocTipoNumerazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcCartografieCaratteriEstrinseci.FkVocTipoNumerazione }{@code >}
     *     
     */
    public JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocTipoNumerazione> getFkVocTipoNumerazione() {
        return fkVocTipoNumerazione;
    }

    /**
     * Sets the value of the fkVocTipoNumerazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcCartografieCaratteriEstrinseci.FkVocTipoNumerazione }{@code >}
     *     
     */
    public void setFkVocTipoNumerazione(JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocTipoNumerazione> value) {
        this.fkVocTipoNumerazione = ((JAXBElement<DComparcCartografieCaratteriEstrinseci.FkVocTipoNumerazione> ) value);
    }

    /**
     * Gets the value of the textNoteNumerazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNoteNumerazione() {
        return textNoteNumerazione;
    }

    /**
     * Sets the value of the textNoteNumerazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNoteNumerazione(JAXBElement<String> value) {
        this.textNoteNumerazione = ((JAXBElement<String> ) value);
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_mediazioni_grafiche"/>
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
        "dVocMediazioniGrafiche"
    })
    public static class FkVocMediazioniGrafiche {

        @XmlElement(name = "d_voc_mediazioni_grafiche", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocMediazioniGrafiche dVocMediazioniGrafiche;

        /**
         * Gets the value of the dVocMediazioniGrafiche property.
         * 
         * @return
         *     possible object is
         *     {@link DVocMediazioniGrafiche }
         *     
         */
        public DVocMediazioniGrafiche getDVocMediazioniGrafiche() {
            return dVocMediazioniGrafiche;
        }

        /**
         * Sets the value of the dVocMediazioniGrafiche property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocMediazioniGrafiche }
         *     
         */
        public void setDVocMediazioniGrafiche(DVocMediazioniGrafiche value) {
            this.dVocMediazioniGrafiche = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_proc_grafico"/>
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
        "dVocProcGrafico"
    })
    public static class FkVocProcGrafico {

        @XmlElement(name = "d_voc_proc_grafico", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocProcGrafico dVocProcGrafico;

        /**
         * Gets the value of the dVocProcGrafico property.
         * 
         * @return
         *     possible object is
         *     {@link DVocProcGrafico }
         *     
         */
        public DVocProcGrafico getDVocProcGrafico() {
            return dVocProcGrafico;
        }

        /**
         * Sets the value of the dVocProcGrafico property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocProcGrafico }
         *     
         */
        public void setDVocProcGrafico(DVocProcGrafico value) {
            this.dVocProcGrafico = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipo_materiale"/>
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
        "dVocTipoMateriale"
    })
    public static class FkVocTipoMateriale {

        @XmlElement(name = "d_voc_tipo_materiale", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocTipoMateriale dVocTipoMateriale;

        /**
         * Gets the value of the dVocTipoMateriale property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipoMateriale }
         *     
         */
        public DVocTipoMateriale getDVocTipoMateriale() {
            return dVocTipoMateriale;
        }

        /**
         * Sets the value of the dVocTipoMateriale property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipoMateriale }
         *     
         */
        public void setDVocTipoMateriale(DVocTipoMateriale value) {
            this.dVocTipoMateriale = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipo_numerazione"/>
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
        "dVocTipoNumerazione"
    })
    public static class FkVocTipoNumerazione {

        @XmlElement(name = "d_voc_tipo_numerazione", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocTipoNumerazione dVocTipoNumerazione;

        /**
         * Gets the value of the dVocTipoNumerazione property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipoNumerazione }
         *     
         */
        public DVocTipoNumerazione getDVocTipoNumerazione() {
            return dVocTipoNumerazione;
        }

        /**
         * Sets the value of the dVocTipoNumerazione property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipoNumerazione }
         *     
         */
        public void setDVocTipoNumerazione(DVocTipoNumerazione value) {
            this.dVocTipoNumerazione = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_tipo_supporto_cart"/>
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
        "dVocTipoSupportoCart"
    })
    public static class FkVocTipoSupportoCart {

        @XmlElement(name = "d_voc_tipo_supporto_cart", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocTipoSupportoCart dVocTipoSupportoCart;

        /**
         * Gets the value of the dVocTipoSupportoCart property.
         * 
         * @return
         *     possible object is
         *     {@link DVocTipoSupportoCart }
         *     
         */
        public DVocTipoSupportoCart getDVocTipoSupportoCart() {
            return dVocTipoSupportoCart;
        }

        /**
         * Sets the value of the dVocTipoSupportoCart property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocTipoSupportoCart }
         *     
         */
        public void setDVocTipoSupportoCart(DVocTipoSupportoCart value) {
            this.dVocTipoSupportoCart = value;
        }

    }

}
