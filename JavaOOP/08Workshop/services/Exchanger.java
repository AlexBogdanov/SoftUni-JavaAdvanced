package services;

import domain.entities.Money;

public interface Exchanger {

    Money exchange(Money from, String toCurrency) throws Exception;

}
