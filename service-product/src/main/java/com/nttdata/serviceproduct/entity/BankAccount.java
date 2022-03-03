package com.nttdata.serviceproduct.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nttdata.serviceproduct.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_bank_accounts")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number",nullable = false)
    private String accountNumber;

    @Column(name = "maintenance_fee",nullable = false)
    private boolean maintenanceFee;

    @Column(name = "maintenace_cost",nullable = false)
    private double maintenanceCost;

    @Column(name = "movement_limit",nullable = false)
    private boolean movementLimit;

    @Column(name = "number_moves",nullable = false)
    private Long numberMoves;

    @Column(name = "withdrawal_or_deposit")
    private boolean withdrawalOrDeposit;

    @Column(name = "total_amount_in_account")
    private double totalAmountInAccount;


    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_bank_account_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private TypeBankAccount typeBankAccount;

    //Identificador para cliente
    @Column(name = "client_id")
    private Long clientId;
    //Colocamos Transient para no guardar en la base de datos
    @Transient
    private Client client;

}
