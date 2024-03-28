package com.TradeFinance.accountservice.beneficiary;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "beneficiary_details")

public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "is_business",nullable = false)

    private boolean isBusiness;
    private String firstName;
    private String lastName;
    private String businessName;
    @Column(name = "account_number",nullable = false)
    private String accountNumber;
    @Column(name = "iban")
    private String iban;
    @Column(name = "country",nullable = false)
    private String country;
    @Column(name = "address",nullable = false)
    private String address;
    @Column(name = "advising_bank",nullable = false)
    private String advisingBank;
    @Column(name = "advising_bank_country",nullable = false)
    private String advisingBankCountry;
    @Column(name = "advising_bank_bic",nullable = false)
    private String advisingBankBic;
    @Transient
    public String getBeneficiaryName() {
        return isBusiness ? businessName : firstName + " " + lastName;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        this.iban = null; // Reset IBAN if BankAccount number is provided
    }

    public void setIban(String iban) {
        this.iban = iban;
        this.accountNumber = null; // Reset BankAccount number if IBAN is provided
    }
}


