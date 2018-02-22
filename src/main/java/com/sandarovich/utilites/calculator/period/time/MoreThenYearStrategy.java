package com.sandarovich.utilites.calculator.period.time;

import com.sandarovich.utilites.calculator.period.dto.TimeUnit;
import com.sandarovich.utilites.calculator.period.language.Language;
import com.sandarovich.utilites.calculator.period.time.formatter.impl.ExtendedTimeDescriptionFormatter;
import org.joda.time.Period;

/**
 * @author Olexander Kolodiazhny
 *
 * <p>
 * This strategy is need to correct application behaviors
 * in case when period value is more than one year.
 * <p>
 * <p>
 * Examples:
 * Ukraininan localization: більше року: 1 рік 7 місяців 12 днів
 * Russsian localization: больше года: 1 год 7 месяцев 12 дней
 * English localization: more than a year: 1 year 7 month 12 days
 */

public class MoreThenYearStrategy extends AbstractTimeStrategy {

    private static final String DESCRIPTION_KEY = "time.strategy.description.more.than.year";

    MoreThenYearStrategy(Period period, Language language) {
        super(period, new ExtendedTimeDescriptionFormatter(language, DESCRIPTION_KEY));
    }

    @Override
    public String getPeriodDescription() {
        formatter.add(TimeUnit.YEAR, this.period.getYears());
        formatter.add(TimeUnit.MONTH, this.period.getMonths());
        formatter.add(TimeUnit.DAY, this.period.getDays());

        return formatter.format();
    }

}
