package org.ieee.ltsc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Wrappes a single langstring
 * @author ernst-jan
 *
 */
@XmlType
public class LangstringWrapper {
    
    @XmlElement
    private Langstring langstring;

    public LangstringWrapper() {
        super();
        // required by JAXB
    }
    
    public LangstringWrapper(Langstring langstring) {
        super();
        this.langstring = langstring;
    }

    public Langstring getLangstring() {
        return langstring;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        
        if (!(getClass().isInstance(other))) {
            return false;
        }
        
        final LangstringWrapper that = getClass().cast(other);
        return new EqualsBuilder().append(this.langstring, that.langstring).isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.langstring).toHashCode();
    }
}
