package nl.finalist.golem.service.vdex;

import java.io.Reader;
import java.util.List;

import javax.xml.bind.JAXBException;

public interface VdexService {
    
    public void saveVdex(Reader reader, String vocabularySourceId) throws JAXBException;

    public List<VdexSummary> allVdexSummaries();

}
