//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.27 at 02:03:47 PM CET 
//


package it.beniculturali.sas.catalogo.comparc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocMateriaSigillo;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocModoApposizione;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocNaturaSigillo;
import it.beniculturali.sas.catalogo.vocabolari_comparc.DVocRapportoDocumento;


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
 *         &lt;element name="fk_voc_natura_sigillo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_natura_sigillo"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_anno_inizio" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_anno_fine" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_datazione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_rapporto_documento">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_rapporto_documento"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_riferimento_documento" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_nota_diplomatico_archivistica" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_posizione_nel_documento" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_materia_sigillo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_materia_sigillo"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fk_voc_modo_apposizione" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_modo_apposizione"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text_descr_attacchi" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_sistema_protezione" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_altri_materiali" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_autenticita" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_descrizione_sigillo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_comparc_sigilli_descr" maxOccurs="unbounded" minOccurs="0"/>
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
    "fkVocNaturaSigillo",
    "textAnnoInizio",
    "textAnnoFine",
    "textDatazione",
    "fkVocRapportoDocumento",
    "textRiferimentoDocumento",
    "textNotaDiplomaticoArchivistica",
    "textPosizioneNelDocumento",
    "fkVocMateriaSigillo",
    "fkVocModoApposizione",
    "textDescrAttacchi",
    "textSistemaProtezione",
    "textAltriMateriali",
    "textAutenticita",
    "textDescrizioneSigillo",
    "dComparcSigilliDescr"
})
@XmlRootElement(name = "d_comparc_sigilli")
public class DComparcSigilli {

