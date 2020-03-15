package p03Validtion.utils;

import p03Validtion.domain.Person;

public class PersonParser {
    
    public static Person parseData(String input) {
        String[] tokens = input.split("\\s+");
        String firstName = tokens[0];
        String lastName = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        double salary = Double.parseDouble(tokens[3]);

        return new Person(firstName, lastName, age, salary);
    }

}
