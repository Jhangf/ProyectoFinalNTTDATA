package com.nttdata.serviceproduct.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_credit_payments")
public class CreditPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "installment_number",nullable = false)
    private int installmentNumber;

    @Column(name = "amount_paid",nullable = false)
    private double amountPaid;

    @Column(name = "remaining_amount",nullable = false)
    private double remainingAmount;

    @Column(name = "payment_date",nullable = false)
    private Date paymentDate;

    @Column(name = "due_date",nullable = false)
    private Date dueDate;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Credit credit;

}
