package com.sandarovich.utilites.calculator.period.time;

import com.sandarovich.utilites.calculator.period.language.Language;
import com.sandarovich.utilites.calculator.period.time.formatter.impl.BriefTimeDescriptionFormatter;
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

public class LessThenMinuteStrategy extends AbstractTimeStrategy {

    private static final String DESCRIPTION_KEY = "time.strategy.description.less.than.minute";

    LessThenMinuteStrategy(Period period, Language language) {
        super(period, new BriefTimeDescriptionFormatter(language, DESCRIPTION_KEY));
    }

    @Override
    public String getPeriodDescription() {
        return formatter.format();
    }
}