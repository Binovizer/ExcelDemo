package com.cars24.exceldemo.service;

import com.cars24.exceldemo.model.Income;

import java.io.InputStream;
import java.util.List;

/**
 * The type Parser
 *
 * @author Mohd Nadeem
 */
public interface IncomeParser {

    /**
     * Parses and returns the list
     *
     * @return the list of income objects
     */
    List<Income> parse(InputStream inputStream);

    /**
     * Parses and returns the list
     *
     * @return the list of income objects
     */
    List<Income> parse(InputStream inputStream, boolean hasHeaders);
}
