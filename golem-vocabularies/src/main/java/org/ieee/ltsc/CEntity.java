package org.ieee.ltsc;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class CEntity {

    private String vcard;
    
    public CEntity() {
        // required by JaxB
    }
    
    public CEntity(String vCard) {
        this.vcard = vCard;
    }
    
    public String getVcard() {
        return vcard;
    }

    
}
