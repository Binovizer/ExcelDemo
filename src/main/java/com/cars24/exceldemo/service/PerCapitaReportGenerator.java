package com.cars24.exceldemo.service;

import com.cars24.exceldemo.model.Income;

import java.util.List;

/**
 * The type Generator
 *
 * @author Mohd Nadeem
 */
public interface PerCapitaReportGenerator {

    /**
     * Generates the report
     *
     * @param incomes are the incomes list to process
     */
    void generate(List<Income> incomes);
}
