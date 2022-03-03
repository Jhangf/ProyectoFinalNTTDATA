package com.nttdata.serviceproduct.service.impl;

import com.nttdata.serviceproduct.client.CustomerClient;
import com.nttdata.serviceproduct.entity.Transaction;
import com.nttdata.serviceproduct.repository.BankAccountRepository;
import com.nttdata.serviceproduct.repository.TransactionRepository;
import com.nttdata.serviceproduct.service.BankAccountService;
import com.nttdata.serviceproduct.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    //Traemos el cliente de tipo personal

    @Autowired
    CustomerClient customerClient;

    //Traemos la cuenta bancaria del cliente
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public List<Transaction> listAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }



    @Autowired
    BankAccountService bankAccountService;

    //Al guardar una transaccion actualizamos el dinero en la cuenta bancaria
    @Override
    public Transaction saveTransaction(Transaction transaction) {
        transaction.setCreateAt(new Date());
        double monto = transaction.getAmount(); //obtenemops el monto de la transaccion el cual actualziara la cuenta bancaria
        if(transaction.getTypeTransaction().getId()==1){
            //En este caso la transaccion es de tipo DEPOSITO, sumamos
            bankAccountService.updateBankAccountAmount(transaction.getBankAccount().getId(),monto);
        }else {
            //En este caso la transaccion es de Tipo Retiro entonces restamos
            bankAccountService.updateBankAccountAmount(transaction.getBankAccount().getId(),monto*-1);
        }
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Long id, Transaction transaction) {
        Transaction t = getTransaction(id);
        if (t==null){
            return null;
        }else {
            t.setAmount(t.getAmount());
            return transactionRepository.save(t);
        }
    }

    @Override
    public boolean deleteTransaction(Long id) {
        try{
            transactionRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
