package p02CommandDesignPattern.domain.commands;

import java.util.List;

public class PrintCommand extends Command {

    private List<String> storage;

    public PrintCommand(List<String> storage) {
        this.storage = storage;
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        
        for (String text : this.storage) {
            sb.append(text).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

}
