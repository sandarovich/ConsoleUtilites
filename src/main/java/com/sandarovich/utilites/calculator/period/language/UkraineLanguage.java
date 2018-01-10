package com.sandarovich.utilites.calculator.period.language;

import java.util.Locale;

/**
 * @author Olexander Kolodiazhny
 * <p>
 * Ukrainian language strategy helps us to determine correct form
 * of singular (2 variants) or plural text form in Ukrainian
 * depends unit of time.
 * <p>
 * Examples:
 * <p>
 * 1 день
 * 2 роки
 * 7 хвилин
 * 11 місяців
 */
class UkraineLanguage extends SlavicLanguage {

    UkraineLanguage() {
        super(new Locale.Builder().setLanguage("uk").setRegion("UA").build());
    }
}
