package com.nttdata.serviceproduct.repository;

import com.nttdata.serviceproduct.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {

    //Cargando cargos a la tardejta de credito hasta antes de superar el limite

    
}
