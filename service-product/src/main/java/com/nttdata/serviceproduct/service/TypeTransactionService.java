package com.nttdata.serviceproduct.service;


import com.nttdata.serviceproduct.entity.TypeTransaction;

import java.util.List;

public interface TypeTransactionService {

    //Listar todos los tipos de transacciones
    public List<TypeTransaction> listAllTypeTransaction();

    //Obtener un tipo de  transaccion por id
    public TypeTransaction getTypeTransaction(Long id);

    //Crear un tipo de transaccion
    public TypeTransaction saveTypeTransaction(TypeTransaction typeTransaction);

    //Actualizar un tipo de transaccion
    public TypeTransaction updateTypeTransaction(Long id, TypeTransaction typeTransaction);

    //Eliminar un tipo de transaccion
    public boolean deleteTypeTransaction(Long id);
}
