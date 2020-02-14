package p06StrategyPattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import p06StrategyPattern.Person.AgeComparator;
import p06StrategyPattern.Person.NameComparator;
import p06StrategyPattern.Person.Person;

public class Main {

    public static void main(String[] args) {

        String[] tokens = readInput();
        Set<Person> people = createPeopleTree(tokens);
        
        List<Person> nameSortedPeople = new ArrayList<>();
        nameSortedPeople = people.stream()
            .sorted(new NameComparator())
            .collect(Collectors.toList());
        
        List<Person> ageSortedPeople = new ArrayList<>();
        ageSortedPeople = people.stream()
            .sorted(new AgeComparator())
            .collect(Collectors.toList());

        StringBuilder sb = createOutput(nameSortedPeople, ageSortedPeople);
        System.out.println(sb);

    }

    private static StringBuilder createOutput(List<Person> nameSortedPeople, List<Person> ageSortedPeople) {
        StringBuilder sb = new StringBuilder();

        for (Person person : nameSortedPeople) {
            sb.append(person.toString()).append(System.lineSeparator());
        }

        for (Person person : ageSortedPeople) {
            sb.append(person.toString()).append(System.lineSeparator());
        }

        return sb;
    }

    private static Set<Person> createPeopleTree(String[] tokens) {
        Set<Person> people = new HashSet<>();

        for (String input : tokens) {
            String[] info = input.split("\\s+");
            int age = Integer.parseInt(info[1]);
            Person person = new Person(info[0], age);
            people.add(person);
        }

        return people;
    }

    private static String[] readInput() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] tokens = new String[n];

        for (int i = 0; i < n; i++) {
            tokens[i] = scanner.nextLine();
        }

        scanner.close();
        return tokens;
    }

}
