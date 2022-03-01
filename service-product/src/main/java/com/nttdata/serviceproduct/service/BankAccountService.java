package com.nttdata.serviceproduct.service;

import com.nttdata.serviceproduct.entity.BankAccount;

import java.util.List;

public interface BankAccountService {

    //Listar todas las cuentas bancarias
    public List<BankAccount> listAllBankAccount();

    //Obtener una cuenta bancaria por id
    public BankAccount getBankAccount(Long id);

    //Crear una cuenta bancaria
    public BankAccount saveBankAccount(BankAccount bankAccount);

    //Actualizar una cuenta bancaria
    public BankAccount updateBankAccount(Long id, BankAccount bankAccount);

    //Eliminar cuenta bancaria
    public boolean deleteBankAccount(Long id);
}
