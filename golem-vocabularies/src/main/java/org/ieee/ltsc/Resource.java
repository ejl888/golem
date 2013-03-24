package org.ieee.ltsc;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType
public final class Resource {

    @XmlElementWrapper(name = "description")
    @XmlElement(name = "langstring")
    private List<Langstring> descriptions;

    @XmlElement(name = "catalogentry")
    private List<CatalogEntry> catalogEntries;

    public List<Langstring> getDescriptions() {
        return descriptions;
    }

    public List<CatalogEntry> getCatalogEntries() {
        if (catalogEntries == null) {
            catalogEntries = Collections.emptyList();
        }

        return catalogEntries;
    }
}