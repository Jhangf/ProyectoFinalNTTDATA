package com.nttdata.serviceclient.service.impl;

import com.nttdata.serviceclient.entity.Client;
import com.nttdata.serviceclient.repository.ClientRepository;
import com.nttdata.serviceclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Client> listAllClients() {
        return  clientRepository.findAll();
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
