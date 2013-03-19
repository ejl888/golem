package nl.finalist.golem.repository.vocabulary;

import java.util.List;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

public class Vdex {

    @GraphId Long nodeId;
    
    private String name;
    
    private String id;
    
    @RelatedTo private VocabularySource vocabularySource;
    
    @RelatedToVia(type = VdexContainsTerm.TYPE, elementClass = Term.class)
    private List<Term> terms;
    
    @RelatedTo
    private List<VdexTermRelationship> relationships;

    Vdex() {
        // Required by spring-data
    }

    Vdex(VocabularySource vocabularySource, String id, String name) {
        super();
        this.vocabularySource = vocabularySource;
        this.id = id;
        this.name = name;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public VocabularySource getVocabularySource() {
        return vocabularySource;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
