package com.nttdata.serviceproduct.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class AuthorizedSigner {

    private Long id;

    private String firtName;

    private String lastName;

    private String email;


    BusinessClient businessCustomer;
}
