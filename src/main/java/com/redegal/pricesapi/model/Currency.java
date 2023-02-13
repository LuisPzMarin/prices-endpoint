package com.redegal.pricesapi.model;

public enum Currency {
    EUR("Euro"),
    DOL("Dolar"),
    UNK("Unknown");
    private final String value;

    Currency(String value) {
        this.value = value;
    }


}
