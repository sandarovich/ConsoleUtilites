package com.blogcalendar;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Period;

import com.blogcalendar.languagestrategy.LanguageStrategy;
import com.blogcalendar.timestrategy.*;
import com.blogcalendar.util.Constant;


/**
 * @author Olexander Kolodiazhny 2015.
 * 
 * Calculator utility. Help to calculate periods from entry date to current moment of the time
 * and represents in text readable and understandable by human. 
 * This text can be output in 3 kind of languages (Ukrainian, English, Russian). 
 * 
 * Entry date is passed through constructor. 
 * Output is returning by getDescriptiveDateLength()
 * 
 */

public class DescriptiveDateLength {

	
	private Period period;
	private DateTime entryDate;
	private LanguageStrategy languageStrategy;

	public DescriptiveDateLength(Date entryDate) {
		this.entryDate = new DateTime(entryDate);
		this.period = new Period(this.entryDate, new DateTime());
	}

	public LanguageStrategy getLanguageStrategy() {
		return this.languageStrategy;
	}
	
	public void setStrategy(LanguageStrategy languageStrategy) {
		this.languageStrategy = languageStrategy;
	}
	
	/** Method is choosing appropriate time strategy. 
	 * Returns  text output, according to entry date and language localization
	 * 
	 */
	
	public String getDescriptiveDateLength() {
		
		TimeStrategy timeStrategy = null;
		
		if (this.period.getYears() >= 1) {
			timeStrategy = new MoreThenYearStrategy();	
		}  else if (this.period.getYears() == 0 
				&& this.period.getMonths() >= 1) {
			timeStrategy = new LessThenYearStrategy();
		}  else if (this.period.getYears()  == 0 
				&& this.period.getMonths() == 0 
				&& this.period.getDays() + Constant.DAYS_IN_WEEK * this.period.getWeeks()  >= 1) {
			timeStrategy = new LessThenMonthStrategy();
		} else if (this.period.getYears()  == 0 
				&& this.period.getMonths() == 0 
				&& this.period.getDays() + Constant.DAYS_IN_WEEK * this.period.getWeeks() == 0 
				&& this.period.getMinutes() >= 1) {
			timeStrategy = new LessThenDayStrategy();
		} else if (this.period.getYears()  == 0 
				&& this.period.getMonths() == 0 
				&& this.period.getDays() + Constant.DAYS_IN_WEEK * this.period.getWeeks() == 0 
				&& this.period.getMinutes() == 0) {
			timeStrategy = new LessThenMinuteStrategy();
		}	
	
		return trimOutput(timeStrategy.getDescriptiveLocalization(this.period, this.getLanguageStrategy()));
	}
	
	/**
	 *  If exist comma char in end of sentence, then remove it,
	 * 
	 */

	private static String trimOutput(String out) {
			if (out.lastIndexOf(",") == out.length() - 2) {
				return  out.substring(0, out.length() - 2);
			} else {
				return out;
			}
	}	

}
