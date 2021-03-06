package nl.finalist.golem.repository.lom;

import nl.finalist.golem.repository.common.CachedHashCodeNode;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@TypeAlias("Language")
@NodeEntity(useShortNames = true)
public class LanguageNode extends CachedHashCodeNode {

    @Indexed(unique = true) 
    private String code;
    
    private String label;
    
    LanguageNode() {
        // require by Spring
    }

	public LanguageNode(String code) {
		super();
		this.code = code;
	}

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }
    
    
}
