package com.sandarovich.utilites.calculator.period.dto;

/**
 * @author Olexander KOlodiazhny
 * <p>
 * Enumerator that listed all main time units with translation keys.
 */
public enum TimeUnit {
    YEAR("time.unit.year"),
    MONTH("time.unit.month"),
    DAY("time.unit.day"),
    HOUR("time.unit.hour"),
    MINUTE("time.unit.minute");

    private final String translationKey;

    TimeUnit(String translationKey) {
        this.translationKey = translationKey;
    }

    public String getTranslationKey() {
        return translationKey;
    }
}
