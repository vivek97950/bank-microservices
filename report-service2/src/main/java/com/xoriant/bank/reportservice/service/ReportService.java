package com.xoriant.bank.reportservice.service;

import java.util.List;

import com.xoriant.bank.reportservice.model.Account;
import com.xoriant.bank.reportservice.model.Customer;
import com.xoriant.bank.reportservice.model.Transaction;

public interface ReportService {

	Customer getCustomerById(int customerId);

	Account findAccountByNumber(long accountNumber);

	List<Transaction> statement(long accountNo);

}