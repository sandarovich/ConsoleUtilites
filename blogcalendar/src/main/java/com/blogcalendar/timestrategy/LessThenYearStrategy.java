package com.blogcalendar.timestrategy;

import org.joda.time.Period;

import com.blogcalendar.languagestrategy.LanguageStrategy;
import com.blogcalendar.reference.Constant;
import com.blogcalendar.reference.TIMEUNIT;

/**
 * @author Olexander Kolodiazhny
 * 
 * 
 * This strategy is need to correct application behaviors
 * in case when period value is less than one year.
 * 
 * Examples: 
 * Ukraininan localization: меньше року: 7 місяців 12 днів
 * Russsian localization: меньше года: 7 месяцев 12 дней
 * English localization: less than a year: 7 months 12 days
 *  
 */

public class LessThenYearStrategy implements TimeStrategy {
		
	@Override
	public String getDescriptiveLocalization(Period period, LanguageStrategy languageStrategy) {
		String out = languageStrategy.getLocalizedText(TIMEUNIT.TIMESTRATEGY, 3) 
				+  languageStrategy.getLocalizedText (TIMEUNIT.MONTHS, period.getMonths()) 
				+  languageStrategy.getLocalizedText (TIMEUNIT.DAYS, period.getDays() 
						+ Constant.DAYS_IN_WEEK * period.getWeeks() );

		return out;
	}

}