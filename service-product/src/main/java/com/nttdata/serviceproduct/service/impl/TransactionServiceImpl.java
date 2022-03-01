package com.nttdata.serviceproduct.service.impl;

import com.nttdata.serviceproduct.entity.Transaction;
import com.nttdata.serviceproduct.repository.TransactionRepository;
import com.nttdata.serviceproduct.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> listAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        transaction.setCreateAt(new Date());
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
