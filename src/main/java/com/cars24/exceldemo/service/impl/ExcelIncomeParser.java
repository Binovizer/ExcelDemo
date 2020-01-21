package com.cars24.exceldemo.service.impl;

import com.cars24.exceldemo.model.Currency;
import com.cars24.exceldemo.model.Gender;
import com.cars24.exceldemo.model.Income;
import com.cars24.exceldemo.service.IncomeParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.cars24.exceldemo.utils.Constants.*;

/**
 * The type ExcelSheetParser
 *
 * @author Mohd Nadeem
 */
public class ExcelIncomeParser implements IncomeParser {

    @Override
    public List<Income> parse(InputStream inputStream) {
        return parse(inputStream, true);
    }

    @Override
    public List<Income> parse(InputStream inputStream, boolean hasHeaders) {
        List<Income> incomes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            if (hasHeaders) {
                if (reader.ready()) {
                    reader.readLine();
                }
            }
            while (reader.ready()) {
                String line = reader.readLine();

                String[] row = line.split(COMMA);
                String country = row[COUNTRY_INDEX];
                String city = row[CITY_INDEX];
                Gender gender = Gender.fromAbbr(row[GENDER_INDEX]);
                Currency currency = Currency.fromCode(row[CURRENCY_INDEX]);
                long averageIncome = Long.parseLong(row[AVERAGE_INCOME_INDEX]);
                Income income =
                        Income.builder()
                                .country(country)
                                .city(city)
                                .gender(gender)
                                .currency(currency)
                                .averageIncome(averageIncome)
                                .build();
                incomes.add(income);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return incomes;
    }
}
