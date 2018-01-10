package com.sandarovich.utilites.calculator.period;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Olexander Kolodiazhny
 * @since 2015
 */
@RunWith(DataProviderRunner.class)
public class PeriodDescriptionCalculatorTest {

    private static final String ENGLISH_LANGUAGE = Locale.ENGLISH.getLanguage();
    private static final String UKRAINIAN_LANGUAGE = Locale.forLanguageTag("uk-UA").getLanguage();
    private static final String RUSSIAN_LANGUAGE = Locale.forLanguageTag("ru-RU").getLanguage();
    private static final String DEFAULT_LANGUAGE = ENGLISH_LANGUAGE;

    private PeriodDescriptionCalculator sut;

    @DataProvider
    public static Object[][] moreThanYearData() {
        return new Object[][]{
                {DEFAULT_LANGUAGE, LocalDateTime.now().minusYears(1), "more than a year: 1 year"},
                {ENGLISH_LANGUAGE, LocalDateTime.now().minusYears(1), "more than a year: 1 year"},
                {DEFAULT_LANGUAGE, LocalDateTime.now().minusYears(3), "more than a year: 3 years"},
                {ENGLISH_LANGUAGE, LocalDateTime.now().minusYears(3), "more than a year: 3 years"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusYears(1), "більше року: 1 рік"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusYears(3), "більше року: 3 роки"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusYears(5), "більше року: 5 років"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusYears(1), "больше года: 1 год"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusYears(3), "больше года: 3 года"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusYears(5), "больше года: 5 лет"},
                {DEFAULT_LANGUAGE, LocalDateTime.now().minusYears(1), "more than a year: 1 year"},
                {ENGLISH_LANGUAGE, LocalDateTime.now().minusYears(1), "more than a year: 1 year"},
                {DEFAULT_LANGUAGE, LocalDateTime.now().minusYears(3).minusDays(1), "more than a year: 3 years, 1 day"},
                {ENGLISH_LANGUAGE, LocalDateTime.now().minusYears(3).minusDays(1), "more than a year: 3 years, 1 day"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusYears(1), "більше року: 1 рік"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusYears(3).minusDays(1), "більше року: 3 роки, 1 день"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusYears(5).minusDays(1), "більше року: 5 років, 1 день"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusYears(1).minusDays(1), "больше года: 1 год, 1 день"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusYears(3).minusDays(1), "больше года: 3 года, 1 день"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusYears(5).minusDays(1), "больше года: 5 лет, 1 день"}
        };
    }

    @DataProvider
    public static Object[][] lessThanYearData() {
        return new Object[][]{
                {DEFAULT_LANGUAGE, LocalDateTime.now().minusMonths(1), "less than a year: 1 month"},
                {DEFAULT_LANGUAGE, LocalDateTime.now().minusMonths(1), "less than a year: 1 month"},
                {ENGLISH_LANGUAGE, LocalDateTime.now().minusMonths(3), "less than a year: 3 months"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusMonths(1), "меньше року: 1 місяць"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusMonths(3), "меньше року: 3 місяці"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusMonths(5), "меньше року: 5 місяців"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusMonths(1), "меньше года: 1 месяц"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusMonths(3), "меньше года: 3 месяца"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusMonths(5), "меньше года: 5 месяцев"}
        };
    }

    @UseDataProvider("moreThanYearData")
    @Test
    public void shouldReturnMoreThanYearStatement(String language, LocalDateTime localDateTime, String expectedResult) {
        sut = new PeriodDescriptionCalculator(localDateTime);

        assertThat(sut.getPeriodDescription(language)).isEqualTo(expectedResult);
    }

    @UseDataProvider("lessThanYearData")
    @Test
    public void shouldReturnLessThanYearStatement(String language, LocalDateTime localDateTime, String expectedResult) {
        sut = new PeriodDescriptionCalculator(localDateTime);

        assertThat(sut.getPeriodDescription(language)).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnLessThanMonthStatement() {
        sut = new PeriodDescriptionCalculator(LocalDateTime.now().minusDays(10));

        assertThat(sut.getPeriodDescription(DEFAULT_LANGUAGE)).isEqualTo("less than a month: 10 days");
    }

    @Test
    public void shouldReturnLessThanDayStatement() {
        sut = new PeriodDescriptionCalculator(LocalDateTime.now().minusHours(9));

        assertThat(sut.getPeriodDescription(DEFAULT_LANGUAGE)).isEqualTo("less than a day: 9 hours");
    }

    @Test
    public void shouldReturnLessThanMinuteStatement() {
        sut = new PeriodDescriptionCalculator(LocalDateTime.now().minusSeconds(3));

        assertThat(sut.getPeriodDescription(DEFAULT_LANGUAGE)).isEqualTo("less than a minute");
    }
}
