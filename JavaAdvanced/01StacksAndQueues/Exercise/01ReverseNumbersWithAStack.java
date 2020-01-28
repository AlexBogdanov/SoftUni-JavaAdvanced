import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int[] input = Stream.of(scanner.nextLine().split("\\s+"))
            .mapToInt(n -> Integer.parseInt(n))
            .toArray();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : input) {
            stack.push(num);
        }

        while (stack.size() > 0) {
            if (stack.size() == 1) {
                System.out.print(stack.pop());
                continue;
            }

            System.out.print(stack.pop() + " ");
        }

    }

}
