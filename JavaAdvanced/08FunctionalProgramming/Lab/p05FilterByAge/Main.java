package p05FilterByAge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

import p05FilterByAge.Person.Person;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<Person> people = readInput(scanner);
        Deque<Person> filteredPeople = filterPairs(scanner, people);
        StringBuilder sb = createOutput(filteredPeople, scanner);

        scanner.close();
        System.out.println(sb);
        
    }

    private static StringBuilder createOutput(Deque<Person> filteredPeople, Scanner scanner) {
        StringBuilder sb = new StringBuilder();
        String[] tokens = scanner.nextLine().split("\\s+");
        
        if (tokens.length == 1) {
            String printCondition = tokens[0];

            for (Person person : filteredPeople) {
                sb.append(person.getPrintCondition(printCondition)).append(System.lineSeparator());
            }

            return sb;
        }

        for (Person person : filteredPeople) {
            sb.append(person.getName() + " - " + person.getAge()).append(System.lineSeparator());
        }

        return sb;
    }

    private static Deque<Person> filterPairs(Scanner scanner, Deque<Person> people) {
        String condition = scanner.nextLine();
        var conditionAge = Integer.parseInt(scanner.nextLine());        

        Deque<Person> filteredPeople = people.stream()
            .filter(p -> {
                if (condition.equals("younger")) {
                    if (p.getAge() <= conditionAge) { return true; }
                    return false;
                }

                if (condition.equals("older")) {
                    if (p.getAge() >= conditionAge) { return true; }
                    return false;
                }

                return true;
            }).collect(Collectors.toCollection(ArrayDeque::new));

        return filteredPeople;
    }
    
    private static Deque<Person> readInput(Scanner scanner) {
        var n = Integer.parseInt(scanner.nextLine());
        var people = new ArrayDeque<Person>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            var age = Integer.parseInt(tokens[1]);
            var person = new Person(tokens[0], age);
            people.offer(person);
        }

        return people;
    }

}
