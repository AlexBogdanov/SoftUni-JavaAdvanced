package p02SalaryIncrease;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import p02SalaryIncrease.domain.Person;
import p02SalaryIncrease.io.Printer;
import p02SalaryIncrease.io.Reader;
import p02SalaryIncrease.utils.PersonParser;

public class Main {

    public static void main(String[] args) throws IOException {

        int n = Reader.nextInt();
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            people.add(PersonParser.parseData(Reader.nextLine()));
        }

        double bonus = Reader.nextDouble();
        for (Person person : people) {
            person.increaseSalary(bonus);
            Printer.print(person.toString());
        }

    }

}
