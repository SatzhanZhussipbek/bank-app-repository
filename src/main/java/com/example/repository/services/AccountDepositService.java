package com.example.repository.services;

import com.example.repository.entities.Account;

public interface AccountDepositService {
    public void deposit(double amount, Account account);
}
