package domain.commands;

import domain.entities.Money;
import domain.repositories.MoneyRepository;
import logger.Logger;
import utils.Converter;

public class ConvertCommand implements Command<ConvertCommand.Input> {

    private MoneyRepository moneyRepository;
    private Logger logger;

    public ConvertCommand(MoneyRepository moneyRepository, Logger logger) {
        this.moneyRepository = moneyRepository;
        this.logger = logger;
    }

    @Override
    public void execute(Input input) {
        Money to = Converter.convert(input.getFrom(), input.getToCurrency());
        this.moneyRepository.save(input.getFrom(), to);
        this.logger.log(input.getFrom().toString() + " - " + to.toString());
    }

    public static class Input extends EmptyInput {

        private final Money from;
        private final String toCurrency;

        public Input(Money from, String toCurrency) {
            this.from = from;
            this.toCurrency = toCurrency;
        }

        public Money getFrom() {
            return this.from;
        }

        public String getToCurrency() {
            return this.toCurrency;
        }

    }

}
