package com.cars24.exceldemo.utils;

import com.cars24.exceldemo.model.Currency;
import lombok.experimental.UtilityClass;

/**
 * The type ConversionUtil
 *
 * @author Mohd Nadeem
 */
@UtilityClass
public class CurrencyConversionUtility {

    /**
     * Converts the amount to USD
     *
     * @param amount is the amount to be converted
     * @param from is the from currency
     * @return returns the converted amount
     */
    public double convertToUSD(double amount, Currency from) {
        return convert(amount, from, Currency.USD);
    }

    /**
     * Converts the amount from one currency to other currency
     *
     * @param amount is the amount to be converted
     * @param from is the from currency
     * @param to is the to currency
     * @return returns the converted amount
     */
    public double convert(double amount, Currency from, Currency to) {
        double amountInUSD = amount / from.getConversionRate();
        return amountInUSD * to.getConversionRate();
    }
}
