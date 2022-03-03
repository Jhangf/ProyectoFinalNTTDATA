package com.nttdata.serviceproduct.controller;

import com.nttdata.serviceproduct.client.CustomerClient;
import com.nttdata.serviceproduct.entity.*;
import com.nttdata.serviceproduct.model.Client;
import com.nttdata.serviceproduct.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductRest {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private CreditPaymentService creditPaymentService;

    @Autowired
    private CreditService creditService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TypeBankAccountService typeBankAccountService;

    @Autowired
    private TypeTransactionService typeTransactionService;

    //Traemos al cleinte para el listado de cuenats bancarias
    @Autowired
    private CustomerClient customerClient;

    //REST CUENTAS BANCARIAS

    //Listar cuentas bancarias
    @GetMapping(value = "/bankAccounts")
    public ResponseEntity<List<BankAccount>> listBankAccounts(@RequestParam(name = "clientId", required = false) Long clientId ){
       /* List<BankAccount> bankAccounts = bankAccountService.listAllBankAccount();
        if(bankAccounts.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(bankAccounts);
        }*/
        List<BankAccount> bankAccounts = new ArrayList<>();
        if(null==clientId){
            bankAccounts = bankAccountService.listAllBankAccount();
            if (bankAccounts.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else{
            bankAccounts = bankAccountService.findBankAccountByIdClient(clientId);
            if (bankAccounts.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(bankAccounts);
    }

    //Listar una cuenta bancaria por su id
    @GetMapping(value = "/bankAccounts/{id}")
    public ResponseEntity<BankAccount> getBankAccount(@PathVariable Long id){
        BankAccount ba = bankAccountService.getBankAccount(id);
        if(ba.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(ba);
        }
    }

    //Crear cuenta bancaria
    @PostMapping(value = "/bankAccounts")
    public ResponseEntity<BankAccount> saveBankAccount( @RequestBody BankAccount bankAccount){
        try {
            BankAccount ba = bankAccountService.saveBankAccount(bankAccount);
            if (ba.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new BankAccount());
            }else{
                return ResponseEntity.ok(ba);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BankAccount());
        }
    }

    @PutMapping(value = "/bankAccounts/{id}")
    public ResponseEntity<BankAccount> updateBankAccount(@PathVariable Long id, @RequestBody BankAccount bankAccount){
        BankAccount ba = bankAccountService.updateBankAccount(id,bankAccount);
        if(ba.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new BankAccount());
        }else {
            return ResponseEntity.ok(ba);
        }
    }

    //Actualizar el monto total de la cuenta bancaria
    @PutMapping (value = "/bankAccounts/{id}/amountAccount")
    public ResponseEntity<BankAccount> updaAmountAccount(@PathVariable  Long id ,@RequestParam(name = "amount", required = true) Double amount){
        BankAccount bankAccount = bankAccountService.updateBankAccountAmount(id,amount);
        if (bankAccount == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bankAccount);
    }

    @DeleteMapping(value = "/bankAccounts/{id}")
    public ResponseEntity<BankAccount> deleteBankAccount(@PathVariable Long id){
        if(bankAccountService.deleteBankAccount(id)){
            return ResponseEntity.ok(new BankAccount());
        }else {
            return   ResponseEntity.badRequest().build();
        }
    }

    //REST TARJETA DE CREDITO

    //Listar tarjetas de credito
    @GetMapping(value = "/creditCards")
    public ResponseEntity<List<CreditCard>> listCreditCards(){
        List<CreditCard> creditCards = creditCardService.listAllCreditCards();
        if(creditCards.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(creditCards);
        }
    }

    //Listar una atrjeta de credito por su id
    @GetMapping(value = "/creditCards/{id}")
    public ResponseEntity<CreditCard> getCreditCard(@PathVariable Long id){
        CreditCard cc = creditCardService.getCreditCard(id);
        if(cc.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(cc);
        }
    }

    //Crear una tarjeta de credito
    @PostMapping(value = "/creditCards")
    public ResponseEntity<CreditCard> saveCreditCard( @RequestBody CreditCard creditCard){
        try {
            CreditCard cc = creditCardService.saveCreditCard(creditCard);
            if (cc.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new CreditCard());
            }else{
                return ResponseEntity.ok(cc);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreditCard());
        }
    }

    @PutMapping(value = "/creditCards/{id}")
    public ResponseEntity<CreditCard> updateCreditCard(@PathVariable Long id, @RequestBody CreditCard creditCard){
        CreditCard cc = creditCardService.updateCreditCard(id,creditCard);
        if(cc.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new CreditCard());
        }else {
            return ResponseEntity.ok(cc);
        }
    }

    @DeleteMapping(value = "/creditCards/{id}")
    public ResponseEntity<CreditCard> deleteCreditCard(@PathVariable Long id){
        if(creditCardService.deleteCreditCard(id)){
            return ResponseEntity.ok(new CreditCard());
        }else {
            return   ResponseEntity.badRequest().build();
        }
    }

    //REST PAGOS DE CREDITOS

    //Listar pagos de creditos
    @GetMapping(value = "/credits/creditPayments")
    public ResponseEntity<List<CreditPayment>> listCreditPayments(){
        List<CreditPayment> creditPayments = creditPaymentService.listAllCreditPayments();
        if(creditPayments.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(creditPayments);
        }
    }

    //Listar un apgo de un credito por su id
    @GetMapping(value = "/credits/creditPayments/{id}")
    public ResponseEntity<CreditPayment> getCreditPayment(@PathVariable Long id){
        CreditPayment cp = creditPaymentService.getCreditPayment(id);
        if(cp.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(cp);
        }
    }

    //Guardar un apgo de un credito
    @PostMapping(value = "/credits/creditPayments")
    public ResponseEntity<CreditPayment> saveCreditPayment( @RequestBody CreditPayment creditPayment){
        try {
            CreditPayment cp = creditPaymentService.saveCreditPayment(creditPayment);
            if (cp.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new CreditPayment());
            }else{
                return ResponseEntity.ok(cp);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreditPayment());
        }
    }

    //Actualizar un pago de credito
    @PutMapping(value = "/credits/creditPayments/{id}")
    public ResponseEntity<CreditPayment> updateCreditPayment(@PathVariable Long id, @RequestBody CreditPayment creditPayment){
        CreditPayment cp = creditPaymentService.updateCreditPayment(id,creditPayment);
        if(cp.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new CreditPayment());
        }else {
            return ResponseEntity.ok(cp);
        }
    }

    @DeleteMapping(value = "/credits/creditPayments/{id}")
    public ResponseEntity<CreditPayment> deleteCreditPayment(@PathVariable Long id){
        if(creditPaymentService.deleteCreditPayment(id)){
            return ResponseEntity.ok(new CreditPayment());
        }else {
            return   ResponseEntity.badRequest().build();
        }
    }

    //REST PARA CREDITOS

    //Listar  creditos
    @GetMapping(value = "/credits")
    public ResponseEntity<List<Credit>> listCredits(){
        List<Credit> credits = creditService.listAllCredits();
        if(credits.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(credits);
        }
    }

    //Listar  un credito por su id
    @GetMapping(value = "/credits/{id}")
    public ResponseEntity<Credit> getCredit(@PathVariable Long id){
        Credit c = creditService.getCredit(id);
        if(c.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(c);
        }
    }

    //Guardar un credito
    @PostMapping(value = "/credits")
    public ResponseEntity<Credit> saveCredit( @RequestBody Credit credit){
        try {
            Credit c = creditService.saveCredit(credit);
            if (c.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new Credit());
            }else{
                return ResponseEntity.ok(c);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Credit());
        }
    }

    //Actualizar un credito
    @PutMapping(value = "/credits/{id}")
    public ResponseEntity<Credit> updateCredit(@PathVariable Long id, @RequestBody Credit credit){
        Credit c = creditService.updateCredit(id,credit);
        if(c.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new Credit());
        }else {
            return ResponseEntity.ok(c);
        }
    }

    @DeleteMapping(value = "/credits/{id}")
    public ResponseEntity<Credit> deleteCredit(@PathVariable Long id){
        if(creditService.deleteCredit(id)){
            return ResponseEntity.ok(new Credit());
        }else {
            return   ResponseEntity.badRequest().build();
        }
    }

    //REST tipo de transaccion

    //Listar  todos lops tipos de transacciones
    @GetMapping(value = "/transactions/typeTransactions")
    public ResponseEntity<List<TypeTransaction>> listTypeTransactions(){
        List<TypeTransaction> typeTransaction = typeTransactionService.listAllTypeTransaction();
        if(typeTransaction.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(typeTransaction);
        }
    }

    //Listar  un tipo de transaccion por su id
    @GetMapping(value = "/transactions/typeTransactions/{id}")
    public ResponseEntity<TypeTransaction> getTypeTransaction(@PathVariable Long id){
        TypeTransaction tt = typeTransactionService.getTypeTransaction(id);
        if(tt.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(tt);
        }
    }

    //Generar un tipo transaccion
    @PostMapping(value = "/transactions/typeTransactions")
    public ResponseEntity<TypeTransaction> saveTypeTransaction( @RequestBody TypeTransaction typeTransaction){
        try {
            TypeTransaction tt = typeTransactionService.saveTypeTransaction(typeTransaction);
            if (tt.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new TypeTransaction());
            }else{
                return ResponseEntity.ok(tt);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new TypeTransaction());
        }
    }

    //Actualizar un tipo de transaccion
    @PutMapping(value = "/transactions/typeTransactions/{id}")
    public ResponseEntity<TypeTransaction> updateTypeTransaction(@PathVariable Long id, @RequestBody TypeTransaction typeTransaction){
        TypeTransaction tt = typeTransactionService.updateTypeTransaction(id,typeTransaction);
        if(tt.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new TypeTransaction());
        }else {
            return ResponseEntity.ok(tt);
        }
    }

    @DeleteMapping(value = "/transactions/typeTransactions/{id}")
    public ResponseEntity<TypeTransaction> deleteTypeTransaction(@PathVariable Long id){
        if(typeTransactionService.deleteTypeTransaction(id)){
            return ResponseEntity.ok(new TypeTransaction());
        }else {
            return   ResponseEntity.badRequest().build();
        }
    }

    //REST PARA TRANSACCIONES

    //Listar  todas las transacciones
    @GetMapping(value = "/transactions")
    public ResponseEntity<List<Transaction>> listTransactions(){
        List<Transaction> transaction = transactionService.listAllTransactions();
        if(transaction.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(transaction);
        }
    }

    //Listar  una transaccion por su id
    @GetMapping(value = "/transactions/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long id){
        Transaction t = transactionService.getTransaction(id);
        if(t.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(t);
        }
    }

    //Generar una transaccion
    @PostMapping(value = "/transactions")
    public ResponseEntity<Transaction> saveTransaction( @RequestBody Transaction transaction){
        try {
            Transaction t = transactionService.saveTransaction(transaction);
            if (t.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new Transaction());
            }else{
                return ResponseEntity.ok(t);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Transaction());
        }
    }

    //Actualizar una transaccion
    @PutMapping(value = "/transactions/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction){
        Transaction t = transactionService.updateTransaction(id,transaction);
        if(t.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new Transaction());
        }else {
            return ResponseEntity.ok(t);
        }
    }

    @DeleteMapping(value = "/transactions/{id}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable Long id){
        if(transactionService.deleteTransaction(id)){
            return ResponseEntity.ok(new Transaction());
        }else {
            return   ResponseEntity.badRequest().build();
        }
    }

    //REST PARA TIPO DE CUENTAS BANCARIAS
    //Listar  todas las cuentas bancarias
    @GetMapping(value = "/bankAccounts/typeBankAccounts")
    public ResponseEntity<List<TypeBankAccount>> listTypeBankAccounts(){
        List<TypeBankAccount> typeBankAccounts = typeBankAccountService.listAllTypeBankAccount();
        if(typeBankAccounts.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(typeBankAccounts);
        }
    }

    //Listar  tipo de cuenta bancaria por id
    @GetMapping(value = "/bankAccounts/typeBankAccounts/{id}")
    public ResponseEntity<TypeBankAccount> getTypeBankAccount(@PathVariable Long id){
        TypeBankAccount tba = typeBankAccountService.getTypeBankAccount(id);
        if(tba.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(tba);
        }
    }

    //Generar un tipo de cuenta bancaria
    @PostMapping(value = "/bankAccounts/typeBankAccounts")
    public ResponseEntity<TypeBankAccount> saveTypeBankAccount( @RequestBody TypeBankAccount typeBankAccount){
        try {
            TypeBankAccount tba = typeBankAccountService.saveTypeBankAccount(typeBankAccount);
            if (tba.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new TypeBankAccount());
            }else{
                return ResponseEntity.ok(tba);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new TypeBankAccount());
        }
    }

    //Actualizar tipo de cuenta bancaria
    @PutMapping(value = "/bankAccounts/typeBankAccounts/{id}")
    public ResponseEntity<TypeBankAccount> updateTypeBankAccount(@PathVariable Long id, @RequestBody TypeBankAccount typeBankAccount){
        TypeBankAccount tba = typeBankAccountService.updateTypeBankAccount(id,typeBankAccount);
        if(tba.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new TypeBankAccount());
        }else {
            return ResponseEntity.ok(tba);
        }
    }

    @DeleteMapping(value = "/bankAccounts/typeBankAccounts/{id}")
    public ResponseEntity<TypeBankAccount> deleteTypeBankAccount(@PathVariable Long id){
        if(typeBankAccountService.deleteTypeBankAccount(id)){
            return ResponseEntity.ok(new TypeBankAccount());
        }else {
            return   ResponseEntity.badRequest().build();
        }
    }
}
