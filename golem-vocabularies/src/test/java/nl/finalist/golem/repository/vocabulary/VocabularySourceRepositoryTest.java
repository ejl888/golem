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
public class VocabularySourceRepositoryTest {

    @Autowired VocabularySourceRepository testSubject;
    
    @Test
    public void save_and_merge() {
        final VocabularySourceNode newEntity = new VocabularySourceNode(LOM_V1_0);
        VocabularySourceNode saved = testSubject.save(newEntity);
        
        VocabularySourceNode actual = testSubject.findOne(saved.getNodeId());
        
        assertThat(actual.getUri(), equalTo(LOM_V1_0));
    }

}
