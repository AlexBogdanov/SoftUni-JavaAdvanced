package services;

import java.math.BigDecimal;

import domain.entities.Money;
import enums.Currency;

public class InhouseExchanger implements Exchanger {

    @Override
    public Money exchange(Money from, String toCurrency) {
        Currency currency = Currency.valueOf(toCurrency);
        BigDecimal rate = currency.getRateToBGN();
        BigDecimal convertedVal = rate.multiply(from.getValue());
        return new Money(currency, convertedVal);
    }

}
