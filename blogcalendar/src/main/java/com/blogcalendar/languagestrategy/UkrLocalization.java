package com.blogcalendar.languagestrategy;

import java.util.EnumMap;
import java.util.Map;

import com.blogcalendar.util.TIMEUNIT;

/**
 * @author Olexander Kolodiazhny
 * 
 * Ukrainian Constants. 
 * Units of time in text plural and singular form.
 *
 */

public  class UkrLocalization {
	
	final static String[] YEARS = {"рік", "роки", "років"};
	final static String[] MONTHS = {"місяць", "місяці", "місяців"};
	final static String[] DAYS = {"день", "дні", "днів"};
	final static String[] HOURS = {"година", "години", "годин"};
	final static String[] MINUTES = {"хвилина", "хвилини", "хвилин"};
	final static String[] STRATEGY = {
			"меньше хвилини", 
			"меньше дня: ", 
			"меньше місяця: ", 
			"меньше року: ", 
			"більше року: "
	};
	
	private static Map<TIMEUNIT, String[]> scopeUkr = new EnumMap
			<TIMEUNIT, String[]> (TIMEUNIT.class);
	
	static {
		scopeUkr.put(TIMEUNIT.TIMESTRATEGY, STRATEGY);
		scopeUkr.put(TIMEUNIT.YEARS, YEARS);
		scopeUkr.put(TIMEUNIT.MONTHS, MONTHS);
		scopeUkr.put(TIMEUNIT.DAYS, DAYS);
		scopeUkr.put(TIMEUNIT.HOURS, HOURS);
		scopeUkr.put(TIMEUNIT.MINUTES, MINUTES);	
	}
	
	/**
	* @author Olexander Kolodiazhny
	* 
	* Get Ukranian translation of time units respectively.
	* 	
	* <p> <b>Example:</b> 
	* getTranslation(YEARS, 1) -> "роки"
	* </p>
	* <p>
	* getTranslation(MINUTES, 2) -> "хвилин"
	* </p>
	* 
	* @return String text of time unit, relatively to time unit input label
	*/
			
	public static String getTranslation(TIMEUNIT timeLabel, int index){
		return scopeUkr.get(timeLabel)[index];
	}

}
	
