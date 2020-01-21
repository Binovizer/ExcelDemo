package com.cars24.exceldemo.service;

import com.cars24.exceldemo.model.Gender;
import com.cars24.exceldemo.model.Income;

import java.util.List;
import java.util.Map;

/**
 * The type CalculationService
 *
 * @author Mohd Nadeem
 */
public interface IncomeCalculationService {

    /**
     * Calculates the average income per country per gender
     *
     * @param incomes the incomes to be process
     * @return returns the map
     */
    Map<String, Map<Gender, Double>> calculateAverageIncomePerCountryPerGender(
            List<Income> incomes);
}
