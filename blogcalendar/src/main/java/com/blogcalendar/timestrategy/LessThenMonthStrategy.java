package com.blogcalendar.timestrategy;

import org.joda.time.Period;

import com.blogcalendar.languagestrategy.LanguageStrategy;
import com.blogcalendar.reference.Constants;
import com.blogcalendar.reference.TIME;

/**
 * @author Olexander Kolodiazhny
 * 
 * This strategy is need to correct application behaviors
 * in case when period value is less than one month.
 * 
 * Examples: 
 * Ukrainian localization: меньше місяця: 5 днів
 * Russian localization: меньше месяца: 5 дней
 * English localization: less than a month: 5 days
 *  
 */

public class LessThenMonthStrategy implements TimeStrategy {
		
	@Override
	public String getDescriptiveLocalization(Period period, LanguageStrategy languageStrategy) {
		
		String out = languageStrategy.getLocalizedText(TIME.TIMESTRATEGY, 2) 
				+ languageStrategy.getLocalizedText (TIME.DAYS, period.getDays() 
						+ Constants.DAYS_IN_WEEK * period.getWeeks());
		
		return out;
	}

}
