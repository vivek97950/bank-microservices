package com.xoriant.bank.transactionservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xoriant.bank.transactionservice.entity.Account;

@FeignClient(name = "account-proxy", url = "http://localhost:8085/api/account")
public interface AccountProxy {

	@GetMapping("/{accountNumber}")
	public Account findAccountByNumber(@PathVariable long accountNumber);
	
	@PostMapping
	public Account save(@RequestBody Account account);
}
