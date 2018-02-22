package com.sandarovich.utilites.calculator.period.time;

import com.sandarovich.utilites.calculator.period.dto.TimeUnit;
import com.sandarovich.utilites.calculator.period.language.Language;
import com.sandarovich.utilites.calculator.period.time.formatter.impl.ExtendedTimeDescriptionFormatter;
import org.joda.time.Period;

/**
 * @author Olexander Kolodiazhny
 * <p>
 * This strategy is need to correct application behaviors in case when
 * period value is less than one day.
 * <p>
 * Examples: : Ukrainian localization: меньше дня: 1 година 2 хвилини
 * Russian localization: меньше дня: 1 час 2 минуты English
 * localization: less than a day: 1 hour 2 minutes
 */

public class LessThenDayStrategy extends TimeStrategy {

    private static final String DESCRIPTION_KEY = "time.strategy.description.less.than.day";

    LessThenDayStrategy(Period period, Language language) {
        super(period, new ExtendedTimeDescriptionFormatter(language, DESCRIPTION_KEY));
    }

    @Override
    public String getPeriodDescription() {
        formatter.add(TimeUnit.HOUR, period.getHours());
        formatter.add(TimeUnit.MINUTE, period.getMinutes());
        return formatter.format();
    }
}
