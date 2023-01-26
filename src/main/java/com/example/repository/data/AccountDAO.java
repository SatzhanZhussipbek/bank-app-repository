package com.example.repository.data;

import com.example.repository.entities.Account;
import com.example.repository.entities.AccountType;
import com.example.repository.services.AccountWithdraw;

import java.util.List;

public interface AccountDAO {
    public List<Account> getClientAccounts(String clientID);

    public void createNewAccount(Account account);

    public void updateAccount(Account account, double amount);

    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);

    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    public Account getClientAccount(String clientID, String accountID);
}
