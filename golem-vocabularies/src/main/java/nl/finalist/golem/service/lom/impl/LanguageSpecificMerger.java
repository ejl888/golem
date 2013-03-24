package nl.finalist.golem.service.lom.impl;

import java.util.List;

import nl.finalist.golem.repository.vocabulary.VocabularyRepository;
import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;

import org.ieee.ltsc.Langstring;
import org.ieee.ltsc.SourceValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LanguageSpecificMerger {

	@Autowired private LangStringHandler langStringHandler;
	
	@Autowired private VocabularyRepository vocabularyRepository;

	public String getBestText(List<Langstring> entries) {
		return langStringHandler.getLanguageText(entries);
	}
	
	public String getBestValue(List<Langstring> entries) {
		return langStringHandler.getValue(entries);
	}

    public final VocabularyTermNode findOrCreateVocabularyTerm(SourceValuePair sourceValue) {
        return findOrCreateVocabularyTerm(sourceValue.getSource().getValue(), sourceValue.getValue().getValue());
    }

    public VocabularyTermNode findOrCreateVocabularyTerm(String vocabularySourceUri, String termId) {
        return vocabularyRepository.findOrCreate(vocabularySourceUri, termId);
    }

}