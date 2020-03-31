package com.github.AlexBogdanov.p02ExtendedDatabase_tests;

import com.github.AlexBogdanov.p02_ExtendedDatabase.Person;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersonTests {

    @Test
    public void valid_person_should_be_created_with_valid_data() {
        // GIVEN
        int id = 1;
        String name = "Name";

        // WHEN
        var person = new Person(id, name);

        // THEN
        assertEquals(Person.class, person.getClass());
    }

    @Test
    public void getId_should_return_int_id() {
        // GIVEN
        var person = new Person(1, "Name");

        // WHEN
        int id = person.getId();

        // THEN
        assertEquals(1, id);
    }

    @Test
    public void getUsername_should_return_String_name() {
        // GIVEN
        var person = new Person(1, "Name");

        // WHEN
        String name = person.getUsername();

        // THEN
        assertEquals("Name", name);
    }

}
