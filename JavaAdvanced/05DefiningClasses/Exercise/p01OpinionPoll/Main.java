package p01OpinionPoll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Person[] persons = createPersons(scanner);
        scanner.close();
        List<Person> sortedPersons = sortPersons(persons);
        StringBuilder sb = formOutput(sortedPersons);

        System.out.println(sb);

    }

    private static Person[] createPersons(Scanner scanner) {
        int numOfPersons = Integer.parseInt(scanner.nextLine());
        Person[] persons = new Person[numOfPersons];

        for (int i = 0; i < numOfPersons; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person();
            person.name = name;
            person.age = age;

            persons[i] = person;
        }

        return persons;
    }

    private static List<Person> sortPersons(Person[] persons) {
        List<Person> personsList = new ArrayList<>(Arrays.asList(persons));

        List<Person> sortedPersons = personsList.stream()
            .filter(p -> p.age > 30)
            .sorted((p1, p2) -> p1.name.compareTo(p2.name))
            .collect(Collectors.toList());

        return sortedPersons;
    }

    private static StringBuilder formOutput(List<Person> sortedPersons) {
        StringBuilder sb = new StringBuilder();

        for (Person person : sortedPersons) {
            sb.append(person.name + " - " + person.age);
            sb.append(System.lineSeparator());
        }

        return sb;
    }

}
