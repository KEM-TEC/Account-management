package com.TradeFinance.accountservice.BankAccount;

import com.TradeFinance.accountservice.BankAccount.Dto.AccountRequest;
import com.TradeFinance.accountservice.BankAccount.Dto.AccountResponse;
import com.TradeFinance.accountservice.applicant.Applicant;
import com.TradeFinance.accountservice.util.AccountGenerator;
import com.TradeFinance.accountservice.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;
@Service
@RequiredArgsConstructor

public class AccountService {
    private final AccountRepository accountRepository;

    public ApiResponse<?> createApplicantAccount(AccountRequest accountRequest) {

        //checking if applicant has an account

        Applicant applicant = Applicant.builder()
                .cifId(AccountGenerator.generateCifId())
                .firstName(accountRequest.getFirstName())
                .lastName(accountRequest.getLastName())
                .email(accountRequest.getEmail())
                .passportNumber(accountRequest.getPassportNumber())
                .nationalId(accountRequest.getNationalId())
                .businessName(accountRequest.getBusinessName())
                .gender(accountRequest.getGender())
                .passportNumber(accountRequest.getPhoneNumber())
                .address(accountRequest.getAddress())
                .kra(accountRequest.getKra())
                .country(accountRequest.getCountry())
                .accountNumber(AccountGenerator.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .status("active")
                .build();
       accountRepository.save(new Account());
        return new ApiResponse<>("account created successfully", null, HttpStatus.CREATED.value());
    }

    @Transactional
    public ApiResponse<?> getApplicantAccountDetailsByCifId(Applicant applicant) {
        Optional<Account> accountOptional = accountRepository.findByCifId(applicant.getCifId());
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            AccountResponse accountResponse = AccountResponse.builder()
                    .cifId(Long.valueOf(account.getCifId()))
                    .accountBalance(account.getAccountBalance())
                    .accountName(account.getAccountName())
                    .accountNumber(account.getAccountNumber())
                    .build();


            return new ApiResponse<>("account details fetched successfully", accountResponse, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("account not found with the given cifId advice on creating an account", null, HttpStatus.NOT_FOUND.value());
        }

    }
}





