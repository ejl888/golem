package nl.finalist.golem.repository.lom;

import java.util.Set;

import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@TypeAlias("LomGeneral")
@NodeEntity(useShortNames = true)
public class LomGeneralNode extends PartOfLomRecordNode {
    
    // is not unique!
    @RelatedTo(type = "IDENTIFIED_BY", elementClass = LearningObjectIdentifierNode.class)
    private Set<LearningObjectIdentifierNode> identifiers;
    
    // fulltext candidate (LangText)
    private String title;
    
    // fulltext candidate (LangText)
    private String description;
    
    // fulltext candidate (LangText)
    private String[] keywords;
    
    // fulltext candidate (LangText)
    private String coverage;
    
    @RelatedTo(type = "STRUCTURE")
    private VocabularyTermNode structure;
    
    @RelatedTo(type = "AGGREGATION_LEVEL")
    private VocabularyTermNode aggregationLevel;
    
    @RelatedTo(type = "LANGUAGE")
    private Set<LanguageNode> languages;

	LomGeneralNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LomGeneralNode(LomRecordNode parentLomRecord) {
		super(parentLomRecord);
	}

	public Set<LearningObjectIdentifierNode> getIdentifiers() {
		return identifiers;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public String getCoverage() {
		return coverage;
	}

	public VocabularyTermNode getStructure() {
		return structure;
	}

	public VocabularyTermNode getAggregationLevel() {
		return aggregationLevel;
	}

	public Set<LanguageNode> getLanguages() {
		return languages;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public void setStructure(VocabularyTermNode structure) {
		this.structure = structure;
	}

	public void setLanguages(Set<LanguageNode> languages) {
		this.languages = languages;
	}

	public void setIdentifiers(Set<LearningObjectIdentifierNode> identifiers) {
		this.identifiers = identifiers;
	}
}
