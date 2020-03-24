package barracksWars.core.commands;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public interface CommandOperation {

    String execute(String[] data) throws NotImplementedException;

}
