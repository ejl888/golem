package nl.finalist.golem.repository.vocabulary;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class VocabularyTermNode {

    @GraphId private Long nodeId;
    
    @Indexed(unique = true) private String uri;
    
    private String sourceId;

    @RelatedTo private VocabularySourceNode vocabularySourceNode;
    
    private String caption;
    
    private String description;
    
    VocabularyTermNode() {
        // Required by spring-data
    }

    public VocabularyTermNode(VocabularySourceNode vocabularySourceNode, String sourceId) {
        super();
        this.vocabularySourceNode = vocabularySourceNode;
        this.sourceId = sourceId;
        this.uri = createUri(vocabularySourceNode.getUri(), sourceId);
    }
    
    

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public String getUri() {
        return uri;
    }

    public String getSourceId() {
        return sourceId;
    }

    public VocabularySourceNode getVocabularySource() {
        return vocabularySourceNode;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public static String createUri(String vocabularySourceId, String sourceId) {
        return vocabularySourceId + "#" + sourceId;
    }

    
    
}