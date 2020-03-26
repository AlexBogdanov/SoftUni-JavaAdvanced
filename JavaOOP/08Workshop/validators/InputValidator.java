package validators;

import java.math.BigDecimal;

import enums.Currency;

public class InputValidator {

    public static String[] validateConvertCommand(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Invalid number of argumets.");
        }
        
        try {
            Currency.valueOf(args[1]);
        } catch (RuntimeException re) {
            throw new IllegalArgumentException("Invalid currency " + args[1]);
        }

        try {
            new BigDecimal(args[2]);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid numeric value " + args[2]);
        }

        try {
            Currency.valueOf(args[3]);
        } catch (RuntimeException re) {
            throw new IllegalArgumentException("Invalid currency " + args[3]);
        }

        return args;
    }

    public static String[] validateHistoryCommand(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid number of argumets.");
        }

        try {
            Integer.parseInt(args[1]);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid numeric value " + args[1]);
        }

        return args;
    }

}
