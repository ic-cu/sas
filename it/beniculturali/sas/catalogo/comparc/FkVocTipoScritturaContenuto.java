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
import javax.xml.bind.annotation.XmlType;
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
 *       &lt;choice maxOccurs="unbounded">
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
public class FkVocTipoScritturaContenuto {

    @XmlElement(name = "d_voc_tipo_scrittura", namespace = "http://sas.beniculturali.it/catalogo/vocabolari-trasv")
    protected List<DVocTipoScrittura> dVocTipoScrittura;

    /**
     * Gets the value of the dVocTipoScrittura property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dVocTipoScrittura property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDVocTipoScrittura().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DVocTipoScrittura }
     * 
     * 
     */
    public List<DVocTipoScrittura> getDVocTipoScrittura() {
        if (dVocTipoScrittura == null) {
            dVocTipoScrittura = new ArrayList<DVocTipoScrittura>();
        }
        return this.dVocTipoScrittura;
    }

}
