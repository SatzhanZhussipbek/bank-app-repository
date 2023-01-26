package com.example.repository.services;

import com.example.repository.data.AccountDAO;
import com.example.repository.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDepositServiceImpl implements AccountDepositService{
    private AccountDAO accountDAO;
    @Autowired
    public AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void deposit(double amount, Account account) {
        System.out.printf("%.2f$ transferred to %s account\n", amount, account.getAccountID());
        accountDAO.updateAccount(account, account.getBalance()+amount);
    }
}
