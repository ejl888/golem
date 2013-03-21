package nl.finalist.golem.service.vocabulary;

import java.io.Reader;
import java.util.List;

import javax.xml.bind.JAXBException;

public interface VocabularyService {
    
    public void saveVdex(Reader reader, String vocabularySourceId) throws JAXBException;

    public List<VdexSummary> allVdexSummaries();
}
