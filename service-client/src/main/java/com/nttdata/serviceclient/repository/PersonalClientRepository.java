package com.nttdata.serviceclient.repository;

import com.nttdata.serviceclient.entity.PersonalClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonalClientRepository extends JpaRepository<PersonalClient,Long> {

    //Obtener si el cliente es personal
    @Query(nativeQuery = true, value = "SELECT * FROM tbl_personals_clients WHERE client_id = :clientId")
    public PersonalClient findClientPersonal(@Param(value = "clientId") Long ClientId);
}
