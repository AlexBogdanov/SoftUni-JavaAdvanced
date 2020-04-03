package com.github.AlexBogdanov;

public interface Transaction {

    TransactionStatus getTransactionStatus();
    void setTransactionStatus(TransactionStatus ts);
    double getAmount();
    int getId();
    String getFrom();
    String getTo();
    int compareTo(Transaction t);

}
