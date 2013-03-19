package nl.finalist.golem.repository.vocabulary;

import org.springframework.data.neo4j.annotation.RelatedTo;

public class Term {

    String sourceId;
    
    String caption;
    
    String description;
    
    @RelatedTo VocabularySource vocabularySource;
    
    Term() {
        // Required by spring-data
    }
    
}
