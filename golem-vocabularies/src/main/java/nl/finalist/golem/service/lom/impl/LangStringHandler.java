package nl.finalist.golem.service.lom.impl;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.ieee.ltsc.Langstring;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LangStringHandler {

	private static final String NON_LANGUAGE = "x-none";
	
	@Value("${lom.record.merger.language}")
	private String language = "nl";
	
	public String getLanguageText(Collection<Langstring> languageStrings) {
		if (languageStrings == null || languageStrings.isEmpty()) {
			return null;
		}
		
		for (Langstring langstring : languageStrings) {
			if (language.equalsIgnoreCase(langstring.getLang())) {
				return langstring.getValue();
			}
		}
		
		return languageStrings.iterator().next().getValue();
	}

	public String getValue(Collection<Langstring> languageStrings) {
		if (languageStrings == null || languageStrings.isEmpty()) {
			return null;
		}
		
		for (Langstring langstring : languageStrings) {
			if (NON_LANGUAGE.equalsIgnoreCase(langstring.getLang())) {
				return langstring.getValue();
			}
		}

		for (Langstring langstring : languageStrings) {
			if (StringUtils.isBlank(langstring.getLang())) {
				return langstring.getValue();
			}
		}
		
		return languageStrings.iterator().next().getValue();
	}
}
