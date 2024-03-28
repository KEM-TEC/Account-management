package com.TradeFinance.accountservice.lookUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBicLookUpService {
    @Autowired
    private BankBicMappingRespository bankBicMappingRepository;

    public String getBankNameByBic(String bic) {
        BankBicMapping mapping = bankBicMappingRepository.findById(bic).orElse(null);
        return mapping != null ? mapping.getBankName() : "Unknown Bank";
    }
}
