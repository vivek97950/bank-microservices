package com.xoriant.bank.accountservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.bank.accountservice.entity.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {

	Account findByAccountNoEquals(long accountNumber);

}
