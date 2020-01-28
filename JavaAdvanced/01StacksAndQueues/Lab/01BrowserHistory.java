import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        
        while (true) {
            String command = readInput(scanner);
            String output = "";

            switch(command) {
                case "Home":
                    return;
                case "back":
                    if (history.size() <= 1) {
                        output = "no previous URLs";
                    } else {
                        history.pop();
                        output = history.peek();
                    }
                    break;
                default:
                    history.push(command);
                    output = command;
            }

            print(output);
        }
        
    }

    public static String readInput(Scanner scanner) {
        return scanner.nextLine();
    }

    public static void print(String output) {
        System.out.println(output);
    }

}
