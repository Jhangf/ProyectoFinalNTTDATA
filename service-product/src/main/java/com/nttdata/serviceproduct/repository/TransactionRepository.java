package com.nttdata.serviceproduct.repository;

import com.nttdata.serviceproduct.entity.BankAccount;
import com.nttdata.serviceproduct.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    //Obtener el listado de todos los movimientos bancarios de un cliente por su numeor de cuenta
    @Query(nativeQuery = true, value ="SELECT * FROM tbl_transactios WHERE bank_account_id= :bank_account_id")
    public List<Transaction> findTransactionByBankAccountId(@Param(value = "bank_account_id") Long bank_account_id);
}
