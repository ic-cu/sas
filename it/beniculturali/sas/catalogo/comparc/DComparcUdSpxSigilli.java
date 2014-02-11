//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.11.07 at 10:27:57 AM CET 
//


package it.beniculturali.sas.catalogo.comparc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.beniculturali.sas.catalogo.commons.DCompilatore;
import it.beniculturali.sas.catalogo.commons.DUrl;


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
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}codi_provenienza"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}fk_voc_tipo_comparc"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}text_den_uniformata"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}fk_voc_stato_descrizione"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}flag_comparc_proprieta_statale_tf"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}fk_fonte"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_antiche_segnature" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}fk_voc_qualita_scheda" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}text_note" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_comparc_cond_accesso" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_comparc_categorie" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_comparc_area_tematica" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_comparc_voci_indice" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_rel_comparc_toponimi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_comparc_antroponimi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_comparc_famiglia" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_comparc_ente" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}text_contenuto" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}fk_voc_tipo_lingua_contenuto" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}fk_voc_tipo_scrittura_contenuto" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}flag_ordinamento_tf" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}fk_voc_stato_ordinamento" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}text_criteri_ordinamento" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}fk_voc_stato_inventariazione" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_comparc_doccoll" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/commons}d_url" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/commons}d_compilatore" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_comparc_sigilli" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_comparc_sigillo_fonti" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://sas.beniculturali.it/catalogo/comparc}d_comparc_titolari_sigilli" maxOccurs="unbounded" minOccurs="0"/>
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
    "fkVocTipoComparc",
    "textDenUniformata",
    "fkVocStatoDescrizione",
    "flagComparcProprietaStataleTf",
    "fkFonte",
    "dAnticheSegnature",
    "fkVocQualitaScheda",
    "textNote",
    "dComparcCondAccesso",
    "dComparcCategorie",
    "dComparcAreaTematica",
    "dComparcVociIndice",
    "dRelComparcToponimi",
    "dComparcAntroponimi",
    "dComparcFamiglia",
    "dComparcEnte",
    "textContenuto",
    "fkVocTipoLinguaContenuto",
    "fkVocTipoScritturaContenuto",
    "flagOrdinamentoTf",
    "fkVocStatoOrdinamento",
    "textCriteriOrdinamento",
    "fkVocStatoInventariazione",
    "dComparcDoccoll",
    "dUrl",
    "dCompilatore",
    "dComparcSigilli",
    "dComparcSigilloFonti",
    "dComparcTitolariSigilli"
})
@XmlRootElement(name = "d_comparc_ud_spx_sigilli")
public class DComparcUdSpxSigilli {

