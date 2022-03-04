package com.nttdata.serviceproduct.repository;

import com.nttdata.serviceproduct.entity.BankAccount;
import com.nttdata.serviceproduct.model.Client;
import com.nttdata.serviceproduct.model.PersonalClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {

    //Obtener el id del cliente conectando con smicroservicio client
    public List<BankAccount> findByClientId(Long clientId);


    //Obtener cuentas bancarias listando por clientes
    @Query(nativeQuery = true, value ="SELECT * FROM tbl_bank_accounts WHERE client_id= :clientId")
    public List<BankAccount> findBankAccountByClientId(@Param(value = "clientId") Long ClientId);

}
