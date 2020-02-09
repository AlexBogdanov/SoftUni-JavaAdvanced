package p03GenericSwapMethodIntegers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import classes.Swapper.Swapper;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = createList(scanner);
        Swapper<Integer> swapper = swap(list, scanner);

        System.out.println(swapper.toString());
    
    }

    private static List<Integer> createList(Scanner scanner) {
        List<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }

        return list;
    }

    private static Swapper<Integer> swap(List<Integer> list, Scanner scanner) {
        Swapper<Integer> swapper = new Swapper<>(list);
        int[] tokens = Stream.of(scanner.nextLine().split("\\s+"))
            .mapToInt(i -> Integer.parseInt(i))
            .toArray();
        
        swapper.swap(tokens[0], tokens[1]);

        return swapper;
    }

}
