package com.nttdata.serviceclient.repository;

import com.nttdata.serviceclient.entity.BusinessClient;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BusinessClientRepository extends JpaRepository<BusinessClient,Long> {

}
