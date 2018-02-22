package com.sandarovich.utilites.calculator.period.time;

import com.sandarovich.utilites.calculator.period.time.formatter.TimeDescriptionFormatter;
import org.joda.time.Period;

public abstract class AbstractTimeStrategy implements TimeStrategy {

    protected final Period period;
    protected final TimeDescriptionFormatter formatter;

    AbstractTimeStrategy(Period period, TimeDescriptionFormatter formatter) {
        this.period = period;
        this.formatter = formatter;
    }
}
