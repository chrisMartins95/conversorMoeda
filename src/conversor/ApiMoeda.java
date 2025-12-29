package conversor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

/**
 * 🌐 API de Moedas com GSON - parsing PROFISSIONAL! 💎
 */
public class ApiMoeda {

    private final HttpClient client;
    private final Gson gson;

    // 🔑 SUA API Key aqui!
    private static final String API_URL =
            "https://v6.exchangerate-api.com/v6/f5b8e9a7ce958002da029cd0/latest/BRL";

    public ApiMoeda() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson(); // 🛠️ Gson pronto!
    }

    /**
     * 🚀 Busca 6 moedas com estrutura CORRETA da API v6!
     */
    public Moeda[] buscarTodasMoedas() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            //System.out.println("✅ JSON: " + json.substring(0, 150) + "...");

            // 💎 GSON para API v6
            JsonObject jsonObj = gson.fromJson(json, JsonObject.class);

            // 🔍 DEBUG - mostra estrutura real
            //System.out.println("🔍 Chaves encontradas: " + jsonObj.keySet());

            // ✅ API v6 usa "conversion_rates" ou "rates"
            JsonObject rates = null;
            if (jsonObj.has("conversion_rates")) {
                rates = jsonObj.getAsJsonObject("conversion_rates");
            } else if (jsonObj.has("rates")) {
                rates = jsonObj.getAsJsonObject("rates");
            }

            if (rates == null) {
                throw new RuntimeException("Estrutura rates não encontrada!");
            }


            return new Moeda[] {
                    new Moeda("🇺🇸 Dólar", "USD", 1.0 / rates.get("USD").getAsDouble()),
                    new Moeda("🇪🇺 Euro", "EUR", 1.0 / rates.get("EUR").getAsDouble()),
                    new Moeda("🇬🇧 Libra", "GBP", 1.0 / rates.get("GBP").getAsDouble()),
                    new Moeda("🇨🇦 Dólar Canadense", "CAD", 1.0 / rates.get("CAD").getAsDouble()),
                    new Moeda("🇯🇵 Iene", "JPY", 1.0 / rates.get("JPY").getAsDouble()),
                    new Moeda("🇦🇺 Dólar Australiano", "AUD", 1.0 / rates.get("AUD").getAsDouble()),
                    new Moeda("🇲🇽 Peso Mexicano", "MXN", 1.0 / rates.get("MXN").getAsDouble()),
                    new Moeda("🇷🇺 Rublo", "RUB", 1.0 / rates.get("RUB").getAsDouble()),
                    new Moeda("🇨🇳 Yuan", "CNY", 1.0 / rates.get("CNY").getAsDouble()),
                    new Moeda("🇮🇳 Rupia", "INR", 1.0 / rates.get("INR").getAsDouble()),
                    new Moeda("🇧🇬 Bitcoin", "BTC", 450000.0),
                    new Moeda("🪙 Ethereum", "ETH", 15000.0)
            };

        } catch (Exception e) {
            System.err.println("❌ Erro API: " + e.getMessage());
            return criarMoedasFallback();
        }
    }


    /**
     * 🪙 Bitcoin tem API própria - valor aproximado
     */
    private double getBitcoinValue() {
        return 450000.0; // R$ por BTC (aproximado)
    }

    /**
     * 🔄 Fallback caso API falhe
     */
    private Moeda[] criarMoedasFallback() {
        return new Moeda[] {
                new Moeda("Dólar", "USD", 5.67),
                new Moeda("Euro", "EUR", 6.12),
                new Moeda("Libra", "GBP", 7.15),
                new Moeda("Peso Argentino", "ARS", 0.032),
                new Moeda("Yuan Chinês", "CNY", 0.80),
                new Moeda("Bitcoin", "BTC", 450000.0)
        };
    }
}
