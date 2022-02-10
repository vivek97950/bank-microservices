package com.xoriant.bank.transactionservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xoriant.bank.transactionservice.entity.Transaction;

public interface TransactionService {

	Transaction fundTransfer(long payorAcc, long payeeAcc, double amount);

	Transaction deposite(long AccountNo, double amount);

	Transaction withdraw(long AccountNo, double amount);

	List<Transaction> statement(long AccountNo);

	//List<Transaction> customizedStatement(LocalDate to, LocalDate from, long accountNo);

}