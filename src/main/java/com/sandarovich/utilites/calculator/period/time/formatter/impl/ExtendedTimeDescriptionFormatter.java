package com.sandarovich.utilites.calculator.period.time.formatter.impl;

import com.sandarovich.utilites.calculator.period.dto.TimeUnit;
import com.sandarovich.utilites.calculator.period.language.Language;
import com.sandarovich.utilites.calculator.period.time.formatter.TimeDescriptionFormatter;
import org.codehaus.plexus.util.StringUtils;


public class ExtendedTimeDescriptionFormatter implements TimeDescriptionFormatter {

    private static final String OUTPUT_FORMAT = "%s: %s";
    private static final String TIME_UNIT_FORMAT = "%s %s, ";
    private static final String EMPTY_VALUE = "";

    private final String description;
    private final Language language;
    private StringBuilder sb;

    public ExtendedTimeDescriptionFormatter(Language language, String descriptionKey) {
        sb = new StringBuilder();
        this.description = language.getLocalizedDescription(descriptionKey);
        this.language = language;
    }

    @Override
    public void add(TimeUnit timeUnit, int value) {
        sb.append(formatValue(value, language.getLocalizedText(timeUnit, value)));
    }

    private String formatValue(int value, String localizedTimeUnitValue) {
        if (value == 0) {
            return EMPTY_VALUE;
        }
        return String.format(TIME_UNIT_FORMAT, value, localizedTimeUnitValue);
    }

    @Override
    public String format() {
        return String.format(OUTPUT_FORMAT, description, trimLast(sb.toString()));
    }

    private String trimLast(String src) {
        return trimLast(src, ',');
    }

    private String trimLast(String src, char ch) {
        if (StringUtils.isEmpty(src)) {
            return src;
        }
        String result = src.trim();

        if (result.lastIndexOf(ch) == result.length() - 1) {
            return result.substring(0, result.length() - 1);
        }
        return result;
    }
}