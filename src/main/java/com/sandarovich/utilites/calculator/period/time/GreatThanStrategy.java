package com.sandarovich.utilites.calculator.period.time;

import com.sandarovich.utilites.calculator.period.language.Language;
import org.joda.time.Period;

public class GreatThanStrategy extends TimeStrategy {
    GreatThanStrategy(Period period, Language language) {
        super(period, language);
    }

    @Override
    public String getPeriodDescription() {
        return language.getLocalizedDescription("time.strategy.description.great.than.now");
    }
}
