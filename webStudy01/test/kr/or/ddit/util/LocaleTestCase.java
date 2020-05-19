package kr.or.ddit.util;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;

public class LocaleTestCase { //POJO(Plain Old Java Object)
	@Test
	public void test1() {
		Locale defaultLoc = Locale.getDefault();
		String localeCode = defaultLoc.toLanguageTag();
		System.out.println(localeCode);
		Locale locale = Locale.forLanguageTag(localeCode);
		System.err.println(locale == defaultLoc);
		System.err.println(locale.equals(defaultLoc));
	}

	@Test
	public void asdfas() {
		Locale defaultLoc = Locale.getDefault();
		String lang = defaultLoc.getLanguage();
		String country = defaultLoc.getCountry();
		System.out.printf("language : %s, country : %s, localeCode : %s\n", 
					lang, country, defaultLoc.toString());
		System.out.printf("language : %s, country : %s\n",
					defaultLoc.getDisplayLanguage(),  defaultLoc.getDisplayCountry());
		Locale[] locales = Locale.getAvailableLocales();
		for(Locale tmp : locales) {
			System.out.printf("language : %s, country : %s\n",
					tmp.getDisplayLanguage(tmp),  tmp.getDisplayCountry(tmp));
		}
	}

}






