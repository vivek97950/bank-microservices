package com.xoriant.bank.transactionservice.resource;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.bank.transactionservice.entity.Transaction;
import com.xoriant.bank.transactionservice.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
@CrossOrigin
public class TrnsactionServiceResource {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/{payorAcc}/{payeeAcc}/{amount}")
	public Transaction fundTransfer(@PathVariable long payorAcc, @PathVariable long payeeAcc,
			@PathVariable double amount) {
		return transactionService.fundTransfer(payorAcc, payeeAcc, amount);
	}

	@GetMapping("/deposite/{accountNo}/{amount}")
	public Transaction deposite(@PathVariable long accountNo, @PathVariable double amount) {
		return transactionService.deposite(accountNo, amount);
	}

	@GetMapping("/withdraw/{accountNo}/{amount}")
	public Transaction withdraw(@PathVariable long accountNo, @PathVariable double amount) {
		return transactionService.withdraw(accountNo, amount);
	}

	@GetMapping("/{accountNo}")
	public List<Transaction> statement(@PathVariable long accountNo){
    	return transactionService.statement(accountNo);
    }
	
//	@GetMapping("/customize/{toDate}/{fromDate}/{accountNo}")
//	public List<Transaction> customizeStatement(@PathVariable LocalDate toDate,@PathVariable LocalDate fromDate,@PathVariable long accountNo){
//    	return transactionService.customizedStatement(toDate, fromDate, accountNo);
//    }

}
