package nl.finalist.golem.repository.vdex;

import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = VdexTerm.TYPE, useShortNames = true)
public class VdexTerm {

    @GraphId private Long nodeId;
    
    public static final String TYPE = "VDEX_CONTAINS_TERM";
    
    private boolean validIndex;
    private boolean orderSignificant;
    
    @StartNode private VdexNode parentVdex;
    @EndNode private VocabularyTermNode vocabularyTermNode;
    
    
    
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

    public VocabularyTermNode getTerm() {
        return vocabularyTermNode;
    }
    
    
}
