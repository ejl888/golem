package nl.finalist.golem.service.vdex.xml;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Term {

    @XmlAttribute(name = "orderSignificant")
    private Boolean orderSignificant;

    @XmlAttribute(name = "validIndex")
    private Boolean validIndex;

    @XmlElement(name = "termIdentifier")
    private String identifier;

    @XmlElement(name = "caption")
    private LangStrings caption;

    @XmlElement(name = "description")
    private LangStrings description;

    @XmlElement(name = "term")
    private Collection<Term> terms = new ArrayList<Term>();

    public Term() {
    }

    public Term(String identifier, LangStrings caption, LangStrings description, Collection<Term> terms) {
        super();
        this.identifier = identifier;
        this.caption = caption;
        this.description = description;
        this.terms = terms;
    }

    protected Term findTerm(Term source) {
        for (Term childTerm : terms) {
            if (childTerm.equals(source)) {
                return this;
            }
        }

        return null;
    }

    public Collection<String> getDescendentTermIds() {
        Collection<String> result = new ArrayList<String>();

        for (Term child : terms) {
            if (!result.contains(child.identifier)) {
                result.add(child.identifier);
                result.addAll(child.getDescendentTermIds());
            }
        }

        return result;
    }

    public String getIdentifier() {
        return identifier;
    }

    public LangStrings getCaption() {
        return caption;
    }

    public LangStrings getDescription() {
        return description;
    }

    public Collection<Term> getTerms() {
        return terms;
    }

    public boolean isOrderSignificant() {
        return Boolean.TRUE.equals(orderSignificant);
    }

    public boolean isValidIndex() {
        return !Boolean.FALSE.equals(validIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append(identifier)
            .append(caption)
            .append(description)
            .append(validIndex)
            .append(orderSignificant)
            .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(identifier).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }

        final Term that = getClass().cast(obj);
        return new EqualsBuilder().append(this.identifier, that.identifier).isEquals();
    }
}
