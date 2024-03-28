package com.TradeFinance.accountservice.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository <Account, Long>{
    Optional<Account> findByCifId(int cifId);
    Optional<Account>findAccountByNationalId(String nationalId);
}
