package utils;

import domain.entities.Money;
import services.ExchangeService;
import services.Exchanger;
import services.InhouseExchanger;

public class Converter {

    public static Money convert(Money from, String toCurrency) {
        try {
            Exchanger exchanger = new ExchangeService();
            return exchanger.exchange(from, toCurrency);
        } catch (Exception e) {
            return secondaryHandler(from, toCurrency);
        }
    }

    private static Money secondaryHandler(Money from, String toCurrency) {
        try {
            Exchanger exchanger = new InhouseExchanger();
            return exchanger.exchange(from, toCurrency);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong with our converter");
        }
    }

}
