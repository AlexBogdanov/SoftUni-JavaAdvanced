package p06StrategyPattern.Person;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int p1NameLength = p1.getName().length();
        int p2NameLength = p2.getName().length();

        if (p1NameLength > p2NameLength) { return 1; }

        if (p1NameLength < p2NameLength) { return -1; }

        char p1FL = p1.getName().toLowerCase().charAt(0);
        char p2FL = p2.getName().toLowerCase().charAt(0);

        if (p1FL > p2FL) { return 1; }

        if (p1FL < p2FL) { return -1; }

        return 0;
    }

}
