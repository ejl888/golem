package nl.finalist.golem.service.vdex.xml;

import java.io.Reader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

@Component
public class VdexLoader {

//    private static final Logger LOG = LoggerFactory.getLogger(VdexLoader.class);
    private static final JAXBContext CONTEXT;
    
    static {
        try {
            CONTEXT = JAXBContext.newInstance(Vdex.class);
        } catch (JAXBException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
   
    public Vdex fromReader(Reader reader) throws JAXBException {
        final Unmarshaller unmarshaller = CONTEXT.createUnmarshaller();
        return (Vdex) unmarshaller.unmarshal(reader);
    }
}
