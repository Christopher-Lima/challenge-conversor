import com.google.gson.Gson;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ExchangeRateClient {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    // Sua chave da API
    private static final String API_KEY = "10ff7caf2e6f14e1809a91e1";

    public BigDecimal fetchRate(String baseCurrency, String targetCurrency) {
        URI url = URI.create(
                "https://v6.exchangerate-api.com/v6/" + API_KEY
                        + "/pair/" + baseCurrency.toUpperCase()
                        + "/" + targetCurrency.toUpperCase()
        );

        HttpRequest request = HttpRequest.newBuilder(url).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Falha na API: HTTP " + response.statusCode());
            }

            ExchangeRate body = gson.fromJson(response.body(), ExchangeRate.class);

            if (body == null) {
                throw new RuntimeException("Resposta da API vazia.");
            }
            if (!"success".equalsIgnoreCase(body.result())) {
                String detail = body.errorType() != null ? body.errorType() : "desconhecido";
                throw new RuntimeException("A API retornou erro: " + detail);
            }
            if (body.conversionRate() == null) {
                throw new RuntimeException("A API não retornou conversion_rate.");
            }

            return body.conversionRate();

        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter a taxa desta moeda.", e);
        }
    }
}
