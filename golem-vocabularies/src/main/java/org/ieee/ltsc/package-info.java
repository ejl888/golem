@XmlAccessorType(XmlAccessType.FIELD)
@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(value = DateTimeAdapter.class, type = Date.class)
})
@XmlSchema(namespace = "http://ltsc.ieee.org/xsd/LOM",
    elementFormDefault = XmlNsForm.QUALIFIED)
package org.ieee.ltsc;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

