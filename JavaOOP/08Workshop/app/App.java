package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public void run() {

        var reader = new BufferedReader(new InputStreamReader(System.in));
        var commandExecutor = new CommandExecutor();

        while(true) {
            try {
                String[] tokens = reader.readLine().split("\\s+");
                commandExecutor.execute(tokens);
            } catch (IOException ioe) {
                throw new RuntimeException(ioe.getMessage());
            }
        }

    }

}
