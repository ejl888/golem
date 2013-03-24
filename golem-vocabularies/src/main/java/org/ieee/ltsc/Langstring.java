package org.ieee.ltsc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType(name = "string")
public final class Langstring {

    public final static String NO_LANGUAGE = "x-none";
    public static final String DUTCH = "nl";

    @XmlAttribute(name = "language")
    private String lang;

    @XmlValue
    private String value;

    public Langstring() {
        // required by JaxB
        lang = NO_LANGUAGE;
    }

    public Langstring(String value, String language) {
        this.value = value;
        this.lang = language;
    }

    public Langstring(String value) {
        this(value, NO_LANGUAGE);
    }

    public String getValue() {
        return value;
    }

    public String getLang() {
        return lang;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        
        if (!(getClass().isInstance(other))) {
            return false;
        }
        
        final Langstring that = getClass().cast(other);
        return new EqualsBuilder()
                .append(this.value, that.value)
                .append(this.lang, that.lang)
                .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.value)
                .append(this.lang)
                .toHashCode();
    }
    
}