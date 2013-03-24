package nl.finalist.golem.repository.lom;

import java.util.HashSet;
import java.util.Set;

import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@TypeAlias("LomClassification")
@NodeEntity(useShortNames = true)
public class LomClassificationNode extends PartOfLomRecordNode {
	
    @RelatedTo(type = "PARENT_LOM_RECORD")
    private LomRecordNode parentLomRecord;
	
    @RelatedTo(type = "PURPOSE") 
    private VocabularyTermNode purpose;
    
    @RelatedTo(type = "CLASSIFIES", elementClass = VocabularyTermNode.class)
    private Set<VocabularyTermNode> classifiers = new HashSet<>();
    
    // fulltext candidate (LangText)
    private String[] keywords;
    
    // fulltext candidate (LangText)
    private String description;

	LomClassificationNode() {
		super();
		// required by Spring
	}

	public LomClassificationNode(LomRecordNode parentLomRecord, VocabularyTermNode purpose) {
		super(parentLomRecord);
		this.purpose = purpose;
	}

	public LomRecordNode getParentLomRecord() {
		return parentLomRecord;
	}

	public VocabularyTermNode getPurpose() {
		return purpose;
	}

	public Set<VocabularyTermNode> getClassifiers() {
		return classifiers;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public void setClassifiers(Set<VocabularyTermNode> classifiers) {
        this.classifiers = classifiers;
    }
}
