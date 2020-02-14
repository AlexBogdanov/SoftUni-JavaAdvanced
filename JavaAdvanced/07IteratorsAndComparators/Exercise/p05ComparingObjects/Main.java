package p05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import p05ComparingObjects.Person.Person;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> people = createPeople(scanner);
        System.out.println(collectInfo(scanner, people));

    }

    private static List<Person> createPeople(Scanner scanner) {
        List<Person> people = new ArrayList<>();

        for (String input = scanner.nextLine();!input.equals("END"); input = scanner.nextLine()) {
            String[] tokens = input.split("\\s+");
            int age = Integer.parseInt(tokens[1]);
            people.add(new Person(tokens[0], age, tokens[2]));
        }

        return people;
    }

    private static String collectInfo(Scanner scanner, List<Person> people) {
        int index = scanner.nextInt() - 1;

        Person person = people.remove(index);
        int equal = 0;
        int notEqual = 0;

        for (Person p : people) {
            int res = person.compareTo(p);

            if (res == 0) {
                equal++;
            } else {
                notEqual++;
            }
        }

        if (equal == 0) {
            return "No matches";
        }

        equal++;
        int peopleCount = people.size() + 1;
        return equal + " " + notEqual + " " + peopleCount;
    }

}
