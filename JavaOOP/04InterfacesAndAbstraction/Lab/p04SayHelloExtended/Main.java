package p04SayHelloExtended;

import java.util.ArrayList;
import java.util.List;

import p04SayHelloExtended.domain.BasePerson;
import p04SayHelloExtended.domain.Bulgarian;
import p04SayHelloExtended.domain.Chinese;
import p04SayHelloExtended.domain.European;
import p04SayHelloExtended.domain.Person;

public class Main {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
    
        persons.add(new Bulgarian("Pesho"));
        persons.add(new European("Pesho"));
        persons.add(new Chinese("Pesho"));

        for (Person person : persons) {
            print(person);
        }

    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }

}
