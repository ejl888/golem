package nl.finalist.golem.repository.vcard.x520;


import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;


/***
 * 
 * Post Office Address (first field) 
 * Extended Address (second field), 
 * Street (third field), 
 * Locality (fourth field), 
 * Region (fifth field), 
 * Postal Code (six field), and 
 * Country (seventh field)
 * 
 * @author ernst-jan
 *
 */


@NodeEntity
public class Address {

	private String postOfficeAddress; // PO. BOX
	
	@RelatedTo(type = "STREET")
	private Street street; 

	private String extendedAddress;

	@RelatedTo(type = "ZIPCODE")
	private Zipcode zipcode;
	
	private Country country;
}
