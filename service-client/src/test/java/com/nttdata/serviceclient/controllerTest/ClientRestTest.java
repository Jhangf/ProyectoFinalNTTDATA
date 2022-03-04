package com.nttdata.serviceclient.controllerTest;

import com.nttdata.serviceclient.controller.ClientRest;
import com.nttdata.serviceclient.entity.Client;
import com.nttdata.serviceclient.entity.PersonalClient;
import com.nttdata.serviceclient.service.impl.PersonalClientServiceImpl;
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

public class ClientRestTest {

    @Mock
    PersonalClientServiceImpl personalClientServiceImpl;

    @InjectMocks
    ClientRest clientRest;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void test_getListClientsPersonals_whenExistClientsPersonals(){
        Mockito.when(personalClientServiceImpl.listAllPersonalClient()).thenReturn(builListClientPersonals());
        ResponseEntity<List<PersonalClient>> response = clientRest.listPersonalClient();

        Assertions.assertEquals(1,response.getBody().size());
        Assertions.assertEquals(200,response.getStatusCode().value());

    }

    @Test
    public void test_getListClientsPersonals_whenNotExistClientsPersonals(){
        Mockito.when(personalClientServiceImpl.listAllPersonalClient()).thenReturn(builListClientPersonals());
        ResponseEntity<List<PersonalClient>> response = clientRest.listPersonalClient();

        Assertions.assertTrue(response.hasBody());
        Assertions.assertEquals(200,response.getStatusCode().value());
    }


    private List<PersonalClient> builListClientPersonals(){
        PersonalClient personalClient = new PersonalClient();
        personalClient.setId(1L);
        personalClient.setFirstName("Katerine");
        personalClient.setLastName("Perez");
        personalClient.setDocumentType(2);
        personalClient.setDocumentNumber("76070000");
        personalClient.setPhone("922402000");
        personalClient.setClient(Client.builder().id(1L).build());

        return Arrays.asList(personalClient);
    }
}
