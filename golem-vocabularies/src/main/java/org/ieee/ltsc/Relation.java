package org.ieee.ltsc;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType
public final class Relation {

    @XmlElement(name = "kind")
    private SourceValuePair kind;

    @XmlElement(name = "resource")
    private List<Resource> resources;

    public SourceValuePair getKind() {
        return kind;
    }

    public List<Resource> getResources() {
        return resources;
    }
}