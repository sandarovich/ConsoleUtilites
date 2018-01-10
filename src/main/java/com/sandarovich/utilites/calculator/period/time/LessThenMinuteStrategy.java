package com.sandarovich.utilites.calculator.period.time;

import com.sandarovich.utilites.calculator.period.language.Language;
import org.joda.time.Period;

/**
 * @author Olexander Kolodiazhny
 * <p>
 * This strategy is need to correct application behaviors
 * in case when period value is less than one minute.
 * <p>
 * Examples:
 * Ukrainian localization: меньше хвилини
 * Russian localization: меньше минуты
 * English localization: less than a minute
 */

public class LessThenMinuteStrategy extends TimeStrategy {

    LessThenMinuteStrategy(Period period, Language language) {
        super(period, language);
    }

    @Override
    public String getPeriodDescription() {
        return language.getLocalizedDescription("time.strategy.description.less.than.minute");
    }

}