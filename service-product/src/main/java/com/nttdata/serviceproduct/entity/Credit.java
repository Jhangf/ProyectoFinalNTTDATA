package com.nttdata.serviceproduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_credits")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "borrowed_amount",nullable = false)
    private double borrowedAmount;

    @Column(name = "number_of_installments",nullable = false)
    private int numberOfInstallments;

    @Column(name = "time",nullable = false)
    private String time;

    @Column(name = "interest",nullable = false)
    private double interest;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;


}
