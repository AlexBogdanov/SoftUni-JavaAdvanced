package barracksWars.core.commands;

public class FightCommand implements CommandOperation {

    private Command command;

    public FightCommand(Command command) {
        this.command = command;
    }

    @Override
    public String execute(String[] data) {
        return command.fight(data);
    }

}
