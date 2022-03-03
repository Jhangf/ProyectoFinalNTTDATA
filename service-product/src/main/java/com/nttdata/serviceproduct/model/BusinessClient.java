package com.nttdata.serviceproduct.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class BusinessClient {

    private Long id;


    private String businessName;

    private String ruc;

    private Client client;
}
