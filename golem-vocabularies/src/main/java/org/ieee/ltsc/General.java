package org.ieee.ltsc;

import static com.finalist.commons.util.CollectionUtils.emptyListWhenNull;
import static com.finalist.commons.util.CollectionUtils.lazyInitOnAdd;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * Note: empty lists are not supported by Edurep. Lists are created when first element is added.
 *
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType(propOrder = {"title", "catalogEntries", "languages", "descriptions", "keywords", "coverage", 
        "aggregationLevels" })
public final class General {

    @XmlElementWrapper(name = "title")
    @XmlElement(name = "string")
    private List<Langstring> title;

    @XmlElement(name = "catalogentry")
    private List<CatalogEntry> catalogEntries;

    @XmlElementWrapper(name = "description")
    @XmlElement(name = "langstring")
    private List<Langstring> descriptions;

    @XmlElement(name = "language")
    private List<String> languages;

    @XmlElement(name = "keyword")
    private List<Keyword> keywords;

    @XmlElementWrapper(name = "coverage")
    @XmlElement(name = "langstring")
    private List<Langstring> coverage;

    @XmlElement(name = "aggregationlevel")
    private List<SourceValuePair> aggregationLevels;
    
    public List<SourceValuePair> getAggregationLevels() {
        return aggregationLevels;
    }

    public void addAggregationLevel(SourceValuePair additionalAggregationLevel) {
        this.aggregationLevels = lazyInitOnAdd(aggregationLevels, additionalAggregationLevel);
    }

    public List<CatalogEntry> getCatalogEntries() {
        return emptyListWhenNull(catalogEntries);
    }

    public void addCatalogEntry(CatalogEntry additionalEntry) {
        this.catalogEntries = lazyInitOnAdd(catalogEntries, additionalEntry);
    }

    public List<Langstring> getDescriptions() {
        return emptyListWhenNull(descriptions);
    }

    public void addDescription(Langstring additionalDescription) {
        this.descriptions = lazyInitOnAdd(descriptions, additionalDescription);
    }

    public List<Keyword> getKeywords() {
        return emptyListWhenNull(keywords);
    }

    public void addKeyword(Keyword additionalKeyword) {
        this.keywords = lazyInitOnAdd(keywords, additionalKeyword);
    }

    public List<String> getLanguages() {
        return emptyListWhenNull(languages);
    }

    public void addLanguage(String additionalLanguage) {
        this.languages = lazyInitOnAdd(languages, additionalLanguage);
    }

    public List<Langstring> getTitle() {
        return emptyListWhenNull(title);
    }

    public void addTitle(Langstring additionalTitle) {
        this.title = lazyInitOnAdd(title, additionalTitle);
    }

    public List<Langstring> getCoverage() {
        return emptyListWhenNull(coverage);
    }

}