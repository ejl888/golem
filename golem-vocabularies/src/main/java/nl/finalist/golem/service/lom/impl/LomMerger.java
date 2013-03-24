package nl.finalist.golem.service.lom.impl;

import java.io.Reader;
import java.util.List;

import javax.xml.bind.JAXBException;

import nl.finalist.golem.repository.lom.LomRecordNode;
import nl.finalist.golem.repository.lom.LomRecordRepository;

import org.ieee.ltsc.Lom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LomMerger {
	
	@Autowired LomRecordRepository lomRecordRepository;
	
	@Autowired LomLoader lomLoader;
	
	@Autowired List<LomFieldMerger> lomFieldMergers;
	
	public LomRecordNode merge(Reader reader, String recordId) throws JAXBException {
		final Lom lom = lomLoader.fromReader(reader);
		
		final LomRecordNode result = lomRecordRepository.save(new LomRecordNode(recordId));
		for (LomFieldMerger lomFieldMerger : lomFieldMergers) {
			lomFieldMerger.merge(lom, result);
		}
		return result;
	}

}
