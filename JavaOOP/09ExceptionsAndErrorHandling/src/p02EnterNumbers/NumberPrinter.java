package p02EnterNumbers;

import java.util.Scanner;

public class NumberPrinter {

    private Scanner scanner;

    public NumberPrinter(Scanner scanner) {
        this.scanner = scanner;
    }

    public void print() {
        int i;
        int n;

        try {
            i = Integer.parseInt(this.scanner.nextLine());
            n = Integer.parseInt(this.scanner.nextLine());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid number");
        }

        if (i < 1 || i > n || n > 100) {
            throw new IllegalArgumentException("Invalid number");
        }

        StringBuilder sb = new StringBuilder();

        for (int j = i; j < n; j++) {
            sb.append(j + " ");
        }

        System.out.println(sb);

    }

}
