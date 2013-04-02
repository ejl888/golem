package nl.finalist.golem.lom;

import java.io.File;

import nl.finalist.golem.service.lom.LomService;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Imports an edurep dump zip archive (IEEE)
 * 
 */
public class ImportEdurepDump
{

	public static void main(final String[] args) throws Exception
	{
		final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		try {
            LomService lomService = (LomService) context.getBean("lomServiceImpl");
            
            final File archiveFile = new File("C:/Users/ernst-jan/Documents/Customers/Kennisnet/1700.zip");
            lomService.loadLomsFromArchive(archiveFile);
        } finally {
            GraphDatabaseService service = (GraphDatabaseService) context.getBean("graphDatabaseService");
            service.shutdown();
        }
	}

}
