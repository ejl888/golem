package nl.finalist.golem.service.lom.impl;

import java.io.Reader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.ieee.ltsc.Lom;
import org.springframework.stereotype.Component;

@Component
public class LomLoader {

//    private static final Logger LOG = LoggerFactory.getLogger(VdexLoader.class);
    private static final JAXBContext CONTEXT;
    
    static {
        try {
            CONTEXT = JAXBContext.newInstance(Lom.class);
        } catch (JAXBException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
   
    public Lom fromReader(Reader reader) throws JAXBException {
        final Unmarshaller unmarshaller = CONTEXT.createUnmarshaller();
        return (Lom) unmarshaller.unmarshal(reader);
    }
}
