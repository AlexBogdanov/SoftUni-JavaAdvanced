package com.github.AlexBogdanov;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.mockito.Mockito;

public class InstockTests {

    // getCount()
    @Test
    public void getCount_should_return_number_of_products_instock() {
        // GIVEN
        var instock = new Instock();
        var prodMock = Mockito.mock(Product.class);

        // WHEN
        instock.add(prodMock);

        // THEN
        assertEquals(1, instock.getCount());
    }

    @Test
    public void getCount_should_return_0_when_instock_is_empty() {
        // GIVEN
        var instock = new Instock();

        // WHEN / THEN
        assertEquals(0, instock.getCount());
    }

    // contains()
    @Test
    public void contains_should_return_true_if_prod_is_instock() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);

        // WHEN
        instock.add(prod1);
        instock.add(prod2);

        // THEN
        assertTrue(instock.contains(prod1));
    }
    
    @Test
    public void contains_should_return_false_if_prod_is_not_instock() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);

        // WHEN
        instock.add(prod1);

        // THEN
        assertFalse(instock.contains(prod2));
    }

    // add()
    @Test(expected = IllegalArgumentException.class)
    public void add_should_throw_iae_if_prod_is_present() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);

        // WHEN / THEN IllegalArgumentException should be thrown
        instock.add(prod1);
        instock.add(prod1);
    }

    // changeQuantity()
    @Test
    public void changeQuantity_should_change_prod_quantity_if_prod_is_instock() {
        // GIVEN
        var instock = new Instock();
        var prod = new Product("Meat", 20, 5);
        instock.add(prod);

        // WHEN
        instock.changeQuantity("Meat", 2);

        // THEN
        assertEquals(7, instock.findByLabel("Meat").quantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantity_should_throw_iae_if_prod_is_not_instock() {
        // GIVEN
        var instock = new Instock();
        var prod = new Product("Meat", 20, 5);
        instock.add(prod);

        // WHEN / THEN
        instock.changeQuantity("Vegetable", 2);
    }

    // find()
    @Test
    public void find_should_return_prod_on_given_index() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);

        // WHEN
        instock.add(prod1);
        instock.add(prod2);

        // THEN
        assertEquals(prod2, instock.find(1));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void find_should_throw_iob_if_index_is_bigger_than_instock() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);

        // WHEN / THEN
        instock.add(prod1);
        instock.add(prod2);
        prod2.compareTo(instock.find(2));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void find_should_throw_iob_if_invalid_index_is_invalid_num() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);

        // WHEN / THEN
        instock.add(prod1);
        instock.add(prod2);
        prod2.compareTo(instock.find(-1));
    }

    // findByLabel()
    @Test
    public void findByLabel_should_return_prod_with_given_label() {
        // GIVEN
        var instock = new Instock();
        var prod = new Product("Meat", 20, 5);

        // WHEN
        instock.add(prod);

        // THEN
        assertEquals(prod, instock.findByLabel("Meat"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void findByLabel_should_throw_iae_if_prod_with_label_is_not_instock() {
        // GIVEN
        var instock = new Instock();
        var prod = new Product("Meat", 20, 5);

        // WHEN / THEN
        instock.add(prod);
        instock.findByLabel("Vegetable");
    }

    // findFirstByAlphabeticalOrder()
    @Test
    public void findFirstByAlphabeticalOrder_should_return_nth_el_when_they_are_alphabetivally_sorted() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);
        var prod3 = new Product("Herbs", 50, 2);

        // WHEN
        instock.add(prod1);
        instock.add(prod2);
        instock.add(prod3);
        Product[] arr = { prod3, prod1, prod2 };
        Iterable<Product> res = Arrays.asList(arr);

        // THEN
        assertEquals(res, instock.findFirstByAlphabeticalOrder(3));
    }

    @Test
    public void findFirstByAlphabeticalOrder_should_return_empty_collection_if_index_is_out_of_bounds() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);
        var prod3 = new Product("Herbs", 50, 2);

        // WHEN
        instock.add(prod1);
        instock.add(prod2);
        instock.add(prod3);
        Product[] arr = {};
        Iterable<Product> res = Arrays.asList(arr);

        // THEN
        assertEquals(res, instock.findFirstByAlphabeticalOrder(15));
    }

    @Test
    public void findFirstByAlphabeticalOrder_should_return_empty_collection_if_index_is_invalid() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);
        var prod3 = new Product("Herbs", 50, 2);

        // WHEN
        instock.add(prod1);
        instock.add(prod2);
        instock.add(prod3);
        Product[] arr = {};
        Iterable<Product> res = Arrays.asList(arr);

        // THEN
        assertEquals(res, instock.findFirstByAlphabeticalOrder(-15));
    }

    // findAllInRange()
    @Test
    public void findAllInRange_should_return_all_prods_in_given_price_range() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);
        var prod3 = new Product("Herbs", 50, 2);

        // WHEN
        instock.add(prod1);
        instock.add(prod2);
        instock.add(prod3);
        Product[] arr = { prod3, prod1 };
        Iterable<Product> res = Arrays.asList(arr);

        // THEN
        assertEquals(res, instock.findAllInRange(19.5, 60));
    }

    @Test
    public void findAllInRange_should_return_empty_collection_if_there_are_no_prods_in_given_range() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);
        var prod3 = new Product("Herbs", 50, 2);

        // WHEN
        instock.add(prod1);
        instock.add(prod2);
        instock.add(prod3);
        Product[] arr = {};
        Iterable<Product> res = Arrays.asList(arr);

        // THEN
        assertEquals(res, instock.findAllInRange(0.5, 4));
    }

    // findAllByPrice()
    @Test
    public void findAllByPrice_should_return_all_prods_with_given_price() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);
        var prod3 = new Product("Herbs", 50, 2);

        // WHEN
        instock.add(prod1);
        instock.add(prod2);
        instock.add(prod3);
        Product[] arr = { prod3 };
        Iterable<Product> res = Arrays.asList(arr);

        // THEN
        assertEquals(res, instock.findAllByPrice(50));
    }

    @Test
    public void findAllByPrice_should_return_empty_collection_if_no_prods_match_the_given_price() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);
        var prod3 = new Product("Herbs", 50, 2);

        // WHEN
        instock.add(prod1);
        instock.add(prod2);
        instock.add(prod3);
        Product[] arr = {};
        Iterable<Product> res = Arrays.asList(arr);

        // THEN
        assertEquals(res, instock.findAllByPrice(14));
    }

    // findFirstMostExpensiveProducts()
    @Test
    public void findFirstMostExpensiveProducts_should_return_the_first_nth_most_expensive_prods() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);
        var prod3 = new Product("Herbs", 50, 2);

        // WHEN
        instock.add(prod1);
        instock.add(prod2);
        instock.add(prod3);
        Product[] arr = { prod3, prod1, prod2 };
        Iterable<Product> res = Arrays.asList(arr);

        // THEN
        assertEquals(res, instock.findFirstMostExpensiveProducts(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProducts_should_throw_iae_if_there_are_not_enough_prods() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);
        var prod3 = new Product("Herbs", 50, 2);

        // WHEN / THEN IllegalArgumentException should be thrown
        instock.add(prod1);
        instock.add(prod2);
        instock.add(prod3);
        instock.findFirstMostExpensiveProducts(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProducts_should_throw_iae_if_n_is_invalid_num() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 5);
        var prod2 = new Product("Vegetable", 5, 10);
        var prod3 = new Product("Herbs", 50, 2);

        // WHEN / THEN IllegalArgumentException should be thrown
        instock.add(prod1);
        instock.add(prod2);
        instock.add(prod3);
        instock.findFirstMostExpensiveProducts(-4);
    }

    // findAllByQuantity()
    @Test
    public void findAllByQuantity_should_return_all_prods_with_the_given_quantity_remaining() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 10);
        var prod2 = new Product("Vegetable", 5, 10);
        var prod3 = new Product("Herbs", 50, 2);

        // WHEN
        instock.add(prod1);
        instock.add(prod2);
        instock.add(prod3);
        Product[] arr = { prod1, prod2 };
        Iterable<Product> res = Arrays.asList(arr);

        // THEN
        assertEquals(res, instock.findAllByQuantity(10));
    }
    
    @Test
    public void findAllByQuantity_should_return_empty_collection_if_no_prods_matching_the_quantity_are_present() {
        // GIVEN
        var instock = new Instock();
        var prod1 = new Product("Meat", 20, 10);
        var prod2 = new Product("Vegetable", 5, 10);
        var prod3 = new Product("Herbs", 50, 2);

        // WHEN
        instock.add(prod1);
        instock.add(prod2);
        instock.add(prod3);
        Product[] arr = {};
        Iterable<Product> res = Arrays.asList(arr);

        // THEN
        assertEquals(res, instock.findAllByQuantity(14));
    }

}
