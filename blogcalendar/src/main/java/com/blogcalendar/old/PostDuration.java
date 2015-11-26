package com.blogcalendar.old;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.joda.time.Period;
import org.joda.time.Seconds;
import org.joda.time.format.PeriodFormat;
//import org.joda.time.format.PeriodFormatter;
//import org.joda.time.format.PeriodFormatterBuilder;;

public class PostDuration {

	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		Date z1 = null, z2 = null;
		try {
			z1 = df.parse("12.10.2015 09:00:00");
			z2 = df.parse("30.03.2017 08:59:05");
		} catch (ParseException e) {
			System.out.println(e.getStackTrace());
		}
		DateTime d1 = new DateTime(z1);
		DateTime d2 = new DateTime(z2);
		
		// NE PROKONALO		
		//	PeriodFormatter postFormat = new PeriodFormatterBuilder() 
		
		System.out.println("Input:");
		System.out.println(z1);
		System.out.println(z2);
		System.out.println("****************");
		System.out.println("English by JODA");
		System.out.println(PeriodFormat.getDefault().print(new Period(d1, d2))+ '\n');
		System.out.println("Russian by Okolodiazhny:");
		System.out.println(PostFormatterMy(d1, d2));;
		}
	
	public static String PostFormatterMy(DateTime d1, DateTime d2) {
		final String[] YEARS = {"год", "года", "лет"};
		final String[] MONTHS = {"месяц", "месяца", "месяцев"};
		final String[] DAYS = {"день", "дня", "дней"};
		final String[] HOURS = {"час", "часа", "часов"};
		final String[] MINUTES = {"минута", "минуты", "минут"};
		final String[] SECONDS = {"секунда", "секунды", "секунд"};
		
		Period p = new Period(d1, d2);
		int s = Seconds.secondsBetween(d1, d2).getSeconds();
		
		if (Seconds.secondsBetween(d1, d2).getSeconds() > 60) {
			String out = addText(p.getYears(), YEARS)
					+ addText(p.getMonths(), MONTHS)
					+ addText(p.getDays(), DAYS)
					+ addText(p.getHours() , HOURS)
					+ addText(p.getMinutes(), MINUTES)
				    + addText(p.getSeconds(), SECONDS);
			out = out.substring(0, out.length()-2);
			return out;
		} else {
			return "меньше минуты";
		}
	}
	
	public static String addText(int val, String[] col) {
		String out = "";
		String prefix=", ";
		if (val % 20  == 1) {
			out += val + " " + col[0] + prefix;
		} else if (val % 20 > 1 && val % 20 < 5) {
			out += val + " " + col[1] + prefix;
		} else if (val % 20 >= 5 ) {
			out += val + " " + col[2] + prefix ;
		}
		return out;
	}	
	
	

}
