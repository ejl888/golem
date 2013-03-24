package nl.finalist.golem.repository.lom;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface LomRecordRepository extends GraphRepository<LomRecordNode> {

    LomRecordNode findByRecordId(String recordId);

}
