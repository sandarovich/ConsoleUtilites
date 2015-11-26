package com.blogcalendar.languagestrategy;

import com.blogcalendar.reference.Constants;
import com.blogcalendar.reference.TIME;

/**
 * @author Olexander Kolodiazhny
 * Strategy that determines plural or singular unit of a time according
 * to English language rule, return number value and respective descriptive text.
 * 
 * Example:
 * 
 * more than year
 * 1 day
 * 3 years
 * 2 months
 * 
 */

public class EnglishLanguageStrategy implements LanguageStrategy {
	
		
	
	@Override
	public String getLocalizedText(TIME timeLabel, int value) {
	
		if (timeLabel == TIME.TIMESTRATEGY) {
			return EngLocalization.getTranslation(timeLabel, value);
		} else if (value != 0) {
			return value + " " 
					+ EngLocalization.getTranslation(timeLabel, EnglishRule(value))
					+ ", ";
		} else {
			return "";
		}
		
	}
	
	private int EnglishRule(int val) {
		return (val == Constants.ENG_SINGULAR) ? 
				Constants.INDEX_SINGULAR : Constants.INDEX_PLURAL_FORM_ONE;
	};

}