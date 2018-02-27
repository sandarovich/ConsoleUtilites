package com.sandarovich.utilites.calculator.period.language;

public class LanguageFactory {
    private LanguageFactory() {
    }

    public static Language getLanguage(String languageCode) {
        switch (languageCode) {
            case "en":
                return new EnglishLanguage();
            case "uk":
                return new UkraineLanguage();
            case "ru":
                return new RussianLanguage();
            default:
                return new EnglishLanguage();
        }
    }
}
