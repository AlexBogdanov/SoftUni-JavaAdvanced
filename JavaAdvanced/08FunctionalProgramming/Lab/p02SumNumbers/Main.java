package p02SumNumbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String res = calculateSum();
        System.out.println(res);

    }

    private static String calculateSum() {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(", ");

        int sum = Arrays.stream(tokens)
            .mapToInt(Integer::parseInt)
            .sum();
        int totalCount = tokens.length;

        scanner.close();
        return String.format(
            "Count = %d%nSum = %d",
            totalCount, sum
        );
    }

}
