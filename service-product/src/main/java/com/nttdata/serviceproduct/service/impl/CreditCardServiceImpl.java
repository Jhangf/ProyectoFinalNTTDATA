package com.nttdata.serviceproduct.service.impl;

import com.nttdata.serviceproduct.entity.CreditCard;
import com.nttdata.serviceproduct.repository.CreditCardRepository;
import com.nttdata.serviceproduct.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CreditCardServiceImpl implements  CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Override
    public List<CreditCard> listAllCreditCards() {
        return creditCardRepository.findAll();
    }

    @Override
    public CreditCard getCreditCard(Long id) {
        return creditCardRepository.findById(id).orElse(null);
    }

    @Override
    public CreditCard saveCreditCard(CreditCard creditCard) {
        creditCard.setCreateAt(new Date()); //Guardar fecha actual de la creacion
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard updateCreditCard(Long id, CreditCard creditCard) {
        CreditCard cc= getCreditCard(id);
        if (cc==null){
            return null;
        }else
        {
            cc.setAccountNumber(creditCard.getAccountNumber());
            cc.setAmountSpent(creditCard.getAmountSpent());
            cc.setExpirationDate(creditCard.getExpirationDate());
            cc.setMaximumAmount(creditCard.getMaximumAmount());
            return creditCardRepository.save(cc);
        }

    }

    @Override
    public boolean deleteCreditCard(Long id) {
        try{
            creditCardRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
