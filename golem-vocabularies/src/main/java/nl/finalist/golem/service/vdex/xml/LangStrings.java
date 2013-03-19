package nl.finalist.golem.service.vdex.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class LangStrings {

    @XmlElement(name = "langstring")
    private List<LangString> strings = new ArrayList<LangString>();

    public List<LangString> getStrings() {
        return strings;
    }

    @Override
    public String toString() {
        if (strings.isEmpty()) {
            return "";
        }
        if (strings.size() == 1) {
            return strings.get(0).getValue();
        }
        for (LangString str : strings) {
            if ("nl".equals(str.getLanguage())) {
                return str.getValue();
            }
        }
        return strings.get(0).getValue();
    }

    public String getValue(String language) {
        if (strings == null) {
            return null;
        }
        
        for (LangString langString : strings) {
            if (language.equalsIgnoreCase(langString.getLanguage())) {
                return langString.value;
            }
        }
        return null;
    }
}
