package domain.commands;

import java.util.List;

import domain.entities.Money;
import domain.repositories.MoneyRepository;
import logger.Logger;

public class HistoryCommand implements Command<HistoryCommand.Input> {

    private MoneyRepository moneyRepository;
    private Logger logger;

    public HistoryCommand(MoneyRepository moneyRepository, Logger logger) {
        this.moneyRepository = moneyRepository;
        this.logger = logger;
    }

    @Override
    public void execute(Input input) {
        List<Money> money = this.moneyRepository.getLastRecords(input.getRecordsCount());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < money.size(); i+=2) {
            Money to = money.get(i);
            Money from = money.get(i + 1);

            sb.append(from.toString() + " - " + to.toString())
                .append(System.lineSeparator());
        }

        this.logger.log(sb.toString());
    }


    public static class Input extends EmptyInput {

        private int recordsCount;

        public Input(int recordsCount) {
            this.recordsCount = recordsCount;
        }

        public int getRecordsCount() {
            return this.recordsCount;
        }

    }
}