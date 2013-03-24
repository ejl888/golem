package nl.finalist.golem.repository.vcard.x520;

import org.springframework.data.neo4j.annotation.Indexed;

public class Country {

	@Indexed(unique = true) private String code;
	
	private String name;
}
