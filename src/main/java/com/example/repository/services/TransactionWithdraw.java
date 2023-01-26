package com.example.repository.services;

import com.example.repository.data.TransactionDAO;
import com.example.repository.entities.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;

    private TransactionDAO transactionDAO;

    public TransactionWithdraw(AccountWithdrawService accountWithdrawService,
                               TransactionDAO transactionDAO) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(AccountWithdraw accountWithdraw, double amount) {
        accountWithdrawService.withdraw(amount,accountWithdraw);
        Transaction newTransaction = new Transaction(accountWithdraw.getClientID(),
                accountWithdraw.getAccountID(), accountWithdraw.getAccountType(), amount);
        transactionDAO.addTransactions(newTransaction);
    }
}
