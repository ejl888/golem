package nl.finalist.golem.repository.vocabulary;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity()
public class VocabularySourceNode {

    @GraphId private Long nodeId;
    
    @Indexed(unique = true) private String uri;  // i.e. LomV1.0 

    public static final String LOM_V1_0 = "LomV1.0";
    
    VocabularySourceNode() {
        // Required by spring-data
    }
    
    public VocabularySourceNode(String uri) {
        this.uri = uri;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public String getUri() {
        return uri;
    }

}
