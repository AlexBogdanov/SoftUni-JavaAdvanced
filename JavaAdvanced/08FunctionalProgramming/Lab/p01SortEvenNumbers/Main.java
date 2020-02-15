package p01SortEvenNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> evenNums = readInput(new Scanner(System.in));
        List<Integer> sortedNums = sortNums(evenNums);

        System.out.println(createStr(evenNums));
        System.out.println(createStr(sortedNums));

    }

    private static String createStr(List<Integer> nums) {
        return nums.stream()
            .map(Object::toString)
            .collect(Collectors.joining(", "));
    }

    private static List<Integer> sortNums(List<Integer> evenNums) {
        return evenNums.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    private static List<Integer> readInput(Scanner scanner) {
        String[] tokens = scanner.nextLine().split(", ");

        return Arrays.stream(tokens)
            .map(Integer::parseInt)
            .filter(x -> x % 2 == 0)
            .collect(Collectors.toList());
    }

}
