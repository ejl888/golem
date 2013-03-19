package nl.finalist.golem.repository.vdex;

import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity(useShortNames = true)
public class VdexTermRelationshipNode {

    @GraphId Long graphId;
    
    @RelatedTo VdexNode parent;
    
    @RelatedTo VocabularyTermNode type;
    
    @RelatedTo VocabularyTermNode source;
    
    @RelatedTo VocabularyTermNode target;

    VdexTermRelationshipNode() {
        // Required by spring-data
    }

    public VdexTermRelationshipNode(VdexNode parent, VocabularyTermNode type, 
            VocabularyTermNode source, VocabularyTermNode target) {
        super();
        this.parent = parent;
        this.type = type;
        this.source = source;
        this.target = target;
        
        this.parent.addRelationship(this);
    }
}
