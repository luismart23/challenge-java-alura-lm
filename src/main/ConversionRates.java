package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConversionRates {

    public List<String> filterCurrencies(Map<String, Double> rates) {
        List<String> filteredRates = new ArrayList<>();
        String[] currenciesOfInterest = {"USD", "ARS", "CLP", "BRL", "GBP"};

        for (String currency : currenciesOfInterest) {
            if (rates.containsKey(currency)) {
                filteredRates.add(currency + ": " + rates.get(currency));
            }
        }
        return filteredRates;
    }

    public double convert(String fromCurrency, String toCurrency, double amount, Map<String, Double> rates) {
        if (rates.containsKey(fromCurrency) && rates.containsKey(toCurrency)) {
            double fromRate = rates.get(fromCurrency);
            double toRate = rates.get(toCurrency);
            return (amount / fromRate) * toRate; // Convert to the target currency
        }
        throw new IllegalArgumentException("Invalid currency for conversion");
    }
}
