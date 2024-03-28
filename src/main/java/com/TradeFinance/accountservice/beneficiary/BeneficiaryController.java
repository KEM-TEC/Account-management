package com.TradeFinance.accountservice.beneficiary;

import com.TradeFinance.accountservice.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/beneficiary")

public class BeneficiaryController {
    @Autowired
    private BeneficiaryService beneficiaryService;
    @PostMapping("/beneficiary-details")
    public ResponseEntity<?> enterBeneficiaryDetails(@RequestBody BeneficiaryDto beneficiaryDto) {
       return ResponseEntity.ok(beneficiaryService.enterBeneficiaryDetails(beneficiaryDto));
    }
}


