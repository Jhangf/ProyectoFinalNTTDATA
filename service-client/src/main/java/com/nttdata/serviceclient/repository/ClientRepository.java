package com.nttdata.serviceclient.repository;

import com.nttdata.serviceclient.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

    // @Query(nativeQuery = true,value = "SELECT C.id,C.email FROM tbl_clients C INNER JOIN tbl_personals_clients PC on C.id = PC.client_id")
    //public List<Client> findByAll();

    //Listar Clientes de tipo Personal
    //Listar clientes de tipo Empresarial

}
