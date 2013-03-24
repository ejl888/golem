package org.ieee.ltsc;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType(name = "catalogentryType")
public final class CatalogEntry {

    
    private String catalog;
    
    @XmlElementWrapper(name = "entry")
    @XmlElement(name = "langstring")
    private List<Langstring> entries;

    public CatalogEntry() {
        // required by JaxB
    }
    
    public CatalogEntry(String catalog, Langstring... entries) {
        this.catalog = catalog;
        this.entries = Arrays.asList(entries);
    }

    public String getCatalog() {
        return catalog;
    }

    public List<Langstring> getEntries() {
        return entries;
    }
}