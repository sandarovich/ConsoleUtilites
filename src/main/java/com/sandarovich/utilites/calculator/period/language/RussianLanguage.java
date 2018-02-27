package com.sandarovich.utilites.calculator.period.language;

import java.util.Locale;

/**
 * @author Olexander Kolodiazhny
 * Russian language strategy helps us to determine correct form
 * of singular (2 variants) or plural text form in Russian
 * depends unit of time.
 * <p>
 * Examples:
 * <p>
 * 2 дня
 * 3 года
 * 7 минут
 * 11 месяцев
 */
class RussianLanguage extends SlavicLanguage {
    RussianLanguage() {
        super(new Locale("ru", "RU"));
    }
}
