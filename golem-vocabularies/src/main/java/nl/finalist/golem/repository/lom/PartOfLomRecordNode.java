package nl.finalist.golem.repository.lom;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
class PartOfLomRecordNode {

	@GraphId private Long nodeId;
	
    @RelatedTo(type = "PARENT_LOM_RECORD")
    private LomRecordNode parentLomRecord;

    PartOfLomRecordNode() {
		// required by Spring
	}
    
	public PartOfLomRecordNode(LomRecordNode parentLomRecord) {
		super();
		this.parentLomRecord = parentLomRecord;
	}

	public LomRecordNode getParentLomRecord() {
		return parentLomRecord;
	}
	
	
}
