package org.ieee.ltsc;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType
public final class Classification {

    @XmlElement(name = "purpose")
    private SourceValuePair purpose;

    @XmlElement(name = "taxonPath")
    private List<TaxonPath> taxonPaths = new ArrayList<TaxonPath>();

    public Classification() {
        // required by JAXB
    }

    public Classification(SourceValuePair purpose) {
        this.purpose = purpose;
    }

    public SourceValuePair getPurpose() {
        return purpose;
    }

    /**
     * @deprecated here for compatibility, will be removed in the future.
     */
    @Deprecated
    public TaxonPath getTaxonPath() {
        return taxonPaths != null && !taxonPaths.isEmpty() ? taxonPaths.get(0) : null;
    }

    public List<TaxonPath> getTaxonPaths() {
        return taxonPaths;
    }
}