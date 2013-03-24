package nl.finalist.golem.repository.vcard;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * This property specifies the name and optionally the unit(s) of the
 * organization associated with the vCard object. This property is based on the
 * X.520 Organization Name attribute and the X.520 Organization Unit attribute.
 * For example, “The AB Corporation” and the “North American Division”. This
 * property is identified by the property name ORG. This property is defined to
 * encapsulate the Organization Name and Organization Unit properties as
 * sub-properties. The property value consists of the components of the
 * organization specified as positional fields separated by the Field Delimiter
 * (ASCII decimal 59). The property value is a concatenation of the Organization
 * Name (first field), Organizational Unit (second field) strings. Additional
 * positional fields, if specified, contain additional Organizational Units. The
 * following is an example of the Organization property: ORG:ABC, Inc.;North
 * American Division;Marketing Support for this property is optional for vCard
 * Writers conforming to this specification.
 * 
 * @author ernst-jan
 * 
 */
@TypeAlias("ENTITY")
@NodeEntity(useShortNames = true)
public class OrganizationName {

	@GraphId private Long nodeId;
	
	private String organizationName;
	
	private String[] organizationalUnits;
	
	OrganizationName() {
		// required by Spring
	}
	
	public OrganizationName(String name) {
		this.organizationName = name;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String[] getOrganizationalUnits() {
		return organizationalUnits;
	}

	public void setOrganizationalUnits(String[] organizationalUnits) {
		this.organizationalUnits = organizationalUnits;
	}

	public Long getNodeId() {
		return nodeId;
	}
	
	
}
