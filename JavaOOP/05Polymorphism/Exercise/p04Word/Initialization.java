package p04Word;

public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface cI = new CommandImpl(text);
        cI.init();
        return cI;
    }

}
