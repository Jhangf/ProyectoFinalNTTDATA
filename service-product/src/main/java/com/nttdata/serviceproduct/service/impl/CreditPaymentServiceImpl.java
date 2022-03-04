package com.nttdata.serviceproduct.service.impl;

import com.nttdata.serviceproduct.entity.CreditPayment;
import com.nttdata.serviceproduct.repository.CreditPaymentRepository;
import com.nttdata.serviceproduct.service.CreditPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CreditPaymentServiceImpl implements CreditPaymentService {

    @Autowired
    CreditPaymentRepository creditPaymentRepository;
    @Override
    public List<CreditPayment> listAllCreditPayments() {

        return creditPaymentRepository.findAll();
    }

    @Override
    public CreditPayment getCreditPayment(Long id) {
        return creditPaymentRepository.findById(id).orElse(null);
    }

    @Override
    public CreditPayment saveCreditPayment(CreditPayment creditPayment) {
        creditPayment.setCreateAt(new Date()); //Fecha actual de creacion
        return creditPaymentRepository.save(creditPayment);
    }

    @Override
    public CreditPayment updateCreditPayment(Long id, CreditPayment creditPayment) {
        CreditPayment cp = getCreditPayment(id);
        if (cp==null){
            return null;
        }else {
            cp.setInstallmentNumber(creditPayment.getInstallmentNumber());
            cp.setAmountPaid(creditPayment.getAmountPaid());
            cp.setRemainingAmount(creditPayment.getRemainingAmount());
            cp.setPaymentDate(creditPayment.getPaymentDate());
            return creditPaymentRepository.save(cp);
        }
    }
    @Override
    public boolean deleteCreditPayment(Long id) {
        try{
            creditPaymentRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
