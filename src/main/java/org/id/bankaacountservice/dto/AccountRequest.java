package org.id.bankaacountservice.dto;

import org.id.bankaacountservice.enums.AccountType;

public record AccountRequest(
        double balance,
        String currency,
        AccountType type
) {}
