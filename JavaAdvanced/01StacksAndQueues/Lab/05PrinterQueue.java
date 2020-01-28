import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!input.equals("print")) {
            if ("cancel".equals(input)) {
                if (queue.size() > 0) {
                    System.out.println("Canceled " + queue.pop());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                queue.offer(input);
            }

            input = scanner.nextLine();
        }

        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }

    }

}
