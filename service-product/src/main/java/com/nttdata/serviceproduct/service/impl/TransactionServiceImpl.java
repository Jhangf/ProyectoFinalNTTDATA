package com.nttdata.serviceproduct.service.impl;

import com.nttdata.serviceproduct.client.CustomerClient;
import com.nttdata.serviceproduct.entity.BankAccount;
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

        //obtenemos el monto de la transaccion el cual actualziara la cuenta bancaria
        double monto = transaction.getAmount();
        //Obtenemos los datos del numero de cuenta en los que se quiere actualziar sus datos
        BankAccount bankAccount = bankAccountService.getBankAccount(transaction.getBankAccount().getId());
        if(transaction.getTypeTransaction().getId()==1){
            if (bankAccount.getTypeBankAccount().getId()==1){
                if (bankAccount.getNumberMoves()==0){
                    return null; //Cuenta llega a limite de movimientos
                }else {
                    bankAccount.setNumberMoves(bankAccount.getNumberMoves()-1);
                    bankAccountService.updateBankAccount(transaction.getBankAccount().getId(),bankAccount);
                }
            }else if (bankAccount.getTypeBankAccount().getId()==3)
            {
                if (!bankAccount.isWithdrawalOrDeposit()){
                    return null; //
                }else {
                    bankAccount.setWithdrawalOrDeposit(false);
                    bankAccountService.updateBankAccount(transaction.getBankAccount().getId(),bankAccount);
                }
            }
            //En este caso la transaccion es de tipo DEPOSITO, sumamos
            bankAccountService.updateBankAccountAmount(transaction.getBankAccount().getId(),monto);
        }else {
            if(bankAccount.getTotalAmountInAccount()-monto<=0){
                return null;
            }else {
                if (bankAccount.getTypeBankAccount().getId()==1){
                    if (bankAccount.getNumberMoves()==0){
                        return null; //Cuenta llega a limite de movimientos
                    }else {
                        bankAccount.setNumberMoves(bankAccount.getNumberMoves()-1);
                        bankAccountService.updateBankAccount(transaction.getBankAccount().getId(),bankAccount);
                    }
                }else if (bankAccount.getTypeBankAccount().getId()==3)
                {
                    if (!bankAccount.isWithdrawalOrDeposit()){
                        return null; //
                    }else {
                        bankAccount.setWithdrawalOrDeposit(false);
                        bankAccountService.updateBankAccount(transaction.getBankAccount().getId(),bankAccount);
                    }
                }
                //En este caso la transaccion es de Tipo Retiro entonces restamos
                bankAccountService.updateBankAccountAmount(transaction.getBankAccount().getId(),monto*-1);
            }
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

    @Override
    public List<Transaction> findTransactionsByBankAccountId(Long id) {
        return transactionRepository.findTransactionByBankAccountId(id);
    }
}
