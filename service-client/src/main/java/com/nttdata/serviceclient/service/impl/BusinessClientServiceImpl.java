package com.nttdata.serviceclient.service.impl;

import com.nttdata.serviceclient.entity.BusinessClient;
import com.nttdata.serviceclient.repository.BusinessClientRepository;
import com.nttdata.serviceclient.service.BusinessClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BusinessClientServiceImpl implements BusinessClientService {

    @Autowired
    private BusinessClientRepository businessClientRepository;


    @Override
    public List<BusinessClient> listAllBusinessClient() {
        return businessClientRepository.findAll();
    }

    @Override
    public BusinessClient getBusinessClient(Long id) {
        return businessClientRepository.findById(id).orElse(null);
    }

    @Override
    public BusinessClient saveBusinessClient(BusinessClient businessClient) {
        businessClient.setCreateAt(new Date()); //Fecha actual al crear
        return businessClientRepository.save(businessClient);
    }

    @Override
    public BusinessClient updateBusinessClient(Long id, BusinessClient businessClient) {
        BusinessClient bc = getBusinessClient(id);
        if(bc==null){
            return null;
        }else {
            bc.setBusinessName(businessClient.getBusinessName());
            bc.setRuc(businessClient.getRuc());
            bc.setCreateAt(businessClient.getCreateAt());
            return businessClientRepository.save(bc);
        }
    }

    @Override
    public boolean deleteBusinessClient(Long id) {
        try{
            businessClientRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public BusinessClient getBusinessClientByIdClient(Long id) {
        return businessClientRepository.findClientBusiness(id);
    }
}
