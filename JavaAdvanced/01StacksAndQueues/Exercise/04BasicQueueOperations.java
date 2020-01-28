import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

class Main {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int numsToOffer = scanner.nextInt();
        int numsToPoll = scanner.nextInt();
        int numToMatch = scanner.nextInt();

        scanner.nextLine();

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numsToOffer; i++) {
            queue.offer(scanner.nextInt());
        }

        for (int i = 0; i < numsToPoll; i++) {
            queue.poll();
        }

        if (queue.size() == 0) {
            System.out.println(0);
            return;
        }

        boolean isPresent = false;
        
        for (Integer integer : queue) {
            if (integer == numToMatch) {
                isPresent = true;
                break;
            }
        }

        if (isPresent) {
            System.out.println(isPresent);
        } else {
            System.out.println(Collections.min(queue));
        }

    }

}
