package com.cars24.exceldemo.service.impl;

import com.cars24.exceldemo.model.Gender;
import com.cars24.exceldemo.model.Income;
import com.cars24.exceldemo.service.IncomeCalculationService;
import com.cars24.exceldemo.utils.CurrencyConversionUtility;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.*;

/**
 * The type IncomeCalculationServiceImpl
 *
 * @author Mohd Nadeem
 */
public class IncomeCalculationServiceImpl implements IncomeCalculationService {

    @Override
    public Map<String, Map<Gender, Double>> calculateAverageIncomePerCountryPerGender(
            List<Income> incomes) {
        return incomes.stream()
                .collect(
                        groupingBy(
                                Income::getCountry,
                                groupingBy(
                                        Income::getGender,
                                        mapping(
                                                this::getIncomeInUSDollars,
                                                averagingDouble(Double::valueOf)))))
                .entrySet()
                .stream()
                .sorted(Entry.comparingByKey())
                .collect(toMap(Entry::getKey, Entry::getValue, (m1, m2) -> m1, LinkedHashMap::new));
    }

    private double getIncomeInUSDollars(Income income) {
        return CurrencyConversionUtility.convertToUSD(
                income.getAverageIncome(), income.getCurrency());
    }
}
