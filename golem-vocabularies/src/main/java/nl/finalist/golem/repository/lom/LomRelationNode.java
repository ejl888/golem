package nl.finalist.golem.repository.lom;

import nl.finalist.golem.repository.vocabulary.VocabularySourceNode;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@TypeAlias("LomRelation")
@NodeEntity(useShortNames = true)
public class LomRelationNode extends PartOfLomRecordNode {
	
	@RelatedTo(type = "TYPE")
	private VocabularySourceNode type;
	
	@RelatedTo(type = "RELATED_TO")
	private LearningObjectIdentifierNode relatedTo;
	
	// langText
	private String description;  
}
