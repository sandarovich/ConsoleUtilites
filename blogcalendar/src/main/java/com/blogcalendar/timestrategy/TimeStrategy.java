package com.blogcalendar.timestrategy;

import org.joda.time.Period;

import com.blogcalendar.languagestrategy.LanguageStrategy;

/**
 * @author Olexander Kolodiazhny
 * 
 * Interface is using for applying Language Strategy according to input
 * period and language localization.
 * 
 */

public interface TimeStrategy {
	public String getDescriptiveLocalization(Period period, LanguageStrategy languageStrategy);
}