package com.nttdata.serviceclient.service.impl;

import com.nttdata.serviceclient.entity.Holder;
import com.nttdata.serviceclient.repository.HolderRepository;
import com.nttdata.serviceclient.service.HolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HolderServiceClient implements HolderService {

    @Autowired
    private HolderRepository holderRepository;

    @Override
    public List<Holder> listAllHolders() {
        return holderRepository.findAll();
    }

    @Override
    public Holder getHolder(Long id) {
        return holderRepository.findById(id).orElse(null);
    }

    @Override
    public Holder saveHolder(Holder holder) {
        holder.setCreateAt(new Date()); //guardar fecha actual
        return holderRepository.save(holder);
    }

    @Override
    public Holder updateHolder(Long id, Holder holder) {
        Holder h = getHolder(id);
        if(h==null){
            return null;
        }else {
            h.setFirstName(holder.getFirstName());
            h.setLastName(holder.getLastName());
            h.setEmail(holder.getEmail());
            h.setCreateAt(holder.getCreateAt());
            return holderRepository.save(h);
        }

    }

    @Override
    public boolean deleteHolder(Long id) {
        try{
            holderRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
