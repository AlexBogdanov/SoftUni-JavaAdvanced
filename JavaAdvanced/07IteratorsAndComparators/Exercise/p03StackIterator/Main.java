package p03StackIterator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import p03StackIterator.Stack.Stack;

public class Main {

    public static void main(String[] args) {

        handleStack();

    }

    private static void handleStack() {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        boolean cycle = true;
        
        while (cycle) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "Push":
                    Integer[] intTokens = handleTokens(tokens);
                    stack.push(intTokens);
                    break;
                case "Pop":
                    stack.pop();
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    
                    for (Integer el : stack) {
                        sb.append(el).append(System.lineSeparator());
                    }

                    sb.append(sb);
                    System.out.println(sb);

                    cycle = false;
            }
        }

        scanner.close();
    }

    private static Integer[] handleTokens(String[] tokens) {
        Integer[] intTokens = new Integer[tokens.length - 1];
        Pattern p = Pattern.compile("\\d+");

        int j = 0;
        for (int i = 1; i < tokens.length; i++) {
            Matcher m = p.matcher(tokens[i]);

            if (m.find()) {
                intTokens[j++] = Integer.parseInt(m.group());
            }
        }

        return intTokens;
    }

}
