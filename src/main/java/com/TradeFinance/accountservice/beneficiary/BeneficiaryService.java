package com.TradeFinance.accountservice.beneficiary;

import com.TradeFinance.accountservice.lookUp.BankBicLookUpService;
import com.TradeFinance.accountservice.lookUp.CountryLookUpService;
import com.TradeFinance.accountservice.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BeneficiaryService {
    private final BeneficiaryRepository beneficiaryRepository;
    private final CountryLookUpService countryLookupService;
    private final BankBicLookUpService bankBicLookupService;

    public ApiResponse<?> enterBeneficiaryDetails(BeneficiaryDto beneficiaryDto) {

        // Populate country and bank details
        String country = countryLookupService.getCountryNameCountryCode(beneficiaryDto.getCountry());
        String advisingBank = bankBicLookupService.getBankNameByBic(beneficiaryDto.getAdvisingBankBic());


        Beneficiary beneficiary= Beneficiary.builder()
                .isBusiness(beneficiaryDto.isBusiness())
                .firstName(beneficiaryDto.getFirstName())
                .lastName(beneficiaryDto.getLastName())
                .businessName(beneficiaryDto.getBusinessName())
                .accountNumber(beneficiaryDto.getAccountNumber())
                .iban(beneficiaryDto.getIban())
                .country(beneficiaryDto.getCountry())
                .address(beneficiaryDto.getAddress())
                .advisingBank(beneficiaryDto.getAdvisingBank())
                .advisingBankCountry(beneficiaryDto.getAdvisingBankCountry())
                .advisingBankBic(beneficiaryDto.getAdvisingBankBic())
                .build();
        // Map BeneficiaryDto to Beneficiary entity
       // Beneficiary beneficiary = mapToEntity(updatedBeneficiaryDto);

        // Save beneficiary entity
        beneficiaryRepository.save(beneficiary);
        return new ApiResponse<>("Beneficiary details entered successfully",null, HttpStatus.CREATED.value());
    }


}
