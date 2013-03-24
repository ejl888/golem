package nl.finalist.golem.web.vdex;

import org.springframework.web.multipart.MultipartFile;

public class VdexForm {
    
    private MultipartFile file;
    private String vocabularySourceId;
    private String name;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVocabularySourceId(String vocabularySourceId) {
        this.vocabularySourceId = vocabularySourceId;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
        
    }

    public String getVocabularySourceId() {
        return vocabularySourceId;
    }
}
