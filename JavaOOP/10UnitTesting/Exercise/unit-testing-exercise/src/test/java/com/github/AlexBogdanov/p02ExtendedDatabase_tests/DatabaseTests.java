package com.github.AlexBogdanov.p02ExtendedDatabase_tests;

import com.github.AlexBogdanov.p02_ExtendedDatabase.Database;
import com.github.AlexBogdanov.p02_ExtendedDatabase.Person;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

import org.junit.Test;
import org.mockito.Mockito;

public class DatabaseTests {

    // ctor() and setElements()
    @Test
    public void database_should_be_create_with_minimum_of_1_element() throws OperationNotSupportedException {
        // GIVEN
        var personMock = Mockito.mock(Person.class);
        Person[] people = { personMock };

        // THEN
        var db = new Database(people);

        // WHEN
        assertEquals(Database.class, db.getClass());
    }

    @Test
    public void database_should_be_create_with_maximum_of_16_element() throws OperationNotSupportedException {
        // GIVEN
        var personMock = Mockito.mock(Person.class);
        Person[] people = {
            personMock, personMock, personMock, personMock,
            personMock, personMock, personMock, personMock,
            personMock, personMock, personMock, personMock,
            personMock, personMock, personMock, personMock
        };

        // THEN
        var db = new Database(people);

        // WHEN
        assertEquals(Database.class, db.getClass());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void database_should_throw_onse_when_created_with_empty_arr() throws OperationNotSupportedException {
        // GIVEN
        Person[] people = new Person[0];

        // WHEN / THEN OperationNotSupportedException should be thrown
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void database_should_throw_onse_when_created_with_arr_with_more_than_16_el() throws OperationNotSupportedException {
        // GIVEN
        var personMock = Mockito.mock(Person.class);
        Person[] people = {
            personMock, personMock, personMock, personMock,
            personMock, personMock, personMock, personMock,
            personMock, personMock, personMock, personMock,
            personMock, personMock, personMock, personMock,
            personMock
        };

        // WHEN / THEN OperationNotSupportedException should be thrown
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databse_should_throw_onse_when_person_with_negative_id_is_passed() throws OperationNotSupportedException {
        // GIVEN
        var person = new Person(-1, "Name");

        // WHEN / THEN OperationNotSupportedException should be thrown
        new Database(person);
    }

    // getElements()
    @Test
    public void getElements_should_return_elements_as_arr() throws OperationNotSupportedException {
        // GIVEN
        var personMock = Mockito.mock(Person.class);

        // THEN
        var db = new Database(personMock);

        // WHEN
        Person[] res = { personMock };
        assertArrayEquals(res, db.getElements());
    }

    // add()
    @Test
    public void add_operation_adding_valid_person() throws OperationNotSupportedException {
        // GIVEN
        var person1 = new Person(1, "Name");
        var db = new Database(person1);

        // WHEN
        var person2 = new Person(2, "Eman");
        db.add(person2);

        // THEN
        Person[] res = { person1, person2 };
        assertArrayEquals(res, db.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void add_operation_should_throw_onse_when_null_is_passed() throws OperationNotSupportedException {
        // GIVEN
        var personMock = Mockito.mock(Person.class);
        var db = new Database(personMock);

        // WHEN / THEN OperationNotSupportedException should be thrown
        db.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void add_operation_should_throw_onse_if_people_with_the_same_id_are_trying_to_be_added()
            throws OperationNotSupportedException {
        // GIVEN
        var person1 = new Person(1, "Name");
        var person2 = new Person(1, "Eman");
        var db = new Database(person1);

        // WHEN / THEN OperationNotSupportedException should be thrown
        db.add(person2);
    }

    @Test
    // remove()
    public void remove_operation_should_return_last_el() throws OperationNotSupportedException {
        // GIVEN
        var personMock = Mockito.mock(Person.class);
        var db = new Database(personMock, personMock);

        // WHEN
        db.remove();

        // THEN
        Person[] res = { personMock };
        assertArrayEquals(res, db.getElements());
    }
    
    @Test(expected = OperationNotSupportedException.class)
    public void remove_operation_should_throw_onse_if_its_arr_is_empty() throws OperationNotSupportedException {
        // GIVEN
        var personMock = Mockito.mock(Person.class);
        var db = new Database(personMock);

        // WHEN / THEN OperatonNotSupported should be thrown
        db.remove();
        db.remove();
    }

    // findByUsername()
    @Test
    public void findByUsername_should_return_valid_person_if_there_is_present() throws OperationNotSupportedException {
        // GIVEN
        var person1 = new Person(1, "Name");
        var person2 = new Person(2, "Eman");
        var db = new Database(person1, person2);

        // WHEN
        var person = db.findByUsername("Eman");

        // THEN
        assertEquals(person, person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsername_should_throw_onse_if_no_person_is_present() throws OperationNotSupportedException {
        // GIVEN
        var person1 = new Person(1, "Name");
        var person2 = new Person(2, "Eman");
        var db = new Database(person1, person2);

        // WHEN / THEN OperationNotSupportedException should be thrown
        db.findByUsername("InvalidName");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsername_should_throw_onse_if_null_is_passed() throws OperationNotSupportedException {
        // GIVEN
        var person1 = new Person(1, "Name");
        var person2 = new Person(2, "Eman");
        var db = new Database(person1, person2);

        // WHEN / THEN OperationNotSupportedException should be thrown
        db.findByUsername(null);
    }

    // findById()
    @Test
    public void findById_should_return_valid_person_if_there_is_present() throws OperationNotSupportedException {
        // GIVEN
        var person1 = new Person(1, "Name");
        var person2 = new Person(2, "Eman");
        var db = new Database(person1, person2);

        // WHEN
        var person = db.findById(2);

        // THEN
        assertEquals(person, person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findById_should_throw_onse_if_no_person_is_present() throws OperationNotSupportedException {
        // GIVEN
        var person1 = new Person(1, "Name");
        var person2 = new Person(2, "Eman");
        var db = new Database(person1, person2);

        // WHEN / THEN OperationNotSupportedException should be thrown
        db.findById(3);
    }

}
