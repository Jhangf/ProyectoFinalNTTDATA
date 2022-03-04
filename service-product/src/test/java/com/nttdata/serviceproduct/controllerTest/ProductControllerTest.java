package com.nttdata.serviceproduct.controllerTest;

import com.nttdata.serviceproduct.controller.ProductRest;
import com.nttdata.serviceproduct.entity.BankAccount;
import com.nttdata.serviceproduct.service.impl.BankAccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public class ProductControllerTest {

    @Mock
    BankAccountServiceImpl bankAccountServiceImpl;

    @InjectMocks
    ProductRest productRest;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_getListBankAccounts_whenExistBankAccounts(){
        Mockito.when(bankAccountServiceImpl.listAllBankAccount()).thenReturn(buildListBankAccounts());
        ResponseEntity<List<BankAccount>> response = productRest.listBankAccounts(null);

        Assertions.assertEquals(1,response.getBody().size());
        Assertions.assertEquals(200,response.getStatusCode().value());
    }

    private List<BankAccount> buildListBankAccounts(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(1L);
        bankAccount.setAccountNumber("1453202357896542365");
        bankAccount.setMaintenanceFee(false);
        bankAccount.setMaintenanceCost(250);
        bankAccount.setMovementLimit(false);
        bankAccount.setNumberMoves(0L);
        bankAccount.setWithdrawalOrDeposit(false);
        bankAccount.setTotalAmountInAccount(1500);
        bankAccount.setClientId(1L);

        return Arrays.asList(bankAccount);
    }
}
