package p03ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import p03ShoppingSpree.domain.Person;
import p03ShoppingSpree.domain.Product;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            Map<String, Person> people = readPeople(scanner);
            Map<String, Product> products = readProducts(scanner);
    
            buyProducts(scanner, people, products);
            scanner.close();
    
            print(people, products);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

    }

    private static void print(Map<String, Person> people, Map<String, Product> products) {
        StringBuilder sb = new StringBuilder();

        for (String name : people.keySet()) {
            Person person = people.get(name);
            sb.append(person.getName() + " - ");

            if (person.getProducts().size() > 0) {
                String prefix = "";

                for (Product product : person.getProducts()) {
                    sb.append(prefix);
                    prefix = ", ";
                    sb.append(product.getName());
                }
            } else {
                sb.append("Nothing bought");
            }

            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static void buyProducts(Scanner scanner, Map<String, Person> people, Map<String, Product> products) {
        for (String input = scanner.nextLine(); !input.equals("END"); input = scanner.nextLine()) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String prodName = tokens[1];

            if (!people.containsKey(personName) || !products.containsKey(prodName)) {
                continue;
            }

            Person person = people.get(personName);
            person.buyProduct(products.get(prodName));
        }
    }

    private static Map<String, Product> readProducts(Scanner scanner) {
        var products = new LinkedHashMap<String, Product>();
        String[] split = scanner.nextLine().split(";");

        for (int i = 0; i < split.length; i++) {
            String[] tokens = split[i].split("=");
            String name = tokens[0];

            if (products.containsKey(name)) {
                continue;
            }

            double cost = Double.parseDouble(tokens[1]);
            Product product = new Product(name, cost);
            products.put(name, product);
        }

        return products;
    }

    private static Map<String, Person> readPeople(Scanner scanner) {
        var people = new LinkedHashMap<String, Person>();
        String[] split = scanner.nextLine().split(";");

        for (int i = 0; i < split.length; i++) {
            String[] tokens = split[i].split("=");
            String name = tokens[0];

            if (people.containsKey(name)) {
                continue;
            }

            double money = Double.parseDouble(tokens[1]);
            Person person = new Person(name, money);
            people.put(name, person);
        }

        return people;
    }

}
