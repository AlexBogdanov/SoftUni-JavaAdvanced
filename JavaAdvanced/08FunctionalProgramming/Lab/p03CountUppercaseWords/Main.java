package p03CountUppercaseWords;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Deque<String> queue = findWords();
        StringBuilder sb = createOutput(queue);
        
        System.out.println(sb);

    }

    private static StringBuilder createOutput(Deque<String> queue) {
        StringBuilder sb = new StringBuilder();

        sb.append(queue.size()).append(System.lineSeparator());
        queue.forEach(w -> { sb.append(w).append(System.lineSeparator()); });

        return sb;
    }

    private static Deque<String> findWords() {
        Scanner scanner = new Scanner(System.in);
        Deque<String> queue = Arrays.stream(scanner.nextLine().split("\\s+"))
            .filter(getPredicate())
            .collect(Collectors.toCollection(ArrayDeque::new));

        scanner.close();
        return queue;
    }

    private static Predicate<String> getPredicate() {
        return w -> {
            char fL = w.charAt(0);

            if (fL >= 65 && fL <= 90) {
                return true;
            }

            return false;
        };
    }

}
