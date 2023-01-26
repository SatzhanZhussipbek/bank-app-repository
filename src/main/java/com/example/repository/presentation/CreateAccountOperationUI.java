package com.example.repository.presentation;

import com.example.repository.entities.AccountType;
import org.springframework.stereotype.Component;

@Component
public interface CreateAccountOperationUI{
    AccountType requestAccountType();
}

