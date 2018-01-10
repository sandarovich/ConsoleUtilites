package com.sandarovich.utilites.calculator.period.time;

import com.sandarovich.utilites.calculator.period.dto.TimeUnit;
import com.sandarovich.utilites.calculator.period.language.Language;
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

    LessThenMonthStrategy(Period period, Language language) {
        super(period, language);
    }

    @Override
    public String getPeriodDescription() {
        TimeDescriptionFormatter formatter = new TimeDescriptionFormatter("time.strategy.description.less.then.month");
        formatter.add(TimeUnit.DAY, period.getDays() + Days.SEVEN.getDays() * period.getWeeks());
        formatter.add(TimeUnit.MINUTE, period.getMinutes());

        return formatter.format();

    }

}
