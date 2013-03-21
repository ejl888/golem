package nl.finalist.golem.web.vocabulary;

import nl.finalist.golem.service.vocabulary.VocabularyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/vocabulary")
public class VocabularyAdminController {

    private static final Logger LOG = LoggerFactory.getLogger(VocabularyAdminController.class);
    
    
    @Autowired VocabularyService vocabularyService;
    
    // list all VDEX
    @RequestMapping
    String index(Model model) {
        model.addAttribute("vdexs", vocabularyService.allVdexSummaries());
        return "admin/vocabulary/vdexs";
    }

    
}
