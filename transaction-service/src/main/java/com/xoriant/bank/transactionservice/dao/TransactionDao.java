package com.xoriant.bank.transactionservice.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.xoriant.bank.transactionservice.entity.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByToAcount_AccountIdOrFromAcount_AccountId(int accountNo, int accountNo2);

//	List<Transaction> findByTransactionDateBetweenAndToAcount_AccountIdOrTransactionDateBetweenFromAcount_AccountId(
//			LocalDate to, LocalDate from, int accountNo, LocalDate to2, LocalDate from2, int accountNo2);

}
