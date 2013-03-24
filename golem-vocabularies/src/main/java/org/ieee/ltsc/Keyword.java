package org.ieee.ltsc;

import static com.finalist.commons.util.CollectionUtils.emptyListWhenNull;
import static com.finalist.commons.util.CollectionUtils.lazyInitOnAdd;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType
public final class Keyword {

    @XmlElement(name = "string")
    private List<Langstring> langstring;

    public List<Langstring> getLangstring() {
        return emptyListWhenNull(langstring);
    }

    public void addLangstring(Langstring extraLangstring) {
        this.langstring = lazyInitOnAdd(langstring, extraLangstring);
    }
}