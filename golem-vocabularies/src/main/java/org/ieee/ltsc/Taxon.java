package org.ieee.ltsc;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType(propOrder = {"id", "entry" })
public final class Taxon {

    private String id;

    @XmlElementWrapper(name = "entry")
    @XmlElement(name = "langstring")
    private List<Langstring> entry = new ArrayList<Langstring>();

    public Taxon() {
        // required by JAXB
    }

    public Taxon(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Langstring> getEntries() {
        return entry;
    }

    public Langstring getEntry() {
        return entry == null || entry.isEmpty() ? null : entry.get(0);
    }

}