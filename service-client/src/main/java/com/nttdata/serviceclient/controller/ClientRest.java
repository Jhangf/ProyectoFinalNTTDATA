package com.nttdata.serviceclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.serviceclient.entity.*;
import com.nttdata.serviceclient.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/clients")
public class ClientRest {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PersonalClientService personalClientService;

    @Autowired
    private BusinessClientService businessClientService;

    @Autowired
    private AuthorizedSignerService authorizedSignerService;

    @Autowired
    private HolderService holderService;


    //REST CLIENTES
    //Listar todos los clientes
    @GetMapping
    public ResponseEntity<List<Client>> listClients(){
        List<Client> clients = clientService.listAllClients();
        if (clients.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(clients);
        }
    }

    //Listar un cliente por id psado como parametro
    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id){
        Client c = clientService.getClient(id);
        if(c.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(c);
        }
    }

    //REST PARA CLIENTES PERSONALES

    //listar los clientes de tipo personales
    @GetMapping(value = "/personals")
    public ResponseEntity<List<PersonalClient>> listPersonalClient(){
        List<PersonalClient> personalClients = personalClientService.listAllPersonalClient();
        if (personalClients.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(personalClients);
        }
    }

    //Listar un cliente personal por id psado como parametro
    @GetMapping(value = "/personals/{id}")
    public ResponseEntity<PersonalClient> getPersonalClient(@PathVariable Long id){
        PersonalClient pc = personalClientService.getPersonalClient(id);
        if(pc.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(pc);
        }
    }

    //Listar un cliente personal por id del cliente
    @GetMapping(value = "/personals/clientId/{id}")
    public ResponseEntity<PersonalClient> getPersonalClientByIdClient(@PathVariable Long id){
        PersonalClient pc = personalClientService.getPersonalClientByIdClient(id);
        if(pc.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(pc);
        }
    }

    @PostMapping(value = "/personals")
    public ResponseEntity<PersonalClient> savePersonalClient( @RequestBody PersonalClient personalClient){
        try {
            PersonalClient pc = personalClientService.savePersonalClient(personalClient);
            if (pc.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new PersonalClient());
            }else{
                return ResponseEntity.ok(pc);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PersonalClient());
        }
    }

    @PutMapping(value = "/personals/{id}")
    public ResponseEntity<PersonalClient> updatePersonalClient(@PathVariable Long id, @RequestBody PersonalClient personalClient){
        PersonalClient pc = personalClientService.updatePersonalClient(id,personalClient);
        if(pc.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new PersonalClient());
        }else {
            return ResponseEntity.ok(pc);
        }
    }

    @DeleteMapping(value = "/personals/{id}")
    public ResponseEntity<PersonalClient> deletePersonalClient(@PathVariable Long id){
        if(personalClientService.deletePersonalClient(id)){
            return ResponseEntity.ok(new PersonalClient());
        }else {
          return   ResponseEntity.badRequest().build();
        }
    }

                 //REST PARA CLIENTES EMPRESARIALES

    //listar los clientes de tipo Empresarial
    @GetMapping(value = "/business")
    public ResponseEntity<List<BusinessClient>> listBusinessClient(){
        List<BusinessClient> businessClients = businessClientService.listAllBusinessClient();
        if (businessClients.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(businessClients);
        }
    }

    //Listar un cliente Empresarial por id psado como parametro
    @GetMapping(value = "/business/{id}")
    public ResponseEntity<BusinessClient> getBusinessClient(@PathVariable Long id){
        BusinessClient bc = businessClientService.getBusinessClient(id);
        if(bc.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(bc);
        }
    }
    //Listar un cliente Empresarial por id del clietne psado como parametro
    @GetMapping(value = "/business/clientId/{id}")
    public ResponseEntity<BusinessClient> getBusinessClientFindIdClient(@PathVariable Long id){
        BusinessClient bc = businessClientService.getBusinessClientByIdClient(id);
        if(bc.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(bc);
        }
    }

    @PostMapping(value = "/business")
    public ResponseEntity<BusinessClient> saveBusinessClient(@RequestBody BusinessClient businessClient){
        try {
            BusinessClient bc = businessClientService.saveBusinessClient(businessClient);
            if (bc.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new BusinessClient());
            }else{
                return ResponseEntity.ok(bc);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BusinessClient());
        }
    }

    @PutMapping(value = "/business/{id}")
    public ResponseEntity<BusinessClient> updateBusinessClient(@PathVariable Long id, @RequestBody BusinessClient businessClient){
        BusinessClient bc = businessClientService.updateBusinessClient(id,businessClient);
        if(bc.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new BusinessClient());
        }else {
            return ResponseEntity.ok(bc);
        }
    }

    @DeleteMapping(value = "/business/{id}")
    public ResponseEntity<BusinessClient> deleteBusinessClient(@PathVariable Long id) {
        if (businessClientService.deleteBusinessClient(id)) {
            return ResponseEntity.ok(new BusinessClient());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    //REST PARA FIRMANTES AUTHORIZADOS DE UN CLIENTE EMPRESARIAL

    //listar los firmantes authorizados de un cliente empresarial
    @GetMapping(value = "/business/authorizedSigners")
    public ResponseEntity<List<AuthorizedSigner>> listAuthorizedSigners(){
        List<AuthorizedSigner> authorizedSigners = authorizedSignerService.listAllAuthorizedSigners();
        if (authorizedSigners.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(authorizedSigners);
        }
    }

    //Listar un firmante authorizado por id
    @GetMapping(value = "/business/authorizedSigner/{id}")
    public ResponseEntity<AuthorizedSigner> getAuthorizedSigner(@PathVariable Long id){
        AuthorizedSigner as = authorizedSignerService.getAuthorizedSigner(id);
        if(as.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(as);
        }
    }
    //Guardar un firmante authorizado
    @PostMapping(value = "/business/authorizedSigner")
    public ResponseEntity<AuthorizedSigner> saveAuthorizedSigner(@RequestBody AuthorizedSigner authorizedSigner){
        try {
            AuthorizedSigner as = authorizedSignerService.saveAuthorizedSigner(authorizedSigner);
            if (as.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new AuthorizedSigner());
            }else{
                return ResponseEntity.ok(as);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthorizedSigner());
        }
    }

    @PutMapping(value = "/business/authorizedSigner/{id}")
    public ResponseEntity<AuthorizedSigner> updateAuthorizedSigner(@PathVariable Long id, @RequestBody AuthorizedSigner authorizedSigner){
        AuthorizedSigner bc = authorizedSignerService.updateAuthorizedSigner(id,authorizedSigner);
        if(bc.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new AuthorizedSigner());
        }else {
            return ResponseEntity.ok(bc);
        }
    }

    @DeleteMapping(value = "/business/authorizedSigner/{id}")
    public ResponseEntity<AuthorizedSigner> deleteAuthorizedSigner(@PathVariable Long id) {
        if (authorizedSignerService.deleteAuthorizedSigner(id)) {
            return ResponseEntity.ok(new AuthorizedSigner());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //REST PARA TITULARES DE UN CLIENTE EMPRESARIAL

    //listar los titulares empresariales
    @GetMapping(value = "/business/holders")
    public ResponseEntity<List<Holder>> listHolders(){
        List<Holder> holders = holderService.listAllHolders();
        if (holders.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(holders);
        }
    }

    //Listar un titular
    @GetMapping(value = "/business/holder/{id}")
    public ResponseEntity<Holder> getHolder(@PathVariable Long id){
        Holder h = holderService.getHolder(id);
        if(h.getId()==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(h);
        }
    }
    //Guardar un titular
    @PostMapping(value = "/business/holder")
    public ResponseEntity<Holder> saveHolder(@RequestBody Holder holder){
        try {
            Holder h = holderService.saveHolder(holder);
            if (h.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new Holder());
            }else{
                return ResponseEntity.ok(h);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Holder());
        }
    }
    //Actualizar Titular
    @PutMapping(value = "/business/holder/{id}")
    public ResponseEntity<Holder> updateHolder(@PathVariable Long id, @RequestBody Holder holder){
        Holder h = holderService.updateHolder(id,holder);
        if(h.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new Holder());
        }else {
            return ResponseEntity.ok(h);
        }
    }
    //Eliminar titular
    @DeleteMapping(value = "/business/holder/{id}")
    public ResponseEntity<Holder> deleteHolder(@PathVariable Long id) {
        if (holderService.deleteHolder(id)) {
            return ResponseEntity.ok(new Holder());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //MESSAGE DE ERROR
    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}
