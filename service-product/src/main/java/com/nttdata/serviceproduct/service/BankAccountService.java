package com.nttdata.serviceproduct.service;

import com.nttdata.serviceproduct.entity.BankAccount;
import com.nttdata.serviceproduct.model.Client;

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

    //Actualizar el dienro en la cuenta bancaria
    public BankAccount updateBankAccountAmount(Long id, Double moneyDeposited );

    //Obtener Cuentas bancarias por id del clietne
    public  List<BankAccount> findBankAccountByIdClient(Long id);

}
