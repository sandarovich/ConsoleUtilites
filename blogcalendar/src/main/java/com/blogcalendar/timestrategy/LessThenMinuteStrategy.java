package com.blogcalendar.timestrategy;

import org.joda.time.Period;

import com.blogcalendar.languagestrategy.LanguageStrategy;
import com.blogcalendar.util.TIMEUNIT;

/**
 * @author Olexander Kolodiazhny
 * 
 * This strategy is need to correct application behaviors
 * in case when period value is less than one minute.
 * 
 * Examples: 
 * Ukrainian localization: меньше хвилини
 * Russian localization: меньше минуты
 * English localization: less than a minute 
 */

public class LessThenMinuteStrategy implements TimeStrategy {
			
	@Override
	public String getDescriptiveLocalization(Period period, LanguageStrategy languageStrategy) {
		
		return languageStrategy.getLocalizedText(TIMEUNIT.TIMESTRATEGY, 0);
	}

}