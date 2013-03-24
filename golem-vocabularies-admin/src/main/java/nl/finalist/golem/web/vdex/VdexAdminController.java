package nl.finalist.golem.web.vdex;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBException;

import nl.finalist.golem.service.vdex.VdexService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/vdex")
public class VdexAdminController {

//    private static final Logger LOG = LoggerFactory.getLogger(VocabularyAdminController.class);
    
    private static final String VIEW_BASE = "admin/vdex";
    
    @Autowired VdexService vdexService;
    
    // list all VDEX
    @RequestMapping
    String index(Model model) {
        model.addAttribute("vdexs", vdexService.allVdexSummaries());
        return VIEW_BASE + "/vdexs";
    }

    @RequestMapping(value = "/new")
    public String create(Model model) {
        model.addAttribute("vdex", new VdexForm());
        return VIEW_BASE + "/vdex-upload";
    }
    
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String create(@ModelAttribute("vdexForm") VdexForm form, Model model) throws IOException, JAXBException {
        final MultipartFile file = form.getFile();
        if (file != null) {
            InputStreamReader vdexReader = new InputStreamReader(file.getInputStream());
            vdexService.saveVdex(vdexReader, form.getVocabularySourceId());
        }
        model.addAttribute("vdexs", vdexService.allVdexSummaries());
        return VIEW_BASE + "/vdexs";
    }
}
