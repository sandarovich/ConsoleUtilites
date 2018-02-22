package com.sandarovich.utilites.calculator.period.time;

import com.sandarovich.utilites.calculator.period.language.Language;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.Period;

public interface TimeStrategy {
    static AbstractTimeStrategy from(Period period, Language language) {
        if (isAfterNow(period)) {
            return new GreatThanStrategy(period, language);
        }
        if (period.getYears() >= 1) {
            return new MoreThenYearStrategy(period, language);
        }
        if (period.getYears() == 0 && period.getMonths() >= 1) {
            return new LessThenYearStrategy(period, language);
        }
        if (period.toStandardDays().getDays() >= 1) {
            return new LessThenMonthStrategy(period, language);
        }
        if (period.toStandardMinutes().getMinutes() >= 1) {
            return new LessThenDayStrategy(period, language);
        }
        return new LessThenMinuteStrategy(period, language);
    }

    static boolean isAfterNow(Period period) {
        return getInstantFromPeriod(period).isAfter(Instant.now());
    }

    static Instant getInstantFromPeriod(Period period) {
        Instant now = new Instant();
        Duration duration = period.toDurationTo(now);
        return now.minus(duration);
    }

    String getPeriodDescription();
}
