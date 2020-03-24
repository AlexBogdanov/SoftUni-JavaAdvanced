package barracksWars.core.commands;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class CommandExecutor {

    private Command command;

    public CommandExecutor(Repository repository, UnitFactory unitFactory) {
        this.command = new Command(repository, unitFactory);
    }

    public String executeCommand(String commandName, String[] data)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotImplementedException {
        try {
            String classSimpleName = commandName.substring(0, 1).toUpperCase() + commandName.substring(1) + "Command";
            String className = "barracksWars.core.commands." + classSimpleName;
            Class<?> clazz =  Class.forName(className);
            Constructor<?> ctor = clazz.getDeclaredConstructor(Command.class);
            CommandOperation obj = (CommandOperation) ctor.newInstance(this.command);
            return obj.execute(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

}
