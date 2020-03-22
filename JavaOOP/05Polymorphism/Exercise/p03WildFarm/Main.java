package p03WildFarm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import p03WildFarm.farm.animals.Cat;
import p03WildFarm.farm.animals.Mammal;
import p03WildFarm.farm.animals.Mouse;
import p03WildFarm.farm.animals.Tiger;
import p03WildFarm.farm.animals.Zebra;
import p03WildFarm.farm.foods.Food;
import p03WildFarm.farm.foods.Meat;
import p03WildFarm.farm.foods.Vegetable;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        List<Mammal> mammals = createMammals(scanner);
        
        scanner.close();

        printMammals(mammals);

    }

    private static void printMammals(List<Mammal> mammals) {
        for (Mammal mammal : mammals) {
            System.out.println(mammal.toString());
        }
    }

    private static List<Mammal> createMammals(Scanner scanner) throws IOException {
        var mammals = new ArrayList<Mammal>();
        
        for (String input = scanner.nextLine(); !input.equals("End"); input = scanner.nextLine()) {
            String[] animalTokens = input.split("\\s+");
            String[] foodTokens = scanner.nextLine().split("\\s+");
            Mammal mammal = createMammal(animalTokens);
            Food food = createFood(foodTokens);

            mammal.makeSound();
            try {
                mammal.eat(food);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            mammals.add(mammal);
        }

        return mammals;
    }

    private static Food createFood(String[] tokens) throws IOException {
        Integer quantity = Integer.parseInt(tokens[1]);
        Food food;

        switch(tokens[0]) {
            case "Vegetable":
                food = new Vegetable(quantity);
                break;
            case "Meat":
                food = new Meat(quantity);
                break;
            default:
                throw new IOException("No such " + tokens[0] + " food type");
        }

        return food;
    }

    private static Mammal createMammal(String[] tokens) throws IOException {
        Mammal mammal;

        switch(tokens[0]) {
            case "Cat":
                mammal = createCat(tokens);
                break;
            default: {
                mammal = createSpecificEatingMammal(tokens);
            }
        }

        return mammal;
    }

    private static Mammal createSpecificEatingMammal(String[] tokens) throws IOException {
        String animalType = tokens[0];
        String animalName = tokens[1];
        double animalWeight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];
        Mammal mammal;

        switch(animalType) {
            case "Mouse":
                mammal = new Mouse(animalName, animalWeight, livingRegion);
                break;
            case "Zebra":
                mammal = new Zebra(animalName, animalWeight, livingRegion);
                break;
            case "Tiger":
                mammal = new Tiger(animalName, animalWeight, livingRegion);
                break;
            default:
                throw new IOException("No such " + animalType + " animal type");
        }

        return mammal;
    }

    private static Mammal createCat(String[] tokens) {
        String animalName = tokens[1];
        double animalWeight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];
        String breed = tokens[4];
        
        return new Cat(animalName, animalWeight, livingRegion, breed);
    }

}
