package org.ieee.ltsc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType
public final class TaxonPath {

    @XmlElementWrapper(name = "source")
    @XmlElement(name = "langstring")
    private List<Langstring> source = new ArrayList<Langstring>(1);

    @XmlElement(name = "taxon")
    private List<Taxon> taxons = new LinkedList<Taxon>();

    public TaxonPath() {
        // required by JAXB
    }

    public TaxonPath(Langstring source) {
        this.source.add(source);
    }

    public Langstring getSource() {
        return source != null && !source.isEmpty() ? source.get(0) : null;
    }

    public List<Taxon> getTaxons() {
        if (taxons == null) {
            taxons = Collections.emptyList();
        }

        return taxons;
    }
}