package com.nttdata.serviceproduct.service;


import com.nttdata.serviceproduct.entity.Transaction;

import java.util.List;

public interface TransactionService {

    //Listar todas las transacciones
    public List<Transaction> listAllTransactions();

    //Obtener una transaccion por id
    public Transaction getTransaction(Long id);

    //Guardar una neuva transaccion
    public Transaction saveTransaction(Transaction transaction);

    //Actualizar una nueva transaccion
    public Transaction updateTransaction(Long id, Transaction transaction);

    //Eliminar una transaccion
    public boolean deleteTransaction(Long id);
}
