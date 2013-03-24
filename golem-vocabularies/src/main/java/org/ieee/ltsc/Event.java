package org.ieee.ltsc;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType
public class Event {

    @XmlElement(name = "datetime")
    private Date timestamp;

    @XmlElementWrapper(name = "description")
    @XmlElement(name = "langstring")
    private List<Langstring> descriptions;

    public Event() {
        // required by JaxB
    }

    public Event(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<Langstring> getDescriptions() {
        return descriptions;
    }

    public Date getTimestamp() {
        if (timestamp == null) {
            return null;
        }
        return new Date(timestamp.getTime());
    }
}