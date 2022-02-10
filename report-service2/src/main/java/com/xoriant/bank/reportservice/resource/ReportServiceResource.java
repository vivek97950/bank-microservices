package com.xoriant.bank.reportservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.bank.reportservice.model.Account;
import com.xoriant.bank.reportservice.model.Customer;
import com.xoriant.bank.reportservice.model.Transaction;
import com.xoriant.bank.reportservice.service.ReportService;

@RestController
@RequestMapping("/api/report")
@CrossOrigin
public class ReportServiceResource {

	@Autowired
	private ReportService reportService;

	@GetMapping("/customer/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		System.out.println("load balancer --------1");
		return reportService.getCustomerById(customerId);
	}
	
	

	@GetMapping("/account/{accountNumber}")
	public Account findAccountByNumber(@PathVariable long accountNumber) {
		return reportService.findAccountByNumber(accountNumber);
	}
	
	@GetMapping("/account/balance/{accountNumber}")
	public String findAccountBalanceByNumber(@PathVariable long accountNumber) {
		Account account= reportService.findAccountByNumber(accountNumber);
		return "your account balance is - "+account.getBalance();
	}

	@GetMapping("/transaction/{accountNo}")
	public List<Transaction> statement(@PathVariable long accountNo) {
		return reportService.statement(accountNo);
	}

}
