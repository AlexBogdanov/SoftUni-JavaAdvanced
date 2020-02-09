package p02GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import classes.Swapper.Swapper;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<String> list = createList(scanner);
        Swapper<String> swapper = swap(list, scanner);

        System.out.println(swapper.toString());
    
    }

    private static List<String> createList(Scanner scanner) {
        List<String> list = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            list.add(scanner.nextLine());
        }

        return list;
    }

    private static Swapper<String> swap(List<String> list, Scanner scanner) {
        Swapper<String> swapper = new Swapper<>(list);
        int[] tokens = Stream.of(scanner.nextLine().split("\\s+"))
            .mapToInt(i -> Integer.parseInt(i))
            .toArray();
        
        swapper.swap(tokens[0], tokens[1]);

        return swapper;
    }

}
