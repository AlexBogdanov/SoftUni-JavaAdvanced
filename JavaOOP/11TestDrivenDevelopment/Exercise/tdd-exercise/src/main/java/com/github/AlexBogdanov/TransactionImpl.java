package com.github.AlexBogdanov;

public class TransactionImpl implements Transaction, Comparable<Transaction> {

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public TransactionStatus getTransactionStatus() {
        return this.status;
    }

    @Override
    public void setTransactionStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getFrom() {
        return this.from;
    }

    @Override
    public String getTo() {
        return this.to;
    }

    @Override
    public int compareTo(Transaction t) {
        if (this.getAmount() == t.getAmount()) {
            if (this.getId() > t.getId()) { return 1; }
            if (this.getId() < t.getId()) { return -1; }
            return 0;
        }
        
        if (this.getAmount() > t.getAmount()) { return -1; }
        if (this.getAmount() < t.getAmount()) { return 1; }
        return 0;
    }
}
