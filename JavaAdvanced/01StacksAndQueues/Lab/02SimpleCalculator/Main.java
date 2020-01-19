import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = readInput(scanner);
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);

        while(stack.size() > 1) {
            int a = Integer.valueOf(stack.pop());
            String op = stack.pop();
            int b = Integer.valueOf(stack.pop());

            if ("+".equals(op)) {
                int c = a + b;
                stack.push(String.valueOf(c));
            } else if ("-".equals(op)) {
                int c = a - b;
                stack.push(String.valueOf(c));
            }
        }

        print(stack.pop());

    }

    public static String[] readInput(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    public static void print(String output) {
        System.out.println(output);
    }

}
