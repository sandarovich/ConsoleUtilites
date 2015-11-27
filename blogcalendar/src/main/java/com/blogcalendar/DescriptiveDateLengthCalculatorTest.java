package com.blogcalendar;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import com.blogcalendar.languagestrategy.*;


/**
 * @author Olexander Kolodiazhny 2015
 * Класс для тестирования текстового калькулятора дат
 * DescriptiveDateLength
 *
 */

public class DescriptiveDateLengthCalculatorTest {

	public static void main(String[] args) throws ParseException, IOException {
		// *********************************************/
		
		
		
		// Входная дата, задаем вручную.
		
		String userInput = "26.11.2015 19:38:55";

		// *********************************************/
		
		// Задаем стратегию (описал Украинскую, русскую, английскую).
		
		LanguageStrategy strategy = new RussianLanguageStrategy();
				
		// Задаем форматирование ввода даты в виде число.месяц.год часы:минуты:секунды
		
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		
		// Пробуем привести входную дату под заданный формат даты, 
	
		Date entryDate = df.parse(userInput);
		Date now = new Date();
		System.out.println("In: " +  df.format(entryDate) 
			+ " <--> Now: "
			+ df.format(now) );
		
		DescriptiveDateLength testObj = new DescriptiveDateLength(entryDate);
		testObj.setStrategy(strategy);
		
		// Вывод результата.
		if (now.after(entryDate)) {
			System.out.println("Out: " + testObj.getDescriptiveDateLength());
		} else {
			System.out.println("Input Date is greater then now");
		}
		
	}
	

}
