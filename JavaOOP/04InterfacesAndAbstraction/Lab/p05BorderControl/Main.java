package p05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import p05BorderControl.domain.Citizen;
import p05BorderControl.domain.Identifiable;
import p05BorderControl.domain.Robot;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Identifiable> rezidents = createRezidents(scanner);
        String invalidIdEnd = scanner.nextLine();
        scanner.close();

        List<Identifiable> filteredRezidents = filterRezidents(rezidents, invalidIdEnd);
        print(filteredRezidents);

    }

    private static void print(List<Identifiable> filteredRezidents) {
        for (Identifiable rezident : filteredRezidents) {
            System.out.println(rezident.getId());
        }
    }

    private static List<Identifiable> filterRezidents(List<Identifiable> rezidents, String invalidIdEnd) {
        Predicate<Identifiable> validateId = r -> r.getId().endsWith(invalidIdEnd);

        return rezidents.stream()
            .filter(r -> validateId.test(r))
            .collect(Collectors.toList());
    }

    private static List<Identifiable> createRezidents(Scanner scanner) {
        var rezidents = new ArrayList<Identifiable>();

        for (String input = scanner.nextLine(); !input.equals("End"); input = scanner.nextLine()) {
            String[] tokens = input.split("\\s+");

            if (tokens.length > 2) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];

                Identifiable citizen = new Citizen(name, age, id);
                rezidents.add(citizen);

                continue;
            }

            String model = tokens[0];
            String id = tokens[1];

            Identifiable robot = new Robot(model, id);
            rezidents.add(robot);
        }

        return rezidents;
    }

}
