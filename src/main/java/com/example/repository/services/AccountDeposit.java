package com.example.repository.services;

import com.example.repository.entities.Account;
import com.example.repository.entities.AccountType;

public class AccountDeposit extends Account {
    public AccountDeposit(AccountType accountType, long id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
