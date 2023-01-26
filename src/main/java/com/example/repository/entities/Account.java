package com.example.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Entity
@Table(name="Account")
public class Account {
    @Id
    private long accountID;

    private AccountType accountType;

    private String clientID;

    public Account() {

    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getAccountID() {
        return String.format("%03d%06d", 1, accountID);
    }

    public String getClientID() {
        return clientID;
    }

    public double getBalance() {
        return balance;
    }

    private double balance;

    private boolean withdrawAllowed;

    public boolean isWithdrawAllowed() {
        return withdrawAllowed;
    }

    @Override
    public String toString() {
        return String.format("Account{id='%03d%06d', clientID='%s', balance='%.1f'}", 1, accountID, clientID, balance);
    }
}
