package p01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<Integer> queueLoot = createQueue(scanner);
        Deque<Integer> stackLoot = createStack(scanner);
        
        scanner.close();

        int claimedItemsSum = handleLoots(queueLoot, stackLoot);
        StringBuilder sb = createOutput(claimedItemsSum, queueLoot, stackLoot);

        System.out.println(sb);

    }

    private static StringBuilder createOutput(int claimedItemsSum, Deque<Integer> queueLoot, Deque<Integer> stackLoot) {
        StringBuilder sb = new StringBuilder();

        if (queueLoot.isEmpty()) {
            sb.append("First lootbox is empty").append(System.lineSeparator());
        } else {
            sb.append("Second lootbox is empty").append(System.lineSeparator());
        }

        if (claimedItemsSum >= 100) {
            sb.append("Your loot was epic! Value: " + claimedItemsSum);
        } else {
            sb.append("Your loot was poor... Value: " + claimedItemsSum);
        }

        return sb;
    }

    private static int handleLoots(Deque<Integer> queueLoot, Deque<Integer> stackLoot) {
        int sum = 0;

        while (!queueLoot.isEmpty() && !stackLoot.isEmpty()) {
            int queueEl = queueLoot.peek();
            int stackEl = stackLoot.peek();
            int currSum = queueEl + stackEl;

            if (currSum % 2 == 0) {
                sum += queueEl + stackEl;
                queueLoot.poll();
                stackLoot.pop();
                continue;
            }

            
            queueLoot.offer(stackLoot.pop());
        }

        return sum;
    }

    private static Deque<Integer> createStack(Scanner scanner) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        Arrays.stream(scanner.nextLine().split("\\s+"))
            .map(Integer::parseInt)
            .forEach(x -> {
                stack.push(x);
            });

        return stack;
    }

    private static Deque<Integer> createQueue(Scanner scanner) {
        Deque<Integer> queue = Arrays
            .stream(scanner.nextLine().split("\\s+"))
            .map(Integer::parseInt)
            .collect(Collectors.toCollection(ArrayDeque::new));
        
        return queue;
    }

}
