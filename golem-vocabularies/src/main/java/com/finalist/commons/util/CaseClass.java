package com.finalist.commons.util;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.io.Serializable;

/**
 * Abstract base class for immutable objects adding a default
 * {@link #equals(Object)}, {@link #hashCode()} and {@link #toString()} based on
 * reflection.
 * 
 * @author Rob Schellhorn
 * @since 1.0
 */
@SuppressWarnings("serial")
public abstract class CaseClass implements Serializable {

    /**
     * @see Object#equals(Object)
     * @see org.apache.commons.lang.builder.EqualsBuilder#reflectionEquals(Object, Object)
     */
    @Override
    public boolean equals(Object obj) {
        return reflectionEquals(this, obj);
    }

    /**
     * @see Object#hashCode()
     * @see org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode(Object)
     */
    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }

    /**
     * @see Object#toString()
     * @see org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(Object, ToStringStyle)
     */
    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}