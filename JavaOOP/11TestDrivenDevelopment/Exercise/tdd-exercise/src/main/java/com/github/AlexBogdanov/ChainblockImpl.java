package com.github.AlexBogdanov;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private List<Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new ArrayList<>();
    }

    public int getCount() {
        return this.transactions.size();
    }

    public void add(Transaction transaction) {
        if (this.contains(transaction.getId())) {
            return;
        }

        if (this.contains(transaction)) {
            return;
        }

        this.transactions.add(transaction);
    }

    public boolean contains(Transaction transaction) {
        return this.transactions.contains(transaction);
    }

    public boolean contains(int id) {
        Transaction transaction = this.transactions.stream()
            .filter(t -> t.getId() == id)
            .findFirst()
            .orElse(null);

        if (transaction == null) {
            return false;
        }

        return true;
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        Transaction transaction = this.transactions.stream()
            .filter(t -> t.getId() == id)
            .findFirst()
            .orElse(null);

        if (transaction == null) {
            throw new IllegalArgumentException("Invalid transcation with id: " + id);
        }

        transaction.setTransactionStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        Transaction transaction = this.transactions.stream()
            .filter(t -> t.getId() == id)
            .findFirst()
            .orElse(null);

        if (transaction == null) {
            throw new IllegalArgumentException("Invalid transcation with id: " + id);
        }

        this.transactions.remove(transaction);
    }

    public Transaction getById(int id) {
        Transaction transaction = this.transactions.stream()
            .filter(t -> t.getId() == id)
            .findFirst()
            .orElse(null);

        if (transaction == null) {
            throw new IllegalArgumentException("Invalid transcation with id: " + id);
        }

        return transaction;
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> fetchedTransactions = this.transactions.stream()
            .filter(t -> t.getTransactionStatus() == status)
            .sorted((t1, t2) -> t1.compareTo(t2))
            .collect(Collectors.toList());

        if (fetchedTransactions.size() < 1) {
            throw new IllegalArgumentException("No transactions with status: " + status.toString());
        }

        return fetchedTransactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> senders = this.transactions.stream()
            .filter(t -> t.getTransactionStatus() == status)
            .sorted((t1, t2) -> t1.compareTo(t2))
            .map(Transaction::getFrom)
            .collect(Collectors.toList());

        if (senders.size() < 1) {
            throw new IllegalArgumentException("No senders with transactios with status: " + status.toString());
        }

        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> receivers = this.transactions.stream()
            .filter(t -> t.getTransactionStatus() == status)
            .sorted((t1, t2) -> t1.compareTo(t2))
            .map(Transaction::getTo)
            .collect(Collectors.toList());

        if (receivers.size() < 1) {
            throw new IllegalArgumentException("No receivers with transactios with status: " + status.toString());
        }

        return receivers;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactions.stream()
            .sorted((t1, t2) -> t1.compareTo(t2))
            .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> sendersTranscations = this.transactions.stream()
            .filter(t -> t.getFrom().equals(sender))
            .sorted((t1, t2) -> t1.compareTo(t2))
            .collect(Collectors.toList());

        if (sendersTranscations.size() < 1) {
            throw new IllegalArgumentException("No transactions with sender: " + sender);
        }

        return sendersTranscations;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> receiversTranscations = this.transactions.stream()
            .filter(t -> t.getTo().equals(receiver))
            .sorted((t1, t2) -> t1.compareTo(t2))
            .collect(Collectors.toList());

        if (receiversTranscations.size() < 1) {
            throw new IllegalArgumentException("No transactions with receiver: " + receiver);
        }

        return receiversTranscations;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return this.transactions.stream()
            .filter(t -> t.getTransactionStatus() == status)
            .filter(t -> t.getAmount() <= amount)
            .sorted((t1, t2) -> t1.compareTo(t2))
            .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> fetchedTransactions = this.transactions.stream()
            .filter(t -> t.getFrom().equals(sender))
            .filter(t -> t.getAmount() > amount)
            .sorted((t1, t2) -> t1.compareTo(t2))
            .collect(Collectors.toList());

        if (fetchedTransactions.size() < 1) {
            throw new IllegalArgumentException("No transactions matching criterias: sender " + sender + " and amount " + amount);
        }

        return fetchedTransactions;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> fetchedTransactions = this.transactions.stream()
            .filter(t -> t.getTo().equals(receiver))
            .filter(t -> t.getAmount() >= lo && t.getAmount() < hi)
            .sorted((t1, t2) -> t1.compareTo(t2))
            .collect(Collectors.toList());

        if (fetchedTransactions.size() < 1) {
            throw new IllegalArgumentException(
                "No transactions matching criterias: receiver " + receiver + " and amount between " + lo + " and " + hi
            );
        }

        return fetchedTransactions;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.transactions.stream()
            .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
            .sorted((t1, t2) -> t1.compareTo(t2))
            .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
