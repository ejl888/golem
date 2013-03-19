package nl.finalist.golem.repository.vocabulary;

import static nl.finalist.golem.repository.vocabulary.VocabularySourceNode.LOM_V1_0;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/vocabularies-context.xml" })
public class VocabularyTermRepositoryTest {

    private static final String AUTHOR_SOURCE_ID = "author";
    @Autowired VocabularyTermRepository testSubject;
    @Autowired VocabularySourceRepository sourceRepository;
    
    @Test
    public void save_and_merge() {
        final VocabularySourceNode newSource = new VocabularySourceNode(LOM_V1_0);
        VocabularySourceNode savedSource = sourceRepository.save(newSource);
        
        VocabularyTermNode savedTerm = testSubject.save(new VocabularyTermNode(savedSource, AUTHOR_SOURCE_ID));
        
        VocabularyTermNode actual = testSubject.findOne(savedTerm.getNodeId());
        
        assertThat(actual.getSourceId(), equalTo(AUTHOR_SOURCE_ID));
    }

}
