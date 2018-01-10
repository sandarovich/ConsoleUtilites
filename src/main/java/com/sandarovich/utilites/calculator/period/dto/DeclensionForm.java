package com.sandarovich.utilites.calculator.period.dto;

public enum DeclensionForm {
    SINGULAR(0),
    PLURAL_ONE(1),
    PLURAL_TWO(2);

    private final int index;

    DeclensionForm(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }
}
