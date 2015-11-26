package com.blogcalendar.languagestrategy;

import com.blogcalendar.reference.Constants;
import com.blogcalendar.reference.TIME;

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
		if (val % Constants.UKR_SEQUENCE_LIMIT == Constants.UKR_SINGULAR) {
			return Constants.INDEX_SINGULAR;
		} else if (val % Constants.UKR_SEQUENCE_LIMIT > Constants.UKR_SINGULAR 
				&& val % Constants.UKR_SEQUENCE_LIMIT < Constants.UKR_PLURAL_END) {
			return Constants.INDEX_PLURAL_FORM_ONE;
		} else if (val % Constants.UKR_SEQUENCE_LIMIT >= Constants.UKR_PLURAL_END
				|| val % Constants.UKR_SEQUENCE_LIMIT == Constants.UKR_PLURAL_START  ) {
			return Constants.INDEX_PLURAL_FORM_TWO;
		} else {
			 return Constants.INDEX_NOT_FOUND;
		}
	}
	
	@Override
	public String getLocalizedText(TIME timeLabel, int value) {
		
		if (timeLabel == TIME.TIMESTRATEGY)  {
			return UkrLocalization.getTranslation(timeLabel, value);
		} else if (value != 0) {
			return value + " " 
					+ UkrLocalization.getTranslation(timeLabel, UkraineRule(value)) 
					+ ", ";
		} else return "";
	}

}
