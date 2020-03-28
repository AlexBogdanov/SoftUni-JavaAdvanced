package p02EnterNumbers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        var numberPrinter = new NumberPrinter(scanner);
        printNumbers(numberPrinter);
        scanner.close();

    }

    private static void printNumbers(NumberPrinter numberPrinter) {
        try {
            numberPrinter.print();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            printNumbers(numberPrinter);
        }
    }

}
