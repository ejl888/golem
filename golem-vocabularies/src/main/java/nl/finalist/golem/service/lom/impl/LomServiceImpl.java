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
	private LomMerger lomMerger;

	@Override
	public ProcessSummary loadLomsFromArchive(File archiveFile) throws ZipException, IOException, JAXBException {
		final ProcessSummary result = new ProcessSummary();

		try (ZipFile zipfile = new ZipFile(archiveFile)) {
			
			// Enumerate each entry
			for (Enumeration<? extends ZipEntry> entries = zipfile.entries(); entries.hasMoreElements();) {
				ZipEntry zipEntry = entries.nextElement();

				
				try (InputStream zipEntryInputStream = zipfile.getInputStream(zipEntry)) {
			
					Reader zipEntryReader = new InputStreamReader(zipEntryInputStream, "UTF-8");
					
					lomMerger.merge(zipEntryReader, toLomRecordId(zipEntry.getName()));
				} catch (Exception ex) {
					LOGGER.warn("Skipping entry {} due to {}", zipEntry.getName(), ex.getMessage());
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
