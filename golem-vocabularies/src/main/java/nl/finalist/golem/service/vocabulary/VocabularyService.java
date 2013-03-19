package nl.finalist.golem.service.vocabulary;

import java.io.Reader;

import javax.xml.bind.JAXBException;

public interface VocabularyService {
    
    public void saveVdex(Reader reader, String vocabularySourceId) throws JAXBException;
}
