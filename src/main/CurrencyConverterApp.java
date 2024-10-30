package main;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverterApp {

    public static void main(String[] args) {
        try {
            CurrencyService service = new CurrencyService();
            String jsonResponse = service.getExchangeRates();

            Gson gson = new Gson();
            CurrencyData currencyData = gson.fromJson(jsonResponse, CurrencyData.class);
            ConversionRates conversionRates = new ConversionRates();
            Map<String, Double> rates = currencyData.getConversionRates();
            List<String> filteredCurrencies = conversionRates.filterCurrencies(rates);

            // Crear un mapa para el acceso rápido a las monedas
            Map<Integer, String> currencyMap = new java.util.HashMap<>();
            for (int i = 0; i < filteredCurrencies.size(); i++) {
                String[] parts = filteredCurrencies.get(i).split(":");
                String currencyCode = parts[0].trim();
                currencyMap.put(i + 1, currencyCode);
                System.out.println((i + 1) + ". " + currencyCode);
            }

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Ingrese el número de la moneda de origen (o 0 para salir): ");
                int fromIndex = scanner.nextInt();
                if (fromIndex == 0) break;

                System.out.print("Ingrese el número de la moneda de destino: ");
                int toIndex = scanner.nextInt();

                System.out.print("Ingrese la cantidad a convertir: ");
                double amount = scanner.nextDouble();

                // Realizar la conversión
                String fromCurrency = currencyMap.get(fromIndex);
                String toCurrency = currencyMap.get(toIndex);
                if (fromCurrency == null || toCurrency == null) {
                    System.out.println("Selección de moneda no válida. Intente de nuevo.");
                    continue;
                }

                double convertedAmount = conversionRates.convert(fromCurrency, toCurrency, amount, rates);
                System.out.printf("La cantidad de %.2f %s es %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

