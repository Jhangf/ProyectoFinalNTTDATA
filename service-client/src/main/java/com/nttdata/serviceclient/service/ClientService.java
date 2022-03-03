package com.nttdata.serviceclient.service;

import com.nttdata.serviceclient.entity.Client;
import com.nttdata.serviceclient.entity.Holder;

import java.util.List;

public interface ClientService {

    //Listar todos los Clientes
    public List<Client> listAllClients();

    //Listar un  cliente por ID
    public Client getClient(Long id);
}
