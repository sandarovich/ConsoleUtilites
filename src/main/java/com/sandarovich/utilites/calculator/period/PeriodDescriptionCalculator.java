package com.sandarovich.utilites.calculator.period;


import com.sandarovich.utilites.calculator.period.language.Language;
import com.sandarovich.utilites.calculator.period.time.TimeStrategy;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;

/**
 * @author Olexander Kolodiazhny 2015.
 * <p>
 * Calculator utility. Help to calculate periods from entry date to current moment of the time
 * and represents in text readable and understandable by human.
 * This text can be output in 3 kind of languages (Ukrainian, English, Russian).
 * <p>
 * Entry date is passed through constructor.
 * Output is returning by getPeriodDescription()
 */

public class PeriodDescriptionCalculator {
    private Period period;

    PeriodDescriptionCalculator(LocalDateTime entryDate) {
        this.period = new Period(entryDate, new LocalDateTime());
    }

    /**
     * Method is choosing appropriate time strategy.
     * Returns  text output, according to entry date and language localization
     */
    public String getPeriodDescription(String languageCode) {
        TimeStrategy timeStrategy = TimeStrategy.from(period, Language.from(languageCode));
        return timeStrategy.getPeriodDescription();
    }
}

