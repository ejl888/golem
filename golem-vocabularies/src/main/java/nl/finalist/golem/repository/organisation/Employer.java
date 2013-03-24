package nl.finalist.golem.repository.organisation;

import nl.finalist.golem.repository.people.Person;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity 
public class Employer {
	
	private long startDate;
	
	private long endDate;
	
	@StartNode private Person employee;
	
	@EndNode private Organisation employer;
}
