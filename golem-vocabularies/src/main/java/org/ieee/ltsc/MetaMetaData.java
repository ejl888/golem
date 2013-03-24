package org.ieee.ltsc;

import static com.finalist.commons.util.CollectionUtils.emptyListWhenNull;
import static com.finalist.commons.util.CollectionUtils.lazyInitOnAdd;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType
public final class MetaMetaData {

    @XmlElement(name = "contribute")
    private List<Contribute> contributions;

    @XmlElement(name = "metadatascheme")
    private String metaDataScheme;

    @XmlElement(name = "catalogentry")
    private List<CatalogEntry> catalogEntries;

    private String language;

    public List<CatalogEntry> getCatalogEntries() {
        return emptyListWhenNull(catalogEntries);
    }

    public void addCatalogEntry(CatalogEntry catalogEntry) {
        this.catalogEntries = lazyInitOnAdd(catalogEntries, catalogEntry);
    }

    public List<Contribute> getContributions() {
        return emptyListWhenNull(contributions);
    }

    public void addContribute(Contribute contribute) {
        this.contributions = lazyInitOnAdd(contributions, contribute);
    }

    public String getLanguage() {
        return language;
    }

    public String getMetaDataScheme() {
        return metaDataScheme;
    }
}