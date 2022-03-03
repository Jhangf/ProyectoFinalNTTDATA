package com.nttdata.serviceproduct.client;

import com.nttdata.serviceproduct.model.Client;
import com.nttdata.serviceproduct.model.PersonalClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-client", path = "/clients")
//@RequestMapping("/clients")
public interface CustomerClient {

    //Listar un cliente por id psado como parametro
    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id);

    // Listar un cliente Personal
    @GetMapping(value = "/personals/{id}")
    public ResponseEntity<PersonalClient> getPersonalClient(@PathVariable Long id);

}
