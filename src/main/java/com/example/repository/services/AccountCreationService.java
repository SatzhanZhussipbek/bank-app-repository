package com.example.repository.services;

import com.example.repository.entities.AccountType;

public interface AccountCreationService {
    public void create(AccountType accountType, long bankID, String clientID, long accountID);
}
