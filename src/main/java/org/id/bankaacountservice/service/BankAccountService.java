package org.id.bankaacountservice.service;

import org.id.bankaacountservice.dto.AccountResponse;
import org.id.bankaacountservice.dto.AccountRequest;

import java.util.List;

public interface BankAccountService {
    List<AccountResponse> getAllAccounts();
    AccountResponse getAccountById(String id);
    AccountResponse createBankAccount(AccountRequest request);
    AccountResponse updateBankAccount(String id, AccountRequest request);
    void deleteBankAccountById(String id);
}

