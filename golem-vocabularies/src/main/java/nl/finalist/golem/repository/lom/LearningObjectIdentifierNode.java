package nl.finalist.golem.repository.lom;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * Learning Object Identifier
 * @author ernst-jan
 *
 */
@TypeAlias("LearningObjectIdentifier")
@NodeEntity(useShortNames = true)
public class LearningObjectIdentifierNode {

	@GraphId private Long nodeId;
	
    // combination of catalog :: entry, which must be unique
    @Indexed(unique = true) private String id;

    private String catalog; // ie. "URI" 
    
    private String entry; // valid URI like "isbn:12345"
    
    @RelatedTo(type = "LOM_RECORDS")
    private Set<LomRecordNode> lomRecords = new HashSet<>();
    
    LearningObjectIdentifierNode() {
		// required by Spring data 
	}

	public LearningObjectIdentifierNode(String catalog, String entry) {
		super();
		this.catalog = catalog;
		this.entry = entry;
		this.id = toLearningObjectIdentifier(catalog, entry);
	}
	
	public void identificationOf(LomRecordNode lomRecord) {
		lomRecords.add(lomRecord);
	}

	public static String toLearningObjectIdentifier(String catalog, String entry) {
		return catalog + "::" + entry;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public String getId() {
		return id;
	}

	public String getCatalog() {
		return catalog;
	}

	public String getEntry() {
		return entry;
	}

	public Set<LomRecordNode> getLomRecords() {
		return lomRecords;
	}
    
	
}
