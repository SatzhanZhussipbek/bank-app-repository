package com.example.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Transaction")
public class Transaction {
    @Id
    private String clientID;

    private String accountID;

    private AccountType accountType;

    private double amount;

    public Transaction() {

    }

    @Override
    public String toString() {
        return String.format("Transaction[id=%s, account=%s, amount=%.2f, account type=%s]", clientID,
                accountID, amount, accountType);
    }

}
