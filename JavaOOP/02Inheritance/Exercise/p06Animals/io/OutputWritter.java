package p06Animals.io;

import java.io.PrintStream;

public class OutputWritter {

    private PrintStream out;

    public OutputWritter(PrintStream out) {
        this.out = out;
    }

    public void print(String msg) {
        out.println(msg);
    }

}
