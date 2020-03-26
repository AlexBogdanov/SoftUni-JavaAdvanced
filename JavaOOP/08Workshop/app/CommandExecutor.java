package app;

import java.math.BigDecimal;

import domain.commands.ConvertCommand;
import domain.commands.EmptyInput;
import domain.commands.EndCommand;
import domain.commands.HistoryCommand;
import domain.entities.Money;
import domain.repositories.MoneyRepository;
import enums.Currency;
import logger.Logger;
import validators.InputValidator;

public class CommandExecutor {

    private Logger logger;
    private MoneyRepository moneyRepository;

    public CommandExecutor() {
        this.logger = new Logger();
        this.moneyRepository = new MoneyRepository();
    }

    public void execute(String[] args) {
        switch (args[0]) {
            case "End":
                end();
                break;
            case "Convert":
                try {
                    convert(InputValidator.validateConvertCommand(args));
                } catch (IllegalArgumentException iae) {
                    this.logger.logErr(iae.getMessage());
                }
                break;
            case "History":
                try {
                    history(InputValidator.validateHistoryCommand(args));
                } catch (IllegalArgumentException iae) {
                    this.logger.logErr(iae.getMessage());
                }
                break;
            default:
                this.logger.logErr("Invalid command!");
        }
    }

    private void history(String[] args) {
        int recordsCount = Integer.parseInt(args[1]);
        var input = new HistoryCommand.Input(recordsCount);
        var command = new HistoryCommand(this.moneyRepository, this.logger);
        command.execute(input);
    }

    private void convert(String[] args) {
        var fromCurr = Currency.valueOf(args[1]);
        BigDecimal fromCurrVal = new BigDecimal(args[2]);
        String toCurr = args[3];

        var input = new ConvertCommand.Input(new Money(fromCurr, fromCurrVal), toCurr);
        var command = new ConvertCommand(this.moneyRepository, this.logger);
        command.execute(input);
    }

    private void end() {
        var command = new EndCommand();
        command.execute(new EmptyInput());
    }

}
