package com.nttdata.serviceproduct.repository;

import com.nttdata.serviceproduct.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit,Long> {
}
