package com.example.repository.data;

import com.example.repository.entities.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MemoryTransactionDAO implements TransactionDAO{
    private List<Transaction> transactions = new ArrayList<>();
    @Override
    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    @Override
    public void addTransactions(Transaction transaction) {
        this.transactions.add(transaction);
    }

}
