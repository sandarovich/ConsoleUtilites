package com.blogcalendar.old;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime; // Тип данных. Внешнея библиотека JODA -> лежит в папке Libs
import org.joda.time.Period;// Класс помощник. Внешнея библиотека JODA -> лежит в папке Libs

/**
 * @author Oleksandr Kolodiazhny 2015
 * @category Utilites
 * @version 0.1
 *
 */

public class Descriptive {
	public static void main(String[] args) {
		
		//Задаем форматирование ввода даты в виде число.месяц.год часы:минуты:секунды
		
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		
		// Назначем переменную для хранения входной даты
		
		Date entryDate = null;
		
		// Пробуем привести входную дату под заданный формат даты, 
		//если нет выбрасываем Exception 
		
		try {
			
			//Входная дата, задаем вручную.
			
			entryDate = df.parse("15.10.2015 00:18:00");
			
		} catch(ParseException e) {
			e.printStackTrace();
		}
		// Вызываем метод getDescriptiveLength и выводим результат на экран
		
		System.out.println(getDescriptiveDateLength(entryDate));
	
	}
	/**
	 * getDescriptiveDateLength(Date date) - определяет разницу между заданной датой 
	 * и текущим моментом времени. 
	 * 
	 * @param date  - значение даты с которой сравниваем текущий момент времени.
	 * @return String - текстовое значение понятное человеку эквивалентное
	 * периоду, прошедшего с заданого момента времени. Если входная дата больще
	 * текущего системного времени, то возвращаем значение -1.
	 */	
	
	public static String getDescriptiveDateLength(Date date) {
		
		// Задаем константы для склонения дат (Украинская локализация)
		
		final String[] YEARS = {"рік", "роки", "років"};
		final String[] MONTHS = {"місяць", "місяці", "місяців"};
		final String[] DAYS = {"день", "дні", "днів"};
		final String[] HOURS = {"година", "години", "годин"};
		final String[] MINUTES = {"хвилина", "хвилини", "хвилин"};
		
		//Резервируем для возможных изменениях в бизнесс логике
		//final String[] SECONDS = {"секунда", "секунди", "секунд"};
		
		// Создаем новую переменную entryDate, с помощью  
		// конструктора DateTime библиотеки JODA
		
		DateTime entryDate = new DateTime(date);
		
		// JODA.Проверяем входную дат, если она больше текущего момента времени, 
		//возвращаем -1, если это так.
		if (entryDate.isBeforeNow()) {
			
			// Cоздаем переменную currentDate (текущая дата) с помощью конструктора 
			//DateTime библиотеки JODA
			
			DateTime currentDate = new DateTime();
			
			// JODA. Задаем период. Определяем разницу по периоду в годах, месяцах, 
			//днях, часах, минутах
			
			Period period = new Period(entryDate, currentDate);
			
			// Значение разницы в абсолютных величинах годов, месяцев, дней, минут
			
			int y = period.getYears(); 
			int m = period.getMonths();
			int d = period.getDays();
			int h = period.getHours();
			int mm = period.getMinutes();		
			
			// Будем собирать вывод в переменную out
			
			String out = "";
			
			// Преобразуем y, m, d, h, mm в текстовый 
			//эквивалент с помощью метода getUkrText. 
		
			if (y >= 1) {
				out = "більше року: "
						+ getUkrText(y, YEARS)
						+ getUkrText(m, MONTHS)
						+ getUkrText(d, DAYS);
			} else if (y == 0 && m >= 1) {
				out = "меньше року: "
						+ getUkrText(m, MONTHS)
						+ getUkrText(d, DAYS);
			} else if (y == 0 && m == 0 && d >= 1) {
				out = "меньше місяця: "
						+ getUkrText(d, DAYS);
			} else if (y == 0 && m == 0 && d == 0 && mm >= 1 ) {
				out = "меньше дня: "
						+ getUkrText(h, HOURS)
						+ getUkrText(mm, MINUTES);
			} else if (y == 0 && m == 0 && d == 0 && mm == 0 ) {
				out = "меньше хвилини";
			}
			
			// Обрезаем  в выоде последнею запятую-разделитель, если она есть.
			
			if (out.lastIndexOf(",") == out.length() - 2) {
				out = out.substring(0, out.length() - 2);
			}
			return out;
		} else {
			return "-1"; // Входная дата больше текущего времени, выводим -1
		}
		
	}
	/**
	 * @author Oleksandr Kolodiazhny 2015
	 * Метод помогает получать один из трех возможных вариантов склонение 
	 * единицы времени в Украинском языке, в зависимости от входного параметра
	 *
	 *@param val - целочисельное значение разницы временных промежутков
	 *@param col - массив вариантов склонений едииницы времени.
	 *@return текстовое значение
	 *
	 * Пример 1: 
	 * getUkrText(2, YEARS), где YEARS = {"рік", "роки", "років"}
	 * Возвращает: 2 роки
	 * 
	 * Пример 2:
	 *  getUkrText(10, HOURS), где HOURS = {"година", "години", "годин"};
	 * Возвращает: 10 годин
	 */
	
	public static String getUkrText(int val, String[] col) {
		String out = "";
		
		//Нулевые значения заблаговременно отсекаем.
		
		if (val != 0) { 
			String prefix=", ";
			if (val % 20  == 1) {
				out += val + " " + col[0] + prefix;
			} else if (val % 20 > 1 && val % 20 < 5) {
				out += val + " " + col[1] + prefix;
			} else if (val % 20 >= 5 || val % 20 == 0 ) {
				out += val + " " + col[2] + prefix ;
			}
		} else {
			
		}
		return out;
			
	}
}
