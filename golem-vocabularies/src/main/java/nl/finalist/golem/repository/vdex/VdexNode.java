package nl.finalist.golem.repository.vdex;

import java.util.LinkedHashSet;
import java.util.Set;

import nl.finalist.golem.repository.vocabulary.VocabularySourceNode;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@TypeAlias("Vdex")
@NodeEntity(useShortNames = true)
public class VdexNode {

    @GraphId Long nodeId;
    
    private String name;
    
    private String id;
    
    @RelatedTo private VocabularySourceNode vocabularySourceNode;
    
    @RelatedTo(type = VdexTerm.TYPE)
    private Set<VdexTerm> vdexTerms = new LinkedHashSet<>();
    
    @RelatedTo(type = "RELATIONSHIPS")
    private Set<VdexTermRelationshipNode> relationships = new LinkedHashSet<>();

    VdexNode() {
        // Required by spring-data
    }

    public VdexNode(VocabularySourceNode vocabularySourceNode, String id, String name) {
        super();
        this.vocabularySourceNode = vocabularySourceNode;
        this.id = id;
        this.name = name;
    }
    
    void addTerm(VdexTerm vdexTerm) {
        this.vdexTerms.add(vdexTerm);
        vdexTerm.setIndex(vdexTerms.size());
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

    public VocabularySourceNode getVocabularySource() {
        return vocabularySourceNode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    void addRelationship(VdexTermRelationshipNode relationship) {
        this.relationships.add(relationship);
        relationship.setIndex(relationships.size());
    }
    
    
}
