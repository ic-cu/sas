//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.25 at 03:07:39 PM CET 
//


package it.beniculturali.sas.catalogo.commons;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.beniculturali.sas.catalogo.commons package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Secoli_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "secoli");
    private final static QName _DCompilatoreFkVocTipoLingua_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "fk_voc_tipo_lingua");
    private final static QName _DCompilatoreTextNote_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_note");
    private final static QName _DCompilatoreFkVocTipoScrittura_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "fk_voc_tipo_scrittura");
    private final static QName _DSogcStatoLocaliDateAccertamento_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "date_accertamento");
    private final static QName _DSogcStatoLocaliNumeMetriLineari_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "nume_metri_lineari");
    private final static QName _DSogcStatoLocaliDescrStatoAntincendio_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "descr_stato_antincendio");
    private final static QName _DSogcStatoLocaliFlagStatoRischioTf_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "flag_stato_rischio_tf");
    private final static QName _DSogcStatoLocaliFkVocTipoUsoLocali_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "fk_voc_tipo_uso_locali");
    private final static QName _DSogcStatoLocaliTextStatoLocali_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_stato_locali");
    private final static QName _DSogcStatoLocaliDescrStatoRischio_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "descr_stato_rischio");
    private final static QName _DSogcStatoLocaliDescrStatoAttrezzature_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "descr_stato_attrezzature");
    private final static QName _DSogcStatoLocaliDateRilevamento_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "date_rilevamento");
    private final static QName _DSogcStatoLocaliFkVocStatoLocali_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "fk_voc_stato_locali");
    private final static QName _DSogcStatoLocaliFlagSpaziIncrementiTf_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "flag_spazi_incrementi_tf");
    private final static QName _DSogcStatoLocaliDescrStatoClimatizzazione_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "descr_stato_climatizzazione");
    private final static QName _DSogcStatoLocaliDescrStatoImpiantoElettrico_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "descr_stato_impianto_elettrico");
    private final static QName _DSogcStatoLocaliDescrStatoAntintrusione_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "descr_stato_antintrusione");
    private final static QName _DSogcStatoLocaliFlagIdoneitaAmbientaleTf_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "flag_idoneita_ambientale_tf");
    private final static QName _DUrlTextDescrUrl_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_descr_url");
    private final static QName _DUrlDateUrl_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "date_url");
    private final static QName _DTopografiaLocNumeMetriLineariDisp_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "nume_metri_lineari_disp");
    private final static QName _DTopografiaLocNumeVisualizzazione_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "nume_visualizzazione");
    private final static QName _DLocalizzazioneTextOrariApertura_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_orari_apertura");
    private final static QName _DLocalizzazioneFlgLocalizzazioneAttivaNy_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "flg_localizzazione_attiva_ny");
    private final static QName _DLocalizzazioneTextNoteLocalizzazione_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_note_localizzazione");
    private final static QName _DLocalizzazioneTextFax_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_fax");
    private final static QName _DLocalizzazioneTextDenComuneParallela_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_den_comune_parallela");
    private final static QName _DLocalizzazioneTextServiziRiproduzione_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_servizi_riproduzione");
    private final static QName _DLocalizzazioneFkProvincia_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "fk_provincia");
    private final static QName _DLocalizzazioneDataAccertamento_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "data_accertamento");
    private final static QName _DLocalizzazioneTextAccessibilita_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_accessibilita");
    private final static QName _DLocalizzazioneFlgImmobileVincolatiIny_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "flg_immobile_vincolati_iny");
    private final static QName _DLocalizzazioneTextNoteLocAttrezzataCons_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_note_loc_attrezzata_cons");
    private final static QName _DLocalizzazioneTextUrlweb_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_urlweb");
    private final static QName _DLocalizzazioneTextServiziRicerca_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_servizi_ricerca");
    private final static QName _DLocalizzazioneFkRegione_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "fk_regione");
    private final static QName _DLocalizzazioneTextDenProvParallela_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_den_prov_parallela");
    private final static QName _DLocalizzazioneTextNoteAttrezzataDidattica_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_note_attrezzata_didattica");
    private final static QName _DLocalizzazioneFlgLocAttrezzataDidatticaIny_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "flg_loc_attrezzata_didattica_iny");
    private final static QName _DLocalizzazioneTextTelefono_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_telefono");
    private final static QName _DLocalizzazioneTextSpaziPubblico_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_spazi_pubblico");
    private final static QName _DLocalizzazioneTextEmail_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_email");
    private final static QName _DLocalizzazioneTextCap_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_cap");
    private final static QName _DLocalizzazioneFlgLocAttrezzataConsultazioneIny_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "flg_loc_attrezzata_consultazione_iny");
    private final static QName _DLocalizzazioneTextCondReqAccesso_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_cond_req_accesso");
    private final static QName _DLocalizzazioneTextDenEdificio_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_den_edificio");
    private final static QName _DLocalizzazioneFkIstatComune_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "fk_istat_comune");
    private final static QName _DContattiTextIndirizzo_QNAME = new QName("http://sas.beniculturali.it/catalogo/commons", "text_indirizzo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.beniculturali.sas.catalogo.commons
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DLocalizzazione.FkIstatComune }
     * 
     */
    public DLocalizzazione.FkIstatComune createDLocalizzazioneFkIstatComune() {
        return new DLocalizzazione.FkIstatComune();
    }

    /**
     * Create an instance of {@link DCompilatore.FkVocTipoLingua }
     * 
     */
    public DCompilatore.FkVocTipoLingua createDCompilatoreFkVocTipoLingua() {
        return new DCompilatore.FkVocTipoLingua();
    }

    /**
     * Create an instance of {@link DUrl }
     * 
     */
    public DUrl createDUrl() {
        return new DUrl();
    }

    /**
     * Create an instance of {@link DTopografiaLoc }
     * 
     */
    public DTopografiaLoc createDTopografiaLoc() {
        return new DTopografiaLoc();
    }

    /**
     * Create an instance of {@link DLocalizzazione }
     * 
     */
    public DLocalizzazione createDLocalizzazione() {
        return new DLocalizzazione();
    }

    /**
     * Create an instance of {@link DCompilatore.FkVocTipoScrittura }
     * 
     */
    public DCompilatore.FkVocTipoScrittura createDCompilatoreFkVocTipoScrittura() {
        return new DCompilatore.FkVocTipoScrittura();
    }

    /**
     * Create an instance of {@link DCompilatore.FkVocTipoIntervento }
     * 
     */
    public DCompilatore.FkVocTipoIntervento createDCompilatoreFkVocTipoIntervento() {
        return new DCompilatore.FkVocTipoIntervento();
    }

    /**
     * Create an instance of {@link DLocalizzazione.FkProvincia }
     * 
     */
    public DLocalizzazione.FkProvincia createDLocalizzazioneFkProvincia() {
        return new DLocalizzazione.FkProvincia();
    }

    /**
     * Create an instance of {@link DTopografiaLoc.FkVocTipoContenitore }
     * 
     */
    public DTopografiaLoc.FkVocTipoContenitore createDTopografiaLocFkVocTipoContenitore() {
        return new DTopografiaLoc.FkVocTipoContenitore();
    }

    /**
     * Create an instance of {@link DContatti }
     * 
     */
    public DContatti createDContatti() {
        return new DContatti();
    }

    /**
     * Create an instance of {@link DLocalizzazione.FkRegione }
     * 
     */
    public DLocalizzazione.FkRegione createDLocalizzazioneFkRegione() {
        return new DLocalizzazione.FkRegione();
    }

    /**
     * Create an instance of {@link DSogcStatoLocali.FkVocTipoUsoLocali }
     * 
     */
    public DSogcStatoLocali.FkVocTipoUsoLocali createDSogcStatoLocaliFkVocTipoUsoLocali() {
        return new DSogcStatoLocali.FkVocTipoUsoLocali();
    }

    /**
     * Create an instance of {@link DCompilatore }
     * 
     */
    public DCompilatore createDCompilatore() {
        return new DCompilatore();
    }

    /**
     * Create an instance of {@link DSogcStatoLocali }
     * 
     */
    public DSogcStatoLocali createDSogcStatoLocali() {
        return new DSogcStatoLocali();
    }

    /**
     * Create an instance of {@link DSogcStatoLocali.FkVocStatoLocali }
     * 
     */
    public DSogcStatoLocali.FkVocStatoLocali createDSogcStatoLocaliFkVocStatoLocali() {
        return new DSogcStatoLocali.FkVocStatoLocali();
    }

    /**
     * Create an instance of {@link DContatti.FkVocTipoContatto }
     * 
     */
    public DContatti.FkVocTipoContatto createDContattiFkVocTipoContatto() {
        return new DContatti.FkVocTipoContatto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "secoli")
    public JAXBElement<String> createSecoli(String value) {
        return new JAXBElement<String>(_Secoli_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DCompilatore.FkVocTipoLingua }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "fk_voc_tipo_lingua", scope = DCompilatore.class)
    public JAXBElement<DCompilatore.FkVocTipoLingua> createDCompilatoreFkVocTipoLingua(DCompilatore.FkVocTipoLingua value) {
        return new JAXBElement<DCompilatore.FkVocTipoLingua>(_DCompilatoreFkVocTipoLingua_QNAME, DCompilatore.FkVocTipoLingua.class, DCompilatore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_note", scope = DCompilatore.class)
    public JAXBElement<String> createDCompilatoreTextNote(String value) {
        return new JAXBElement<String>(_DCompilatoreTextNote_QNAME, String.class, DCompilatore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DCompilatore.FkVocTipoScrittura }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "fk_voc_tipo_scrittura", scope = DCompilatore.class)
    public JAXBElement<DCompilatore.FkVocTipoScrittura> createDCompilatoreFkVocTipoScrittura(DCompilatore.FkVocTipoScrittura value) {
        return new JAXBElement<DCompilatore.FkVocTipoScrittura>(_DCompilatoreFkVocTipoScrittura_QNAME, DCompilatore.FkVocTipoScrittura.class, DCompilatore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "date_accertamento", scope = DSogcStatoLocali.class)
    public JAXBElement<XMLGregorianCalendar> createDSogcStatoLocaliDateAccertamento(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DSogcStatoLocaliDateAccertamento_QNAME, XMLGregorianCalendar.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "nume_metri_lineari", scope = DSogcStatoLocali.class)
    public JAXBElement<BigDecimal> createDSogcStatoLocaliNumeMetriLineari(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DSogcStatoLocaliNumeMetriLineari_QNAME, BigDecimal.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "descr_stato_antincendio", scope = DSogcStatoLocali.class)
    public JAXBElement<String> createDSogcStatoLocaliDescrStatoAntincendio(String value) {
        return new JAXBElement<String>(_DSogcStatoLocaliDescrStatoAntincendio_QNAME, String.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "flag_stato_rischio_tf", scope = DSogcStatoLocali.class, defaultValue = "f")
    public JAXBElement<String> createDSogcStatoLocaliFlagStatoRischioTf(String value) {
        return new JAXBElement<String>(_DSogcStatoLocaliFlagStatoRischioTf_QNAME, String.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DSogcStatoLocali.FkVocTipoUsoLocali }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "fk_voc_tipo_uso_locali", scope = DSogcStatoLocali.class)
    public JAXBElement<DSogcStatoLocali.FkVocTipoUsoLocali> createDSogcStatoLocaliFkVocTipoUsoLocali(DSogcStatoLocali.FkVocTipoUsoLocali value) {
        return new JAXBElement<DSogcStatoLocali.FkVocTipoUsoLocali>(_DSogcStatoLocaliFkVocTipoUsoLocali_QNAME, DSogcStatoLocali.FkVocTipoUsoLocali.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_stato_locali", scope = DSogcStatoLocali.class)
    public JAXBElement<String> createDSogcStatoLocaliTextStatoLocali(String value) {
        return new JAXBElement<String>(_DSogcStatoLocaliTextStatoLocali_QNAME, String.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "descr_stato_rischio", scope = DSogcStatoLocali.class)
    public JAXBElement<String> createDSogcStatoLocaliDescrStatoRischio(String value) {
        return new JAXBElement<String>(_DSogcStatoLocaliDescrStatoRischio_QNAME, String.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "descr_stato_attrezzature", scope = DSogcStatoLocali.class)
    public JAXBElement<String> createDSogcStatoLocaliDescrStatoAttrezzature(String value) {
        return new JAXBElement<String>(_DSogcStatoLocaliDescrStatoAttrezzature_QNAME, String.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "date_rilevamento", scope = DSogcStatoLocali.class)
    public JAXBElement<XMLGregorianCalendar> createDSogcStatoLocaliDateRilevamento(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DSogcStatoLocaliDateRilevamento_QNAME, XMLGregorianCalendar.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DSogcStatoLocali.FkVocStatoLocali }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "fk_voc_stato_locali", scope = DSogcStatoLocali.class)
    public JAXBElement<DSogcStatoLocali.FkVocStatoLocali> createDSogcStatoLocaliFkVocStatoLocali(DSogcStatoLocali.FkVocStatoLocali value) {
        return new JAXBElement<DSogcStatoLocali.FkVocStatoLocali>(_DSogcStatoLocaliFkVocStatoLocali_QNAME, DSogcStatoLocali.FkVocStatoLocali.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "flag_spazi_incrementi_tf", scope = DSogcStatoLocali.class, defaultValue = "f")
    public JAXBElement<String> createDSogcStatoLocaliFlagSpaziIncrementiTf(String value) {
        return new JAXBElement<String>(_DSogcStatoLocaliFlagSpaziIncrementiTf_QNAME, String.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "descr_stato_climatizzazione", scope = DSogcStatoLocali.class)
    public JAXBElement<String> createDSogcStatoLocaliDescrStatoClimatizzazione(String value) {
        return new JAXBElement<String>(_DSogcStatoLocaliDescrStatoClimatizzazione_QNAME, String.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "descr_stato_impianto_elettrico", scope = DSogcStatoLocali.class)
    public JAXBElement<String> createDSogcStatoLocaliDescrStatoImpiantoElettrico(String value) {
        return new JAXBElement<String>(_DSogcStatoLocaliDescrStatoImpiantoElettrico_QNAME, String.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "descr_stato_antintrusione", scope = DSogcStatoLocali.class)
    public JAXBElement<String> createDSogcStatoLocaliDescrStatoAntintrusione(String value) {
        return new JAXBElement<String>(_DSogcStatoLocaliDescrStatoAntintrusione_QNAME, String.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "flag_idoneita_ambientale_tf", scope = DSogcStatoLocali.class, defaultValue = "f")
    public JAXBElement<String> createDSogcStatoLocaliFlagIdoneitaAmbientaleTf(String value) {
        return new JAXBElement<String>(_DSogcStatoLocaliFlagIdoneitaAmbientaleTf_QNAME, String.class, DSogcStatoLocali.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_descr_url", scope = DUrl.class)
    public JAXBElement<String> createDUrlTextDescrUrl(String value) {
        return new JAXBElement<String>(_DUrlTextDescrUrl_QNAME, String.class, DUrl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "date_url", scope = DUrl.class)
    public JAXBElement<XMLGregorianCalendar> createDUrlDateUrl(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DUrlDateUrl_QNAME, XMLGregorianCalendar.class, DUrl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "nume_metri_lineari_disp", scope = DTopografiaLoc.class)
    public JAXBElement<BigDecimal> createDTopografiaLocNumeMetriLineariDisp(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DTopografiaLocNumeMetriLineariDisp_QNAME, BigDecimal.class, DTopografiaLoc.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "nume_visualizzazione", scope = DTopografiaLoc.class)
    public JAXBElement<Integer> createDTopografiaLocNumeVisualizzazione(Integer value) {
        return new JAXBElement<Integer>(_DTopografiaLocNumeVisualizzazione_QNAME, Integer.class, DTopografiaLoc.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_orari_apertura", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextOrariApertura(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextOrariApertura_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "flg_localizzazione_attiva_ny", scope = DLocalizzazione.class, defaultValue = "N")
    public JAXBElement<String> createDLocalizzazioneFlgLocalizzazioneAttivaNy(String value) {
        return new JAXBElement<String>(_DLocalizzazioneFlgLocalizzazioneAttivaNy_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_note_localizzazione", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextNoteLocalizzazione(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextNoteLocalizzazione_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_fax", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextFax(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextFax_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_den_comune_parallela", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextDenComuneParallela(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextDenComuneParallela_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_servizi_riproduzione", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextServiziRiproduzione(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextServiziRiproduzione_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DLocalizzazione.FkProvincia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "fk_provincia", scope = DLocalizzazione.class)
    public JAXBElement<DLocalizzazione.FkProvincia> createDLocalizzazioneFkProvincia(DLocalizzazione.FkProvincia value) {
        return new JAXBElement<DLocalizzazione.FkProvincia>(_DLocalizzazioneFkProvincia_QNAME, DLocalizzazione.FkProvincia.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "data_accertamento", scope = DLocalizzazione.class)
    public JAXBElement<XMLGregorianCalendar> createDLocalizzazioneDataAccertamento(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DLocalizzazioneDataAccertamento_QNAME, XMLGregorianCalendar.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_accessibilita", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextAccessibilita(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextAccessibilita_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "flg_immobile_vincolati_iny", scope = DLocalizzazione.class, defaultValue = "I")
    public JAXBElement<String> createDLocalizzazioneFlgImmobileVincolatiIny(String value) {
        return new JAXBElement<String>(_DLocalizzazioneFlgImmobileVincolatiIny_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_note_loc_attrezzata_cons", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextNoteLocAttrezzataCons(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextNoteLocAttrezzataCons_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_urlweb", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextUrlweb(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextUrlweb_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_servizi_ricerca", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextServiziRicerca(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextServiziRicerca_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DLocalizzazione.FkRegione }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "fk_regione", scope = DLocalizzazione.class)
    public JAXBElement<DLocalizzazione.FkRegione> createDLocalizzazioneFkRegione(DLocalizzazione.FkRegione value) {
        return new JAXBElement<DLocalizzazione.FkRegione>(_DLocalizzazioneFkRegione_QNAME, DLocalizzazione.FkRegione.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_den_prov_parallela", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextDenProvParallela(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextDenProvParallela_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_note_attrezzata_didattica", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextNoteAttrezzataDidattica(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextNoteAttrezzataDidattica_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "flg_loc_attrezzata_didattica_iny", scope = DLocalizzazione.class, defaultValue = "I")
    public JAXBElement<String> createDLocalizzazioneFlgLocAttrezzataDidatticaIny(String value) {
        return new JAXBElement<String>(_DLocalizzazioneFlgLocAttrezzataDidatticaIny_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_telefono", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextTelefono(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextTelefono_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_spazi_pubblico", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextSpaziPubblico(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextSpaziPubblico_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_email", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextEmail(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextEmail_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_cap", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextCap(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextCap_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "flg_loc_attrezzata_consultazione_iny", scope = DLocalizzazione.class, defaultValue = "I")
    public JAXBElement<String> createDLocalizzazioneFlgLocAttrezzataConsultazioneIny(String value) {
        return new JAXBElement<String>(_DLocalizzazioneFlgLocAttrezzataConsultazioneIny_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_cond_req_accesso", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextCondReqAccesso(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextCondReqAccesso_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_den_edificio", scope = DLocalizzazione.class)
    public JAXBElement<String> createDLocalizzazioneTextDenEdificio(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextDenEdificio_QNAME, String.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DLocalizzazione.FkIstatComune }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "fk_istat_comune", scope = DLocalizzazione.class)
    public JAXBElement<DLocalizzazione.FkIstatComune> createDLocalizzazioneFkIstatComune(DLocalizzazione.FkIstatComune value) {
        return new JAXBElement<DLocalizzazione.FkIstatComune>(_DLocalizzazioneFkIstatComune_QNAME, DLocalizzazione.FkIstatComune.class, DLocalizzazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_indirizzo", scope = DContatti.class)
    public JAXBElement<String> createDContattiTextIndirizzo(String value) {
        return new JAXBElement<String>(_DContattiTextIndirizzo_QNAME, String.class, DContatti.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_note", scope = DContatti.class)
    public JAXBElement<String> createDContattiTextNote(String value) {
        return new JAXBElement<String>(_DCompilatoreTextNote_QNAME, String.class, DContatti.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_telefono", scope = DContatti.class)
    public JAXBElement<String> createDContattiTextTelefono(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextTelefono_QNAME, String.class, DContatti.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_email", scope = DContatti.class)
    public JAXBElement<String> createDContattiTextEmail(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextEmail_QNAME, String.class, DContatti.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_fax", scope = DContatti.class)
    public JAXBElement<String> createDContattiTextFax(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextFax_QNAME, String.class, DContatti.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sas.beniculturali.it/catalogo/commons", name = "text_cap", scope = DContatti.class)
    public JAXBElement<String> createDContattiTextCap(String value) {
        return new JAXBElement<String>(_DLocalizzazioneTextCap_QNAME, String.class, DContatti.class, value);
    }

}