    @XmlElement(name = "codi_provenienza", required = true)
    protected String codiProvenienza;
    @XmlElement(name = "fk_voc_tipo_comparc", required = true)
    protected FkVocTipoComparc fkVocTipoComparc;
    @XmlElement(name = "text_den_uniformata", required = true)
    protected String textDenUniformata;
    @XmlElement(name = "fk_voc_stato_descrizione", required = true, nillable = true)
    protected FkVocStatoDescrizione fkVocStatoDescrizione;
    @XmlElement(name = "flag_comparc_proprieta_statale_tf", required = true, nillable = true)
    protected String flagComparcProprietaStataleTf;
    @XmlElement(name = "fk_fonte", required = true)
    protected FkFonte fkFonte;
    @XmlElement(name = "d_antiche_segnature")
    protected List<DAnticheSegnature> dAnticheSegnature;
    @XmlElement(name = "fk_voc_qualita_scheda", nillable = true)
    protected FkVocQualitaScheda fkVocQualitaScheda;
    @XmlElement(name = "text_note", nillable = true)
    protected String textNote;
    @XmlElement(name = "d_comparc_cond_accesso")
    protected List<DComparcCondAccesso> dComparcCondAccesso;
    @XmlElement(name = "d_comparc_categorie")
    protected List<DComparcCategorie> dComparcCategorie;
    @XmlElement(name = "d_comparc_area_tematica")
    protected List<DComparcAreaTematica> dComparcAreaTematica;
    @XmlElement(name = "d_comparc_voci_indice")
    protected List<DComparcVociIndice> dComparcVociIndice;
    @XmlElement(name = "d_rel_comparc_toponimi")
    protected List<DRelComparcToponimi> dRelComparcToponimi;
    @XmlElement(name = "d_comparc_antroponimi")
    protected List<DComparcAntroponimi> dComparcAntroponimi;
    @XmlElement(name = "d_comparc_famiglia")
    protected List<DComparcFamiglia> dComparcFamiglia;
    @XmlElement(name = "d_comparc_ente")
    protected List<DComparcEnte> dComparcEnte;
    @XmlElement(name = "text_contenuto", nillable = true)
    protected String textContenuto;
    @XmlElement(name = "fk_voc_tipo_lingua_contenuto", nillable = true)
    protected FkVocTipoLinguaContenuto fkVocTipoLinguaContenuto;
    @XmlElement(name = "fk_voc_tipo_scrittura_contenuto", nillable = true)
    protected FkVocTipoScritturaContenuto fkVocTipoScritturaContenuto;
    @XmlElement(name = "flag_ordinamento_tf", nillable = true)
    protected Boolean flagOrdinamentoTf;
    @XmlElement(name = "fk_voc_stato_ordinamento", nillable = true)
    protected FkVocStatoOrdinamento fkVocStatoOrdinamento;
    @XmlElement(name = "text_criteri_ordinamento", nillable = true)
    protected String textCriteriOrdinamento;
    @XmlElement(name = "fk_voc_stato_inventariazione", nillable = true)
    protected FkVocStatoInventariazione fkVocStatoInventariazione;
    @XmlElement(name = "d_comparc_doccoll")
    protected DComparcDoccoll dComparcDoccoll;
    @XmlElement(name = "d_url", namespace = "http://sas.beniculturali.it/catalogo/commons")
    protected List<DUrl> dUrl;
    @XmlElement(name = "d_compilatore", namespace = "http://sas.beniculturali.it/catalogo/commons")
    protected List<DCompilatore> dCompilatore;
    @XmlElement(name = "d_comparc_sigilli")
    protected List<DComparcSigilli> dComparcSigilli;
    @XmlElement(name = "d_comparc_sigillo_fonti")
    protected List<DComparcSigilloFonti> dComparcSigilloFonti;
    @XmlElement(name = "d_comparc_titolari_sigilli")
    protected List<DComparcTitolariSigilli> dComparcTitolariSigilli;

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
     * Gets the value of the fkVocTipoComparc property.
     * 
     * @return
     *     possible object is
     *     {@link FkVocTipoComparc }
     *     
     */
    public FkVocTipoComparc getFkVocTipoComparc() {
        return fkVocTipoComparc;
    }

    /**
     * Sets the value of the fkVocTipoComparc property.
     * 
     * @param value
     *     allowed object is
     *     {@link FkVocTipoComparc }
     *     
     */
    public void setFkVocTipoComparc(FkVocTipoComparc value) {
        this.fkVocTipoComparc = value;
    }

    /**
     * Gets the value of the textDenUniformata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextDenUniformata() {
        return textDenUniformata;
    }

    /**
     * Sets the value of the textDenUniformata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextDenUniformata(String value) {
        this.textDenUniformata = value;
    }

    /**
     * Gets the value of the fkVocStatoDescrizione property.
     * 
     * @return
     *     possible object is
     *     {@link FkVocStatoDescrizione }
     *     
     */
    public FkVocStatoDescrizione getFkVocStatoDescrizione() {
        return fkVocStatoDescrizione;
    }

    /**
     * Sets the value of the fkVocStatoDescrizione property.
     * 
     * @param value
     *     allowed object is
     *     {@link FkVocStatoDescrizione }
     *     
     */
    public void setFkVocStatoDescrizione(FkVocStatoDescrizione value) {
        this.fkVocStatoDescrizione = value;
    }

    /**
     * Gets the value of the flagComparcProprietaStataleTf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagComparcProprietaStataleTf() {
        return flagComparcProprietaStataleTf;
    }

    /**
     * Sets the value of the flagComparcProprietaStataleTf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagComparcProprietaStataleTf(String value) {
        this.flagComparcProprietaStataleTf = value;
    }

    /**
     * Gets the value of the fkFonte property.
     * 
     * @return
     *     possible object is
     *     {@link FkFonte }
     *     
     */
    public FkFonte getFkFonte() {
        return fkFonte;
    }

    /**
     * Sets the value of the fkFonte property.
     * 
     * @param value
     *     allowed object is
     *     {@link FkFonte }
     *     
     */
    public void setFkFonte(FkFonte value) {
        this.fkFonte = value;
    }

    /**
     * Gets the value of the dAnticheSegnature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dAnticheSegnature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDAnticheSegnature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DAnticheSegnature }
     * 
     * 
     */
    public List<DAnticheSegnature> getDAnticheSegnature() {
        if (dAnticheSegnature == null) {
            dAnticheSegnature = new ArrayList<DAnticheSegnature>();
        }
        return this.dAnticheSegnature;
    }

