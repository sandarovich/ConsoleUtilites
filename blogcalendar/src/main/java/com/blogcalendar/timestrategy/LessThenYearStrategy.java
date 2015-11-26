package com.blogcalendar.timestrategy;

import org.joda.time.Period;

import com.blogcalendar.languagestrategy.LanguageStrategy;
import com.blogcalendar.reference.Constants;
import com.blogcalendar.reference.TIME;

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
		String out = languageStrategy.getLocalizedText(TIME.TIMESTRATEGY, 3) 
				+  languageStrategy.getLocalizedText (TIME.MONTHS, period.getMonths()) 
				+  languageStrategy.getLocalizedText (TIME.DAYS, period.getDays() 
						+ Constants.DAYS_IN_WEEK * period.getWeeks() );

		return out;
	}

}