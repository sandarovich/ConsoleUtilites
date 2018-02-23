package com.sandarovich.utilites.calculator.period.language;

import com.sandarovich.utilites.calculator.period.dto.DeclensionForm;
import com.sandarovich.utilites.calculator.period.dto.TimeUnit;

import java.util.Locale;

/**
 * @author Olexander Kolodiazhny
 * Strategy that determines plural or singular unit of a time according
 * to English language rule, return number value and respective descriptive text.
 * <p>
 * Example:
 * <p>
 * more than year
 * 1 day
 * 3 years
 * 2 months
 */
public class EnglishLanguage extends Language {

    private static final int SINGULAR_VALUE = 1;

    EnglishLanguage() {
        super(Locale.ENGLISH);
    }

    /**
     * Get English translation of time units respectively.
     * <p>
     * <p>
     * <p> <b>Example:</b>
     * getLocalizedTimeUnitValue(YEAR, 2) -> "years"
     * </p>
     * <p>
     * getLocalizedTimeUnitValue(MINUTE, 1) -> "minute"
     * </p>
     *
     * @return String text of time unit, relatively to time unit input label
     */

    @Override
    public String getLocalizedTimeUnitValue(TimeUnit timeUnit, int value) {
        DeclensionForm declensionForm = (value == SINGULAR_VALUE) ?
                DeclensionForm.SINGULAR : DeclensionForm.PLURAL_ONE;
        return getLocalization().getTranslationBy(timeUnit, declensionForm);
    }
}