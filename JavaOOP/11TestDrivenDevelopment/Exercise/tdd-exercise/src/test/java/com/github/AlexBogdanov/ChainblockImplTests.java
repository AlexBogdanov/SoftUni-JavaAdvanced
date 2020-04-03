package com.github.AlexBogdanov;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ChainblockImplTests {

    // getCount()
    @Test
    public void getCount_should_return_transactions_count() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Me", "You", 500);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "You", "Me", 500);

        // WHEN
        chainblock.add(trans1);
        chainblock.add(trans2);

        //THEN
        assertEquals(2, chainblock.getCount());
    }
    
    @Test
    public void getCount_should_return_0_if_there_are_no_transactions_added() {
        // GIVEN / WHEN
        var chainblock = new ChainblockImpl();

        //THEN
        assertEquals(0, chainblock.getCount());
    }

    // add()
    @Test
    public void add_should_add_transacaction_valid_transactions() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Me", "You", 333);

        // WHEN
        chainblock.add(trans1);
        chainblock.add(trans2);

        // THEN
        assertEquals(2, chainblock.getCount());
    }

    @Test
    public void add_should_add_transacaction_with_given_id_only_once() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Me", "You", 333);

        // WHEN
        chainblock.add(trans);
        chainblock.add(trans);

        // THEN
        assertEquals(1, chainblock.getCount());
    }

    // contains(Transaction)
    @Test
    public void contains_should_return_true_if_transaction_is_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Me", "You", 333);

        // WHEN
        chainblock.add(trans1);
        chainblock.add(trans2);

        // THEN
        assertTrue(chainblock.contains(trans1));
    }
    
    @Test
    public void contains_should_return_false_if_transaction_is_not_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Me", "You", 333);

        // WHEN
        chainblock.add(trans1);

        // THEN
        assertFalse(chainblock.contains(trans2));
    }

    // contains(id)
    @Test
    public void contains_should_return_true_if_transaction_with_given_id_is_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Me", "You", 333);

        // WHEN
        chainblock.add(trans1);
        chainblock.add(trans2);

        // THEN
        assertTrue(chainblock.contains(1));
    }
    
    @Test
    public void contains_should_return_false_if_transaction_with_given_id_is_not_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Me", "You", 333);

        // WHEN
        chainblock.add(trans1);

        // THEN
        assertFalse(chainblock.contains(2));
    }

    // changeTransactionStatus()
    @Test
    public void changeTransactionStatus_should_change_transaction_status_if_transaction_is_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        chainblock.add(trans);

        // WHEN
        chainblock.changeTransactionStatus(1, TransactionStatus.SUCCESSFUL);

        // THEN
        Transaction transDB = chainblock.getById(1);
        assertEquals(TransactionStatus.SUCCESSFUL, transDB.getTransactionStatus());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionStatus_should_thrown_iae_if_transaction_is_not_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        chainblock.add(trans);

        // WHEN / THEN IllegalArgumentException should be thrown
        chainblock.changeTransactionStatus(1, TransactionStatus.SUCCESSFUL);
        chainblock.getById(2);
    }

    // removeTransactionById
    @Test
    public void removeTransactionById_should_remove_transaction_by_given_id() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 333);
        chainblock.add(trans1);
        chainblock.add(trans2);

        // WHEN
        chainblock.removeTransactionById(1);

        // THEN
        assertEquals(1, chainblock.getCount());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void removeTransactionById_should_throw_iae_if_transaction_with_given_id_is_not_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        chainblock.add(trans);

        // WHEN / THEN IllegalArgumentException should be thrown
        chainblock.getById(2);
    }

    // getById()
    @Test
    public void getById_should_return_transaction_with_given_id() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 333);
        chainblock.add(trans1);
        chainblock.add(trans2);

        // WHEN
        var transDB = chainblock.getById(1);

        // THEN
        assertEquals(trans1, transDB);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getById_should_throw_iae_if_transaction_with_given_id_is_not_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        chainblock.add(trans);

        // WHEN / THEN IllegalArgumentException should be thrown
        chainblock.getById(2);
    }

    // getByTransactionStatus()
    @Test
    public void getByTransactionStatus_should_return_all_transactions_with_given_status_ordered_by_amount() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "Me", "You", 12);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);

        // WHEN
        Transaction[] arr = { trans2, trans1, trans3 };
        Iterable<Transaction> exp = Arrays.asList(arr);

        // THEN
        assertEquals(exp, chainblock.getByTransactionStatus(TransactionStatus.FAILED));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatus_should_throw_iae__if_no_transactions_with_given_status_are_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "Me", "You", 12);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);

        // WHEN / THEN IllegalArgumentException should be thrown
        chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    // getAllSendersWithTransactionStatus()
    @Test
    public void getAllSendersWithTransactionStatus_should_return_all_senders_with_transactions_with_given_status_ordered_by_trans_amount() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);

        // WHEN
        String[] arr = { "You", "Me", "Me", "You" };
        Iterable<String> exp = Arrays.asList(arr);

        // THEN
        assertEquals(exp, chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatus_should_throw_iae_if_transactions_with_given_status_are_not_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);

        // WHEN / THEN
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    // getAllReceiversWithTransactionStatus()
    @Test
    public void getAllReceiversWithTransactionStatus_should_return_all_receivers_with_transactions_with_given_status_ordered_by_trans_amount() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);

        // WHEN
        String[] arr = { "Me", "You", "You", "Me" };
        Iterable<String> exp = Arrays.asList(arr);

        // THEN
        assertEquals(exp, chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatus_should_throw_iae_if_transactions_with_given_status_are_not_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);

        // WHEN / THEN
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    // getAllOrderedByAmountDescendingThenById()
    @Test
    public void getAllOrderedByAmountDescendingThenById_should_return_all_trans_ordered_correctly() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 700);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);

        // WHEN
        Transaction[] arr = { trans2, trans3, trans1, trans4 };
        Iterable<Transaction> exp = Arrays.asList(arr);

        // THEN
        assertEquals(exp, chainblock.getAllOrderedByAmountDescendingThenById());
    }

    // getBySenderOrderedByAmountDescending()
    @Test
    public void getBySenderOrderedByAmountDescending_should_return_all_transactions_with_given_sender_ordered_by_amount() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);

        // WHEN
        Transaction[] arr = { trans2, trans1 };
        Iterable<Transaction> exp = Arrays.asList(arr);

        // THEN
        assertEquals(exp, chainblock.getBySenderOrderedByAmountDescending("Me"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderOrderedByAmountDescending_should_throw_iae_if_transactions_with_given_sender_are_not_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);

        // WHEN / THEN
        chainblock.getBySenderOrderedByAmountDescending("Invalid sender");
    }

    // getByReceiverOrderedByAmountThenById()
    @Test
    public void getByReceiverOrderedByAmountThenById_should_return_all_transactions_with_given_receiver_ordered_by_amount_then_by_id() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        Transaction trans5 = new TransactionImpl(5, TransactionStatus.FAILED, "Me", "You", 500);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);
        chainblock.add(trans5);

        // WHEN
        Transaction[] arr = { trans2, trans5, trans1 };
        Iterable<Transaction> exp = Arrays.asList(arr);

        // THEN
        assertEquals(exp, chainblock.getByReceiverOrderedByAmountThenById("You"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverOrderedByAmountThenById_should_throw_iae_if_transactions_with_given_receiver_are_not_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);

        // WHEN / THEN
        chainblock.getByReceiverOrderedByAmountThenById("Invalid receiver");
    }

    // getByTransactionStatusAndMaximumAmount()
    @Test
    public void getByTransactionStatusAndMaximumAmount_should_return_transactions_with_given_status_and_amount_ordered_by_amount() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);

        // WHEN
        Transaction[] arr = { trans2, trans1, trans4 };
        Iterable<Transaction> exp = Arrays.asList(arr);

        // THEN
        assertEquals(exp, chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.FAILED, 500));
    }
    
    @Test
    public void getByTransactionStatusAndMaximumAmount_should_return_empty_collection_when_no_transactions_with_given_status_or_amount_are_present() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);

        // WHEN
        Transaction[] arr = {};
        Iterable<Transaction> exp = Arrays.asList(arr);

        // THEN
        assertEquals(exp, chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, 500));
    }

    // getBySenderAndMinimumAmountDescending()
    @Test
    public void getBySenderAndMinimumAmountDescending_should_return_transactions_with_given_sender_and_amount_ordered_by_amount_and_id() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        Transaction trans5 = new TransactionImpl(5, TransactionStatus.FAILED, "You", "Me", 400);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);
        chainblock.add(trans5);

        // WHEN
        Transaction[] arr = { trans3, trans5, trans4 };
        Iterable<Transaction> exp = Arrays.asList(arr);

        // THEN
        assertEquals(exp, chainblock.getBySenderAndMinimumAmountDescending("You", 11));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescending_should_throw_iae_if_no_transcations_are_present_with_given_sender() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        Transaction trans5 = new TransactionImpl(5, TransactionStatus.FAILED, "You", "Me", 400);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);
        chainblock.add(trans5);

        // WHEN / THEN IllegalArgumentException should be thrown
        chainblock.getBySenderAndMinimumAmountDescending("Invalid sender", 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescending_should_throw_iae_if_no_transcations_are_present_for_given_amount() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        Transaction trans5 = new TransactionImpl(5, TransactionStatus.FAILED, "You", "Me", 400);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);
        chainblock.add(trans5);

        // WHEN / THEN IllegalArgumentException should be thrown
        chainblock.getBySenderAndMinimumAmountDescending("Me", 2000);
    }

    // getByReceiverAndAmountRange()
    @Test
    public void getByReceiverAndAmountRange_should_return_trascations_with_given_sender_and_in_amount_bounds() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        Transaction trans5 = new TransactionImpl(5, TransactionStatus.FAILED, "You", "Me", 400);
        Transaction trans6 = new TransactionImpl(6, TransactionStatus.FAILED, "You", "Me", 400);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);
        chainblock.add(trans5);
        chainblock.add(trans6);

        // WHEN
        Transaction[] arr = { trans3, trans5, trans6 };
        Iterable<Transaction> exp = Arrays.asList(arr);

        // THEN
        assertEquals(exp, chainblock.getByReceiverAndAmountRange("Me", 200, 800));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRange_should_throw_iae_if_receiver_is_invalid() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        Transaction trans5 = new TransactionImpl(5, TransactionStatus.FAILED, "You", "Me", 400);
        Transaction trans6 = new TransactionImpl(6, TransactionStatus.FAILED, "You", "Me", 400);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);
        chainblock.add(trans5);
        chainblock.add(trans6);

        // WHEN / THEN IllegalArgumentException should be thrown
        chainblock.getByReceiverAndAmountRange("Invalid receiver", 200, 800);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRange_should_throw_iae_if_no_transactions_are_present_in_amount_range() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        Transaction trans5 = new TransactionImpl(5, TransactionStatus.FAILED, "You", "Me", 400);
        Transaction trans6 = new TransactionImpl(6, TransactionStatus.FAILED, "You", "Me", 400);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);
        chainblock.add(trans5);
        chainblock.add(trans6);

        // WHEN / THEN IllegalArgumentException should be thrown
        chainblock.getByReceiverAndAmountRange("You", 300, 303);
    }

    // getAllInAmountRange()
    @Test
    public void getAllInAmountRange_should_return_transactions_in_given_amount() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        Transaction trans5 = new TransactionImpl(5, TransactionStatus.FAILED, "You", "Me", 400);
        Transaction trans6 = new TransactionImpl(6, TransactionStatus.FAILED, "You", "Me", 400);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);
        chainblock.add(trans5);
        chainblock.add(trans6);

        // WHEN
        Transaction[] arr = { trans3, trans2, trans5, trans6 };
        Iterable<Transaction> exp = Arrays.asList(arr);

        // THEN
        assertEquals(exp, chainblock.getAllInAmountRange(350, 701));
    }
    
    @Test
    public void getAllInAmountRange_should_return_empty_collection_if_no_transcation_are_present_in_given_amount() {
        // GIVEN
        var chainblock = new ChainblockImpl();
        Transaction trans1 = new TransactionImpl(1, TransactionStatus.FAILED, "Me", "You", 333);
        Transaction trans2 = new TransactionImpl(2, TransactionStatus.FAILED, "Me", "You", 500);
        Transaction trans3 = new TransactionImpl(3, TransactionStatus.FAILED, "You", "Me", 700);
        Transaction trans4 = new TransactionImpl(4, TransactionStatus.FAILED, "You", "Me", 12);
        Transaction trans5 = new TransactionImpl(5, TransactionStatus.FAILED, "You", "Me", 400);
        Transaction trans6 = new TransactionImpl(6, TransactionStatus.FAILED, "You", "Me", 400);
        chainblock.add(trans1);
        chainblock.add(trans2);
        chainblock.add(trans3);
        chainblock.add(trans4);
        chainblock.add(trans5);
        chainblock.add(trans6);

        // WHEN
        Transaction[] arr = {};
        Iterable<Transaction> exp = Arrays.asList(arr);

        // THEN
        assertEquals(exp, chainblock.getAllInAmountRange(1, 5));
    }

}
