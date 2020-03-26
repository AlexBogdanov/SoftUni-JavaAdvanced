package domain.entities;

import java.math.BigDecimal;

import enums.Currency;

public class Money {

    private final Currency currency;
    private final BigDecimal value;

    public Money(Currency currency, BigDecimal value) {
        this.currency = currency;
        this.value = value;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getValue() + "" + this.getCurrency().toString();
    }

}
