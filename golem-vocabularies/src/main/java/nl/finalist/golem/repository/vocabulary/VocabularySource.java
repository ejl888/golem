package nl.finalist.golem.repository.vocabulary;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class VocabularySource {

    @GraphId Long graphId;
    
    
    @Indexed(unique = false) String id;  // i.e. LomV1.0 
}
