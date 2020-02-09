package p07Tuple;

import java.util.Scanner;

import classes.Tuple.Tuple;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Tuple[] tuples = createTuples(scanner);
        StringBuilder sb = createOutput(tuples);

        System.out.println(sb);

    }

    private static Tuple[] createTuples(Scanner scanner) {
        Tuple[] tuples = new Tuple[3];

        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    Tuple<String, String> tupleInfo = createPersonInfo(scanner.nextLine());
                    tuples[i] = tupleInfo;
                    break;
                case 1:
                    Tuple<String, Integer> tupleProblems = createPersonProblems(scanner.nextLine());
                    tuples[i] = tupleProblems;
                    break;
                case 2:
                    Tuple<Integer, Double> tupleNums = createNums(scanner.nextLine());
                    tuples[i] = tupleNums;
                    break;
            }
        }

        return tuples;
    }
    
    private static Tuple<String, String> createPersonInfo(String input) {
        String[] tokens = input.split("\\s+");
        String name = tokens[0] + " " + tokens[1];
        String address = tokens[2];

        return new Tuple<String, String>(name, address);
    }

    private static Tuple<String, Integer> createPersonProblems(String input) {
        String[] tokens = input.split("\\s+");
        int liters = Integer.parseInt(tokens[1]);

        return new Tuple<String, Integer>(tokens[0], liters);
    }

    private static Tuple<Integer, Double> createNums(String input) {
        String[] tokens = input.split("\\s+");
        int intNum = Integer.parseInt(tokens[0]);
        double doubleNum = Double.parseDouble(tokens[1]);

        return new Tuple<Integer, Double>(intNum, doubleNum);
    }

    private static StringBuilder createOutput(Tuple[] tuples) {
        StringBuilder sb = new StringBuilder();

        for (Tuple tuple : tuples) {
            sb.append(tuple.toString()).append(System.lineSeparator());
        }

        return sb;
    }

}
