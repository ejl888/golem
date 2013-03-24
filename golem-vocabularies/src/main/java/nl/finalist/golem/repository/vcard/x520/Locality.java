package nl.finalist.golem.repository.vcard.x520;

import org.springframework.data.neo4j.annotation.RelatedTo;

public class Locality {
	
	@RelatedTo(type = "LIES_IN")
	private Region region;
}
