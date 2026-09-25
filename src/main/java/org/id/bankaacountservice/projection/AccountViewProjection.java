package org.id.bankaacountservice.projection;

import lombok.Value;
import org.id.bankaacountservice.entity.BankAccount;
import org.id.bankaacountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = { BankAccount.class })
public interface AccountViewProjection {
    String getId();
    double getBalance();
    String getCurrency();
    AccountType getType();

}
