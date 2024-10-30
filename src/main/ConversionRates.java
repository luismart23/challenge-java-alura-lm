package main;

import java.util.Map;

public class ConversionRates {

    public double convert(String fromCurrency, String toCurrency, double amount, Map<String, Double> rates) {
        if (rates.containsKey(fromCurrency) && rates.containsKey(toCurrency)) {
            double fromRate = rates.get(fromCurrency);
            double toRate = rates.get(toCurrency);
            return (amount / fromRate) * toRate;
        }
        throw new IllegalArgumentException("Monedas no válidas para la conversión.");
    }
}
