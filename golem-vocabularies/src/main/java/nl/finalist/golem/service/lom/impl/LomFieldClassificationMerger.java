package nl.finalist.golem.service.lom.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.finalist.golem.repository.lom.LomClassificationNode;
import nl.finalist.golem.repository.lom.LomRecordNode;
import nl.finalist.golem.repository.vocabulary.VocabularyTermNode;

import org.apache.commons.lang3.StringUtils;
import org.ieee.ltsc.Classification;
import org.ieee.ltsc.Lom;
import org.ieee.ltsc.Taxon;
import org.ieee.ltsc.TaxonPath;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Component
class LomFieldClassificationMerger extends SingleLanguageLomMerger implements LomFieldMerger {

    @Override
	public void merge(Lom lom, final LomRecordNode recordNode) {
		final Function<Classification, LomClassificationNode> classificationTransformer =
		        new Function<Classification, LomClassificationNode>() {
			@Override
			public LomClassificationNode apply(Classification input)  {
				final VocabularyTermNode purpose = findOrCreateVocabularyTerm(input.getPurpose());
				LomClassificationNode result = new LomClassificationNode(recordNode, purpose);

				// TODO description and keywords
				result.setClassifiers(toClassifiers(input.getTaxonPaths()));
				
				return result;
			}
		};
		
		recordNode.setClassifications(new HashSet<>(
		        Lists.transform(lom.getClassifications(), classificationTransformer)));
	}

    protected Set<VocabularyTermNode> toClassifiers(List<TaxonPath> taxonPaths) {
        if (taxonPaths == null) {
            return null;
        }
        
        final Set<VocabularyTermNode> result = new HashSet<>(taxonPaths.size());
        for (TaxonPath taxonPath : taxonPaths) {
            final String vocabularySourceId = getVocabularySourceUri(taxonPath);
            if (StringUtils.isNotBlank(vocabularySourceId)) {
                final List<Taxon> taxons = taxonPath.getTaxons();
                for (Taxon taxon : taxons) {
                    VocabularyTermNode term = save(findOrCreateVocabularyTerm(vocabularySourceId, taxon.getId()));
                    result.add(term);
                }
            }
        }
        return result;
    }

    public String getVocabularySourceUri(TaxonPath taxonPath) {
        if (taxonPath == null || taxonPath.getSource() == null) {
            return null;
        }
        return taxonPath.getSource().getValue();
    }
}
