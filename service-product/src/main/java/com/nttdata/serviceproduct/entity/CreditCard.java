package com.nttdata.serviceproduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_credits_cards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number",nullable = false)
    private String accountNumber;

    @Column(name = "amount_spent",nullable = false)
    private double amountSpent;

    @Column(name = "expiration_date",nullable = false)
    private Date expirationDate;

    @Column(name = "maximum_amount",nullable = false)
    private double maximumAmount;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
}
