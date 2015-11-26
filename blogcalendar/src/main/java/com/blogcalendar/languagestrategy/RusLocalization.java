package com.blogcalendar.languagestrategy;

import java.util.EnumMap;
import java.util.Map;

import com.blogcalendar.reference.TIME;

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
	private static Map<TIME, String[]> scopeRus = new EnumMap
			<TIME, String[]> (TIME.class);
			
	public RusLocalization() {
			
	}
	
	static {
		scopeRus.put(TIME.TIMESTRATEGY, STRATEGY);
		scopeRus.put(TIME.YEARS, YEARS);
		scopeRus.put(TIME.MONTHS, MONTHS);
		scopeRus.put(TIME.DAYS, DAYS);
		scopeRus.put(TIME.HOURS, HOURS);
		scopeRus.put(TIME.MINUTES, MINUTES);
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
			
	public static String getTranslation(TIME timeLabel, int index){
		return scopeRus.get(timeLabel)[index];
	}
	
}
