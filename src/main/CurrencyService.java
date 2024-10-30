package main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyService {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/6e2eaa4e34679957110179d3/latest/USD";

    public String getExchangeRates() throws Exception {
        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construir la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Accept", "application/json")
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar el código de respuesta
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error: " + response.statusCode());
        }

        return response.body(); // Retornar el cuerpo de la respuesta
    }
}
