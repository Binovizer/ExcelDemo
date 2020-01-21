package com.cars24.exceldemo;

import com.cars24.exceldemo.model.Income;
import com.cars24.exceldemo.service.IncomeCalculationService;
import com.cars24.exceldemo.service.IncomeParser;
import com.cars24.exceldemo.service.PerCapitaReportGenerator;
import com.cars24.exceldemo.service.impl.ConsoleBasedPerCapitaReportGenerator;
import com.cars24.exceldemo.service.impl.ExcelIncomeParser;
import com.cars24.exceldemo.service.impl.IncomeCalculationServiceImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * The type Main
 *
 * @author Mohd Nadeem
 */
public class Application {

    private static final String EXCEL_FILE_NAME =
            "/Users/nadeem/Documents/demo/ExcelDemo/src/main/resources/Sample_Input.csv";

    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(EXCEL_FILE_NAME);
        IncomeParser incomeParser = new ExcelIncomeParser();
        List<Income> incomes = incomeParser.parse(inputStream);
        IncomeCalculationService incomeCalculationService = new IncomeCalculationServiceImpl();
        PerCapitaReportGenerator perCapitaReportGenerator =
                new ConsoleBasedPerCapitaReportGenerator(incomeCalculationService);
        perCapitaReportGenerator.generate(incomes);
    }
}
