package com.TradeFinance.accountservice.BankAccount;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cifId;
    @Column(nullable = false, updatable = false)
    private String nationalId;
    @Column(name = "account_number", updatable = false)
    private String accountNumber;
    @Column(name = "account_name", updatable = false)
    private String accountName;
    private Date openingDate;
    @Column(name ="currency")
    private String currency;
    @Column(name = "account_balance")
    private BigDecimal accountBalance;
    @Column(name = "book_balance")
    private BigDecimal bookBalance;
    @Column(name = "lien_amount")
    private BigDecimal lienAmount;
    @Column(name = "status")
    private String accountStatus; // Whether active, dormant , suspended, frozen e.t.c
}
