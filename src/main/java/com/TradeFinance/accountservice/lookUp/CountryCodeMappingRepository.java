package com.TradeFinance.accountservice.lookUp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryCodeMappingRepository extends JpaRepository<CountryCodeMapping, String> {
}
