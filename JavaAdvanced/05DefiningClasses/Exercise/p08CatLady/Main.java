package p08CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import p08CatLady.classes.Cat;
import p08CatLady.classes.Cymric;
import p08CatLady.classes.Siamese;
import p08CatLady.classes.StreetExtraordinaire;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Cat> cats = readCats(scanner);
        String catInfo = getCatInfo(cats.get(scanner.nextLine()));

        System.out.println(catInfo);

    }

    private static Map<String, Cat> readCats(Scanner scanner) {
        Map<String, Cat> cats = new HashMap<>();

        for (String input = scanner.nextLine(); !"End".equals(input); input = scanner.nextLine()) {
            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double characteristic = Double.parseDouble(tokens[2]);
            Cat cat;

            switch (breed) {
                case "Cymric":
                    cat = new Cymric(name, characteristic);
                    break;
                case "Siamese":
                    cat = new Siamese(name, characteristic);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, characteristic);
                    break;
                default:
                    cat = new Cat(name, breed);
            }

            cats.put(name, cat);
        }

        return cats;
    }

    private static String getCatInfo(Cat cat) {
        return cat.toString();
    }

}
