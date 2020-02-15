package p04AddVAT;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Deque<Double> pricesWithVAT = calculatePrices();
        printPrices(pricesWithVAT);

    }

    private static void printPrices(Deque<Double> pricesWithVAT) {
        StringBuilder sb = new StringBuilder();

        sb.append("Prices with VAT:").append(System.lineSeparator());

        pricesWithVAT.forEach(p -> {
            sb.append(String.format("%.2f", p)).append(System.lineSeparator());
        });

        System.out.println(sb);
    }

    private static Deque<Double> calculatePrices() {
        Scanner scanner = new Scanner(System.in);
        Deque<Double> pricesWithVAT = Arrays.stream(scanner.nextLine().split(", "))
            .map(Double::parseDouble)
            .map(getOperand())
            .collect(Collectors.toCollection(ArrayDeque<Double>::new));

        scanner.close();
        return pricesWithVAT;
    }

    private static UnaryOperator<Double> getOperand() {
        return x -> x * 1.2;
    }

}
