package com.nttdata.serviceproduct.service;


import com.nttdata.serviceproduct.entity.TypeBankAccount;

import java.util.List;

public interface TypeBankAccountService {

    //Listar todas los tipos de cuentas bancarias
    public List<TypeBankAccount> listAllTypeBankAccount();

    //Obtener un tipo de cuenta bancaria por id
    public TypeBankAccount getTypeBankAccount(Long id);

    //Crear un tipo de cuenta bancaria
    public TypeBankAccount saveTypeBankAccount(TypeBankAccount typeBankAccount);

    //Actualizar un tipo de ceunta bancaria
    public TypeBankAccount updateTypeBankAccount(Long id, TypeBankAccount typeBankAccount);

    //Eliminar un tipo de cuenta bancaria
    public boolean deleteTypeBankAccount(Long id);
}
