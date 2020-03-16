package p03ShoppingSpree;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final String Map = null;

    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        var people = new HashMap<String, Person>();
        var products = new HashMap<String, Product>();
        var counter = 0;

        for (String input = scanner.nextLine(); !input.equals("END"); input = scanner.nextLine()) {
            counter++;
            handleInput(input, people, products, counter);
        }

        scanner.close();

        print(people);

    }

    private static void print(HashMap<String, Person> people) {
        StringBuilder sb = new StringBuilder();

        for (String key : people.keySet()) {
            Person person = people.get(key);

            if (person.getBagOfProducts().size() < 1) {
                sb.append(key + " - Nothing bought").append(System.lineSeparator());
                continue;
            }
            
            sb.append(key + " - " + person.getListedProducts()).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static void handleInput(String input, HashMap<String, Person> people, HashMap<String, Product> products,
            int counter) {
        if (counter < 3) {
            if (counter == 1) {
                handlePeople(input, people);
                return;
            }

            handleProducts(input, products);
            return;
        }

        handleBuying(input, people, products);
    }

    private static void handleBuying(String input, HashMap<String, Person> people, HashMap<String, Product> products) {
        String[] tokens = input.split("\\s+");
        String personName = tokens[0];
        String prodName = tokens[1];

        Person person = people.get(personName);
        Product product = products.get(prodName);

        person.buyProduct(product);
        people.put(personName, person);
    }

    private static void handleProducts(String input, HashMap<String, Product> products) {
        String[] split = input.split(";");

        for (int i = 0; i < split.length; i++) {
            String[] tokens = split[i].split("=")  ;
            String name = tokens[0];

            if (products.containsKey(name)) {
                continue;
            }

            double cost = Double.parseDouble(tokens[1]);

            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private static void handlePeople(String input, HashMap<String, Person> people) {
        String[] split = input.split(";");

        for (int i = 0; i < split.length; i++) {
            String[] tokens = split[i].split("=");
            String name = tokens[0];

            if (people.containsKey(name)) {
                continue;
            }

            double money = Double.parseDouble(tokens[1]);

            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

}
