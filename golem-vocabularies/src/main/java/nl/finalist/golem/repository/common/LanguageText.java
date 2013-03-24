package nl.finalist.golem.repository.common;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.support.index.IndexType;

/**
 * Language specific text.
 *  
 * @author ernst-jan
 *
 */
@TypeAlias("LanguageText")
@NodeEntity(useShortNames = true)
public class LanguageText {
    
    @GraphId Long nodeId;
    
    private String language;
    
    @Indexed(indexName = "fulltext-search", indexType = IndexType.FULLTEXT) private String text;
    
    LanguageText() {
        // required by Spring
    }

    public LanguageText(String language, String text) {
        super();
        this.language = language;
        this.text = text;
    }

    public String getLanguage() {
        return language;
    }

    public String getText() {
        return text;
    }
}
