package nl.finalist.golem.service.lom.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.finalist.golem.repository.lom.LanguageNode;
import nl.finalist.golem.repository.lom.LearningObjectIdentifierNode;
import nl.finalist.golem.repository.lom.LomGeneralNode;
import nl.finalist.golem.repository.lom.LomRecordNode;

import org.ieee.ltsc.CatalogEntry;
import org.ieee.ltsc.General;
import org.ieee.ltsc.Keyword;
import org.ieee.ltsc.Langstring;
import org.ieee.ltsc.Lom;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Component
class LomFieldGeneralMerger extends SingleLanguageLomMerger implements LomFieldMerger {

	private final Function<CatalogEntry, LearningObjectIdentifierNode> identifierTransformer = 
			new Function<CatalogEntry, LearningObjectIdentifierNode>() {
		@Override
        public LearningObjectIdentifierNode apply(CatalogEntry input) {
            return new LearningObjectIdentifierNode(input.getCatalog(),	getBestValue(input.getEntries()));
        }
	};

	private final Function<String, LanguageNode> languageTransformer = new Function<String, LanguageNode>() {
		@Override
        public LanguageNode apply(String input) {
            return new LanguageNode(input);
        }
	};

	@Override
	public void merge(Lom lom, LomRecordNode recordNode) {
		final General source = lom.getGeneral();
		
		final LomGeneralNode target = new LomGeneralNode(recordNode);
        recordNode.setGeneral(target);
		
		List<Langstring> title = source.getTitle();
		target.setTitle(getBestText(title));
		target.setDescription(getBestText(source.getTitle()));
		target.setKeywords(toKeywordsArray(source.getKeywords()));
		target.setCoverage(getBestText(source.getCoverage()));
		target.setIdentifiers(toIdentifiers(source.getCatalogEntries()));
		target.setLanguages(toLanguages(source.getLanguages()));
	}

	private Set<LanguageNode> toLanguages(List<String> languages) {
		return new HashSet<>(Lists.transform(languages, languageTransformer));
	}

	private Set<LearningObjectIdentifierNode> toIdentifiers(List<CatalogEntry> catalogEntries) {
		return new HashSet<>(Lists.transform(catalogEntries, identifierTransformer));
	}

	private String[] toKeywordsArray(List<Keyword> keywords) {
		final List<String> keywordStrings = new ArrayList<>(keywords.size());
		for (Keyword keyword : keywords) {
			keywordStrings.add(getBestText(keyword.getLangstring()));
		}
		return keywordStrings.toArray(new String[keywordStrings.size()]);
	}

}
