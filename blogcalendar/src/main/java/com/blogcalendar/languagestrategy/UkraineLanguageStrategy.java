package com.blogcalendar.languagestrategy;

import com.blogcalendar.util.Constant;
import com.blogcalendar.util.TIMEUNIT;

/**
 * @author Olexander Kolodiazhny
 * Ukrainian language strategy helps us to determine correct form 
 * of singular (2 variants) or plural text form in Ukrainian 
 * depends unit of time. 
 * 
 * Examples: 
 * 
 * 1 день
 * 2 роки
 * 7 хвилин
 * 11 місяців
 */

public class UkraineLanguageStrategy implements LanguageStrategy {
	
	private int UkraineRule(int val) {
		if (val % Constant.UKR_SEQUENCE_LIMIT == Constant.UKR_SINGULAR) {
			return Constant.INDEX_SINGULAR;
		} else if (val % Constant.UKR_SEQUENCE_LIMIT > Constant.UKR_SINGULAR 
				&& val % Constant.UKR_SEQUENCE_LIMIT < Constant.UKR_PLURAL_END) {
			return Constant.INDEX_PLURAL_FORM_ONE;
		} else if (val % Constant.UKR_SEQUENCE_LIMIT >= Constant.UKR_PLURAL_END
				|| val % Constant.UKR_SEQUENCE_LIMIT == Constant.UKR_PLURAL_START  ) {
			return Constant.INDEX_PLURAL_FORM_TWO;
		} else {
			 return Constant.INDEX_NOT_FOUND;
		}
	}
	
	@Override
	public String getLocalizedText(TIMEUNIT timeLabel, int value) {
		
		if (timeLabel == TIMEUNIT.TIMESTRATEGY)  {
			return UkrLocalization.getTranslation(timeLabel, value);
		} else if (value != 0) {
			return value + " " 
					+ UkrLocalization.getTranslation(timeLabel, UkraineRule(value)) 
					+ ", ";
		} else return "";
	}

}
