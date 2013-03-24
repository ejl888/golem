package nl.finalist.golem.web.lom;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipException;

import javax.xml.bind.JAXBException;

import nl.finalist.golem.service.lom.LomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/lom")
public class LomAdminController {

//    private static final Logger LOG = LoggerFactory.getLogger(VocabularyAdminController.class);
    
    private static final String VIEW_BASE = "admin/lom";
    
    @Autowired LomService lomService;
    
    // list all VDEX
    @RequestMapping
    String doIt(Model model) throws ZipException, IOException, JAXBException {
    	
    	final File archiveFile = new File("C:/Users/ernst-jan/Documents/Customers/Kennisnet/1500.zip");
		lomService.loadLomsFromArchive(archiveFile);
    	
    	
        return VIEW_BASE + "/succes";
    }

}
