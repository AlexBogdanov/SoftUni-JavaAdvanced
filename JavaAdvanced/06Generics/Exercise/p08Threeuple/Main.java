package p08Threeuple;

import java.util.Scanner;

import classes.Threeuple.Threeuple;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Threeuple[] threeuples = createThreeuples(scanner);
        StringBuilder sb = formOutput(threeuples);

        System.out.println(sb);
    
    }

    private static Threeuple[] createThreeuples(Scanner scanner) {
        Threeuple[] threeuples = new Threeuple[3];

        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    Threeuple<String, String, String> infoThreeuple = createInfo(scanner.nextLine());
                    threeuples[i] = infoThreeuple;
                    break;
                case 1:
                    Threeuple<String, Integer, Boolean> problemsThreeuple = createProblems(scanner.nextLine());
                    threeuples[i] = problemsThreeuple;
                    break;
                case 2:
                    Threeuple<String, Double, String> bankAccountThreeuple = createBankBalance(scanner.nextLine());
                    threeuples[i] = bankAccountThreeuple;
                    break;
            }
        }

        return threeuples;
    }

    private static Threeuple<String, String, String> createInfo(String input) {
        String[] tokens = input.split("\\s+");
        String name = tokens[0] + " " + tokens[1];
        return new Threeuple<String,String,String>(name, tokens[2], tokens[3]);
    }

    private static Threeuple<String, Integer, Boolean> createProblems(String input) {
        String[] tokens = input.split("\\s+");
        int liters = Integer.parseInt(tokens[1]);
        boolean isDrunk = true;

        if (tokens[2].equals("not")) {
            isDrunk = false;
        }

        return new Threeuple<String,Integer,Boolean>(tokens[0], liters, isDrunk);
    }

    private static Threeuple<String, Double, String> createBankBalance(String input) {
        String[] tokens = input.split("\\s+");
        Double balance = Double.parseDouble(tokens[1]);
        return new Threeuple<String,Double,String>(tokens[0], balance, tokens[2]);
    }

    private static StringBuilder formOutput(Threeuple[] threeuples) {
        StringBuilder sb = new StringBuilder();

        for (Threeuple threeuple : threeuples) {
            sb.append(threeuple.toString()).append(System.lineSeparator());
        }

        return sb;
    }

}
