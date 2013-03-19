package nl.finalist.golem.service.vdex.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class RelationshipType implements VocabularyTermReference {
    
    @XmlAttribute(name = "source")
    private String vocabularySourceURI;
    
    @XmlValue
    private String termSourceId;

    @Override
    public String getVocabularySourceURI() {
        return vocabularySourceURI;
    }

    @Override
    public String getTermSourceId() {
        return termSourceId;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append(this.vocabularySourceURI)
                .append(this.termSourceId)
                .toString();
    }    
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(this.termSourceId)
            .append(this.vocabularySourceURI)
            .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RelationshipType)) {
            return false;
        }
        
        final RelationshipType that = (RelationshipType) obj;
        return new EqualsBuilder()
            .append(this.termSourceId, that.termSourceId)
            .append(this.vocabularySourceURI, that.vocabularySourceURI)
            .isEquals();
    }
    
}
