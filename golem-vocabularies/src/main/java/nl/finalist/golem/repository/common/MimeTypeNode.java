package nl.finalist.golem.repository.common;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@TypeAlias("MimeType")
@NodeEntity(useShortNames = true)
public class MimeTypeNode {

	@GraphId private Long nodeId;
	
    @Indexed(unique = true) private String id;
}
