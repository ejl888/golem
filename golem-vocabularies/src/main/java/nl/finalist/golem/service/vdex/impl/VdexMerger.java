package nl.finalist.golem.service.vdex.impl;

import java.util.Collection;
import java.util.List;

import nl.finalist.golem.repository.vdex.VdexNode;
import nl.finalist.golem.repository.vdex.VdexRepository;
import nl.finalist.golem.repository.vdex.VdexTerm;
import nl.finalist.golem.repository.vdex.VdexTermRelationshipNode;
import nl.finalist.golem.repository.vocabulary.VocabularyRepository;
import nl.finalist.golem.repository.vocabulary.VocabularySourceNode;
import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;
import nl.finalist.golem.service.vdex.xml.Relationship;
import nl.finalist.golem.service.vdex.xml.Term;
import nl.finalist.golem.service.vdex.xml.TermReference;
import nl.finalist.golem.service.vdex.xml.Vdex;
import nl.finalist.golem.service.vdex.xml.VocabularyTermReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Component
public class VdexMerger {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(VdexMerger.class);

    @Autowired private VocabularyRepository vocabularyRepository;
    @Autowired private VdexRepository vdexRepository;

    private String language = "nl";
    
    public void merge(Vdex vdex, String vocabularySourceUri) {
        VocabularySourceNode vocabularySource = findOrCreateVocabularySource(vocabularySourceUri);
        
        VdexNode vdexNode = new VdexNode(vocabularySource, 
                vdex.getIdentifier(), 
                vdex.getName().getValue(language));
        
        merge(vdex, vdexNode);
        
        vdexRepository.save(vdexNode);
    }

    private void merge(Vdex vdex, VdexNode vdexNode) {
        final Collection<Term> terms = vdex.getTerms();
        for (Term term : terms) {
            mergeTerm(vdexNode, term);
        }
        
        final List<Relationship> relationships = vdex.getRelationships();
        for (Relationship relationship : relationships) {
            mergeRelation(vdexNode, relationship);
        }
    }

    private void mergeRelation(VdexNode vdexNode, Relationship relationship) {
        Assert.notNull(relationship, "relationship is mandatory");

        final String localVocabularySourceUri = vdexNode.getVocabularySource().getUri();
        
        TermReference sourceTermReference = relationship.getSourceTerm();
        VocabularyTermNode sourceTerm = findOrCreateVocabularyTerm(sourceTermReference, localVocabularySourceUri);
        if (sourceTerm == null) {
            LOGGER.warn("Source term missing ", sourceTermReference);
        }
        
        TermReference targetTermReference = relationship.getTargetTerm();
        VocabularyTermNode targetTerm = findOrCreateVocabularyTerm(targetTermReference, localVocabularySourceUri);
        if (targetTerm == null) {
            LOGGER.warn("Source term missing ", sourceTermReference);
        }
        
        VocabularyTermReference relationshipType = relationship.getRelationshipType();
        VocabularyTermNode typeTerm = findOrCreateVocabularyTerm(relationshipType);
        
        new VdexTermRelationshipNode(vdexNode, typeTerm, sourceTerm, targetTerm);
    }

    private void mergeTerm(VdexNode vdexNode, Term term) {
        Assert.notNull(term, "term is mandatory");
        
        final VocabularySourceNode vocabularySource = vdexNode.getVocabularySource();
        VocabularyTermNode termNode = findOrCreateVocabularyTerm(vocabularySource.getUri(), term.getIdentifier());
        if (!termNode.isManaged()) {
            termNode.setCaption(term.getCaption().getValue(language));
            termNode.setDescription(term.getDescription().getValue(language));
            termNode.setManaged(true);
        }
        
        final VdexTerm vdexTerm = new VdexTerm(vdexNode, termNode);
        vdexTerm.setOrderSignificant(term.isOrderSignificant());
        vdexTerm.setValidIndex(term.isValidIndex());
    }

    private VocabularyTermNode findOrCreateVocabularyTerm(TermReference sourceTermReference,
            String localVocabularySourceUri) {
        final String termSourceId = sourceTermReference.getTermSourceId();
        final String vocabularySourceUri = sourceTermReference.getVocabularySourceURI();
        if (StringUtils.hasText(vocabularySourceUri)) {
            return findOrCreateVocabularyTerm(vocabularySourceUri, termSourceId);
        }
        return findOrCreateVocabularyTerm(localVocabularySourceUri, termSourceId);
    }
    
    private VocabularyTermNode findOrCreateVocabularyTerm(VocabularyTermReference termReference) {
        return findOrCreateVocabularyTerm(termReference.getVocabularySourceURI(), termReference.getTermSourceId());
    }
    
    private VocabularyTermNode findOrCreateVocabularyTerm(final String vocabularySourceId, String termSourceId) {
        return vocabularyRepository.findOrCreate(vocabularySourceId, termSourceId);
        
    }

    private VocabularySourceNode findOrCreateVocabularySource(String vocabularySourceUri) {
        return vocabularyRepository.findOrCreateVocabularySource(vocabularySourceUri);
    }
}

