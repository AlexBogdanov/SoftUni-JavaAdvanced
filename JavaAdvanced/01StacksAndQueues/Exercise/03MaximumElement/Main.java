import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] tokens = Stream.of(scanner.nextLine().split("\\s+"))
                .mapToInt(num -> Integer.parseInt(num))
                .toArray();

            switch (tokens[0]) {
                case 1:
                    stack.push(tokens[1]);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(stack));
                    break;
            }
        }

    }

}
