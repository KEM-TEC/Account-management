package com.TradeFinance.accountservice.applicant;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "_applicant")
public class Applicant {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int cifId;
    @Column(name = "national_id",nullable = false)
    private String nationalId;
    @Column(name = "passport_number")
    private String passportNumber;
    @Column(name = "is_business",nullable = false)
    private boolean isBusiness;
    private String firstName;
    private String lastName;
    private String businessName;
    @Column(name = "address",nullable = false)
    private String address;
    @Column(name = "account_number",nullable = false)
    private String accountNumber;
    @Column(name = "account_balance",nullable = false)
    private BigDecimal accountBalance;
    @Column(name = "email",unique = true )
    private String email;
    @Column(name = "phone_number",unique = true )
    private String phoneNumber;
    @Column(name ="status" )
    private String status;

    @Column(name = "remitting_bank",nullable = false)
    private String remittingBank;
    @Column(name = "gender",unique = true)
    private String gender;
    @Column(name = "remitting_bank_bic",nullable = false)
    private String remittingBankBic;
    @Column(name = "country",nullable = false)
    private String country;
    @Column (name = "kra_pin")
    private String kra;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Transient
    public String getBeneficiaryName() {
        return isBusiness ? businessName : firstName + " " + lastName;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
        this.passportNumber=null;
    }
    public void setPassportNumber(String passportNumber){
        this.passportNumber=passportNumber;
        this.nationalId=null;
    }
}
