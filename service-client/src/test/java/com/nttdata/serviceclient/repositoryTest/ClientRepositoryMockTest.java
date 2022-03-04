package com.nttdata.serviceclient.repositoryTest;

import com.nttdata.serviceclient.entity.Client;
import com.nttdata.serviceclient.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ClientRepositoryMockTest {

    @Autowired
    private ClientRepository clientRepository;

    public void whenfindById_ThenReturnListClients(){
        Client client = Client.builder().typeClient(Integer.parseInt("1")).build();
        clientRepository.save(client);

        List<Client> founds = clientRepository.findAll();


       // Assertions.assertEquals(5, response);
        //Assertions.assertThat(founds.size()).isEqualTo(5);

    }
}
