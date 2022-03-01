package com.nttdata.serviceproduct.service;

import com.nttdata.serviceproduct.entity.CreditCard;

import java.util.List;

public interface CreditCardService {

    //Listar todas las tarjetas
    public List<CreditCard> listAllCreditCards();

    //Obtener una tarjeta por id
    public CreditCard getCreditCard(Long id);

    //Crear una tarjeta de credito
    public CreditCard saveCreditCard(CreditCard creditCard);

    //Actualizar una tarjeta de credito
    public CreditCard updateCreditCard(Long id, CreditCard creditCard);

    //Eliminar tarjeta de credito
    public boolean deleteCreditCard(Long id);
}
