package org.id.bankaacountservice.dto;

import org.id.bankaacountservice.enums.AccountType;

import java.math.BigDecimal;

public record CreateAccountRequest(
        double balance,
        String currency,
        AccountType type
) {}
