package com.blogcalendar.languagestrategy;

import java.util.Map;

import com.blogcalendar.util.TIMEUNIT;

import java.util.EnumMap;

/**
 * @author Olexander Kolodiazhny
 * 
 * English Constants. Units of time in text plural and singular form.
 *
 */

public class EngLocalization {
	
	final static String[] YEARS = {"year", "years"};
	final static String[] MONTHS = {"month", "months"};
	final static String[] DAYS = {"day", "days"};
	final static String[] HOURS = {"hour", "hours"};
	final static String[] MINUTES = {"minute", "minutes"};
	final static String[] STRATEGY = {
			"less than a minute: ", 
			"less than a day: ", 
			"less than a month: ", 
			"less than a year: ", 
			"more than a year: "
	};
	
	private static Map<TIMEUNIT, String[]> scopeEng = new EnumMap
			<TIMEUNIT, String[]> (TIMEUNIT.class);
		
	static {
	    scopeEng.put(TIMEUNIT.TIMESTRATEGY, STRATEGY);
            scopeEng.put(TIMEUNIT.YEARS, YEARS);
            scopeEng.put(TIMEUNIT.MONTHS, MONTHS);
            scopeEng.put(TIMEUNIT.DAYS, DAYS);
            scopeEng.put(TIMEUNIT.HOURS, HOURS);
            scopeEng.put(TIMEUNIT.MINUTES, MINUTES);
	}
		
	/**
	* @author Olexander Kolodiazhny
	* 
	* Get English translation of time units respectively.
	* 	
	* <p> <b>Example:</b> 
	* getTranslation(YEARS, 1) -> "years"
	* </p>
	* <p>
	* getTranslation(MINUTES, 0) -> "minute"
	* </p>
	* 
	* @return String text of time unit, relatively to time unit input label
	*/
	public static String getTranslation(TIMEUNIT timeLabel, int index){
		return scopeEng.get(timeLabel)[index];
	}
}
