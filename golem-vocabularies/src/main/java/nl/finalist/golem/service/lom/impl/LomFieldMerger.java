package nl.finalist.golem.service.lom.impl;

import nl.finalist.golem.repository.lom.LomRecordNode;

import org.ieee.ltsc.Lom;

public interface LomFieldMerger {

	void merge(Lom lom, LomRecordNode recordNode);

}
