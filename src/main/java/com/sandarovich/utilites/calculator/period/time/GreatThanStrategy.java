package com.sandarovich.utilites.calculator.period.time;

import com.sandarovich.utilites.calculator.period.language.Language;
import com.sandarovich.utilites.calculator.period.time.formatter.impl.BriefTimeDescriptionFormatter;
import org.joda.time.Period;

public class GreatThanStrategy extends AbstractTimeStrategy {

    private static final String DESCRIPTION_KEY = "time.strategy.description.great.than.now";

    GreatThanStrategy(Period period, Language language) {
        super(period, new BriefTimeDescriptionFormatter(language, DESCRIPTION_KEY));
    }

    @Override
    public String getPeriodDescription() {
        return formatter.format();
    }
}
