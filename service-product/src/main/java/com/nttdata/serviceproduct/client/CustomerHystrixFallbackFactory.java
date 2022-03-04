package com.nttdata.serviceproduct.client;

import com.nttdata.serviceproduct.model.BusinessClient;
import com.nttdata.serviceproduct.model.Client;
import com.nttdata.serviceproduct.model.PersonalClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerHystrixFallbackFactory implements CustomerClient{
    @Override
    public ResponseEntity<Client> getClient(Long id) {
        Client client = Client.builder().typeClient(0).build();
        return ResponseEntity.ok(client);
    }

    @Override
    public ResponseEntity<PersonalClient> getPersonalClientByIdClient(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<BusinessClient> getBusinessClient(Long id) {
        return null;
    }
}
