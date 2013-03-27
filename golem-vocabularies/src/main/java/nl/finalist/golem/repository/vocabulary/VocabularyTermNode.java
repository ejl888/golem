package nl.finalist.golem.repository.vocabulary;

import nl.finalist.golem.repository.common.CachedHashCodeNode;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

@TypeAlias("VocabularyTerm")
@NodeEntity(useShortNames = true)
public class VocabularyTermNode extends CachedHashCodeNode {

    @Indexed(unique = true, indexName = "vocabulary-term-uri") 
    private String uri;
    
    private String sourceId;

    @RelatedTo private VocabularySourceNode vocabularySourceNode;
    
 // fulltext candidate (LangText)
    @Indexed(unique = false, indexType = IndexType.FULLTEXT, indexName = "term-caption")
    private String caption;
    
 // fulltext candidate (LangText)
    @Indexed(unique = false, indexType = IndexType.FULLTEXT, indexName = "term-description")
    private String description;

    private boolean managed;
    
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

    public static String createUri(String vocabularySourceId, String sourceTermId) {
        return vocabularySourceId + "#" + sourceTermId;
    }

    public boolean isManaged() {
        return this.managed;
    }

    public void setManaged(boolean managed) {
        this.managed = managed;
    }
    
}
