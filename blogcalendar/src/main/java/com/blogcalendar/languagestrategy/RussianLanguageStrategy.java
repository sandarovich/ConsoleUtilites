package com.blogcalendar.languagestrategy;

import com.blogcalendar.util.Constant;
import com.blogcalendar.util.TIMEUNIT;

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
		if (val % Constant.RUS_SEQUENCE_LIMIT == Constant.RUS_SINGULAR) {
			return Constant.INDEX_SINGULAR;
		} else if (val % Constant.RUS_SEQUENCE_LIMIT > Constant.RUS_SINGULAR 
				&& val % Constant.RUS_SEQUENCE_LIMIT < Constant.RUS_PLURAL_END) {
			return Constant.INDEX_PLURAL_FORM_ONE;
		} else if (val % Constant.RUS_SEQUENCE_LIMIT >= Constant.RUS_PLURAL_END
				|| val % Constant.RUS_SEQUENCE_LIMIT == Constant.RUS_PLURAL_START  ) {
			return Constant.INDEX_PLURAL_FORM_TWO;
		} else {
			return Constant.INDEX_NOT_FOUND;
		}
	}
	
	@Override
	public String getLocalizedText(TIMEUNIT timeLabel, int value) {		
		if (timeLabel == TIMEUNIT.TIMESTRATEGY) {
			return RusLocalization.getTranslation(timeLabel, value);
		} else if (value != 0) {
			return value + " " 
					+ RusLocalization.getTranslation(timeLabel, RussianRule(value)) 
					+ ", ";
		} else return "";
	}
}
