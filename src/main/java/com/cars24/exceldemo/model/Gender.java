package com.cars24.exceldemo.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * The type Gender
 *
 * @author Mohd Nadeem
 */
@Getter
public enum Gender {
    MALE("Male", "M"),
    FEMALE("Female", "F"),
    OTHER("Other", "O");

    private String value;
    private String abbr;

    Gender(String value, String abbr) {
        this.value = value;
        this.abbr = abbr;
    }

    public static Gender fromAbbr(String abbr) {
        Optional<Gender> first =
                Arrays.stream(Gender.values())
                        .filter(currency -> currency.getAbbr().equalsIgnoreCase(abbr))
                        .findFirst();
        return first.orElse(Gender.OTHER);
    }
}
