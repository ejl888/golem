package nl.finalist.golem.repository.vocabulary;

import static nl.finalist.golem.repository.vocabulary.VocabularyTermNode.createUri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VocabularyRepository {

    private static final String URI_PROP = "uri";

    @Autowired
    private VocabularySourceRepository vocabularySourceRepository;
    
    @Autowired
    private VocabularyTermRepository vocabularyTermRepository;

    public VocabularyTermNode findOrCreateVocabularyTerm(String vocabularySourceId, String sourceTermId) {
        VocabularyTermNode result = vocabularyTermRepository.findByUri(createUri(vocabularySourceId, sourceTermId));
        if (result == null) {
            result = new VocabularyTermNode(findOrCreateVocabularySource(vocabularySourceId), sourceTermId);
        }
        return result;
    }

    public VocabularySourceNode findOrCreateVocabularySource(String vocabularySourceUri) {
        VocabularySourceNode vocabularySource = findVocabularySourceByUri(vocabularySourceUri);
        if (vocabularySource == null) {
            vocabularySource = createVocabularySource(vocabularySourceUri);
        }
        return vocabularySource;
    }

    private VocabularySourceNode createVocabularySource(String vocabularySourceUri) {
        VocabularySourceNode entity = new VocabularySourceNode(vocabularySourceUri);
        return save(entity);
    }

    public VocabularySourceNode save(VocabularySourceNode entity) {
        return vocabularySourceRepository.save(entity);
    }
    
    public VocabularyTermNode save(VocabularyTermNode entity) {
        return vocabularyTermRepository.save(entity);
    }

    private VocabularySourceNode findVocabularySourceByUri(String vocabularySourceUri) {
        return vocabularySourceRepository.findByPropertyValue(URI_PROP, vocabularySourceUri);
    }

}
