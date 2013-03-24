package nl.finalist.golem.repository.lom;

import java.util.HashSet;
import java.util.Set;

import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@TypeAlias("LifeCycle")
@NodeEntity(useShortNames = true)
public class LomLifeCycleNode extends PartOfLomRecordNode {
	
	private String version;
	
	@RelatedTo(type = "HAS_STATUS")
	private VocabularyTermNode status;
	
	@RelatedTo(type = "CONTRIBUTION", elementClass = ContributeNode.class)
	private Set<ContributeNode> contributions = new HashSet<>();

	
	
	LomLifeCycleNode() {
		super();
		// required by Spring
	}

	public LomLifeCycleNode(LomRecordNode parentLomRecord) {
		super(parentLomRecord);
	}

	public void addContribute(ContributeNode contributeNode) {
		this.contributions.add(contributeNode);
	}
	
	public String getVersion() {
		return version;
	}

	public VocabularyTermNode getStatus() {
		return status;
	}

	public Set<ContributeNode> getContributions() {
		return contributions;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setStatus(VocabularyTermNode status) {
		this.status = status;
	}
}
