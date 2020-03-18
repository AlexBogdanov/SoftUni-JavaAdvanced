package p03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import p03BirthdayCelebrations.domain.Birthable;
import p03BirthdayCelebrations.domain.Citizen;
import p03BirthdayCelebrations.domain.Pet;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<Birthable> birthables = createBirthables(scanner);
        int year = scanner.nextInt();
        scanner.close();

        List<Birthable> filteredBirthables = filterBirthables(year, birthables);
        print(filteredBirthables);

    }

    private static void print(List<Birthable> birthables) {
        for (Birthable birthable : birthables) {
            System.out.println(birthable.getBirthDate());
        }
    }

    private static List<Birthable> filterBirthables(int year, List<Birthable> birthables) {
        return birthables.stream()
            .filter(b -> {
                int birthableYear = getYear(b.getBirthDate());

                if (birthableYear == year) {
                    return true;
                }

                return false;
            }).collect(Collectors.toList());
    }

    private static int getYear(String birthDate) {
        String[] tokens = birthDate.split("/");
        return Integer.parseInt(tokens[2]);
    }

    private static List<Birthable> createBirthables(Scanner scanner) {
        var birthables = new ArrayList<Birthable>();

        for (String input = scanner.nextLine(); !input.equals("End"); input = scanner.nextLine()) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];

            switch(type) {
                case "Citizen":
                    Birthable citizen = createCitizen(tokens);
                    birthables.add(citizen);
                    break;
                case "Pet":
                    Birthable pet = createPet(tokens);
                    birthables.add(pet);
                    break;
            }
        }

        return birthables;
    }

    private static Birthable createPet(String[] tokens) {
        String name = tokens[1];
        String birthDate = tokens[2];

        return new Pet(name, birthDate);
    }

    private static Birthable createCitizen(String[] tokens) {
        String name = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        String id = tokens[3];
        String birthDate = tokens[4];

        return new Citizen(name, age, id, birthDate);
    }

}
