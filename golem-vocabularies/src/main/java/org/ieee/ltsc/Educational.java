package org.ieee.ltsc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

import static com.finalist.commons.util.CollectionUtils.emptyListWhenNull;
import static com.finalist.commons.util.CollectionUtils.lazyInitOnAdd;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
@XmlType(propOrder = {"interactivityType", "learningResourceTypes", /* "interactivitylevel", "semanticdensity", */
        "intendedEndUserRoles", "contexts", "typicalAgeRanges", /* "difficulty", */ "typicalLearningTime"
        /* "description",  "language"*/ })
public final class Educational {

    @XmlElement(name = "context")
    private List<SourceValuePair> contexts;

    @XmlElementWrapper(name = "typicalagerange")
    @XmlElement(name = "langstring")
    private List<Langstring> typicalAgeRanges;

    @XmlElement(name = "learningresourcetype")
    private List<SourceValuePair> learningResourceTypes;

    @XmlElement(name = "intendedenduserrole")
    private List<SourceValuePair> intendedEndUserRoles;

    @XmlElement(name = "interactivitytype")
    private SourceValuePair interactivityType;

    @XmlElement(name = "typicallearningtime")
    private TypicalLearningTime typicalLearningTime;


    public List<SourceValuePair> getContexts() {
        return emptyListWhenNull(contexts);
    }

    public void addContext(SourceValuePair extraContext) {
        this.contexts = lazyInitOnAdd(contexts, extraContext);
    }

    public void removeContexts() {
        if (contexts != null) {
            this.contexts.clear();
        }
    }

    public SourceValuePair getInteractivityType() {
        return interactivityType;
    }

    public List<SourceValuePair> getIntendedEndUserRoles() {
        return emptyListWhenNull(intendedEndUserRoles);
    }

    public void addIntendedEndUserRole(SourceValuePair extraIntendedEndUserRole) {
        this.intendedEndUserRoles = lazyInitOnAdd(intendedEndUserRoles, extraIntendedEndUserRole);
    }

    public List<SourceValuePair> getLearningResourceTypes() {
        return emptyListWhenNull(learningResourceTypes);
    }

    public void addLearningResourceType(SourceValuePair extraLearningResourceType) {
        this.learningResourceTypes = lazyInitOnAdd(learningResourceTypes, extraLearningResourceType);
    }

    public List<Langstring> getTypicalAgeRanges() {
        return emptyListWhenNull(typicalAgeRanges);
    }

    public void addTypicalAgeRange(Langstring extraTypicalAgeRange) {
        this.typicalAgeRanges = lazyInitOnAdd(typicalAgeRanges, extraTypicalAgeRange);
    }

    public TypicalLearningTime getTypicalLearningTime() {
        return typicalLearningTime;
    }

    public void setIntendedEndUserRoles(List<SourceValuePair> intendedEndUserRoles) {
        this.intendedEndUserRoles = intendedEndUserRoles;
    }

    public void setLearningResourceTypes(List<SourceValuePair> learningResourceTypes) {
        this.learningResourceTypes = learningResourceTypes;
    }

    public void setContexts(List<SourceValuePair> contexts) {
        this.contexts = contexts;
    }
    
    public void setTypicalLearningTime(TypicalLearningTime typicalLearningTime) {
        this.typicalLearningTime = typicalLearningTime;
    }
}