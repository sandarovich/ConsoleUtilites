package com.sandarovich.utilites.calculator.period.language;

import com.sandarovich.utilites.calculator.period.dto.DeclensionForm;
import com.sandarovich.utilites.calculator.period.dto.TimeUnit;

import java.util.Locale;

/**
 * @author Olexander Kolodiazhny
 * <p>
 * Slavic language strategy helps us to determine correct form
 * of singular (2 variants) or plural text form in Ukrainian or Russian
 * depends unit of time.
 * <p>
 * Examples:
 * <p>
 * 1 день
 * 2 года
 * 7 минут
 * 11 місяців
 */
class SlavicLanguage extends Language {

    private static final int SINGULAR_VALUE = 1;
    private static final int REPEATING_RANGE_LENGTH = 20;
    private static final int PLURAL_FORM_TWO_RANGE_START = 5;
    private static final int PLURAL_FORM_TWO_RANGE_END = 0;


    SlavicLanguage(Locale locale) {
        super(locale);
    }

    @Override
    String getLocalizedTimeUnitValue(TimeUnit timeUnit, int value) {
        DeclensionForm declensionForm = getDeclensionForm(value);
        return getLocalization().getTranslationBy(timeUnit, declensionForm);
    }

    private DeclensionForm getDeclensionForm(int value) {
        final int reminder = value % REPEATING_RANGE_LENGTH;
        if (reminder == SINGULAR_VALUE) {
            return DeclensionForm.SINGULAR;
        }
        if (reminder > SINGULAR_VALUE && reminder < PLURAL_FORM_TWO_RANGE_START) {
            return DeclensionForm.PLURAL_ONE;
        }
        if (reminder >= PLURAL_FORM_TWO_RANGE_START || reminder == PLURAL_FORM_TWO_RANGE_END) {
            return DeclensionForm.PLURAL_TWO;
        }
        return DeclensionForm.PLURAL_ONE;
    }
}
