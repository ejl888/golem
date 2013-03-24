package org.ieee.ltsc;

import static com.finalist.commons.util.CollectionUtils.emptyListWhenNull;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.util.StringUtils;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType
public final class Technical {

    public static final String NON_DIGITAL = "non-digital";

    @XmlElement(name = "format")
    private List<String> formats;

    private String location;

    public void setLocation(String location) {
        this.location = location;
        if (StringUtils.hasText(location)) {
            formats = null;
        } else {
            formats = new ArrayList<String>(1);
            formats.add(NON_DIGITAL);
        }
    }

    public Technical() {
        // required by JAXB
    }

    public String getFormat() {
        if (formats == null || formats.size() <= 0) {
            return null;
        }
        return formats.get(0);
    }

    public List<String> getFormats() {
        return emptyListWhenNull(formats);
    }

    public String getLocation() {
        return location;
    }
}