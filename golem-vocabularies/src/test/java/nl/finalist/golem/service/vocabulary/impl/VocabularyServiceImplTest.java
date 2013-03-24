package nl.finalist.golem.service.vocabulary.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBException;

import nl.finalist.golem.service.vdex.impl.VdexServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class VocabularyServiceImplTest {

    @Autowired private VdexServiceImpl testSubject;

    @Configuration
    @ImportResource(value = {"classpath:/vocabularies-test-context.xml" })
    static class ContextConfiguration {
    }
    
    @Test public void writing_flat_vdex_without_relations() 
            throws UnsupportedEncodingException, IOException, JAXBException {
        final Reader reader = new InputStreamReader(
                getClass().getResourceAsStream("/vdex/vdex_context_czp_20060628.xml"),
                "UTF-8");
        
        testSubject.saveVdex(reader, "http://download.edustandaard.nl/vdex/vdex_context_czp_20060628.xml");
    }

}
