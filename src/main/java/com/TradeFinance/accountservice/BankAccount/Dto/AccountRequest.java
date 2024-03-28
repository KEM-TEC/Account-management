package com.TradeFinance.accountservice.BankAccount.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AccountRequest {
    private String cifId;
    private String nationalId;

    private String passportNumber;
    private boolean isBusiness;

    private String firstName;
    private String lastName;
    private String businessName;

    private String address;

    private String email;
    private BigDecimal accountBalance;

    private String phoneNumber;
    private String gender;
    private String country;
    private String kra;
    private String accountNumber;
}
