package nl.finalist.golem.service.vocabulary.impl;

import java.io.Reader;

import javax.xml.bind.JAXBException;

import nl.finalist.golem.service.vdex.xml.Vdex;
import nl.finalist.golem.service.vdex.xml.VdexLoader;
import nl.finalist.golem.service.vocabulary.VocabularyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VocabularyServiceImpl implements VocabularyService {

    @Autowired private VdexMerger vdexMerger;
    
    @Autowired private VdexLoader vdexLoader;
    
    @Override
    public void saveVdex(Reader reader, String vocabularySourceUri) throws JAXBException {
        Vdex vdex = vdexLoader.fromReader(reader);
        vdexMerger.merge(vdex, vocabularySourceUri);
    }


}
