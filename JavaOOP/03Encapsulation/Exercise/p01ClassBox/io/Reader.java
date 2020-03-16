package p01ClassBox.io;

import java.util.Scanner;

public class Reader {

    private static Scanner SCANNER = new Scanner(System.in);

    public static double nextDouble() {
        return Double.parseDouble(SCANNER.nextLine());
    }

}
