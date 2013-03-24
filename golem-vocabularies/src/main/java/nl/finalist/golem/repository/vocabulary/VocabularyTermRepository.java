package nl.finalist.golem.repository.vocabulary;

import org.springframework.data.neo4j.repository.GraphRepository;

interface VocabularyTermRepository extends GraphRepository<VocabularyTermNode> {

    VocabularyTermNode findByUri(String uri);

}
