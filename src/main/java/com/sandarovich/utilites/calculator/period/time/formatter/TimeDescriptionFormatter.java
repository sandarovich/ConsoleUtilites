package com.sandarovich.utilites.calculator.period.time.formatter;

import com.sandarovich.utilites.calculator.period.dto.TimeUnit;

public interface TimeDescriptionFormatter {
    String format();

    void add(TimeUnit timeUnit, int value);
}
