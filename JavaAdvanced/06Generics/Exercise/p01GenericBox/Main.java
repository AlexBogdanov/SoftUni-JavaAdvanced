package p01GenericBox;

import java.util.Scanner;

import classes.Box.Box;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Box box = createBox(scanner);

        System.out.println(box.toString());

    }

    private static Box createBox(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        try {
            int inputInt = Integer.parseInt(input);
            Box<Integer> box = new Box<>();

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    box.add(inputInt);
                    continue;
                }

                box.add(Integer.parseInt(scanner.nextLine()));
            }

            return box;
        } catch (Exception e) {
            Box<String> box = new Box<>();

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    box.add(input);
                    continue;
                }

                box.add(scanner.nextLine());
            }

            return box;
        }
    }

}
