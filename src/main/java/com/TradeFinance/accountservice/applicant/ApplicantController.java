package com.TradeFinance.accountservice.applicant;

import com.TradeFinance.accountservice.BankAccount.Account;
import com.TradeFinance.accountservice.BankAccount.AccountService;
import com.TradeFinance.accountservice.util.ApiResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicant")
public class ApplicantController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/get-applicant-details")
    public ResponseEntity<?>getApplicantAccountDetailsByCifId(@PathVariable ("cifId") Applicant cifId){
        return ResponseEntity.ok(accountService.getApplicantAccountDetailsByCifId(cifId));
    }
}
