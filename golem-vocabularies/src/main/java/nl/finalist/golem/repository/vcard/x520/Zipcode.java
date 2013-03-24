package nl.finalist.golem.repository.vcard.x520;

import org.springframework.data.neo4j.annotation.Indexed;

public class Zipcode {

	@Indexed(unique = true) private String id; // countrycode#zipcode
	
	private Country country;
	
	private String[] parts;
	
	// dutch [0] = zipcode 4, [1] = spec.
}
