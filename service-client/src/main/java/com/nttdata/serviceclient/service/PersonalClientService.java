package com.nttdata.serviceclient.service;

import com.nttdata.serviceclient.entity.PersonalClient;

import java.util.List;

public interface PersonalClientService {
    //Listar todos los clientes de tipo personal
    public List<PersonalClient> listAllPersonalClient();


    //Listar Cliente de tipo Personal por ID
    public PersonalClient getPersonalClient(Long id);

    //Guardar Cliente Personal
    public PersonalClient savePersonalClient(PersonalClient personalClient);

    //Actualizar Cliente tipo Personal
    public PersonalClient updatePersonalClient(Long id, PersonalClient personalClient);

    //Eliminar Cliente tipo Personal
    public boolean deletePersonalClient(Long id);

    //Otener un cliente Personal por id del cliente
    public PersonalClient getPersonalClientByIdClient(Long id);
}
