package org.ieee.ltsc;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Rob Schellhorn
 */
@XmlType
public final class TypicalLearningTime {

    @XmlElement(name = "datetime")
    private String dateTime;

    @XmlElement(name = "description")
    private List<Langstring> description;

    public String getDateTime() {
        return dateTime;
    }

    public List<Langstring> getDescription() {
        return description;
    }
    
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}