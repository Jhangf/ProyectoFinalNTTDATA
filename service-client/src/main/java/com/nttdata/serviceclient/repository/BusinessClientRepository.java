package com.nttdata.serviceclient.repository;

import com.nttdata.serviceclient.entity.BusinessClient;
import com.nttdata.serviceclient.entity.PersonalClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BusinessClientRepository extends JpaRepository<BusinessClient,Long> {

    //Obtener si el cliente es empresarial pero por id del cleinte
    @Query(nativeQuery = true, value = "SELECT * FROM tbl_business_clients WHERE client_id = :clientId")
    public BusinessClient findClientBusiness(@Param(value = "clientId") Long ClientId);
}
