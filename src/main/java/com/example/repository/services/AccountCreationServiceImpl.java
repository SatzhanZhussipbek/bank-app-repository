package com.example.repository.services;

import com.example.repository.data.AccountDAO;
import com.example.repository.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountCreationServiceImpl implements AccountCreationService{
    private AccountDAO accountDAO;
    @Autowired
    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        Account account = null;
        if (accountType.toString().equals("CHECKING") ) {
            account = new CheckingAccount(accountType, accountID, clientID, 0.0, true);
        }
        else if (accountType.toString().equals("SAVING") ) {
            account = new SavingAccount(accountType, accountID, clientID, 0.0, true);
        }
        else if (accountType.toString().equals("FIXED")){
            account = new FixedAccount(accountType, accountID, clientID, 0.0, false);
        }
        this.accountDAO.createNewAccount(account);
    }
}
