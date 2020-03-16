package p01ClassBox.io;

import java.io.PrintStream;

public class Printer {

    private static PrintStream PRINTER = System.out;

    public static void print(String msg) {
        PRINTER.println(msg);
    }

}
