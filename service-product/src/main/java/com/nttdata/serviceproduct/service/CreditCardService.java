package com.nttdata.serviceproduct.service;

import com.nttdata.serviceproduct.entity.BankAccount;
import com.nttdata.serviceproduct.entity.CreditCard;
import com.nttdata.serviceproduct.entity.Transaction;

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

    //Actualizar el dienro en la tarjeta
    public CreditCard updateAmountCreditCard(Long id, Double moneyDeposited );

    //Obtener tarjetas de credito por id del clietne
    public  List<CreditCard> findCreditCardByIdClient(Long id);
}