    @XmlElement(name = "fk_voc_natura_sigillo", required = true, nillable = true)
    protected DComparcSigilli.FkVocNaturaSigillo fkVocNaturaSigillo;
    @XmlElementRef(name = "text_anno_inizio", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textAnnoInizio;
    @XmlElementRef(name = "text_anno_fine", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textAnnoFine;
    @XmlElementRef(name = "text_datazione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textDatazione;
    @XmlElement(name = "fk_voc_rapporto_documento", required = true, nillable = true)
    protected DComparcSigilli.FkVocRapportoDocumento fkVocRapportoDocumento;
    @XmlElementRef(name = "text_riferimento_documento", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textRiferimentoDocumento;
    @XmlElementRef(name = "text_nota_diplomatico_archivistica", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textNotaDiplomaticoArchivistica;
    @XmlElementRef(name = "text_posizione_nel_documento", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textPosizioneNelDocumento;
    @XmlElement(name = "fk_voc_materia_sigillo", required = true, nillable = true)
    protected DComparcSigilli.FkVocMateriaSigillo fkVocMateriaSigillo;
    @XmlElementRef(name = "fk_voc_modo_apposizione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<DComparcSigilli.FkVocModoApposizione> fkVocModoApposizione;
    @XmlElementRef(name = "text_descr_attacchi", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textDescrAttacchi;
    @XmlElementRef(name = "text_sistema_protezione", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textSistemaProtezione;
    @XmlElementRef(name = "text_altri_materiali", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textAltriMateriali;
    @XmlElementRef(name = "text_autenticita", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textAutenticita;
    @XmlElementRef(name = "text_descrizione_sigillo", namespace = "http://sas.beniculturali.it/catalogo/comparc", type = JAXBElement.class)
    protected JAXBElement<String> textDescrizioneSigillo;
    @XmlElement(name = "d_comparc_sigilli_descr")
    protected List<DComparcSigilliDescr> dComparcSigilliDescr;

    /**
     * Gets the value of the fkVocNaturaSigillo property.
     * 
     * @return
     *     possible object is
     *     {@link DComparcSigilli.FkVocNaturaSigillo }
     *     
     */
    public DComparcSigilli.FkVocNaturaSigillo getFkVocNaturaSigillo() {
        return fkVocNaturaSigillo;
    }

    /**
     * Sets the value of the fkVocNaturaSigillo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DComparcSigilli.FkVocNaturaSigillo }
     *     
     */
    public void setFkVocNaturaSigillo(DComparcSigilli.FkVocNaturaSigillo value) {
        this.fkVocNaturaSigillo = value;
    }

    /**
     * Gets the value of the textAnnoInizio property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextAnnoInizio() {
        return textAnnoInizio;
    }

    /**
     * Sets the value of the textAnnoInizio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextAnnoInizio(JAXBElement<String> value) {
        this.textAnnoInizio = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textAnnoFine property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextAnnoFine() {
        return textAnnoFine;
    }

    /**
     * Sets the value of the textAnnoFine property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextAnnoFine(JAXBElement<String> value) {
        this.textAnnoFine = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textDatazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextDatazione() {
        return textDatazione;
    }

    /**
     * Sets the value of the textDatazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextDatazione(JAXBElement<String> value) {
        this.textDatazione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fkVocRapportoDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link DComparcSigilli.FkVocRapportoDocumento }
     *     
     */
    public DComparcSigilli.FkVocRapportoDocumento getFkVocRapportoDocumento() {
        return fkVocRapportoDocumento;
    }

    /**
     * Sets the value of the fkVocRapportoDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link DComparcSigilli.FkVocRapportoDocumento }
     *     
     */
    public void setFkVocRapportoDocumento(DComparcSigilli.FkVocRapportoDocumento value) {
        this.fkVocRapportoDocumento = value;
    }

    /**
     * Gets the value of the textRiferimentoDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextRiferimentoDocumento() {
        return textRiferimentoDocumento;
    }

    /**
     * Sets the value of the textRiferimentoDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextRiferimentoDocumento(JAXBElement<String> value) {
        this.textRiferimentoDocumento = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textNotaDiplomaticoArchivistica property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextNotaDiplomaticoArchivistica() {
        return textNotaDiplomaticoArchivistica;
    }

    /**
     * Sets the value of the textNotaDiplomaticoArchivistica property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextNotaDiplomaticoArchivistica(JAXBElement<String> value) {
        this.textNotaDiplomaticoArchivistica = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textPosizioneNelDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextPosizioneNelDocumento() {
        return textPosizioneNelDocumento;
    }

    /**
     * Sets the value of the textPosizioneNelDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextPosizioneNelDocumento(JAXBElement<String> value) {
        this.textPosizioneNelDocumento = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fkVocMateriaSigillo property.
     * 
     * @return
     *     possible object is
     *     {@link DComparcSigilli.FkVocMateriaSigillo }
     *     
     */
    public DComparcSigilli.FkVocMateriaSigillo getFkVocMateriaSigillo() {
        return fkVocMateriaSigillo;
    }

    /**
     * Sets the value of the fkVocMateriaSigillo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DComparcSigilli.FkVocMateriaSigillo }
     *     
     */
    public void setFkVocMateriaSigillo(DComparcSigilli.FkVocMateriaSigillo value) {
        this.fkVocMateriaSigillo = value;
    }

    /**
     * Gets the value of the fkVocModoApposizione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DComparcSigilli.FkVocModoApposizione }{@code >}
     *     
     */
    public JAXBElement<DComparcSigilli.FkVocModoApposizione> getFkVocModoApposizione() {
        return fkVocModoApposizione;
    }

    /**
     * Sets the value of the fkVocModoApposizione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DComparcSigilli.FkVocModoApposizione }{@code >}
     *     
     */
    public void setFkVocModoApposizione(JAXBElement<DComparcSigilli.FkVocModoApposizione> value) {
        this.fkVocModoApposizione = ((JAXBElement<DComparcSigilli.FkVocModoApposizione> ) value);
    }

    /**
     * Gets the value of the textDescrAttacchi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextDescrAttacchi() {
        return textDescrAttacchi;
    }

    /**
     * Sets the value of the textDescrAttacchi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextDescrAttacchi(JAXBElement<String> value) {
        this.textDescrAttacchi = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textSistemaProtezione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextSistemaProtezione() {
        return textSistemaProtezione;
    }

    /**
     * Sets the value of the textSistemaProtezione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextSistemaProtezione(JAXBElement<String> value) {
        this.textSistemaProtezione = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textAltriMateriali property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextAltriMateriali() {
        return textAltriMateriali;
    }

    /**
     * Sets the value of the textAltriMateriali property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextAltriMateriali(JAXBElement<String> value) {
        this.textAltriMateriali = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textAutenticita property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextAutenticita() {
        return textAutenticita;
    }

    /**
     * Sets the value of the textAutenticita property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextAutenticita(JAXBElement<String> value) {
        this.textAutenticita = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the textDescrizioneSigillo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTextDescrizioneSigillo() {
        return textDescrizioneSigillo;
    }

    /**
     * Sets the value of the textDescrizioneSigillo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTextDescrizioneSigillo(JAXBElement<String> value) {
        this.textDescrizioneSigillo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dComparcSigilliDescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dComparcSigilliDescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDComparcSigilliDescr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DComparcSigilliDescr }
     * 
     * 
     */
    public List<DComparcSigilliDescr> getDComparcSigilliDescr() {
        if (dComparcSigilliDescr == null) {
            dComparcSigilliDescr = new ArrayList<DComparcSigilliDescr>();
        }
        return this.dComparcSigilliDescr;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_materia_sigillo"/>
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
        "dVocMateriaSigillo"
    })
    public static class FkVocMateriaSigillo {

        @XmlElement(name = "d_voc_materia_sigillo", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocMateriaSigillo dVocMateriaSigillo;

        /**
         * Gets the value of the dVocMateriaSigillo property.
         * 
         * @return
         *     possible object is
         *     {@link DVocMateriaSigillo }
         *     
         */
        public DVocMateriaSigillo getDVocMateriaSigillo() {
            return dVocMateriaSigillo;
        }

        /**
         * Sets the value of the dVocMateriaSigillo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocMateriaSigillo }
         *     
         */
        public void setDVocMateriaSigillo(DVocMateriaSigillo value) {
            this.dVocMateriaSigillo = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_modo_apposizione"/>
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
        "dVocModoApposizione"
    })
    public static class FkVocModoApposizione {

        @XmlElement(name = "d_voc_modo_apposizione", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocModoApposizione dVocModoApposizione;

        /**
         * Gets the value of the dVocModoApposizione property.
         * 
         * @return
         *     possible object is
         *     {@link DVocModoApposizione }
         *     
         */
        public DVocModoApposizione getDVocModoApposizione() {
            return dVocModoApposizione;
        }

        /**
         * Sets the value of the dVocModoApposizione property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocModoApposizione }
         *     
         */
        public void setDVocModoApposizione(DVocModoApposizione value) {
            this.dVocModoApposizione = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_natura_sigillo"/>
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
        "dVocNaturaSigillo"
    })
    public static class FkVocNaturaSigillo {

        @XmlElement(name = "d_voc_natura_sigillo", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocNaturaSigillo dVocNaturaSigillo;

        /**
         * Gets the value of the dVocNaturaSigillo property.
         * 
         * @return
         *     possible object is
         *     {@link DVocNaturaSigillo }
         *     
         */
        public DVocNaturaSigillo getDVocNaturaSigillo() {
            return dVocNaturaSigillo;
        }

        /**
         * Sets the value of the dVocNaturaSigillo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocNaturaSigillo }
         *     
         */
        public void setDVocNaturaSigillo(DVocNaturaSigillo value) {
            this.dVocNaturaSigillo = value;
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
     *         &lt;element ref="{http://sas.beniculturali.it/catalogo/vocabolari-comparc}d_voc_rapporto_documento"/>
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
        "dVocRapportoDocumento"
    })
    public static class FkVocRapportoDocumento {

        @XmlElement(name = "d_voc_rapporto_documento", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-comparc")
        protected DVocRapportoDocumento dVocRapportoDocumento;

        /**
         * Gets the value of the dVocRapportoDocumento property.
         * 
         * @return
         *     possible object is
         *     {@link DVocRapportoDocumento }
         *     
         */
        public DVocRapportoDocumento getDVocRapportoDocumento() {
            return dVocRapportoDocumento;
        }

        /**
         * Sets the value of the dVocRapportoDocumento property.
         * 
         * @param value
         *     allowed object is
         *     {@link DVocRapportoDocumento }
         *     
         */
        public void setDVocRapportoDocumento(DVocRapportoDocumento value) {
            this.dVocRapportoDocumento = value;
        }

    }

}