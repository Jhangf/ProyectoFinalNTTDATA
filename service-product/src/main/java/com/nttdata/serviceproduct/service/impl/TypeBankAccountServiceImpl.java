package com.nttdata.serviceproduct.service.impl;

import com.nttdata.serviceproduct.entity.TypeBankAccount;
import com.nttdata.serviceproduct.repository.TypeBankAccountRepository;
import com.nttdata.serviceproduct.service.TypeBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TypeBankAccountServiceImpl implements TypeBankAccountService {

    @Autowired
    private TypeBankAccountRepository typeBankAccountRepository;

    @Override
    public List<TypeBankAccount> listAllTypeBankAccount() {
        return typeBankAccountRepository.findAll();
    }

    @Override
    public TypeBankAccount getTypeBankAccount(Long id) {
        return typeBankAccountRepository.findById(id).orElse(null);
    }

    @Override
    public TypeBankAccount saveTypeBankAccount(TypeBankAccount typeBankAccount) {
        typeBankAccount.setCreateAt(new Date()); //Guardar fecha actual
        return typeBankAccountRepository.save(typeBankAccount);
    }

    @Override
    public TypeBankAccount updateTypeBankAccount(Long id, TypeBankAccount typeBankAccount) {
        TypeBankAccount tba = getTypeBankAccount(id);
        if (tba==null){
            return null;
        }else {
            tba.setName(typeBankAccount.getName());
            return typeBankAccountRepository.save(tba);
        }
    }

    @Override
    public boolean deleteTypeBankAccount(Long id) {
        try{
            typeBankAccountRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
