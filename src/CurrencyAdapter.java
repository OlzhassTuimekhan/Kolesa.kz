import java.util.HashMap;
import java.util.Map;

public class CurrencyAdapter implements CurrencyConverter {
    private final Map<String, Double> exchangeRates;

    public CurrencyAdapter() {
        this.exchangeRates = new HashMap<>();
        // Инициализация курсов валют
        exchangeRates.put("USD", 465.0); // 1 USD = 465 KZT
        exchangeRates.put("EUR", 510.0); // 1 EUR = 510 KZT
        exchangeRates.put("KZT", 1.0);   // 1 KZT = 1 KZT
        exchangeRates.put("RUB", 6.0);   // 1 RUB = 6 KZT
    }

    @Override
    public double convertToKZT(String currency, double amount) {
        Double rate = exchangeRates.get(currency.toUpperCase());
        if (rate == null) {
            throw new IllegalArgumentException("Unsupported currency: " + currency);
        }
        return amount * rate;
    }
}