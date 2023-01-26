package com.example.repository.services;

import com.example.repository.data.TransactionDAO;
import com.example.repository.entities.Account;
import com.example.repository.entities.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDeposit {
    private AccountDepositService accountDepositService;

    private TransactionDAO transactionDAO;

    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(Account accountDeposit, double amount) {
        Transaction transaction = new Transaction(accountDeposit.getClientID(), accountDeposit.getAccountID(), accountDeposit.getAccountType(), amount);
        accountDepositService.deposit(amount, accountDeposit);
        transactionDAO.addTransactions(transaction);
    }
}
