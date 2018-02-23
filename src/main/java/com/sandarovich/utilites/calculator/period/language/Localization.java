package com.sandarovich.utilites.calculator.period.language;

import com.sandarovich.utilites.calculator.period.dto.DeclensionForm;
import com.sandarovich.utilites.calculator.period.dto.TimeUnit;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {
    private static final String BUNDLE_NAME = "i18n/translation";

    private final ResourceBundle resourceBundle;

    Localization(Locale locale) {
        this.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }

    public String getTranslationBy(String key) {
        return resourceBundle.getString(key);
    }

    public String getTranslationBy(TimeUnit timeUnit, DeclensionForm declensionForm) {
        String[] timeUnitValues = resourceBundle.getString(timeUnit.getTranslationKey()).split(",");
        if (ArrayUtils.isEmpty(timeUnitValues)) {
            return "";
        }
        return timeUnitValues[declensionForm.getIndex()];
    }
}
