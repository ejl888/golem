package nl.finalist.golem.repository.vocabulary;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = VdexContainsTerm.TYPE)
public class VdexContainsTerm {

    public static final String TYPE = "VDEX_CONTAINS_TERM";
    
    private boolean validIndex;
    private boolean orderSignificant;
    
    @StartNode private Vdex parent;
    @EndNode private Term term;
    
    public VdexContainsTerm(Vdex parent, Term term) {
        super();
        this.parent = parent;
        this.term = term;
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

    public Vdex getParent() {
        return parent;
    }

    public Term getTerm() {
        return term;
    }
    
    
}
