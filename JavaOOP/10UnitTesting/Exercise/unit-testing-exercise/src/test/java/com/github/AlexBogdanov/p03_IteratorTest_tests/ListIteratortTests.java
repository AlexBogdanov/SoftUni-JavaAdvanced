package com.github.AlexBogdanov.p03_IteratorTest_tests;

import javax.naming.OperationNotSupportedException;

import com.github.AlexBogdanov.p03_IteratorTest.ListIterator;

import static org.junit.Assert.*;
import org.junit.Test;

public class ListIteratortTests {

    // ctor()
    @Test
    public void valid_ListIterator_should_be_initialised_with_valid_data() throws OperationNotSupportedException {
        // GIVEN
        String[] elements = { "element1", "element2", "element3" };

        // WHEN
        var listIterator = new ListIterator(elements);

        // THEN
        assertEquals(ListIterator.class, listIterator.getClass());
    }
    
    @Test(expected = OperationNotSupportedException.class)
    public void ctor_should_throw_onse_when_no_arguments_are_passed() throws OperationNotSupportedException {
        // GIVEN
        String[] elements = null;

        // WHEN / THEN OperationNotSupportedException should be thrown
        new ListIterator(elements);
    }

    // hasNext()
    @Test
    public void hasNext_should_return_true_if_there_is_next_element() throws OperationNotSupportedException {
        // GIVEN
        String[] elements = { "element1", "element2" };
        var listIterator = new ListIterator(elements);

        // THEN
        boolean hasNext = listIterator.hasNext();

        // WHEN
        assertTrue(hasNext);
    }
    
    @Test
    public void hasNext_should_return_false_if_there_is_no_next_element() throws OperationNotSupportedException {
        // GIVEN
        String[] elements = { "element1" };
        var listIterator = new ListIterator(elements);

        // THEN
        boolean hasNext = listIterator.hasNext();

        // WHEN
        assertFalse(hasNext);
    }

    // move()
    @Test
    public void move_should_return_true_if_there_is_next_element() throws OperationNotSupportedException {
        // GIVEN
        String[] elements = { "element1", "element2" };
        var listIterator = new ListIterator(elements);

        // THEN
        boolean canMove = listIterator.move();

        // WHEN
        assertTrue(canMove);
    }
    
    @Test
    public void move_should_return_false_if_there_is_no_next_element() throws OperationNotSupportedException {
        // GIVEN
        String[] elements = { "element1" };
        var listIterator = new ListIterator(elements);

        // THEN
        boolean canMove = listIterator.move();

        // WHEN
        assertFalse(canMove);
    }

    // print()
    @Test
    public void print_should_print_the_element_on_curr_index() throws OperationNotSupportedException {
        // GIVEN
        String[] elements = { "element1", "element2" };
        var listIterator = new ListIterator(elements);

        // WHEN
        String res = listIterator.print();

        // THEN
        assertEquals(elements[0], res);
    }

    @Test(expected = IllegalStateException.class)
    public void print_should_throw_ise_if_elements_are_empty() throws OperationNotSupportedException {
        // GIVEN
        var elements = new String[0];
        var listIterator = new ListIterator(elements);

        // WHEN / THEN IllegalStateException should be thrown
        listIterator.print();
    }

}