    /**
     * Gets the value of the fkVocQualitaScheda property.
     * 
     * @return
     *     possible object is
     *     {@link FkVocQualitaScheda }
     *     
     */
    public FkVocQualitaScheda getFkVocQualitaScheda() {
        return fkVocQualitaScheda;
    }

    /**
     * Sets the value of the fkVocQualitaScheda property.
     * 
     * @param value
     *     allowed object is
     *     {@link FkVocQualitaScheda }
     *     
     */
    public void setFkVocQualitaScheda(FkVocQualitaScheda value) {
        this.fkVocQualitaScheda = value;
    }

    /**
     * Gets the value of the textNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextNote() {
        return textNote;
    }

    /**
     * Sets the value of the textNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextNote(String value) {
        this.textNote = value;
    }

    /**
     * Gets the value of the dComparcCondAccesso property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dComparcCondAccesso property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDComparcCondAccesso().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DComparcCondAccesso }
     * 
     * 
     */
    public List<DComparcCondAccesso> getDComparcCondAccesso() {
        if (dComparcCondAccesso == null) {
            dComparcCondAccesso = new ArrayList<DComparcCondAccesso>();
        }
        return this.dComparcCondAccesso;
    }

    /**
     * Gets the value of the dComparcCategorie property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dComparcCategorie property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDComparcCategorie().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DComparcCategorie }
     * 
     * 
     */
    public List<DComparcCategorie> getDComparcCategorie() {
        if (dComparcCategorie == null) {
            dComparcCategorie = new ArrayList<DComparcCategorie>();
        }
        return this.dComparcCategorie;
    }

    /**
     * Gets the value of the dComparcAreaTematica property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dComparcAreaTematica property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDComparcAreaTematica().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DComparcAreaTematica }
     * 
     * 
     */
    public List<DComparcAreaTematica> getDComparcAreaTematica() {
        if (dComparcAreaTematica == null) {
            dComparcAreaTematica = new ArrayList<DComparcAreaTematica>();
        }
        return this.dComparcAreaTematica;
    }

    /**
     * Gets the value of the dComparcVociIndice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dComparcVociIndice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDComparcVociIndice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DComparcVociIndice }
     * 
     * 
     */
    public List<DComparcVociIndice> getDComparcVociIndice() {
        if (dComparcVociIndice == null) {
            dComparcVociIndice = new ArrayList<DComparcVociIndice>();
        }
        return this.dComparcVociIndice;
    }

    /**
     * Gets the value of the dRelComparcToponimi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dRelComparcToponimi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDRelComparcToponimi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DRelComparcToponimi }
     * 
     * 
     */
    public List<DRelComparcToponimi> getDRelComparcToponimi() {
        if (dRelComparcToponimi == null) {
            dRelComparcToponimi = new ArrayList<DRelComparcToponimi>();
        }
        return this.dRelComparcToponimi;
    }

    /**
     * Gets the value of the dComparcAntroponimi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dComparcAntroponimi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDComparcAntroponimi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DComparcAntroponimi }
     * 
     * 
     */
    public List<DComparcAntroponimi> getDComparcAntroponimi() {
        if (dComparcAntroponimi == null) {
            dComparcAntroponimi = new ArrayList<DComparcAntroponimi>();
        }
        return this.dComparcAntroponimi;
    }

    /**
     * Gets the value of the dComparcFamiglia property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dComparcFamiglia property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDComparcFamiglia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DComparcFamiglia }
     * 
     * 
     */
    public List<DComparcFamiglia> getDComparcFamiglia() {
        if (dComparcFamiglia == null) {
            dComparcFamiglia = new ArrayList<DComparcFamiglia>();
        }
        return this.dComparcFamiglia;
    }

    /**
     * Gets the value of the dComparcEnte property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dComparcEnte property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDComparcEnte().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DComparcEnte }
     * 
     * 
     */
    public List<DComparcEnte> getDComparcEnte() {
        if (dComparcEnte == null) {
            dComparcEnte = new ArrayList<DComparcEnte>();
        }
        return this.dComparcEnte;
    }

    /**
     * Gets the value of the textContenuto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextContenuto() {
        return textContenuto;
    }

    /**
     * Sets the value of the textContenuto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextContenuto(String value) {
        this.textContenuto = value;
    }

    /**
     * Gets the value of the fkVocTipoLinguaContenuto property.
     * 
     * @return
     *     possible object is
     *     {@link FkVocTipoLinguaContenuto }
     *     
     */
    public FkVocTipoLinguaContenuto getFkVocTipoLinguaContenuto() {
        return fkVocTipoLinguaContenuto;
    }

