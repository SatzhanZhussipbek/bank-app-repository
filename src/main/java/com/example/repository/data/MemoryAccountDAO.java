package com.example.repository.data;

import com.example.repository.entities.Account;
import com.example.repository.entities.AccountType;
import com.example.repository.services.AccountWithdraw;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Component
@Repository("")
public class MemoryAccountDAO implements AccountDAO{
    private List<Account> accountList = new ArrayList<>();

    @Override
    public List<Account> getClientAccounts(String clientID) {
        List<Account> listOfAccounts = new ArrayList<>();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getClientID().equals(clientID)) {
                listOfAccounts.add(accountList.get(i));
            }
        }
        return listOfAccounts;
    }

    @Override
    public void createNewAccount(Account account) {
        this.accountList.add(account);
        System.out.println("The bank account has been created");
    }

    @Override
    public void updateAccount(Account account, double amount) {
        account.setBalance(amount);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        List<Account> list2 = new ArrayList<>();
        for (int i = 0; i < accountList.size(); i++) {
            if ( accountList.get(i).getClientID().equals(clientID) &&
                    accountList.get(i).getAccountType().equals(accountType) ) {
                list2.add(accountList.get(i));
            }
        }
        return list2;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {

        for (int i = 0; i < accountList.size(); i++) {
            if ( accountList.get(i).getClientID().equals(clientID) &&
                    accountList.get(i).getAccountID().equals(accountID) ) {
                if (accountList.get(i).isWithdrawAllowed() ) {
                    return (AccountWithdraw) accountList.get(i);
                }
                else {
                    System.out.println("You can't withdraw money from a fixed account.");
                }
            }
        }
        return null;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        Account calledAccount = null;
        if ( (clientID.length() > 0 ) && (accountID.length() > 0 ) ) {
            for (int i = 0; i < accountList.size(); i++) {
                if (accountList.get(i).getClientID().equals(clientID) ) {
                    if ( accountList.get(i).getAccountID().equals(accountID) ){
                        calledAccount = accountList.get(i);
                        return calledAccount;
                    }
                }
            }
        }
        return calledAccount;
    }
}
