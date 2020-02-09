package p04GenericCountMethodStrings;

import java.util.Scanner;

import classes.Box.Box;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Box<String> box = createBox(scanner);
        int count = box.compare(scanner.nextLine());

        System.out.println(count);

    }

    private static Box createBox(Scanner scanner) {
        Box<String> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            box.add(scanner.nextLine());
        }

        return box;
    }

}
