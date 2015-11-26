package com.blogcalendar.languagestrategy;

import com.blogcalendar.reference.Constants;
import com.blogcalendar.reference.TIME;

/**
 * @author Olexander Kolodiazhny
 * Russian language strategy helps us to determine correct form 
 * of singular (2 variants) or plural text form in Russian 
 * depends unit of time. 
 * 
 * Examples: 
 *  
 * 2 дня
 * 3 года
 * 7 минут
 * 11 месяцев
 * 
 */

public class RussianLanguageStrategy implements LanguageStrategy {
		
	private int RussianRule(int val) {
		if (val % Constants.RUS_SEQUENCE_LIMIT == Constants.RUS_SINGULAR) {
			return Constants.INDEX_SINGULAR;
		} else if (val % Constants.RUS_SEQUENCE_LIMIT > Constants.RUS_SINGULAR 
				&& val % Constants.RUS_SEQUENCE_LIMIT < Constants.RUS_PLURAL_END) {
			return Constants.INDEX_PLURAL_FORM_ONE;
		} else if (val % Constants.RUS_SEQUENCE_LIMIT >= Constants.RUS_PLURAL_END
				|| val % Constants.RUS_SEQUENCE_LIMIT == Constants.RUS_PLURAL_START  ) {
			return Constants.INDEX_PLURAL_FORM_TWO;
		} else {
			return Constants.INDEX_NOT_FOUND;
		}
	}
	
	@Override
	public String getLocalizedText(TIME timeLabel, int value) {		
		if (timeLabel == TIME.TIMESTRATEGY) {
			return RusLocalization.getTranslation(timeLabel, value);
		} else if (value != 0) {
			return value + " " 
					+ RusLocalization.getTranslation(timeLabel, RussianRule(value)) 
					+ ", ";
		} else return "";
	}
}
