package org.ieee.ltsc;

import static com.finalist.commons.util.CollectionUtils.emptyListWhenNull;
import static com.finalist.commons.util.CollectionUtils.lazyInitOnAdd;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Note: empty lists are not supported by Edurep. Lists are created when first element is added.
 * Empty elements are not allowed as well.
 *
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlRootElement(name = "lom")
public final class Lom {

    private final General general = new General();
    private final Lifecycle lifecycle = new Lifecycle();
    private final MetaMetaData metametadata = new MetaMetaData();
    private final Technical technical = new Technical();
    private final Educational educational = new Educational();
    private final Rights rights = new Rights();

    @XmlElement(name = "relation")
    private List<Relation> relations;

    @XmlElement(name = "classification")
    private List<Classification> classifications;

    @XmlElement(name = "annotation")
    private List<Annotation> annotations;

    public List<Annotation> getAnnotations() {
        return emptyListWhenNull(annotations);
    }

    public void addAnnotation(Annotation additionalAnnotation) {
        this.annotations = lazyInitOnAdd(annotations, additionalAnnotation);
    }

    public List<Classification> getClassifications() {
        return emptyListWhenNull(classifications);
    }

    public void addClassification(Classification additionalClassification) {
        this.classifications = lazyInitOnAdd(classifications, additionalClassification);
    }

    public Educational getEducational() {
        return educational;
    }

    public General getGeneral() {
        return general;
    }

    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    public MetaMetaData getMetaMetaData() {
        return metametadata;
    }

    public List<Relation> getRelations() {
        return emptyListWhenNull(relations);
    }

    public void addRelation(Relation additionalRelation) {
        this.relations = lazyInitOnAdd(relations, additionalRelation);
    }

    public Rights getRights() {
        return rights;
    }

    public Technical getTechnical() {
        return technical;
    }
}