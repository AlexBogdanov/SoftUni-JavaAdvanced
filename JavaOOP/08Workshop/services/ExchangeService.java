package services;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import domain.entities.Money;
import enums.Currency;

public class ExchangeService implements Exchanger {

    private static final String API_KEY = System.getenv("API_KEY");

    @Override
    public Money exchange(Money from, String toCurrency)
        throws URISyntaxException, IOException, InterruptedException {
        BigDecimal rate = getRate(from.getCurrency().toString(), toCurrency);
        BigDecimal convertedVal = rate.multiply(from.getValue());
        return new Money(Currency.valueOf(toCurrency), convertedVal);
    }

    private BigDecimal getRate(String from, String to)
        throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(getUri(from, to))
            .build();
            
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return extractExchangeRate(response.body());
    }

    private BigDecimal extractExchangeRate(String response) {
        int i = response.lastIndexOf(':');
        int n = response.lastIndexOf('}');
        String exchangeRate = response.substring(i + 1, n);
        return new BigDecimal(exchangeRate);
    }

    private URI getUri(String from, String to) throws URISyntaxException {
        String url = String.format(
            "https://free.currconv.com/api/v7/convert?apiKey=%s&q=%s_%s&compact=ultra",
            API_KEY, from, to
        );

        return new URI(url);
    }

}
