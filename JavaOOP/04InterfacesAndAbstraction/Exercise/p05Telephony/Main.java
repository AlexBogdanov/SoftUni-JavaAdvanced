package p05Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import p05Telephony.domain.Smartphone;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> numbers = createList(scanner);
        List<String> urls = createList(scanner);
        scanner.close();

        Smartphone smartphone = new Smartphone(numbers, urls);
        print(smartphone);

    }

    private static void print(Smartphone smartphone) {
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }

    private static List<String> createList(Scanner scanner) {
        String[] data = scanner.nextLine().split("\\s+");
        return Arrays.asList(data);
    }

}
