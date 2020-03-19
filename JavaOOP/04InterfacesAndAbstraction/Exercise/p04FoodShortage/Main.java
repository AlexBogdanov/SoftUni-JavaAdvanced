package p04FoodShortage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import p04FoodShortage.domain.Buyer;
import p04FoodShortage.domain.Citizen;
import p04FoodShortage.domain.Rebel;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Buyer> buyers = readBuyers(scanner);
        buyFood(scanner, buyers);
        scanner.close();

        print(buyers);

    }

    private static void print(Map<String, Buyer> buyers) {
        int totalFood = 0;

        for (String key : buyers.keySet()) {
            Buyer buyer = buyers.get(key);
            totalFood += buyer.getFood();
        }

        System.out.println(totalFood);
    }

    private static void buyFood(Scanner scanner, Map<String, Buyer> buyers) {
        for (String name = scanner.nextLine(); !name.equals("End"); name = scanner.nextLine()) {
            if (!buyers.containsKey(name)) {
                continue;
            }

            Buyer buyer = buyers.get(name);
            buyer.buyFood();
        }
    }

    private static Map<String, Buyer> readBuyers(Scanner scanner) {
        var buyers = new LinkedHashMap<String, Buyer>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens.length) {
                case 3:
                    Buyer rebel = createRebel(tokens);
                    buyers.put(tokens[0], rebel);
                    break;
                case 4:
                    Buyer citizen = createCitizen(tokens);
                    buyers.put(tokens[0], citizen);
                    break;
            }
        }

        return buyers;
    }

    private static Buyer createCitizen(String[] tokens) {
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String id = tokens[2];
        String birthDate = tokens[3];

        return new Citizen(name, age, id, birthDate);
    }

    private static Buyer createRebel(String[] tokens) {
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String group = tokens[2];

        return new Rebel(name, age, group);
    }

}
