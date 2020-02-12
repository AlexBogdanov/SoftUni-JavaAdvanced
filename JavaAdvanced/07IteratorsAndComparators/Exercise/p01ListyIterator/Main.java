package p01ListyIterator;

import java.util.Scanner;

import p01ListyIterator.ListyIterator.ListyIterator;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        handleList(scanner);

    }

    private static void handleList(Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\\s+");
        ListyIterator list = new ListyIterator(tokens);

        for (String input = scanner.nextLine();!input.equals("END"); input = scanner.nextLine()) {
            switch (input) {
                case "Create":
                    continue;
                case "Move":
                    System.out.println(list.move());
                    break;
                case "Print":
                    try {
                        list.print();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(list.hasNext());
                    break;
            }
        }
    }

}
