package p03Validtion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import p03Validtion.domain.Person;
import p03Validtion.io.Printer;
import p03Validtion.io.Reader;
import p03Validtion.utils.PersonParser;

public class Main {

    public static void main(String[] args) throws IOException {

        int n = Reader.nextInt();
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            try {
                Person person = PersonParser.parseData(Reader.nextLine());
                people.add(person);
            } catch (IllegalArgumentException iae) {
                Printer.print(iae.getMessage());
            }
        }

        double bonus = Reader.nextDouble();
        for (Person person : people) {
            person.increaseSalary(bonus);
            Printer.print(person.toString());
        }

    }

}
