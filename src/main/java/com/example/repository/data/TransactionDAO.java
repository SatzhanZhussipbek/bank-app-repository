package com.example.repository.data;

import com.example.repository.entities.Transaction;

import java.util.List;

public interface TransactionDAO {
    public List<Transaction> getTransactions();

    public void addTransactions(Transaction transaction);


}
