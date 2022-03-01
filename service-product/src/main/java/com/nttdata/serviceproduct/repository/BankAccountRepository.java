package com.nttdata.serviceproduct.repository;

import com.nttdata.serviceproduct.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {
}
