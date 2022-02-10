package com.xoriant.bank.reportservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.bank.reportservice.model.Account;
import com.xoriant.bank.reportservice.model.Customer;
import com.xoriant.bank.reportservice.model.Transaction;




@Service
@EnableFeignClients
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private AccountProxy accountProxy;
	
	@Autowired
	private TransactionProxy transactionProxy;

	@Autowired
	private CustomerProxy customerProxy;
	
	
	@Override
	public Customer getCustomerById(int customerId) {
		return customerProxy.getCustomerById(customerId);
	}
    
	@Override
	public Account findAccountByNumber(long accountNumber) {
		return accountProxy.findAccountByNumber(accountNumber);
	}
	

	@Override
	public List<Transaction> statement(long accountNo){
		return transactionProxy.statement(accountNo);
	}
}
