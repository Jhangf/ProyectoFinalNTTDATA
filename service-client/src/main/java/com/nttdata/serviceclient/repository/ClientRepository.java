package com.nttdata.serviceclient.repository;

public interface ClientRepository {

    // @Query(nativeQuery = true,value = "SELECT C.id,C.email FROM tbl_clients C INNER JOIN tbl_personals_clients PC on C.id = PC.client_id")
    //public List<Client> findByAll();
}
