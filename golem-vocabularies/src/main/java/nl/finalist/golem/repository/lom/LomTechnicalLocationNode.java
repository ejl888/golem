package nl.finalist.golem.repository.lom;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@TypeAlias("LomTechnicalLocation")
@NodeEntity(useShortNames = true)
public class LomTechnicalLocationNode {

	@GraphId private Long nodeId;
	
    @Indexed(unique = true) private String uri;
    
	LomTechnicalLocationNode() {
		super();
		// required by Spring
	}

	public LomTechnicalLocationNode(String uri) {
		super();
		this.uri = uri;
	} 
}
