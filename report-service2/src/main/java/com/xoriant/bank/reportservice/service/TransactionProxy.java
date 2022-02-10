package com.xoriant.bank.reportservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.xoriant.bank.reportservice.model.Transaction;

@FeignClient(name="transaction-proxy",url="http://localhost:8084/api/transaction")
public interface TransactionProxy {
	
	@GetMapping("/{accountNo}")
	public List<Transaction> statement(@PathVariable long accountNo);

}
