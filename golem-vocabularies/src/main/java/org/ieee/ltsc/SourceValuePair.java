package org.ieee.ltsc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType
public final class SourceValuePair {
    
    @XmlElement(name = "source")
    private LangstringWrapper source;

    @XmlElement(name = "value")
    private LangstringWrapper value;
    
    public SourceValuePair() {
        super();
        // required by JaxB
    }
    
    public SourceValuePair(Langstring source, Langstring value) {
        this.source = new LangstringWrapper(source);
        this.value = new LangstringWrapper(value);
    }

    public Langstring getSource() {
        return source == null ? null : source.getLangstring();
    }

    public Langstring getValue() {
        return value == null ? null : value.getLangstring();
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        
        if (!(getClass().isInstance(other))) {
            return false;
        }
        
        final SourceValuePair that = getClass().cast(other);
        return new EqualsBuilder()
                .append(this.value, that.value)
                .append(this.source, that.source)
                .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.value)
                .append(this.source)
                .toHashCode();
    }
    
}