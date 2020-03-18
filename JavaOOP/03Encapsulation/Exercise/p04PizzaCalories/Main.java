package p04PizzaCalories;

import java.util.Scanner;

import p04PizzaCalories.domain.Pizza;
import p04PizzaCalories.domain.Ingredient.Dough.Dough;
import p04PizzaCalories.domain.Ingredient.Topping.Topping;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            Pizza pizza = createPizza(scanner);
            Dough dough = createDough(scanner);
            pizza.setDough(dough);
            setPizzaToppings(scanner, pizza);
            scanner.close();

            System.out.println(String.format(
                "%s - %.2f",
                pizza.getName(),
                pizza.getOverallCalories()
            ));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

    }

    private static void setPizzaToppings(Scanner scanner, Pizza pizza) {
        for (String input = scanner.nextLine(); !input.equals("END"); input = scanner.nextLine()) {
            String[] tokens = input.split("\\s+");
            String toppingType = tokens[1];
            double weight = Double.parseDouble(tokens[2]);

            var topping = new Topping(toppingType, weight);
            pizza.addTopping(topping);
        }
    }

    private static Dough createDough(Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\\s+");
        String flourType = tokens[1];
        String bakingTechnique = tokens[2];
        double weight = Double.parseDouble(tokens[3]);
        return new Dough(flourType, bakingTechnique, weight);
    }

    private static Pizza createPizza(Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\\s+");
        String name = tokens[1];
        int numberOfToppings = Integer.parseInt(tokens[2]);
        return new Pizza(name, numberOfToppings);
    }

}
