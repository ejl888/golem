package nl.finalist.golem.service.vdex.xml;

import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Relationship {

    /** Term that has a broader meaning than the term being described. */
    public static final String TYPE_BT = "BT";
    /** Term that has a narrower meaning than the term being described.  */
    public static final String TYPE_NT = "NT";

    @XmlElement(name = "sourceTerm")
    private TermReference sourceTerm;

    @XmlElement(name = "targetTerm")
    private TermReference targetTerm;

    @XmlElement(name = "relationshipType")
    private RelationshipType relationshipType;

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    public TermReference getSourceTerm() {
        return sourceTerm;
    }

    public TermReference getTargetTerm() {
        return targetTerm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append(relationshipType)
                .append(sourceTerm)
                .append(targetTerm)
                .toString();
    }

}
