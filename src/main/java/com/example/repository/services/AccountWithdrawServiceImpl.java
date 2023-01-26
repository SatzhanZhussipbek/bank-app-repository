package com.example.repository.services;

import com.example.repository.data.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountWithdrawServiceImpl implements AccountWithdrawService{
    private AccountDAO accountDAO;
    @Autowired
    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        System.out.printf("%.2f$ transferred from %s account\n", amount, account.getAccountID());
        accountDAO.updateAccount(account, account.getBalance()-amount);
    }
}
