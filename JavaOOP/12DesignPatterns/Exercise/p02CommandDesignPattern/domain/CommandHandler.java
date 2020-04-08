package p02CommandDesignPattern.domain;

import java.util.ArrayList;
import java.util.List;

import p02CommandDesignPattern.domain.commands.Command;
import p02CommandDesignPattern.domain.commands.EndCommand;
import p02CommandDesignPattern.domain.commands.PrintCommand;
import p02CommandDesignPattern.domain.commands.SaveCommand;

public class CommandHandler {

    private static List<String> storage = new ArrayList<>();

    public static Command createCommand(String[] tokens) {
        switch (tokens[0]) {
            case "save":
                return new SaveCommand(tokens[1], storage);
            case "print":
                return new PrintCommand(storage);
            case "end":
                return new EndCommand();
            default:
                return null;
        }
    }

}
