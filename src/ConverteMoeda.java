import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverteMoeda {

    private static final String API_KEY = "73846b2e5f09f10f2aed121c"; // Your API key

    public TaxaDeConversao buscaMoeda(String moedaBase) { // Renamed parameter for clarity
        // Dynamically build the URI using the provided moedaBase
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + moedaBase;
        URI buscaMoeda = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(buscaMoeda)
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Check for successful HTTP status code
            if (response.statusCode() != 200) {
                System.err.println("Erro na API: Código de status HTTP " + response.statusCode());
                System.err.println("Corpo da resposta: " + response.body());
                throw new IOException("Falha ao buscar dados da API. Status: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            // Re-throwing as RuntimeException is acceptable here given the context,
            // but a more specific custom exception might be better in larger apps.
            throw new RuntimeException("Não consegui fazer a conversão a partir desta opção. Erro: " + e.getMessage(), e);
        }

        String json = response.body();

        Gson gson = new Gson();
        TaxaDeConversao minhaTaxaDeConversao = gson.fromJson(json, TaxaDeConversao.class);

        return minhaTaxaDeConversao;
    }
}


