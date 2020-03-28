package p04ValidPerson;

import p04ValidPerson.domain.Person;

public class Main {

    public static void main(String[] args) {

        new Person("Franco", "Aimee", 19);

        try {
            new Person("   ", "Aimee", 19);
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }

        try {
            new Person("Franco", null, 19);
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }

        try {
            new Person("Franco", "Aimee", -1);
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }

        try {
            new Person("Franco", "Aimee", 121);
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }

    }

}
