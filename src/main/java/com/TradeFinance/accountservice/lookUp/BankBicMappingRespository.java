package com.TradeFinance.accountservice.lookUp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankBicMappingRespository extends JpaRepository<BankBicMapping, String> {
}
