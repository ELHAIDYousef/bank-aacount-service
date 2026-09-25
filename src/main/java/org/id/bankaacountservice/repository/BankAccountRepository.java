package org.id.bankaacountservice.repository;

import org.id.bankaacountservice.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
