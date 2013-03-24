package nl.finalist.golem.repository.vdex;

import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@TypeAlias("VdexTermRelationship")
@NodeEntity(useShortNames = true)
public class VdexTermRelationshipNode {

    @GraphId Long graphId;
    
    // index in vdex (used when orderSignificant is used)
    private int index;
    
    @RelatedTo VdexNode parentVdex;
    
    // might go for @RelationshipType and node uri as the type
    @RelatedTo(type = "TYPE") VocabularyTermNode type;
    
    @RelatedTo(type = "SOURCE") VocabularyTermNode source;
    
    @RelatedTo(type = "TARGET") VocabularyTermNode target;

    VdexTermRelationshipNode() {
        // Required by spring-data
    }

    public VdexTermRelationshipNode(VdexNode parent, VocabularyTermNode type, 
            VocabularyTermNode source, VocabularyTermNode target) {
        super();
        this.parentVdex = parent;
        this.type = type;
        this.source = source;
        this.target = target;
        this.parentVdex.addRelationship(this);
    }

	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
}
