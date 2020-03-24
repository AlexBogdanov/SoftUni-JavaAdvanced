package barracksWars.core.commands;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class AddCommand implements CommandOperation {

    private Command command;

    public AddCommand(Command command) {
        this.command = command;
    }

    @Override
    public String execute(String[] data) throws NotImplementedException {
        return command.add(data);
    }

}
