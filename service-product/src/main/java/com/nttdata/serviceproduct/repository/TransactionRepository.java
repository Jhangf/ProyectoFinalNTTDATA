package com.nttdata.serviceproduct.repository;

import com.nttdata.serviceproduct.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
