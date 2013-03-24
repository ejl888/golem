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
@XmlType
public final class Lifecycle {

    @XmlElementWrapper(name = "version")
    @XmlElement(name = "langstring")
    private List<Langstring> versions;

    @XmlElement(name = "status")
    private SourceValuePair status;

    @XmlElement(name = "contribute")
    private List<Contribute> contribute;

    public List<Contribute> getContribute() {
        return emptyListWhenNull(contribute);
    }

    public void addContribute(Contribute extraContribute) {
        this.contribute = lazyInitOnAdd(contribute, extraContribute);
    }

    public SourceValuePair getStatus() {
        return status;
    }

    public List<Langstring> getVersions() {
        return emptyListWhenNull(versions);
    }

    public void addVersion(Langstring extraVersion) {
        this.versions = lazyInitOnAdd(versions, extraVersion);
    }

}