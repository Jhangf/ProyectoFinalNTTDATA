package com.nttdata.serviceclient.service;

import com.nttdata.serviceclient.entity.AuthorizedSigner;
import com.nttdata.serviceclient.entity.Holder;

import java.util.List;

public interface HolderService {

    //Listar todos los titulares de un cliente empresarial
    public List<Holder> listAllHolders();

    //Listar un titular por ID
    public Holder getHolder(Long id);

    //Guardar titular
    public Holder saveHolder(Holder holder);

    //Actualizar titular
    public Holder updateHolder(Long id, Holder holder);

    //Eliminar titular
    public boolean deleteHolder(Long id);
}
