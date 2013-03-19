package nl.finalist.golem.service.vdex.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vdex")
public class Vdex {

    @XmlAttribute(name = "orderSignificant")
    private Boolean orderSignificant;

    @XmlElement(name = "vocabName")
    private LangStrings name;

    @XmlElement(name = "vocabIdentifier")
    private String identifier;

    @XmlElement(name = "term")
    private List<Term> terms = new ArrayList<Term>();

    @XmlElement(name = "relationship")
    private List<Relationship> relationships = new ArrayList<Relationship>();

    public List<Relationship> getRelationships() {
        return relationships;
    }

    private String vdexId;

    public LangStrings getName() {
        return name;
    }

    public List<Term> getTerms() {
        return terms;
    }

    public String getIdentifier() {
        return identifier;
    }

    public boolean isOrderSignificant() {
        return Boolean.TRUE.equals(orderSignificant);
    }

    public void setVdexId(String vdexId) {
        this.vdexId = vdexId;
    }

    public String getVdexId() {
        return vdexId;
    }
}