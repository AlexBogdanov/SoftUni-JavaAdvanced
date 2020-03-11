package p01RhombusOfStars;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        StringBuilder sb = createRhombus(n);

        System.out.println(sb.toString());

    }

    private static StringBuilder createRhombus(int n) {
        StringBuilder sb = new StringBuilder();

        if (n > 1) {
            sb.append(formRhombus(n, true));
            sb.append(formRhombus(n, false));
            return sb;
        }

        sb.append("*");
        return sb;
    }

    private static String formRhombus(int n, boolean isFirstHalf) {
        StringBuilder sb = new StringBuilder();
        
        if (isFirstHalf) {
            for (int row = 1; row <= n; row++) {
                sb.append(addWhiteSpaces(row, n));
                sb.append(addStars(row));
                sb.append(System.lineSeparator());
            }

            return sb.toString();
        }

        for (int row = n - 1; row >= 0; row--) {
            sb.append(addWhiteSpaces(row, n));
            sb.append(addStars(row));
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private static String addWhiteSpaces(int i, int n) {
        StringBuilder sb = new StringBuilder();

        for (int col = 1; col <= n - i; col++) {
            sb.append(" ");
        }

        return sb.toString();
    }

    private static String addStars(int i) {
        StringBuilder sb = new StringBuilder();

        for (int col = 1; col <= i; col++) {
            sb.append("* ");
        }

        return sb.toString();
    }

}
