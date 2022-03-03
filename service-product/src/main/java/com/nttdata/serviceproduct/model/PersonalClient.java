package com.nttdata.serviceproduct.model;


import lombok.Data;

import java.util.Date;

@Data
public class PersonalClient {

    private Long id;

    private String firstName;

    private String lastName;

    private int documentType;

    private String documentNumber;

    private String phone;

    private Date birthday;

    private Client client;
}
