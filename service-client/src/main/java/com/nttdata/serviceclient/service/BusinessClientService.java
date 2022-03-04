package com.nttdata.serviceclient.service;

import com.nttdata.serviceclient.entity.BusinessClient;
import com.nttdata.serviceclient.entity.PersonalClient;

import java.util.List;

public interface BusinessClientService {

    //Listar Clientes Empresariales
    public List<BusinessClient> listAllBusinessClient();

    //Listar un cliente empresarial por su id
    public BusinessClient getBusinessClient(Long id);

    //Guardar un cliente empresarial
    public  BusinessClient saveBusinessClient(BusinessClient businessClient);

    //Actualizar Cliente empresarial
    public  BusinessClient updateBusinessClient(Long id, BusinessClient businessClient);

    //Eliminar cliente Empresarial
    public boolean deleteBusinessClient(Long id);

    //Otener un cliente empresarial por id del cliente
    public BusinessClient getBusinessClientByIdClient(Long id);
}
