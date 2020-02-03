package p07Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import p07Google.classes.Person;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Person> persons = readPersons(scanner);
        Person person = persons.get(scanner.nextLine());

        System.out.println(person.getInfo());

    }

    private static Map<String, Person> readPersons(Scanner scanner) {
        Map<String, Person> persons = new HashMap<>();

        for (String input = scanner.nextLine(); !"End".equals(input); input = scanner.nextLine()) {
            String[] tokens = input.split("\\s+");

            switch (tokens[1]) {
                case "company":
                    handleCompany(persons, tokens);
                    break;
                case "car":
                    handleCar(persons, tokens);
                    break;
                case "pokemon":
                    handlePokemon(persons, tokens);
                    break;
                case "parents":
                    handleParents(persons, tokens);
                    break;
                case "children":
                    handleChildren(persons, tokens);
                    break;
            }
        }

        return persons;
    }

    private static void handleCompany(Map<String, Person> persons, String[] tokens) {
        String name = tokens[0];
        String companyName = tokens[2];
        String departmentName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);

        if (persons.containsKey(name)) {
            Person person = persons.get(name);
            person.updateWork(companyName, departmentName, salary);
            persons.put(name, person);
        } else {
            Person person = new Person(name, companyName, departmentName, salary);
            persons.put(name, person);
        }
    }

    private static void handleCar(Map<String, Person> persons, String[] tokens) {
        String name = tokens[0];
        String model = tokens[2];
        int speed = Integer.parseInt(tokens[3]);

        if (persons.containsKey(name)) {
            Person person = persons.get(name);
            person.updateCar(model, speed);
            persons.put(name, person);
        } else {
            Person person = new Person(name, model, speed);
            persons.put(name, person);
        }
    }

    private static void handlePokemon(Map<String, Person> persons, String[] tokens) {
        String name = tokens[0];
        String type = tokens[1];
        String pokemonName = tokens[2];
        String pokemonEl = tokens[3];

        if (persons.containsKey(name)) {
            Person person = persons.get(name);
            person.addPokemon(pokemonName, pokemonEl);
            persons.put(name, person);
        } else {
            Person person = new Person(name, pokemonName, pokemonEl, type);
            persons.put(name, person);
        }
    }

    private static void handleParents(Map<String, Person> persons, String[] tokens) {
        String name = tokens[0];
        String type = tokens[1];
        String parentName = tokens[2];
        String parentBirth = tokens[3];

        if (persons.containsKey(name)) {
            Person person = persons.get(name);
            person.addParent(parentName, parentBirth);
            persons.put(name, person);
        } else {
            Person person = new Person(name, parentName, parentBirth, type);
            persons.put(name, person);
        }
    }

    private static void handleChildren(Map<String, Person> persons, String[] tokens) {
        String name = tokens[0];
        String type = tokens[1];
        String childName = tokens[2];
        String childBirth = tokens[3];

        if (persons.containsKey(name)) {
            Person person = persons.get(name);
            person.addChild(childName, childBirth);
            persons.put(name, person);
        } else {
            Person person = new Person(name, childName, childBirth, type);
            persons.put(name, person);
        }
    }

}
