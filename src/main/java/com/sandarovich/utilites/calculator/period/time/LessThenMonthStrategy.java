package com.sandarovich.utilites.calculator.period.time;

import com.sandarovich.utilites.calculator.period.dto.TimeUnit;
import com.sandarovich.utilites.calculator.period.language.Language;
import com.sandarovich.utilites.calculator.period.time.formatter.impl.ExtendedTimeDescriptionFormatter;
import org.joda.time.Days;
import org.joda.time.Period;

/**
 * @author Olexander Kolodiazhny
 * <p>
 * This strategy is need to correct application behaviors
 * in case when period value is less than one month.
 * <p>
 * Examples:
 * Ukrainian localization: меньше місяця: 5 днів
 * Russian localization: меньше месяца: 5 дней
 * English localization: less than a month: 5 days
 */

public class LessThenMonthStrategy extends TimeStrategy {

    private static final String DESCRIPTION_KEY = "time.strategy.description.less.than.month";

    LessThenMonthStrategy(Period period, Language language) {
        super(period, new ExtendedTimeDescriptionFormatter(language, DESCRIPTION_KEY));
    }

    @Override
    public String getPeriodDescription() {
        formatter.add(TimeUnit.DAY, period.getDays() + Days.SEVEN.getDays() * period.getWeeks());
        formatter.add(TimeUnit.HOUR, period.getHours());

        return formatter.format();
    }
}
