package com.blogcalendar.timestrategy;

import org.joda.time.Period;

import com.blogcalendar.languagestrategy.LanguageStrategy;
import com.blogcalendar.util.Constant;
import com.blogcalendar.util.TIMEUNIT;

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
		
		String out = languageStrategy.getLocalizedText(TIMEUNIT.TIMESTRATEGY, 2) 
				+ languageStrategy.getLocalizedText (TIMEUNIT.DAYS, period.getDays() 
						+ Constant.DAYS_IN_WEEK * period.getWeeks());
		
		return out;
	}

}
