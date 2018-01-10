package com.sandarovich.utilites.calculator.period.assertion;

import com.sandarovich.utilites.calculator.period.PeriodDescriptionCalculator;
import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

public class PeriodDescriptionCalculatorAssert extends AbstractAssert<PeriodDescriptionCalculatorAssert, PeriodDescriptionCalculator> {

    PeriodDescriptionCalculatorAssert(PeriodDescriptionCalculator actual) {
        super(actual, PeriodDescriptionCalculatorAssert.class);
    }

    public static PeriodDescriptionCalculatorAssert assertThat(PeriodDescriptionCalculator actual) {
        return new PeriodDescriptionCalculatorAssert(actual);
    }

    public PeriodDescriptionCalculatorAssert hasPeriodDescription(String description) {
        isNotNull();
        if (!Objects.equals(actual.getPeriodDescription(), description)) {
            failWithMessage("Expected period description to be <%s> but was <%s>", description, actual.getPeriodDescription());
        }
        return this;
    }
}
