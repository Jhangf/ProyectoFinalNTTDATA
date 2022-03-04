package com.nttdata.serviceproduct.service.impl;

import com.nttdata.serviceproduct.client.CustomerClient;
import com.nttdata.serviceproduct.entity.BankAccount;
import com.nttdata.serviceproduct.model.BusinessClient;
import com.nttdata.serviceproduct.model.Client;
import com.nttdata.serviceproduct.model.PersonalClient;
import com.nttdata.serviceproduct.repository.BankAccountRepository;
import com.nttdata.serviceproduct.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    CustomerClient customerClient;
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccount> listAllBankAccount() {

        return bankAccountRepository.findAll();
    }

    /*@Override
    public BankAccount getBankAccount(Long id) {

        return bankAccountRepository.findById(id).orElse(null);
    }*/
    @Override
    public BankAccount getBankAccount(Long id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElse(null);

        //Buscar el cliente y colocarlo en cuenta bancaria
        Client client = customerClient.getClient(bankAccount.getClientId()).getBody();
        bankAccount.setClient(client);
        return bankAccount ;
    }

    @Override
    public BankAccount saveBankAccount(BankAccount bankAccount) {
        //Obtener el id del cliente a guardar su cuenta
        Long id = bankAccount.getClientId();
        AtomicInteger n= new AtomicInteger();
        bankAccount.setCreateAt(new Date()); //guardar fecha actual
        //Buscamos sus cuentas registradas
        List<BankAccount> list = findBankAccountByIdClient(id);

        //contamos cuantas cuentas tiene el cliente
        Long x = list.stream().count();

        //Verificamos si existe una cuenta a plazao fijo para podr agegar otra
        list.stream().forEach(p->{if(p.getTypeBankAccount().getId()==3) {n.getAndIncrement();}});

        //Obtenemos el tipo de cliente que es
        Client client = customerClient.getClient(bankAccount.getClientId()).getBody();
            if( x==0 && client.getTypeClient()==1){
                return bankAccountRepository.save(bankAccount);
            }else if( n.get() >0 && bankAccount.getTypeBankAccount().getId()==3 && client.getTypeClient()==1){
                return bankAccountRepository.save(bankAccount);
            }else if(client.getTypeClient()==2 && bankAccount.getTypeBankAccount().getId()==2){
                return bankAccountRepository.save(bankAccount);
            } else return null;
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

    //Metodo para actualizar el dinero en la cuenta bancaria por deposito o retiro
    @Override
    public BankAccount updateBankAccountAmount(Long id, Double moneyDeposited) {
        BankAccount bankAccountDB = getBankAccount(id);
        if (null== bankAccountDB){
            return null;
        }
        Double money = bankAccountDB.getTotalAmountInAccount()+moneyDeposited;
        bankAccountDB.setTotalAmountInAccount(money);
        return bankAccountRepository.save(bankAccountDB);
    }

    @Override
    public List<BankAccount> findBankAccountByIdClient(Long id) {
        return bankAccountRepository.findBankAccountByClientId(id);
    }


}
