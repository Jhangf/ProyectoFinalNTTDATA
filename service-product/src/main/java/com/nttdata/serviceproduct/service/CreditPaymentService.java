package com.nttdata.serviceproduct.service;


import com.nttdata.serviceproduct.entity.CreditPayment;

import java.util.List;

public interface CreditPaymentService {

    //Listar todas los pagos
    public List<CreditPayment> listAllCreditPayments();

    //Obtener una pago de credito por id
    public CreditPayment getCreditPayment(Long id);

    //guardar un nuevo pago de credito
    public CreditPayment saveCreditPayment(CreditPayment creditPayment);

    //Actualizar un pago de credito
    public CreditPayment updateCreditPayment(Long id, CreditPayment creditPayment);

    //Eliminar un pago de credito
    public boolean deleteCreditPayment(Long id);
}
