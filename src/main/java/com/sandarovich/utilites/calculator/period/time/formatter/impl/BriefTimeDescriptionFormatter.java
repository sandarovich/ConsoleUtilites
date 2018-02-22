package com.sandarovich.utilites.calculator.period.time.formatter.impl;

import com.sandarovich.utilites.calculator.period.dto.TimeUnit;
import com.sandarovich.utilites.calculator.period.language.Language;
import com.sandarovich.utilites.calculator.period.time.formatter.TimeDescriptionFormatter;

public class BriefTimeDescriptionFormatter implements TimeDescriptionFormatter {
    private final String description;

    public BriefTimeDescriptionFormatter(Language language, String descriptionKey) {
        this.description = language.getLocalizedDescription(descriptionKey);
    }

    @Override
    public String format() {
        return description;
    }

    @Override
    public void add(TimeUnit timeUnit, int value) {
        throw new UnsupportedOperationException("Operation is not supported. Please use ExtendedTimeFormatter instead");
    }
}

