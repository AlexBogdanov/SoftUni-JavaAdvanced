package p05CustomException;

import p05CustomException.domain.Person;
import p05CustomException.domain.Student;
import p05CustomException.exceptions.InvalidPersonNameException;

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

        new Student("Franco", "Aimee", 19, "franco@aimee.bg");

        try {
            new Student("4avdar", "Aimee", 19, "franco@aimee.bg");
        } catch (InvalidPersonNameException ipne) {
            System.err.println(ipne.getMessage());
        }

    }

}
