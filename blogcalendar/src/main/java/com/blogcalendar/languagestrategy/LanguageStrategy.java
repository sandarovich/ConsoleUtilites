package com.blogcalendar.languagestrategy;

import com.blogcalendar.reference.TIME;

/**
 * @author Olexander Kolodiazhny
 * Интерфейс предназначен для получения, нужного склонения единицы времени, в зависимости
 * от языка и числового значения времени.
 *
 */

public interface LanguageStrategy {
	public String getLocalizedText(TIME timeLabel, int value);
}
