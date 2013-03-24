package nl.finalist.golem.repository.lom;

import nl.finalist.golem.repository.vcard.EntityNode;
import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@TypeAlias("Contribute")
@NodeEntity(useShortNames = true)
public class ContributeNode {
	
	@RelatedTo(type = "ENTITY")
	private EntityNode entity;
	
	@RelatedTo(type = "ROLE")
	private VocabularyTermNode role;
	
	private long timestamp;
}
