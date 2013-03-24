package nl.finalist.golem.repository.lom;

import java.util.Set;

import nl.finalist.golem.repository.common.MimeTypeNode;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@TypeAlias("LomTechnicalLocation")
@NodeEntity(useShortNames = true)
public class LomTechnicalNode extends PartOfLomRecordNode {

    private String size;
    
    // fulltext candidate (LangText)
    private String installationRemarks;
    
    @RelatedTo(type = "MIMETYPE", elementClass = MimeTypeNode.class)
    private Set<MimeTypeNode> mimetypes;
    
    @RelatedTo(type = "LOCATION", elementClass = LomTechnicalLocationNode.class)
    private Set<LomTechnicalLocationNode> locations;

	LomTechnicalNode() {
		super();
		// required by Spring
	}

	public LomTechnicalNode(LomRecordNode parentLomRecord) {
		super(parentLomRecord);
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getInstallationRemarks() {
		return installationRemarks;
	}

	public void setInstallationRemarks(String installationRemarks) {
		this.installationRemarks = installationRemarks;
	}

	public Set<MimeTypeNode> getMimetypes() {
		return mimetypes;
	}

	public void addMimetypes(MimeTypeNode mimetype) {
		this.mimetypes.add(mimetype);
	}

	public Set<LomTechnicalLocationNode> getLocations() {
		return locations;
	}

	public void addLocation(LomTechnicalLocationNode location) {
		this.locations.add(location);
	}
    
    
    
}
