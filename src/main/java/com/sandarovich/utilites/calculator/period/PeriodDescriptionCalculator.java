package com.sandarovich.utilites.calculator.period;


import com.sandarovich.utilites.calculator.period.language.Language;
import com.sandarovich.utilites.calculator.period.language.LanguageFactory;
import com.sandarovich.utilites.calculator.period.time.TimeStrategy;
import com.sandarovich.utilites.calculator.period.time.TimeStrategyFactory;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;

/**
 * @author Olexander Kolodiazhny 2015.
 * <p>
 * Period calculator utility. Help to calculate periods from entry date to current moment of the time
 * and represents in text readable and understandable by human.
 * Description can be output in 3 languages, using language code (Ukrainian - uk, English - en, Russian - ru).
 * <p>
 * Entry date is passed through constructor.
 * Output is returning by {@code}getPeriodDescription(String languageCode) {@code}
 */

public class PeriodDescriptionCalculator {
    private final Period period;
    private final Language language;

    PeriodDescriptionCalculator(LocalDateTime entryDate) {
        this.period = new Period(entryDate, new LocalDateTime());
        this.language = LanguageFactory.getLanguage("en");
    }

    PeriodDescriptionCalculator(LocalDateTime entryDate, String languageCode) {
        this.period = new Period(entryDate, new LocalDateTime());
        this.language = LanguageFactory.getLanguage(languageCode);
    }

    /**
     * Method is choosing appropriate time strategy.
     * Returns  text output, according to entry date and language localization
     */
    public String getPeriodDescription(String languageCode) {
        TimeStrategy timeStrategy = TimeStrategyFactory.getStrategy(period, LanguageFactory.getLanguage(languageCode));
        return timeStrategy.getPeriodDescription();
    }

    public String getPeriodDescription() {
        TimeStrategy timeStrategy = TimeStrategyFactory.getStrategy(period, language);
        return timeStrategy.getPeriodDescription();
    }
}

