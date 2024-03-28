package com.TradeFinance.accountservice.BankAccount;

import com.TradeFinance.accountservice.BankAccount.Dto.AccountRequest;
import com.TradeFinance.accountservice.applicant.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/create-account")
    public ResponseEntity<?> createApplicantAccount(@RequestBody AccountRequest accountRequest){
        return ResponseEntity.ok(accountService.createApplicantAccount(accountRequest));

    }
    @GetMapping("/get-account-details")
    public ResponseEntity<?> getApplicantAccountDetailsByCifId(@PathVariable ("cif_Id")Applicant cifId){
        return ResponseEntity.ok(accountService.getApplicantAccountDetailsByCifId(cifId));
    }
}
