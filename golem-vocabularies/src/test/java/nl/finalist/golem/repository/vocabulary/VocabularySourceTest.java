package nl.finalist.golem.repository.vocabulary;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/vocabularies-context.xml" })
public class VocabularySourceTest {
    
    @Autowired Neo4jTemplate template;

    @Test @Transactional
    public void persistedVocabularySourceShouldBeRetrievableFromGraphDb() {
        VocabularySourceNode newVocabularySource = new VocabularySourceNode("LOMv1.0");
        VocabularySourceNode saved = template.save(newVocabularySource);
        
        VocabularySourceNode actual = template.findOne(saved.getNodeId(), VocabularySourceNode.class);
        assertThat(actual.getUri(), equalTo("LOMv1.0"));
    }
}
