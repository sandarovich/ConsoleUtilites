package com.sandarovich.utilites.calculator.period.language;


import com.sandarovich.utilites.calculator.period.dto.TimeUnit;

import java.util.Locale;


/**
 * @author Olexander Kolodiazhny
 * @since 2015
 */

public abstract class Language {

    private final Localization localization;

    protected Language(Locale locale) {
        this.localization = new Localization(locale);
    }

    public String getLocalizedText(TimeUnit timeUnit, int value) {
        return getLocalizedTimeUnitValue(timeUnit, value);
    }

    public String getLocalizedDescription(String key) {
        return localization.getTranslationBy(key);
    }

    Localization getLocalization() {
        return localization;
    }

    abstract String getLocalizedTimeUnitValue(TimeUnit timeUnit, int value);
}
