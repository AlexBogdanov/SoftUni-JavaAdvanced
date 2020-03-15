package p01SortByNameAndAge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import p01SortByNameAndAge.domain.Person;
import p01SortByNameAndAge.io.Printer;
import p01SortByNameAndAge.io.Reader;
import p01SortByNameAndAge.utils.PersonComparator;
import p01SortByNameAndAge.utils.PersonParser;

public class Main {

    public static void main(String[] args) throws IOException {

        int n = Reader.nextInt();
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            people.add(PersonParser.parseData(Reader.nextLine()));
        }

        Collections.sort(people, new PersonComparator());

        for (Person person : people) {
            Printer.print(person.toString());
        }

    }

}
