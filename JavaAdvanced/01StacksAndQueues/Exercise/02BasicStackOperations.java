import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

class Main {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int numToPush = scanner.nextInt();
        int numToPop = scanner.nextInt();
        int numToMatch = scanner.nextInt();

        scanner.nextLine();

        Deque<Integer> stack = new ArrayDeque<>();
        boolean isPresent = false;

        for (int i = 0; i < numToPush - numToPop; i++) {
            stack.push(scanner.nextInt());

            if (stack.peek() == numToMatch) {
                isPresent = true;
                break;
            }
        }

        if (stack.size() == 0) {
            System.out.println(0);
            return;
        }

        if (isPresent) {
            System.out.println(isPresent);
            return;
        }

        System.out.println(Collections.min(stack));
    }

}
