package com.nttdata.serviceclient.service.impl;

import com.nttdata.serviceclient.entity.PersonalClient;
import com.nttdata.serviceclient.repository.PersonalClientRepository;
import com.nttdata.serviceclient.service.PersonalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonalClientServiceImpl implements PersonalClientService {

    @Autowired
    private PersonalClientRepository personalClientRepository;

    //Listar todos los clientes de tipo Personal
    @Override
    public List<PersonalClient> listAllPersonalClient() {

        return personalClientRepository.findAll();
    }
    //Listar Cliente de tipo personal por id
    @Override
    public PersonalClient getPersonalClient(Long id) {
        return personalClientRepository.findById(id).orElse(null);
    }

    //Guardar un cliente de tipo Personal
    @Override
    public PersonalClient savePersonalClient(PersonalClient personalClient) {
        personalClient.setCreateAt(new Date()); //Al momento de crear asignar la fecha actual :)
        return personalClientRepository.save(personalClient);
    }

    //Actualizar cliente de tipo eprsonal
    @Override
    public PersonalClient updatePersonalClient(Long id, PersonalClient personalClient) {
        PersonalClient pc = getPersonalClient(id);
        if(pc==null){
            return null;
        }else {
            pc.setFirstName(personalClient.getFirstName());
            pc.setLastName(personalClient.getLastName());
            pc.setDocumentType(personalClient.getDocumentType());
            pc.setDocumentNumber(personalClient.getDocumentNumber());
            pc.setPhone(personalClient.getPhone());
            pc.setBirthday(personalClient.getBirthday());
            pc.setCreateAt(personalClient.getCreateAt());
            return personalClientRepository.save(pc);
        }
    }

    //Eliminar un cliente de tipo personal
    @Override
    public boolean deletePersonalClient(Long id) {
        try{
            personalClientRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
