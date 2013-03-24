package org.ieee.ltsc;

import static com.finalist.commons.util.CollectionUtils.emptyListWhenNull;
import static com.finalist.commons.util.CollectionUtils.lazyInitOnAdd;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType(propOrder = {"cost", "copyrightAndOtherRestrictions", "description" })
//@XmlType(propOrder = {"cost", "copyrightAndOtherRestrictions", "description", "temporalAvailability", 
//"groupRestrictions" })
public final class Rights {

    @XmlElement(name = "cost")
    private SourceValuePair cost;

    @XmlElement(name = "copyrightandotherrestrictions")
    private SourceValuePair copyrightAndOtherRestrictions;

    // empty list is not allowed.
    @XmlElementWrapper(name = "description")
    @XmlElement(name = "langstring")
    private List<Langstring> description;

    /**
     * Used by LLOM and ALOM (harvesting of locations and activities), not allowed by Edurep
     */
//    @XmlElement(name = "temporalAvailability", 
//            required = false, 
//            namespace = "http://www.groengelinkt.nl/xsd/nme_lomext_v1p0")
//    private TemporalAvailability temporalAvailability;

//    /**
//     * Used by ALOM (harvesting of activities), not allowed by Edurep
//     */
//    @XmlElement(name = "groupRestrictions", 
//            required = false, 
//            namespace = "http://www.groengelinkt.nl/xsd/nme_lomext_v1p0")
//    private GroupRestrictions groupRestrictions;
//
//    public GroupRestrictions getGroupRestrictions() {
//        return groupRestrictions;
//    }
//
//    public TemporalAvailability getTemporalAvailability() {
//        return temporalAvailability;
//    }

    public SourceValuePair getCopyrightAndOtherRestrictions() {
        return copyrightAndOtherRestrictions;
    }

    public SourceValuePair getCost() {
        return cost;
    }

    public List<Langstring> getDescription() {
        return emptyListWhenNull(description);
    }

    public void addDescription(Langstring additionalDescription) {
        this.description = lazyInitOnAdd(description, additionalDescription);
    }

    public void setCopyrightAndOtherRestrictions(SourceValuePair copyrightAndOtherRestrictions) {
        this.copyrightAndOtherRestrictions = copyrightAndOtherRestrictions;
    }

    public void setCost(SourceValuePair cost) {
        this.cost = cost;
    }

}