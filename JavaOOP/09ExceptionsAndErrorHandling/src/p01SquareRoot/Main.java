package p01SquareRoot;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            double sqrt = Calculator.calcSquareRoot(scanner.nextLine());
            System.out.println(sqrt);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } finally {
            scanner.close();
            System.out.println("Good bye");
        }

    }

}
