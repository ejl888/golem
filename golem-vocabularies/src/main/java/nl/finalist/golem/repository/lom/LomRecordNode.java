package nl.finalist.golem.repository.lom;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@TypeAlias("LomRecord")
@NodeEntity(useShortNames = true)
public class LomRecordNode {
    
	@GraphId private Long nodeId;
	
	@Indexed(unique = true, indexName = "lom-record-id") 
	private String recordId;

	// field 1
    @RelatedTo(type = "GENERAL")
    private LomGeneralNode general;
    
//    // field 2
//    @RelatedTo(type = "LIFECYCLE")
//    private LomLifeCycleNode lifeCycle;
//
//    // field 3 meta metadata
//    
//    // field 4
//    @RelatedTo(type = "TECHNICAL")
//    private LomTechnicalNode technical;
//
//    // field 5 educational
//    
//    // field 6
//    @RelatedTo(type = "RIGHTS")
//    private LomRightsNode rights;
//    
//    // field 7
//    @RelatedTo(type = "RELATED_TO", elementClass = LomRelationNode.class)
//    private Set<LomRelationNode> relations = new HashSet<>();

    // field 9
    @RelatedTo(type = "CLASSIFICATIONS", elementClass = LomClassificationNode.class)
    private Set<LomClassificationNode> classifications = new HashSet<>();

    LomRecordNode() {
        super();
        // Required by Spring
    }
    
    
	public LomRecordNode(String recordId) {
		super();
		this.recordId = recordId;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public LomGeneralNode getGeneral() {
		return general;
	}

	public void setGeneral(LomGeneralNode general) {
        this.general = general;
    }
	
//	public LomLifeCycleNode getLifeCycle() {
//		return lifeCycle;
//	}
//
//	public void setLifeCycle(LomLifeCycleNode lifeCycle) {
//		this.lifeCycle = lifeCycle;
//	}
//
//	public LomTechnicalNode getTechnical() {
//		return technical;
//	}
//
//	public void setTechnical(LomTechnicalNode technical) {
//		this.technical = technical;
//	}
//
//	public LomRightsNode getRights() {
//		return rights;
//	}
//
//	public void setRights(LomRightsNode rights) {
//		this.rights = rights;
//	}
//
//	public Set<LomRelationNode> getRelations() {
//		return relations;
//	}
//
//	public void addRelations(LomRelationNode relation) {
//		this.relations.add(relation);
//	}

	public Set<LomClassificationNode> getClassifications() {
		return classifications;
	}

	public void addClassifications(LomClassificationNode classification) {
		this.classifications.add(classification);
	}

	public void setClassifications(Set<LomClassificationNode> classifications) {
		this.classifications = classifications;
		
	}
    
    
}
