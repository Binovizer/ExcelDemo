package com.cars24.exceldemo.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * The type Currency
 *
 * @author Mohd Nadeem
 */
@Getter
public enum Currency {
    UNKNOWN("", 0),
    USD("USD", 1),
    INR("INR", 66f),
    GBP("GBP", 1.74f),
    SGP("SGP", 1.34f);

    private String code;
    private float conversionRate;

    Currency(String code, float conversionRate) {
        this.code = code;
        this.conversionRate = conversionRate;
    }

    public static Currency fromCode(String code) {
        Optional<Currency> first =
                Arrays.stream(Currency.values())
                        .filter(currency -> currency.getCode().equalsIgnoreCase(code))
                        .findFirst();
        return first.orElse(Currency.UNKNOWN);
    }
}
