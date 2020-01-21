package com.cars24.exceldemo.service.impl;

import com.cars24.exceldemo.model.Gender;
import com.cars24.exceldemo.model.Income;
import com.cars24.exceldemo.service.IncomeCalculationService;
import com.cars24.exceldemo.service.PerCapitaReportGenerator;

import java.util.List;
import java.util.Map;

import static com.cars24.exceldemo.utils.Constants.*;

/**
 * The type ConsolePerCapitaReportGenerator
 *
 * @author Mohd Nadeem
 */
public class ConsoleBasedPerCapitaReportGenerator implements PerCapitaReportGenerator {

    private IncomeCalculationService incomeCalculationService;

    public ConsoleBasedPerCapitaReportGenerator(IncomeCalculationService incomeCalculationService) {
        this.incomeCalculationService = incomeCalculationService;
    }

    @Override
    public void generate(List<Income> incomes) {
        Map<String, Map<Gender, Double>> avgGenderIncomeByCountry =
                incomeCalculationService.calculateAverageIncomePerCountryPerGender(incomes);
        prettyPrint(avgGenderIncomeByCountry);
    }

    private void prettyPrint(Map<String, Map<Gender, Double>> avgGenderIncomeByCountry) {
        printHeaders();
        avgGenderIncomeByCountry.forEach(
                (countryKey, countryValue) ->
                        countryValue.forEach(
                                (genderKey, genderValue) -> {
                                    System.out.format(
                                            PRINT_FORMAT, countryKey, genderKey, genderValue);
                                }));
        printBorder();
    }

    private void printHeaders() {
        printBorder();
        System.out.format(HEADER);
        printBorder();
    }

    private void printBorder() {
        System.out.format(BORDER);
    }
}
