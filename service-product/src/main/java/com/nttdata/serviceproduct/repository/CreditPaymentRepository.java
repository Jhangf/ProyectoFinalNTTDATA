package com.nttdata.serviceproduct.repository;

import com.nttdata.serviceproduct.entity.CreditPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditPaymentRepository extends JpaRepository<CreditPayment,Long> {
}
