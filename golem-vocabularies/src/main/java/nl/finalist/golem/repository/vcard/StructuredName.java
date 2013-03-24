package nl.finalist.golem.repository.vcard;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * This property specifies a structured representation of the name of the
 * person, place or thing associated with the vCard object. This property is
 * identified by the property name N. This property is defined to encapsulate
 * the individual components of an object’s name. The property value consists of
 * the components of the name specified as positional fields separated by the
 * Field Delimiter character (ASCII decimal 59). The property value is a
 * concatenation of the Family Name (first field), Given Name (second field),
 * Additional Names (third field), Name Prefix (fourth field), and Name Suffix
 * (fifth field) strings. The following is an example of the Name property for a
 * person:
 * 
 * @author ernst-jan
 * 
 */
@TypeAlias("VCARD_NAME")
@NodeEntity(useShortNames = true)
public class StructuredName {
	
	@GraphId private Long nodeId;
	
	private String familyName;
	
	private String givenName;
	
	private String additionalNames;
	
	private String namePrefix;
	
	private String nameSuffix;

	StructuredName() {
		// required by SPring
	}
	
	public StructuredName(String familyName) {
		this.familyName = familyName;
	}

	public StructuredName(String familyName, String givenName) {
		this.givenName = givenName;
		this.familyName = familyName;
	}
	
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getAdditionalNames() {
		return additionalNames;
	}

	public void setAdditionalNames(String additionalNames) {
		this.additionalNames = additionalNames;
	}

	public String getNamePrefix() {
		return namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	public String getNameSuffix() {
		return nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}
}
