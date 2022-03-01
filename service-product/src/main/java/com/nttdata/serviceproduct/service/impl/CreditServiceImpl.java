package com.nttdata.serviceproduct.service.impl;

import com.nttdata.serviceproduct.entity.Credit;
import com.nttdata.serviceproduct.repository.CreditRepository;
import com.nttdata.serviceproduct.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public List<Credit> listAllCredits() {
        return creditRepository.findAll();
    }

    @Override
    public Credit getCredit(Long id) {
        return creditRepository.findById(id).orElse(null);
    }

    @Override
    public Credit saveCredit(Credit credit) {
        credit.setCreateAt(new Date()); //Toamr hora y fecha actual
        return creditRepository.save(credit);
    }

    @Override
    public Credit updateCredit(Long id, Credit credit) {
        Credit c = getCredit(id);
        if(c==null){
            return null;
        }else {
            c.setBorrowedAmount(credit.getBorrowedAmount());
            c.setNumberOfInstallments(credit.getNumberOfInstallments());
            c.setTime(credit.getTime());
            c.setInterest(credit.getInterest());
            return creditRepository.save(c);
        }
    }

    @Override
    public boolean deleteCredit(Long id) {
        try{
            creditRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
