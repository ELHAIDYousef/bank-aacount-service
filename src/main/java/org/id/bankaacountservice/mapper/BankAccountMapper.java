package org.id.bankaacountservice.mapper;

import org.id.bankaacountservice.dto.*;
import org.id.bankaacountservice.entity.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {

    // Entity -> Response DTO
    public AccountResponse toResponse(BankAccount account) {
        return new AccountResponse(
                account.getId(),
                account.getBalance(),
                account.getCurrency(),
                account.getType(),
                account.getCreatedAt()
        );
    }

    // Create request -> new Entity (server-controlled fields set in the service, not here)
    public BankAccount toEntity(CreateAccountRequest req) {
        return BankAccount.builder()
                .balance(req.balance())
                .currency(req.currency())
                .type(req.type())
                .build();
    }
}