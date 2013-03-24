package org.ieee.ltsc;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType
public final class Contribute {

    @XmlElement(name = "role")
    private SourceValuePair role;

    @XmlElement(name = "centity")
    private Collection<CEntity> entities;

    @XmlElement(name = "date")
    private Event event;

    public Contribute() {
        // required by JaxB
    }

    public Contribute(SourceValuePair role, Date timestamp, CEntity... entities) {
        this.role = role;
        this.entities = Arrays.asList(entities);
        this.event = new Event(timestamp);
    }

    public Collection<CEntity> getEntities() {
        return entities;
    }

    public Event getEvent() {
        return event;
    }

    public SourceValuePair getRole() {
        return role;
    }
}