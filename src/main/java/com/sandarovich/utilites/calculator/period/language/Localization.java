package com.sandarovich.utilites.calculator.period.language;

import com.sandarovich.utilites.calculator.period.dto.TimeUnit;
import org.apache.commons.lang3.ArrayUtils;

import java.util.EnumMap;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class Localization {
    private static final String BUNDLE_NAME = "i18n/translation";

    private final EnumMap<TimeUnit, String[]> translationKeys;

    private final ResourceBundle resourceBundle;


    Localization(Locale locale) {
        this.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
        this.translationKeys = getTranslationKeysMapping();
    }

    public String getTranslationBy(String key) {
        return resourceBundle.getString(key);
    }

    public String getTranslationBy(TimeUnit timeUnit, int declensionForm) {
        String[] timeUnitKeys = getKeysBy(timeUnit);
        if (ArrayUtils.isEmpty(timeUnitKeys)) {
            return "";
        }
        return getTranslationBy(timeUnitKeys[declensionForm]);
    }

    private String[] getKeysBy(TimeUnit timeUnit) {
        return Optional.ofNullable(translationKeys.get(timeUnit)).orElse(new String[]{});
    }

    private EnumMap<TimeUnit, String[]> getTranslationKeysMapping() {
        EnumMap<TimeUnit, String[]> result = new EnumMap<>(TimeUnit.class);
        result.put(TimeUnit.YEAR,
                new String[]{"time.unit.year.single.form", "time.unit.year.plural.form.1", "time.unit.year.plural.form.2"});
        result.put(TimeUnit.MONTH,
                new String[]{"time.unit.month.single.form", "time.unit.month.plural.form.1", "time.unit.month.plural.form.2"});
        result.put(TimeUnit.DAY,
                new String[]{"time.unit.day.single.form", "time.unit.day.plural.form.1", "time.unit.day.plural.form.2"});
        result.put(TimeUnit.HOUR,
                new String[]{"time.unit.hour.single.form", "time.unit.hour.plural.form.1", "time.unit.hour.plural.form.2"});
        result.put(TimeUnit.MINUTE,
                new String[]{"time.unit.minute.single.form", "time.unit.minute.plural.form.1", "time.unit.minute.plural.form.2"});
        return result;
    }
}
