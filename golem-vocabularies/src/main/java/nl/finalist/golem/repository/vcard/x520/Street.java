package nl.finalist.golem.repository.vcard.x520;

import org.springframework.data.neo4j.annotation.RelatedTo;

public class Street {

	@RelatedTo(type = "LIES_IN")
	private Locality locality;
	
	private String name;
	
	private int number;
	
}
