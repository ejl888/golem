package nl.finalist.golem.repository.vcard.x520;

import org.springframework.data.neo4j.annotation.RelatedTo;

public class Region {
	
	@RelatedTo(type = "LIES_IN")
	private Country country;
}
