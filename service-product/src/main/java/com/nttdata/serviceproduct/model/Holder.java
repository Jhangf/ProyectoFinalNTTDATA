package com.nttdata.serviceproduct.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class Holder {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    BusinessClient businessCustomer;
}
