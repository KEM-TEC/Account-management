package com.TradeFinance.accountservice.beneficiary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BeneficiaryDto {
    private boolean isBusiness;
    private String firstName;
    private String lastName;
    private String businessName;
    private String accountNumber;
    private String iban;
    private String country;
    private String address;
    private String advisingBank;
    private String advisingBankCountry;
    private String advisingBankBic;
    private String beneficiaryName;
}
