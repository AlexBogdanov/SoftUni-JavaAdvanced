package com.github.AlexBogdanov.p01_Database_tests;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

import com.github.AlexBogdanov.p01_Database.Database;

import org.junit.Test;

public class DatabaseTests {

    // ctor() and setElements()
    @Test
    public void database_should_be_create_with_minimum_of_1_element() throws OperationNotSupportedException {
        // GIVEN
        Integer[] elements = { 1 };

        // THEN
        var db = new Database(elements);

        // WHEN
        assertEquals(Database.class, db.getClass());
    }

    @Test
    public void database_should_be_create_with_maximum_of_16_element() throws OperationNotSupportedException {
        // GIVEN
        Integer[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6 };

        // THEN
        var db = new Database(elements);

        // WHEN
        assertEquals(Database.class, db.getClass());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void database_should_throw_onse_when_created_with_empty_arr() throws OperationNotSupportedException {
        // GIVEN
        Integer[] elements = new Integer[0];

        // WHEN / THEN OperationNotSupportedException should be thrown
        new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void database_should_throw_onse_when_created_with_arr_with_more_than_16_el() throws OperationNotSupportedException {
        // GIVEN
        Integer[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7 };

        // WHEN / THEN OperationNotSupportedException should be thrown
        new Database(elements);
    }

    // getElements()
    @Test
    public void getElements_should_return_elements_as_arr() throws OperationNotSupportedException {
        // GIVEN
        Integer[] elements = { 1 };

        // THEN
        var db = new Database(elements);

        // WHEN
        assertArrayEquals(elements, db.getElements());
    }

    // add()
    @Test
    public void add_operation_adding_valid_integers() throws OperationNotSupportedException {
        // GIVEN
        Integer[] elements = { 1 };
        var db = new Database(elements);

        // WHEN
        db.add(2);

        // THEN
        Integer[] res = { 1, 2 };
        assertArrayEquals(res, db.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void add_operation_should_throw_onse_when_null_is_passed() throws OperationNotSupportedException {
        // GIVEN
        Integer[] elements = { 1 };
        var db = new Database(elements);

        // WHEN / THEN OperationNotSupportedException should be thrown
        db.add(null);
    }

    // remove()
    @Test
    public void remove_operation_should_return_last_el() throws OperationNotSupportedException {
        // GIVEN
        Integer[] elements = { 1, 2 };
        var db = new Database(elements);

        // WHEN
        db.remove();

        // THEN
        Integer[] res = { 1 };
        assertArrayEquals(res, db.getElements());
    }
    
    @Test(expected = OperationNotSupportedException.class)
    public void remove_operation_should_throw_onse_if_its_arr_is_empty() throws OperationNotSupportedException {
        // GIVEN
        Integer[] elements = { 1 };
        var db = new Database(elements);

        // WHEN / THEN OperatonNotSupported should be thrown
        db.remove();
        db.remove();
    }

}
