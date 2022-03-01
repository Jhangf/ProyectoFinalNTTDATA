package com.nttdata.serviceproduct.service.impl;

import com.nttdata.serviceproduct.entity.BankAccount;
import com.nttdata.serviceproduct.repository.BankAccountRepository;
import com.nttdata.serviceproduct.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccount> listAllBankAccount() {
        return bankAccountRepository.findAll();
    }

    @Override
    public BankAccount getBankAccount(Long id) {
        return bankAccountRepository.findById(id).orElse(null);
    }

    @Override
    public BankAccount saveBankAccount(BankAccount bankAccount) {
        bankAccount.setCreateAt(new Date()); //guardar fecha actual
        return bankAccountRepository.save(bankAccount) ;
    }

    @Override
    public BankAccount updateBankAccount(Long id, BankAccount bankAccount) {
        BankAccount bankAccountDB = getBankAccount(id);
        if(bankAccountDB==null){
            return null;
        }else {
            bankAccountDB.setAccountNumber(bankAccount.getAccountNumber());
            bankAccountDB.setMaintenanceFee(bankAccount.isMaintenanceFee());
            bankAccountDB.setMaintenanceCost(bankAccount.getMaintenanceCost());
            bankAccountDB.setMovementLimit(bankAccount.isMovementLimit());
            bankAccountDB.setNumberMoves(bankAccount.getNumberMoves());
            bankAccountDB.setWithdrawalOrDeposit(bankAccount.isWithdrawalOrDeposit());
            bankAccountDB.setTotalAmountInAccount(bankAccount.getTotalAmountInAccount());
            return bankAccountRepository.save(bankAccountDB);
        }

    }

    @Override
    public boolean deleteBankAccount(Long id) {
        try{
            bankAccountRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
