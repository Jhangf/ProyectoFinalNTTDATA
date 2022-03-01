package com.nttdata.serviceproduct.service;


import com.nttdata.serviceproduct.entity.Credit;

import java.util.List;

public interface CreditService {

    //Listar todas las creditos
    public List<Credit> listAllCredits();

    //Obtener un credito por id
    public Credit getCredit(Long id);

    //Crear un credito
    public Credit saveCredit(Credit credit);

    //Actualizar un credito
    public Credit updateCredit(Long id, Credit credit);

    //Eliminar credito
    public boolean deleteCredit(Long id);
}
