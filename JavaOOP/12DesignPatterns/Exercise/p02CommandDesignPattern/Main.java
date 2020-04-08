package p02CommandDesignPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import p02CommandDesignPattern.domain.CommandHandler;
import p02CommandDesignPattern.domain.commands.Command;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            Command command = createCommand(reader);
            executeCommand(command);
        }

    }

    private static void executeCommand(Command command) {
        command.execute();
    }

    private static Command createCommand(BufferedReader reader) throws IOException {
        String[] tokens = reader.readLine().split("\\s+");
        return CommandHandler.createCommand(tokens);
    }

}
