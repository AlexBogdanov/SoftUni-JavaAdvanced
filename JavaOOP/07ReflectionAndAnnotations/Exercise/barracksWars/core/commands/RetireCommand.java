package barracksWars.core.commands;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class RetireCommand implements CommandOperation {

    private Command command;

    public RetireCommand(Command command) {
        this.command = command;
    }

    @Override
    public String execute(String[] data) throws NotImplementedException {
        return command.retire(data);
    }

}
