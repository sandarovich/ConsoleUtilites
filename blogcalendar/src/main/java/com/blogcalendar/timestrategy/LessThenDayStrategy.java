package com.blogcalendar.timestrategy;

import org.joda.time.Period;

import com.blogcalendar.languagestrategy.*;
import com.blogcalendar.reference.TIME;

/**
 * @author Olexander Kolodiazhny
 * 
 * This strategy is need to correct application behaviors
 * in case when period value is less than one day.
 * 
 * Examples: :
 * Ukrainian localization: меньше дня: 1 година 2 хвилини
 * Russian localization: меньше дня: 1 час 2 минуты
 * English localization: less than a day: 1 hour 2 minutes 
 */

public class LessThenDayStrategy implements TimeStrategy {
		
	@Override
	public String getDescriptiveLocalization(Period period, LanguageStrategy languageStrategy) {
		
		String out = languageStrategy.getLocalizedText(TIME.TIMESTRATEGY, 1) 
				+ languageStrategy.getLocalizedText (TIME.HOURS, period.getHours())
				+ languageStrategy.getLocalizedText (TIME.MINUTES, period.getMinutes());
		
		return out;
	}

}
