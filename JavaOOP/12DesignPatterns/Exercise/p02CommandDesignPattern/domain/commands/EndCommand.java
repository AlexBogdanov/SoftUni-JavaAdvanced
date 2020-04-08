package p02CommandDesignPattern.domain.commands;

public class EndCommand extends Command {

    @Override
    public void execute() {
        System.exit(1);
    }

}
