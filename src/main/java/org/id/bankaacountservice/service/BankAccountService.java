package org.id.bankaacountservice.service;

import org.id.bankaacountservice.dto.AccountResponse;
import org.id.bankaacountservice.dto.CreateAccountRequest;
import org.id.bankaacountservice.dto.UpdateAccountRequest;

import java.util.List;

public interface BankAccountService {
    List<AccountResponse> getAllAccounts();
    AccountResponse getAccountById(String id);
    AccountResponse createBankAccount(CreateAccountRequest request);
    AccountResponse updateBankAccount(String id, UpdateAccountRequest request);
    void deleteBankAccountById(String id);
}

