package p02CommandDesignPattern.domain.commands;

import java.util.List;

public class SaveCommand extends Command {

    private String text;
    private List<String> storage;

    public SaveCommand(String text, List<String> storage) {
        this.text = text;
        this.storage = storage;
    }

    @Override
    public void execute() {
        this.storage.add(this.text);
    }

}
