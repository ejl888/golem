package nl.finalist.golem.service.lom.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.xml.bind.JAXBException;

import nl.finalist.golem.repository.lom.LomRecordNode;
import nl.finalist.golem.service.lom.LomService;
import nl.finalist.golem.service.lom.ProcessSummary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LomServiceImpl implements LomService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(LomServiceImpl.class);

	@Autowired
	private LomRecordMerger lomMerger;

	@Override
	public ProcessSummary loadLomsFromArchive(File archiveFile) throws ZipException, IOException, JAXBException {
		final ProcessSummary result = new ProcessSummary();

		try (ZipFile zipfile = new ZipFile(archiveFile)) {
            final int numberOfEntries = zipfile.size();
			
            int i = 0;
			// Enumerate each entry
			for (Enumeration<? extends ZipEntry> entries = zipfile.entries(); entries.hasMoreElements();) {
				ZipEntry zipEntry = entries.nextElement();
				i++;
				try (InputStream zipEntryInputStream = zipfile.getInputStream(zipEntry)) {
			
					Reader zipEntryReader = new InputStreamReader(zipEntryInputStream, "UTF-8");
					
					final LomRecordNode lomRecordNode = lomMerger.merge(zipEntryReader, 
					        toLomRecordId(zipEntry.getName()));
					if (i % 100 == 0) {
					    LOGGER.info("Processed entry {} from {} nodeID = {}", i, numberOfEntries, lomRecordNode.getNodeId());
					}
                } catch (JAXBException ex) {
                    LOGGER.debug("Skipping entry {} due to unmarshall error {}", zipEntry.getName(), ex.getMessage());
				} catch (Exception ex) {
				    LOGGER.error("foutje", ex);
				}
			}
		}

		return result;
	}

	private String toLomRecordId(String name) {
		int lastIndexOf = name.lastIndexOf('/');
		if (lastIndexOf > -1) {
			name = name.substring(lastIndexOf);
		}
		return name;
	}

}
