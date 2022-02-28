package com.nttdata.serviceclient.service.impl;

import com.nttdata.serviceclient.entity.AuthorizedSigner;
import com.nttdata.serviceclient.repository.AuthorizedSignerRepository;
import com.nttdata.serviceclient.service.AuthorizedSignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuthorizedSignerServiceImpl implements AuthorizedSignerService {

    @Autowired
    private AuthorizedSignerRepository authorizedSignerRepository;

    @Override
    public List<AuthorizedSigner> listAllAuthorizedSigners() {
        return authorizedSignerRepository.findAll();
    }

    @Override
    public AuthorizedSigner getAuthorizedSigner(Long id) {
        return authorizedSignerRepository.findById(id).orElse(null);
    }

    @Override
    public AuthorizedSigner saveAuthorizedSigner(AuthorizedSigner authorizedSigner) {
        authorizedSigner.setCreateAt(new Date()); //Al momento de crear signar fechaactual
        return authorizedSignerRepository.save(authorizedSigner);
    }

    @Override
    public AuthorizedSigner updateAuthorizedSigner(Long id, AuthorizedSigner authorizedSigner) {
       AuthorizedSigner as = getAuthorizedSigner(id);
       if(as==null){
           return null;
       }else {
           as.setFirtName(authorizedSigner.getFirtName());
           as.setLastName(authorizedSigner.getLastName());
           as.setEmail(authorizedSigner.getEmail());
           as.setCreateAt(authorizedSigner.getCreateAt());
           return authorizedSignerRepository.save(as);
       }
    }

    @Override
    public boolean deleteAuthorizedSigner(Long id) {
        try{
            authorizedSignerRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
