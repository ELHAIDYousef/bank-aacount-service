package org.id.bankaacountservice.dto;

import org.id.bankaacountservice.enums.AccountType;

public record UpdateAccountRequest(
        double balance,     // wrapper type, so null means "don't change", 0 is a real value
        String currency,
        AccountType type
) {}
