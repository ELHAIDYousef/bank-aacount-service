package org.id.bankaacountservice.dto;

import org.id.bankaacountservice.enums.AccountType;

public record BankAccountInput(
        double balance,
        String currency,
        AccountType type
) {}