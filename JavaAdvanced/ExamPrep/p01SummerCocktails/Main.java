package p01SummerCocktails;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> ingredientsQueue = createQueue(scanner);
        Deque<Integer> freshnessStack = createStack(scanner);

        scanner.close();

        Map<String, Integer> cocktails = createCocktails(ingredientsQueue, freshnessStack);
        boolean isTaskSuccessfull = evaluateCocktails(cocktails);
        StringBuilder sb = createOutput(isTaskSuccessfull, ingredientsQueue, cocktails);

        System.out.println(sb);

    }

    private static StringBuilder createOutput(boolean isTaskSuccessfull, Deque<Integer> ingredientsQueue, Map<String, Integer> cocktails) {
        StringBuilder sb = new StringBuilder();

        if (isTaskSuccessfull) {
            sb.append("It's party time! The cocktails are ready!");
        } else {
            sb.append("What a pity! You didn't manage to prepare all cocktails.");
        }

        sb.append(System.lineSeparator());

        if (ingredientsQueue.size() > 0) {
            int sum = ingredientsQueue
                .stream()
                .mapToInt(Integer::valueOf)
                .sum();

            sb.append("Ingredients left: " + sum).append(System.lineSeparator());
        }
        
        cocktails.entrySet()
            .stream()
            .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
            .forEach(e -> {
                sb.append(String.format(
                    "# %s --> %d",
                    e.getKey(), e.getValue()
                )).append(System.lineSeparator());
            });

        return sb;
    }

    private static boolean evaluateCocktails(Map<String, Integer> cocktails) {
        return cocktails.size() >= 4;
    }

    private static Map<String, Integer> createCocktails(Deque<Integer> ingredientsQueue, Deque<Integer> freshnessStack) {
        var cocktails = new LinkedHashMap<String, Integer>();

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int ingredient = ingredientsQueue.peek();
            int freshness = freshnessStack.peek();
    
            if (ingredient == 0) {
                ingredientsQueue.poll();
                continue;
            }

            int value = ingredient * freshness;

            switch (value) {
                case 150:
                    mixCocktail(cocktails, "Mimosa");
                    clearCollections(ingredientsQueue, freshnessStack);
                    break;
                case 250:
                    mixCocktail(cocktails, "Daiquiri");
                    clearCollections(ingredientsQueue, freshnessStack);
                    break;
                case 300:
                    mixCocktail(cocktails, "Sunshine");
                    clearCollections(ingredientsQueue, freshnessStack);
                    break;
                case 400:
                    mixCocktail(cocktails, "Mojito");
                    clearCollections(ingredientsQueue, freshnessStack);
                    break;
                default:
                    noCocktailHandler(ingredientsQueue, freshnessStack);
            }
        }

        return cocktails;
    }

    private static void noCocktailHandler(Deque<Integer> ingredientsQueue, Deque<Integer> freshnessStack) {
        freshnessStack.pop();
        int ingredient = ingredientsQueue.poll();
        ingredientsQueue.offer(ingredient + 5);
    }

    private static void clearCollections(Deque<Integer> ingredientsQueue, Deque<Integer> freshnessStack) {
        ingredientsQueue.poll();
        freshnessStack.pop();
    }

    private static void mixCocktail(LinkedHashMap<String, Integer> cocktails, String cocktailName) {
        if (cocktails.containsKey(cocktailName)) {
            int oldVal = cocktails.get(cocktailName);
            cocktails.put(cocktailName, oldVal + 1);
            return;
        }

        cocktails.put(cocktailName, 1);
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
