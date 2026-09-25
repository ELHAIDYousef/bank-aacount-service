package org.id.bankaacountservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.id.bankaacountservice.enums.AccountType;

import java.util.Date;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
