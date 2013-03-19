package nl.finalist.golem.service.vdex.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class LangString {

    @XmlAttribute(name = "language")
    String language;
    
    @XmlValue
    String value;

    public String getLanguage() {
        return language;
    }

    public String getValue() {
        return value;
    }
}