    /**
     * Sets the value of the fkVocTipoLinguaContenuto property.
     * 
     * @param value
     *     allowed object is
     *     {@link FkVocTipoLinguaContenuto }
     *     
     */
    public void setFkVocTipoLinguaContenuto(FkVocTipoLinguaContenuto value) {
        this.fkVocTipoLinguaContenuto = value;
    }

    /**
     * Gets the value of the fkVocTipoScritturaContenuto property.
     * 
     * @return
     *     possible object is
     *     {@link FkVocTipoScritturaContenuto }
     *     
     */
    public FkVocTipoScritturaContenuto getFkVocTipoScritturaContenuto() {
        return fkVocTipoScritturaContenuto;
    }

    /**
     * Sets the value of the fkVocTipoScritturaContenuto property.
     * 
     * @param value
     *     allowed object is
     *     {@link FkVocTipoScritturaContenuto }
     *     
     */
    public void setFkVocTipoScritturaContenuto(FkVocTipoScritturaContenuto value) {
        this.fkVocTipoScritturaContenuto = value;
    }

    /**
     * Gets the value of the flagOrdinamentoTf property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlagOrdinamentoTf() {
        return flagOrdinamentoTf;
    }

    /**
     * Sets the value of the flagOrdinamentoTf property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlagOrdinamentoTf(Boolean value) {
        this.flagOrdinamentoTf = value;
    }

    /**
     * Gets the value of the fkVocStatoOrdinamento property.
     * 
     * @return
     *     possible object is
     *     {@link FkVocStatoOrdinamento }
     *     
     */
    public FkVocStatoOrdinamento getFkVocStatoOrdinamento() {
        return fkVocStatoOrdinamento;
    }

    /**
     * Sets the value of the fkVocStatoOrdinamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link FkVocStatoOrdinamento }
     *     
     */
    public void setFkVocStatoOrdinamento(FkVocStatoOrdinamento value) {
        this.fkVocStatoOrdinamento = value;
    }

    /**
     * Gets the value of the textCriteriOrdinamento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextCriteriOrdinamento() {
        return textCriteriOrdinamento;
    }

    /**
     * Sets the value of the textCriteriOrdinamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextCriteriOrdinamento(String value) {
        this.textCriteriOrdinamento = value;
    }

    /**
     * Gets the value of the fkVocStatoInventariazione property.
     * 
     * @return
     *     possible object is
     *     {@link FkVocStatoInventariazione }
     *     
     */
    public FkVocStatoInventariazione getFkVocStatoInventariazione() {
        return fkVocStatoInventariazione;
    }

    /**
     * Sets the value of the fkVocStatoInventariazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link FkVocStatoInventariazione }
     *     
     */
    public void setFkVocStatoInventariazione(FkVocStatoInventariazione value) {
        this.fkVocStatoInventariazione = value;
    }

    /**
     * Gets the value of the dComparcDoccoll property.
     * 
     * @return
     *     possible object is
     *     {@link DComparcDoccoll }
     *     
     */
    public DComparcDoccoll getDComparcDoccoll() {
        return dComparcDoccoll;
    }

    /**
     * Sets the value of the dComparcDoccoll property.
     * 
     * @param value
     *     allowed object is
     *     {@link DComparcDoccoll }
     *     
     */
    public void setDComparcDoccoll(DComparcDoccoll value) {
        this.dComparcDoccoll = value;
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
     * Gets the value of the dComparcSigilli property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dComparcSigilli property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDComparcSigilli().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DComparcSigilli }
     * 
     * 
     */
    public List<DComparcSigilli> getDComparcSigilli() {
        if (dComparcSigilli == null) {
            dComparcSigilli = new ArrayList<DComparcSigilli>();
        }
        return this.dComparcSigilli;
    }

    /**
     * Gets the value of the dComparcSigilloFonti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dComparcSigilloFonti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDComparcSigilloFonti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DComparcSigilloFonti }
     * 
     * 
     */
    public List<DComparcSigilloFonti> getDComparcSigilloFonti() {
        if (dComparcSigilloFonti == null) {
            dComparcSigilloFonti = new ArrayList<DComparcSigilloFonti>();
        }
        return this.dComparcSigilloFonti;
    }

    /**
     * Gets the value of the dComparcTitolariSigilli property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dComparcTitolariSigilli property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDComparcTitolariSigilli().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DComparcTitolariSigilli }
     * 
     * 
     */
    public List<DComparcTitolariSigilli> getDComparcTitolariSigilli() {
        if (dComparcTitolariSigilli == null) {
            dComparcTitolariSigilli = new ArrayList<DComparcTitolariSigilli>();
        }
        return this.dComparcTitolariSigilli;
    }

}
