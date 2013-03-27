package nl.finalist.golem.repository.lom;

import nl.finalist.golem.repository.common.CachedHashCodeNode;

import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
class PartOfLomRecordNode extends CachedHashCodeNode {

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
