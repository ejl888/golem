package nl.finalist.golem.service.vdex.impl;

import java.io.Reader;
import java.util.List;

import javax.xml.bind.JAXBException;

import nl.finalist.golem.repository.vdex.VdexNode;
import nl.finalist.golem.repository.vdex.VdexNodeRepository;
import nl.finalist.golem.service.vdex.VdexSummary;
import nl.finalist.golem.service.vdex.VdexService;
import nl.finalist.golem.service.vdex.xml.Vdex;
import nl.finalist.golem.service.vdex.xml.VdexLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Service
public class VdexServiceImpl implements VdexService {

    @Autowired private VdexMerger vdexMerger;
    
    @Autowired private VdexLoader vdexLoader;
    
    @Autowired private VdexNodeRepository vdexRepository;
    
    private static final Function<VdexNode, VdexSummary> VDEX_SUMMARY_TRANSFORMER = new Function<VdexNode, VdexSummary>() {
        @Override
        public VdexSummary apply(VdexNode input) {
            return VdexSummary.aVdexSummary()
                    .withIdentifier(input.getId())
                    .withName(input.getName())
                    .build();
        };
    };  
    
    @Override
    public void saveVdex(Reader reader, String vocabularySourceUri) throws JAXBException {
        Vdex vdex = vdexLoader.fromReader(reader);
        vdexMerger.merge(vdex, vocabularySourceUri);
    }

    @Override
    public List<VdexSummary> allVdexSummaries() {
        return Lists.transform(Lists.newArrayList(vdexRepository.findAll()), VDEX_SUMMARY_TRANSFORMER);
    }
}
