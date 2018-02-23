package com.sandarovich.utilites.calculator.period.time;

import com.sandarovich.utilites.calculator.period.dto.TimeUnit;
import com.sandarovich.utilites.calculator.period.language.Language;
import com.sandarovich.utilites.calculator.period.time.formatter.impl.ExtendedTimeDescriptionFormatter;
import org.joda.time.Days;
import org.joda.time.Period;

/**
 * @author Olexander Kolodiazhny
 * <p>
 * <p>
 * This strategy is need to correct application behaviors
 * in case when period value is less than one year.
 * <p>
 * Examples:
 * Ukraininan localization: меньше року: 7 місяців 12 днів
 * Russsian localization: меньше года: 7 месяцев 12 дней
 * English localization: less than a year: 7 months 12 days
 */

public class LessThenYearStrategy extends TimeStrategy {

    private static final String DESCRIPTION_KEY = "time.strategy.description.less.than.year";

    LessThenYearStrategy(Period period, Language language) {
        super(period, new ExtendedTimeDescriptionFormatter(language, DESCRIPTION_KEY));
    }

    @Override
    public String getPeriodDescription() {
        formatter.add(TimeUnit.MONTH, period.getMonths());
        formatter.add(TimeUnit.DAY, period.getDays() + Days.SEVEN.getDays() * period.getWeeks());

        return formatter.format();
    }
}