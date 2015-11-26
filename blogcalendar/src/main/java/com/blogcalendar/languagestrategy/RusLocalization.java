package com.blogcalendar.languagestrategy;

import java.util.EnumMap;
import java.util.Map;

import com.blogcalendar.reference.TIMEUNIT;

/**
 * @author Olexander Kolodiazhny
 * Russsian Constants. 
 * Units of time in text plural and singular form.
 *
 */

public class RusLocalization {
			
	final static String[] YEARS = {"год", "года", "лет"};
	final static String[] MONTHS = {"месяц", "месяца", "месяцев"};
	final static String[] DAYS = {"день", "дня", "дней"};
	final static String[] HOURS = {"час", "часа", "часов"};
	final static String[] MINUTES = {"минута", "минуты", "минут"};
	final static String[] STRATEGY = {
			"меньше минуты", 
			"меньше дня: ", 
			"меньше месяца: ", 
			"меньше года: ", 
			"больше года: "
			
	};
	private static Map<TIMEUNIT, String[]> scopeRus = new EnumMap
			<TIMEUNIT, String[]> (TIMEUNIT.class);
			
	public RusLocalization() {
			
	}
	
	static {
		scopeRus.put(TIMEUNIT.TIMESTRATEGY, STRATEGY);
		scopeRus.put(TIMEUNIT.YEARS, YEARS);
		scopeRus.put(TIMEUNIT.MONTHS, MONTHS);
		scopeRus.put(TIMEUNIT.DAYS, DAYS);
		scopeRus.put(TIMEUNIT.HOURS, HOURS);
		scopeRus.put(TIMEUNIT.MINUTES, MINUTES);
	}
		
	/**
	* @author Olexander Kolodiazhny
	* 
	* Get Russian translation of time units respectively.
	* 	
	* <p> <b>Example:</b> 
	* getTranslation(YEARS, 1) -> "лет"
	* </p>
	* <p>
	* getTranslation(MINUTES, 2) -> "минут"
	* </p>
	* 
	* @return String text of time unit, relatively to time unit input label
	*/
			
	public static String getTranslation(TIMEUNIT timeLabel, int index){
		return scopeRus.get(timeLabel)[index];
	}
	
}
