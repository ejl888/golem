package nl.finalist.golem.repository.vocabulary;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class VocabularySource {

    @GraphId private Long nodeId;
    
    @Indexed(unique = false) private String id;  // i.e. LomV1.0 
    
    VocabularySource() {
        // Required by spring-data
    }
    
    public VocabularySource(String id) {
        this.id = id;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public String getId() {
        return id;
    }
}
