package main;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CurrencyConverterApp {

    private static final Map<String, String> currencyCountries = new HashMap<>();

    static {
        currencyCountries.put("USD", "Estados Unidos");
        currencyCountries.put("CLP", "Chile");
        currencyCountries.put("ARS", "Argentina");
        currencyCountries.put("GBP", "Reino Unido");
        currencyCountries.put("BRL", "Brasil");
        // Agregar más monedas y países según sea necesario
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyService currencyService = new CurrencyService();
        Gson gson = new Gson();

        try {
            String jsonResponse = currencyService.getExchangeRates();
            CurrencyData currencyData = gson.fromJson(jsonResponse, CurrencyData.class);
            Map<String, Double> rates = currencyData.getConversionRates();

            while (true) {
                System.out.println("Monedas disponibles:");

                // Filtrar las monedas con país
                List<String> currenciesWithCountry = rates.keySet().stream()
                        .filter(currencyCountries::containsKey)
                        .collect(Collectors.toList());

                for (int i = 0; i < currenciesWithCountry.size(); i++) {
                    String currencyCode = currenciesWithCountry.get(i);
                    String country = currencyCountries.get(currencyCode);
                    System.out.printf("%d: %s (%s)%n", (i + 1), currencyCode, country);
                }

                System.out.print("Seleccione la moneda de origen (número): ");
                int fromCurrencyIndex = scanner.nextInt() - 1;
                String fromCurrency = currenciesWithCountry.get(fromCurrencyIndex);

                System.out.print("Seleccione la moneda de destino (número): ");
                int toCurrencyIndex = scanner.nextInt() - 1;
                String toCurrency = currenciesWithCountry.get(toCurrencyIndex);

                System.out.print("Ingrese la cantidad a convertir: ");
                double amount = scanner.nextDouble();

                ConversionRates conversionRates = new ConversionRates();
                double convertedAmount = conversionRates.convert(fromCurrency, toCurrency, amount, rates);
                System.out.printf("Cantidad convertida: %.2f %s%n", convertedAmount, toCurrency);

                System.out.print("¿Desea realizar otra conversión? (s/n): ");
                scanner.nextLine(); // Consumir la nueva línea
                String anotherConversion = scanner.nextLine();
                if (!anotherConversion.equalsIgnoreCase("s")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
