package nl.finalist.golem.repository.vocabulary;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class VdexTermRelationship {

    @GraphId Long graphId;
    
    @RelatedTo Vdex parent;
    
    @RelatedTo Term type;
    
    @RelatedTo Term source;
    
    @RelatedTo Term target;

    VdexTermRelationship() {
        // Required by spring-data
    }

    public VdexTermRelationship(Vdex parent, Term type, Term source, Term target) {
        super();
        this.parent = parent;
        this.type = type;
        this.source = source;
        this.target = target;
    }
}
