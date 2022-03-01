package com.nttdata.serviceproduct.service.impl;

import com.nttdata.serviceproduct.entity.TypeTransaction;
import com.nttdata.serviceproduct.repository.TypeTransactionRepository;
import com.nttdata.serviceproduct.service.TypeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TypeTransactionServiceImpl implements TypeTransactionService {

    @Autowired
    private TypeTransactionRepository typeTransactionRepository;

    @Override
    public List<TypeTransaction> listAllTypeTransaction() {
        return typeTransactionRepository.findAll();
    }

    @Override
    public TypeTransaction getTypeTransaction(Long id) {
        return typeTransactionRepository.findById(id).orElse(null);
    }

    @Override
    public TypeTransaction saveTypeTransaction(TypeTransaction typeTransaction) {
        typeTransaction.setCreateAt(new Date()); //Guardar fecha actual
        return typeTransactionRepository.save(typeTransaction);
    }

    @Override
    public TypeTransaction updateTypeTransaction(Long id, TypeTransaction typeTransaction) {
        TypeTransaction tt = getTypeTransaction(id);
        if(tt==null){
            return null;
        }else {
            tt.setName(typeTransaction.getName());
            return typeTransactionRepository.save(tt);
        }
    }

    @Override
    public boolean deleteTypeTransaction(Long id) {
        try{
            typeTransactionRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
