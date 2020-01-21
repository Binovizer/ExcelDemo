package com.cars24.exceldemo.model;

import lombok.*;

/**
 * The type Income
 *
 * @author Mohd Nadeem
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Income {
    private String country;
    private String city;
    private Gender gender;
    private Currency currency;
    private long averageIncome;
}
