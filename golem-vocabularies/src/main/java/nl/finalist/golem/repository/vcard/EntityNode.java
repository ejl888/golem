package nl.finalist.golem.repository.vcard;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * Entity (person, organisation) based on vCard
 * 
 * @author ernst-jan
 *
 */
@TypeAlias("ENTITY")
@NodeEntity(useShortNames = true)
public class EntityNode {

	@GraphId private Long nodeId;
	
	@RelatedTo(type = "NAME")
	private StructuredName structuredName; // N
	
	private String fullName; // FN 
	
	@RelatedTo(type = "ORGANISATION")
	private OrganizationName organisationName; // ORG
	
//	private Set<EmailAddress> emailAddresses; // EMAIL
//	
//	private Set<TelephoneNumber> telephoneNumbers; // TEL x.500
//	
//	private Set<Address> addresses;
	
	@RelatedTo(type = "UID")
	@Indexed(unique = true) private String uid; // UID

	public StructuredName getStructuredName() {
		return structuredName;
	}

	public void setStructuredName(StructuredName structuredName) {
		this.structuredName = structuredName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public OrganizationName getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(OrganizationName organisationName) {
		this.organisationName = organisationName;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Long getNodeId() {
		return nodeId;
	}
	
//	@RelatedTo(type = "GEO")
//	private GeoPoint geo; 
	
	
}
