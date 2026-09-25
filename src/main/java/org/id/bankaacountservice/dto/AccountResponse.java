package org.id.bankaacountservice.dto;

import org.id.bankaacountservice.enums.AccountType;

import java.util.Date;

public record AccountResponse(
        String id,
        double balance,
        String currency,
        AccountType type,
        Date createdAt
) {}
