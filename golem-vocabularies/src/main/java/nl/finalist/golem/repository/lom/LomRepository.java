package nl.finalist.golem.repository.lom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LomRepository {

    @Autowired LomRecordRepository lomRecordRepository;
    
    public LomRecordNode findOrCreateLomRecord(String recordId) {
        LomRecordNode result = lomRecordRepository.findByRecordId(recordId);
        if (result == null) {
            result = save(new LomRecordNode(recordId));
        }
        return result;
    }

    public LomRecordNode save(LomRecordNode entity) {
        return lomRecordRepository.save(entity);
    }
}
