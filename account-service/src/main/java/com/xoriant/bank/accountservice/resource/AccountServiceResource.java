package com.xoriant.bank.accountservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.bank.accountservice.entity.Account;
import com.xoriant.bank.accountservice.service.AccountService;

@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class AccountServiceResource {

	@Autowired
	private AccountService accountService;

	@GetMapping("/{accountNumber}")
	public Account findAccountByNumber(@PathVariable long accountNumber) {
		return accountService.findAccountByNumber(accountNumber);
	}

	@DeleteMapping
	public void deleteAccount(@RequestBody Account account) {
		accountService.deleteAccount(account);
	}

	@PostMapping
	public Account save(@RequestBody Account account) {
		return accountService.save(account);
	}
	
	@PutMapping
	public Account update(@RequestBody Account account) {
		return accountService.save(account);
	}

}
