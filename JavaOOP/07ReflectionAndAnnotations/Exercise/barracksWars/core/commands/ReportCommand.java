package barracksWars.core.commands;

public class ReportCommand implements CommandOperation {

    private Command command;

    public ReportCommand(Command command) {
        this.command = command;
    }

    @Override
    public String execute(String[] data) {
        return command.report(data);
    }

}
