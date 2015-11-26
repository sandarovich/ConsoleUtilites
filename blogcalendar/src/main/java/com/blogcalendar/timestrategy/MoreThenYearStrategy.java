package com.blogcalendar.timestrategy;

import org.joda.time.Period;

import com.blogcalendar.languagestrategy.LanguageStrategy;
import com.blogcalendar.reference.Constant;
import com.blogcalendar.reference.TIMEUNIT;

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

		String out = languageStrategy.getLocalizedText(TIMEUNIT.TIMESTRATEGY, 4) 
				+  languageStrategy.getLocalizedText (TIMEUNIT.YEARS, period.getYears())
				+  languageStrategy.getLocalizedText (TIMEUNIT.MONTHS, period.getMonths()) 
				+  languageStrategy.getLocalizedText (TIMEUNIT.DAYS, period.getDays() 
						+ Constant.DAYS_IN_WEEK * period.getWeeks());

		return out;
	}

}
