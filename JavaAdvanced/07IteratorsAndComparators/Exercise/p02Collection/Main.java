package p02Collection;

import java.util.Scanner;

import p02Collection.ListyIterator.ListyIterator;

public class Main {

    public static void main(String[] args) {

        handleList();

    }

    private static void handleList() {
        Scanner scanner = new Scanner(System.in);
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
                case "PrintAll":
                    try {
                        list.printAll();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        scanner.close();
    }

}
