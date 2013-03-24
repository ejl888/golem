package nl.finalist.golem.repository.lom;

import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@TypeAlias("LomRights")
@NodeEntity(useShortNames = true)
public class LomRightsNode extends PartOfLomRecordNode {

	@RelatedTo(type = "COSTS")
    private VocabularyTermNode costs;
    
    @RelatedTo(type = "RESTRICTIONS")
    private VocabularyTermNode restrictions;
    
    // fulltext candidate (LangText)
    private String description;

	LomRightsNode() {
		super();
		// required by Spring
	}
    
    public LomRightsNode(LomRecordNode lomRecordNode) {
    	super(lomRecordNode);
    }

	public VocabularyTermNode getCosts() {
		return costs;
	}

	public void setCosts(VocabularyTermNode costs) {
		this.costs = costs;
	}

	public VocabularyTermNode getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(VocabularyTermNode restrictions) {
		this.restrictions = restrictions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
