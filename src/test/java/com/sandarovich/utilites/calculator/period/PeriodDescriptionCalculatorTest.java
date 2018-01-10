package com.sandarovich.utilites.calculator.period;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;

import static com.sandarovich.utilites.calculator.period.assertion.PeriodDescriptionCalculatorAssert.assertThat;
import static org.junit.Assert.assertEquals;

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

    @DataProvider
    public static Object[][] greatThanNowData() {
        return new Object[][]{
                {DEFAULT_LANGUAGE, "great than now"},
                {ENGLISH_LANGUAGE, "great than now"},
                {UKRAINIAN_LANGUAGE, "більше чим поточний час"},
                {RUSSIAN_LANGUAGE, "больше чем текущее время"}
        };
    }

    @DataProvider
    public static Object[][] lessThanYearData() {
        return new Object[][]{
                {DEFAULT_LANGUAGE, LocalDateTime.now().minusMonths(1), "less than a year: 1 month"},
                {DEFAULT_LANGUAGE, LocalDateTime.now().minusMonths(1), "less than a year: 1 month"},
                {ENGLISH_LANGUAGE, LocalDateTime.now().minusMonths(3), "less than a year: 3 months"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusMonths(1), "меньше року: 1 місяць"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusMonths(1).minusDays(2), "меньше року: 1 місяць, 2 дні"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusMonths(1).minusDays(1), "меньше року: 1 місяць, 1 день"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusMonths(1).minusDays(1).minusHours(48), "меньше року: 1 місяць, 3 дні"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusMonths(1).minusDays(1).minusHours(144), "меньше року: 1 місяць, 7 днів"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusMonths(7).minusDays(1).minusHours(168), "меньше року: 7 місяців, 8 днів"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusMonths(3), "меньше року: 3 місяці"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusMonths(5), "меньше року: 5 місяців"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusMonths(1), "меньше года: 1 месяц"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusMonths(3), "меньше года: 3 месяца"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusMonths(5), "меньше года: 5 месяцев"}
        };
    }

    @DataProvider
    public static Object[][] lessThanMonthData() {
        return new Object[][]{
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusDays(2), "меньше місяця: 2 дні"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusDays(2).minusHours(12), "меньше місяця: 2 дні, 12 годин"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusDays(2).minusHours(12).minusMinutes(90), "меньше місяця: 2 дні, 13 годин"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusDays(1), "меньше місяця: 1 день"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusDays(2).minusMinutes(120), "меньше місяця: 2 дні, 2 години"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusDays(3), "меньше місяця: 3 дні"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusDays(20).minusHours(144), "меньше місяця: 26 днів"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusDays(11).minusHours(168), "меньше місяця: 18 днів"},
        };
    }

    @DataProvider
    public static Object[][] lessThanDayData() {
        return new Object[][]{
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusHours(1), "меньше дня: 1 година"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusHours(3), "меньше дня: 3 години"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusHours(5), "меньше дня: 5 годин"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusHours(1).minusMinutes(59), "меньше дня: 1 година, 59 хвилин"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusMinutes(47), "меньше дня: 47 хвилин"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusHours(23).minusMinutes(59).minusSeconds(59), "меньше дня: 23 години, 59 хвилин"},
        };
    }

    @DataProvider
    public static Object[][] lessThanMinuteData() {
        return new Object[][]{
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusSeconds(59), "меньше хвилини"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusSeconds(1), "меньше хвилини"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusSeconds(0), "меньше хвилини"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusSeconds(30), "меньше хвилини"},
                {UKRAINIAN_LANGUAGE, LocalDateTime.now().minusSeconds(5), "меньше хвилини"},
                {ENGLISH_LANGUAGE, LocalDateTime.now().minusSeconds(59), "less than a minute"},
                {ENGLISH_LANGUAGE, LocalDateTime.now().minusSeconds(1), "less than a minute"},
                {ENGLISH_LANGUAGE, LocalDateTime.now().minusSeconds(0), "less than a minute"},
                {ENGLISH_LANGUAGE, LocalDateTime.now().minusSeconds(30), "less than a minute"},
                {ENGLISH_LANGUAGE, LocalDateTime.now().minusSeconds(5), "less than a minute"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusSeconds(59), "меньше минуты"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusSeconds(1), "меньше минуты"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusSeconds(0), "меньше минуты"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusSeconds(30), "меньше минуты"},
                {RUSSIAN_LANGUAGE, LocalDateTime.now().minusSeconds(5), "меньше минуты"},
        };
    }

    @UseDataProvider("moreThanYearData")
    @Test
    public void shouldReturnMoreThanYearStatement(String language, LocalDateTime localDateTime, String expectedResult) {
        assertThat(new PeriodDescriptionCalculator(localDateTime, language))
                .hasPeriodDescription(expectedResult);
    }

    @UseDataProvider("lessThanYearData")
    @Test
    public void shouldReturnLessThanYearStatement(String language, LocalDateTime localDateTime, String expectedResult) {
        assertThat(new PeriodDescriptionCalculator(localDateTime, language))
                .hasPeriodDescription(expectedResult);
    }

    @UseDataProvider("lessThanMonthData")
    @Test
    public void shouldReturnLessThanMonthStatement(String language, LocalDateTime localDateTime, String expectedResult) {
        assertThat(new PeriodDescriptionCalculator(localDateTime, language))
                .hasPeriodDescription(expectedResult);
    }

    @UseDataProvider("lessThanDayData")
    @Test
    public void shouldReturnLessThanDayStatement(String language, LocalDateTime localDateTime, String expectedResult) {
        assertThat(new PeriodDescriptionCalculator(localDateTime, language))
                .hasPeriodDescription(expectedResult);
    }

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

    @UseDataProvider("lessThanMinuteData")
    @Test
    public void shouldReturnLessThanMinuteStatement(String language, LocalDateTime localDateTime, String expectedResult) {
        assertThat(new PeriodDescriptionCalculator(localDateTime, language))
                .hasPeriodDescription(expectedResult);
    }

    @Test
    public void shouldReturnEnglishLanguageStatementWhenLanguageCodeNotSpecified() {
        assertThat(new PeriodDescriptionCalculator(LocalDateTime.now().minusHours(1).minusMinutes(59)))
                .hasPeriodDescription("less than a day: 1 hour, 59 minutes");
    }

    @Test
    public void shouldReturnUkraineLanguageStatementWhenLanguageCodeSpecified() {
        PeriodDescriptionCalculator sut = new PeriodDescriptionCalculator(LocalDateTime.now().minusMinutes(59));
        assertEquals("меньше дня: 59 хвилин", sut.getPeriodDescription("uk"));

    }

    @UseDataProvider("greatThanNowData")
    @Test
    public void shouldReturnGreatThanNowWhenDateIsAfter(String language, String expectedResult) {
        assertThat(new PeriodDescriptionCalculator(LocalDateTime.now().plusHours(1).plusMinutes(59), language))
                .hasPeriodDescription(expectedResult);
    }
}
