package nl.finalist.golem.service.lom.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.finalist.golem.repository.lom.LomClassificationNode;
import nl.finalist.golem.repository.lom.LomRecordNode;
import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;

import org.ieee.ltsc.Classification;
import org.ieee.ltsc.Lom;
import org.ieee.ltsc.Taxon;
import org.ieee.ltsc.TaxonPath;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Component
public class LomFieldClassificationMerger extends LanguageSpecificMerger implements LomFieldMerger {

    @Override
	public void merge(Lom lom, final LomRecordNode recordNode) {
		final Function<Classification, LomClassificationNode> classificationTransformer =
		        new Function<Classification, LomClassificationNode>() {
			@Override
			public LomClassificationNode apply(Classification input)  {
				final VocabularyTermNode purpose = findOrCreateVocabularyTerm(input.getPurpose());
				LomClassificationNode result = new LomClassificationNode(recordNode, purpose);

				// TODO description en keywords
				result.setClassifiers(toClassifiers(input.getTaxonPaths()));
				
				return result;
			}
		};
		
		recordNode.setClassifications(new HashSet<>(Lists.transform(lom.getClassifications(), classificationTransformer)));
	}

    protected Set<VocabularyTermNode> toClassifiers(List<TaxonPath> taxonPaths) {
        if (taxonPaths == null) {
            return null;
        }
        
        final Set<VocabularyTermNode> result = new HashSet<>(taxonPaths.size());
        for (TaxonPath taxonPath : taxonPaths) {
            final String vocabularySourceId = taxonPath.getSource().getValue();
            
            final List<Taxon> taxons = taxonPath.getTaxons();
            for (Taxon taxon : taxons) {
                result.add(findOrCreateVocabularyTerm(vocabularySourceId, taxon.getId()));
            }
        }
        return result;
    }


}
