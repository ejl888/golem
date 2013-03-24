package nl.finalist.golem.repository.people;

import java.util.Set;

import org.springframework.data.neo4j.annotation.RelatedToVia;

import nl.finalist.golem.repository.organisation.Employer;

public class Person {

	
	@RelatedToVia(type = "EMPLOYER", elementClass = Employer.class)
	private Set<Employer> eployers;
}
