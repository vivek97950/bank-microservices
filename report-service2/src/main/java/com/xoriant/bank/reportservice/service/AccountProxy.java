package com.xoriant.bank.reportservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.bank.reportservice.model.Account;


@FeignClient(name = "account-proxy", url = "http://localhost:8085/api/account")
public interface AccountProxy {

	@GetMapping("/{accountNumber}")
	public Account findAccountByNumber(@PathVariable long accountNumber);

}
