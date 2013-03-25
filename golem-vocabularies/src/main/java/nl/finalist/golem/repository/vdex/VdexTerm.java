package nl.finalist.golem.repository.vdex;

import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@TypeAlias(VdexTerm.TYPE)
@NodeEntity(useShortNames = true)
public class VdexTerm {

    @GraphId private Long nodeId;
    
    public static final String TYPE = "VdexTermM";
    
	private boolean validIndex;
    private boolean orderSignificant;
    
    @RelatedTo(type = "PARENT_VDEX") private VdexNode parentVdex;

    // index in the parent Vdex
    private int index;
    
    @RelatedTo(type = "VOCABULARY_TERM") private VocabularyTermNode vocabularyTermNode;
    
    public int getIndex() {
    	return index;
    }
    
    VdexTerm() {
        super();
        // required by spring
    }

    public VdexTerm(VdexNode parent, VocabularyTermNode vocabularyTermNode) {
        super();
        this.parentVdex = parent;
        this.vocabularyTermNode = vocabularyTermNode;
        this.parentVdex.addTerm(this);
    }

    public void setValidIndex(boolean validIndex) {
        this.validIndex = validIndex;
    }

    public void setOrderSignificant(boolean orderSignificant) {
        this.orderSignificant = orderSignificant;
    }

    public boolean isValidIndex() {
        return validIndex;
    }

    public boolean isOrderSignificant() {
        return orderSignificant;
    }

    public VdexNode getParentVdex() {
        return parentVdex;
    }

    public VocabularyTermNode getVocabularyTerm() {
        return vocabularyTermNode;
    }

	void setIndex(int index) {
		this.index = index;
	}
}
