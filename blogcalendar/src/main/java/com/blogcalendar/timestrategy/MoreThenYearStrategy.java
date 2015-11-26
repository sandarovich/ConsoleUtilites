package com.blogcalendar.timestrategy;

import org.joda.time.Period;

import com.blogcalendar.languagestrategy.LanguageStrategy;
import com.blogcalendar.reference.Constants;
import com.blogcalendar.reference.TIME;

/**
 * @author Olexander Kolodiazhny
 * 
 * This strategy is need to correct application behaviors
 * in case when period value is more than one year.
 * 
 * 
 * Examples: 
 * Ukraininan localization: більше року: 1 рік 7 місяців 12 днів
 * Russsian localization: больше года: 1 год 7 месяцев 12 дней
 * English localization: more than a year: 1 year 7 month 12 days
 *  
 */

public class MoreThenYearStrategy implements TimeStrategy {
	
	@Override
	public String getDescriptiveLocalization(Period period, LanguageStrategy languageStrategy) {

		String out = languageStrategy.getLocalizedText(TIME.TIMESTRATEGY, 4) 
				+  languageStrategy.getLocalizedText (TIME.YEARS, period.getYears())
				+  languageStrategy.getLocalizedText (TIME.MONTHS, period.getMonths()) 
				+  languageStrategy.getLocalizedText (TIME.DAYS, period.getDays() 
						+ Constants.DAYS_IN_WEEK * period.getWeeks());

		return out;
	}

}
