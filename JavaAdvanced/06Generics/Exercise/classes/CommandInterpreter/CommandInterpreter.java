package classes.CommandInterpreter;

import java.util.Scanner;

import classes.CustomList.CustomList;
import classes.Sorter.Sorter;

public class CommandInterpreter {

    private CustomList<String> list;

    public CommandInterpreter() {
        this.list = new CustomList<>();
    }

    public void readCommands() {
        Scanner scanner = new Scanner(System.in);
        
        for (String command = scanner.nextLine(); !"END".equals(command); command = scanner.nextLine()) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Add":
                    add(tokens);
                    break;
                case "Remove":
                    remove(tokens);
                    break;
                case "Contains":
                    contains(tokens);
                    break;
                case "Swap":
                    swap(tokens);
                    break;
                case "Greater":
                    greater(tokens);
                    break;
                case "Max":
                    max();
                    break;
                case "Min":
                    min();
                    break;
                case "Print":
                    print();
                    break;
            }
        }
    }

    private void add(String[] tokens) {
        this.list.add(tokens[1]);
    }

    private void remove(String[] tokens) {
        int index = Integer.parseInt(tokens[1]);
        this.list.remove(index);
    }

    private void contains(String[] tokens) {
        System.out.println(this.list.contains(tokens[1]));
    }

    private void swap(String[] tokens) {
        int index1 = Integer.parseInt(tokens[1]);
        int index2 = Integer.parseInt(tokens[2]);
        this.list.swap(index1, index2);
    }

    private void greater(String[] tokens) {
        System.out.println(this.list.countGreaterThan(tokens[1]));
    }

    private void max() {
        System.out.println(this.list.getMax());
    }

    private void min() {
        System.out.println(this.list.getMin());
    }

    private void print() {
        this.list = Sorter.sort(this.list);
        System.out.println(this.list.toString());
    }

}
