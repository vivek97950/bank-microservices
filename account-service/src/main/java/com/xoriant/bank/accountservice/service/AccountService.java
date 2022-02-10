package com.xoriant.bank.accountservice.service;

import com.xoriant.bank.accountservice.entity.Account;

public interface AccountService {

	Account findAccountByNumber(long accountNumber);

	void deleteAccount(Account account);

	Account save(Account account);

}