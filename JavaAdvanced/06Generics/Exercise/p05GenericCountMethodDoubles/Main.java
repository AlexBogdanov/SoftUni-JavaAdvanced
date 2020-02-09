package p05GenericCountMethodDoubles;

import java.util.Scanner;

import classes.Box.Box;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Box<Double> box = createBox(scanner);
        int count = box.compare(Double.parseDouble(scanner.nextLine()));

        System.out.println(count);
    
    }

    private static Box<Double> createBox(Scanner scanner) {
        Box<Double> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            box.add(Double.parseDouble(scanner.nextLine()));
        }

        return box;
    }

}
