package nl.finalist.golem.service.lom;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipException;

import javax.xml.bind.JAXBException;

public interface LomService {

	
	
	ProcessSummary loadLomsFromArchive(File archiveFile) throws ZipException, IOException, JAXBException;

}
