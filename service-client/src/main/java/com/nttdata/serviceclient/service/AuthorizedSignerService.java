package com.nttdata.serviceclient.service;

import com.nttdata.serviceclient.entity.AuthorizedSigner;


import java.util.List;

public interface AuthorizedSignerService {

    //Listar todos los firmantes autorizdos de un cliente empresarial
    public List<AuthorizedSigner> listAllAuthorizedSigners();


    //Listar un firmante authorizado por ID
    public AuthorizedSigner getAuthorizedSigner(Long id);

    //Guardar firmante authorizado
    public AuthorizedSigner saveAuthorizedSigner(AuthorizedSigner authorizedSigner);

    //Actualizar firmante autorizado
    public AuthorizedSigner updateAuthorizedSigner(Long id, AuthorizedSigner authorizedSigner);

    //Eliminar firmante autorizado
    public boolean deleteAuthorizedSigner(Long id);
}
