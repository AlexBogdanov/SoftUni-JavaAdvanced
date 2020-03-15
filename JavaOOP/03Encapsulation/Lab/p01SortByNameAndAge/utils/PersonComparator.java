package p01SortByNameAndAge.utils;

import java.util.Comparator;

import p01SortByNameAndAge.domain.Person;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

        if (sComp != 0) {
            return sComp;
        } else { 
            return Integer.compare(firstPerson.getAge(), secondPerson.getAge()); 
        }
    }

}
