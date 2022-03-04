package com.nttdata.serviceproduct.repository;

import com.nttdata.serviceproduct.entity.BankAccount;
import com.nttdata.serviceproduct.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {


    //Obtener las tarjetas de credito listando por clientes
    @Query(nativeQuery = true, value ="SELECT * FROM tbl_credits_cards WHERE client_id= :clientId")
    public List<CreditCard> findCreditCardByClientId(@Param(value = "clientId") Long ClientId);


}
