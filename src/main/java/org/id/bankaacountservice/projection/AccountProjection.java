package org.id.bankaacountservice.projection;

import org.id.bankaacountservice.entity.BankAccount;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = { BankAccount.class })
public interface AccountProjection {
    String getId();
    double getBalance();
    String getCurrency();
}