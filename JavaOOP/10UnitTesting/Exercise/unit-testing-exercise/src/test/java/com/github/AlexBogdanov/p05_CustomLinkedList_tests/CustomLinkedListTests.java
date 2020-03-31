package com.github.AlexBogdanov.p05_CustomLinkedList_tests;

import com.github.AlexBogdanov.p05_CustomLinkedList.CustomLinkedList;

import static org.junit.Assert.*;
import org.junit.Test;

public class CustomLinkedListTests {
    
    // get()
    @Test
    public void get_valid_node_when_valid_index_is_passed() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN
        int el = linkedList.get(1);

        // THEN
        assertEquals(7, el);
    }

    @Test(expected = IllegalArgumentException.class)
    public void if_index_is_larger_than_list_size_iae_should_be_thrown() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN / THEN IllegalArgumentException should be thrown
        linkedList.get(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void if_index_is_negative_num_iae_should_be_thrown() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN / THEN IllegalArgumentException should be thrown
        linkedList.get(-5);
    }

    // set()
    @Test
    public void set_valid_node_when_valid_index_and_element_are_passed() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN
        linkedList.set(2, 14);

        // THEN
        int res = linkedList.get(2);
        assertEquals(14, res);
    }

    @Test(expected = IllegalArgumentException.class)
    public void if_index_is_out_of_list_boundaries_iae_should_be_thrown() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN / THEN IllegalArgumentException should be thrown
        linkedList.set(5, 14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void if_index_is_less_than_zero_iae_should_be_thrown() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN / THEN IllegalArgumentException should be thrown
        linkedList.set(-5, 14);
    }

    // removeAt()
    @Test
    public void element_should_be_removed_when_index_is_valid() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN
        linkedList.removeAt(1);

        // THEN
        assertFalse(linkedList.contains(7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAt_should_throw_iae_when_index_is_out_of_boundaries() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN / THEN IllegalArgumentException should be thrown
        linkedList.removeAt(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAt_should_throw_iae_when_index_is_a_negative_num() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN / THEN IllegalArgumentException should be thrown
        linkedList.removeAt(-5);
    }

    // remove()
    @Test
    public void remove_should_remove_element_if_it_is_present() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN
        linkedList.remove(7);

        // THEN
        assertFalse(linkedList.contains(7));
    }
    @Test
    public void remove_should_return_negative_num_if_element_is_not_present() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN
        int removedEl = linkedList.remove(11);

        // THEN
        assertEquals(-1, removedEl);
    }

    // indexOf()
    @Test
    public void indexOf_should_return_the_index_of_an_el_if_el_is_present() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN
        int index = linkedList.indexOf(7);

        // THEN
        assertEquals(1, index);
    }

    @Test
    public void indexOf_should_return_negative_num_if_el_is_not_present() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN
        int index = linkedList.indexOf(11);

        // THEN
        assertEquals(-1, index);
    }

    // contains()
    @Test
    public void contains_should_return_true_if_el_is_present() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN
        boolean isContained = linkedList.contains(7);

        // THEN
        assertTrue(isContained);
    }
    
    @Test
    public void contains_should_return_false_if_el_is_not_present() {
        // GIVEN
        var linkedList = new CustomLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);

        // WHEN
        boolean isContained = linkedList.contains(11);

        // THEN
        assertFalse(isContained);
    }

}
