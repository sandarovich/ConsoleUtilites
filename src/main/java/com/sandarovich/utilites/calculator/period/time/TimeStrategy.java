package com.sandarovich.utilites.calculator.period.time;

import com.sandarovich.utilites.calculator.period.dto.TimeUnit;
import com.sandarovich.utilites.calculator.period.language.Language;
import org.codehaus.plexus.util.StringUtils;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.Period;

public abstract class TimeStrategy {

    protected final Period period;
    final Language language;

    TimeStrategy(Period period, Language languageStrategy) {
        this.period = period;
        this.language = languageStrategy;
    }

    public static TimeStrategy from(Period period, Language language) {
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

    private static boolean isAfterNow(Period period) {
        return getInstantFromPeriod(period).isAfter(Instant.now());
    }

    private static Instant getInstantFromPeriod(Period period) {
        Instant now = new Instant();
        Duration duration = period.toDurationTo(now);
        return now.minus(duration);
    }

    public abstract String getPeriodDescription();

    class TimeDescriptionFormatter {

        private static final String OUTPUT_FORMAT = "%s: %s";
        private static final String TIME_UNIT_FORMAT = "%s %s, ";

        private static final String EMPTY_VALUE = "";
        private final String title;
        private StringBuilder sb;

        TimeDescriptionFormatter(String titleKey) {
            sb = new StringBuilder();
            this.title = language.getLocalizedDescription(titleKey);
        }

        public void add(TimeUnit timeUnit, int value) {
            sb.append(formatValue(value, language.getLocalizedText(timeUnit, value)));
        }

        private String formatValue(int value, String localizedTimeUnitValue) {
            if (value == 0) {
                return EMPTY_VALUE;
            }
            return String.format(TIME_UNIT_FORMAT, value, localizedTimeUnitValue);
        }

        public String format() {
            return String.format(OUTPUT_FORMAT, title, trimLastComma(sb.toString()));
        }

        private String trimLastComma(String src) {
            if (StringUtils.isEmpty(src)) {
                return src;
            }
            String result = src.trim();
            if (result.lastIndexOf(',') == result.length() - 1) {
                return result.substring(0, result.length() - 1);
            }
            return result;
        }
    }

}
