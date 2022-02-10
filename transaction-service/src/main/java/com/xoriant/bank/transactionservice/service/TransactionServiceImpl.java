package com.xoriant.bank.transactionservice.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.xoriant.bank.transactionservice.controller.Sender;
import com.xoriant.bank.transactionservice.dao.TransactionDao;
import com.xoriant.bank.transactionservice.entity.Account;
import com.xoriant.bank.transactionservice.entity.Transaction;
import com.xoriant.bank.transactionservice.entity.TransactionType;
import com.xoriant.bank.transactionservice.model.Customer;

@Service
@EnableFeignClients
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private AccountProxy accountProxy;

	@Autowired
	private CustomerProxy customerProxy;

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private Sender sender;

	@Override
	public Transaction fundTransfer(long payorAcc, long payeeAcc, double amount) {

		Account payor = accountProxy.findAccountByNumber(payorAcc);

		Account payee = accountProxy.findAccountByNumber(payeeAcc);

		if (amount > payor.getBalance()) {
			return null;
		}

		payor.setBalance(payor.getBalance() - amount);
		payee.setBalance(payee.getBalance() + amount);

		accountProxy.save(payor);
		accountProxy.save(payee);

		Transaction transaction = new Transaction();

		transaction.setTransactionType(TransactionType.TRANSFER);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionAmount(amount);
		transaction.setFromAcount(payor);
		transaction.setToAcount(payee);
//		email start

		Customer customerSender = customerProxy.getCustomerById(payor.getCustomerId());
		Customer customerReceiver = customerProxy.getCustomerById(payee.getCustomerId());

		Map<String, Object> map = new HashMap();
		map.put("toMail", customerSender.getPersonInfo().getEmailId());
		map.put("fromMail", customerReceiver.getPersonInfo().getEmailId());
		map.put("toAccount", payor.getAccountNo());
		map.put("fromAccount", payee.getAccountNo());
		map.put("amount", amount);
		sender.sendFundTransferMail(map);

//		email end

		return transactionDao.save(transaction);

	}

	@Override
	public Transaction deposite(long AccountNo, double amount) {

		Account account = accountProxy.findAccountByNumber(AccountNo);

		account.setBalance(account.getBalance() + amount);

		accountProxy.save(account);

		Transaction transaction = new Transaction();
		transaction.setTransactionType(TransactionType.DEPOSITE);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionAmount(amount);
		transaction.setFromAcount(null);
		transaction.setToAcount(account);

//		mail start

		Customer customerReceiver = customerProxy.getCustomerById(account.getCustomerId());

		Map<String, Object> map = new HashMap();
		map.put("toMail", customerReceiver.getPersonInfo().getEmailId());

		map.put("toAccount", account.getAccountNo());

		map.put("amount", amount);

		sender.sendDeposit(map);

//		mail end

		return transactionDao.save(transaction);

	}

	@Override
	public Transaction withdraw(long AccountNo, double amount) {

		Account account = accountProxy.findAccountByNumber(AccountNo);

		account.setBalance(account.getBalance() - amount);

		accountProxy.save(account);

		Transaction transaction = new Transaction();
		transaction.setTransactionType(TransactionType.WITHDRAWL);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionAmount(amount);
		transaction.setFromAcount(null);
		transaction.setToAcount(account);

//		mail start

		Customer customerSender = customerProxy.getCustomerById(account.getCustomerId());

		Map<String, Object> map = new HashMap();

		map.put("toMail", customerSender.getPersonInfo().getEmailId());

		map.put("toAccount", account.getAccountNo());

		map.put("amount", amount);

		sender.sendWithdraw(map);

//		mail end

		return transactionDao.save(transaction);

	}

	@Override
	public List<Transaction> statement(long AccountNo) {

		Account account = accountProxy.findAccountByNumber(AccountNo);

		return transactionDao.findByToAcount_AccountIdOrFromAcount_AccountId(account.getAccountId(),
				account.getAccountId());

	}
//	@Override
//	public List<Transaction> customizedStatement(LocalDate to, LocalDate from, long accountNo) {
//
//		Account account = accountProxy.findAccountByNumber(accountNo);
//
//		return transactionDao
//				.findByTransactionDateBetweenAndToAcount_AccountIdOrTransactionDateBetweenFromAcount_AccountId(to, from,
//						account.getAccountId(), to, from, account.getAccountId());
//
//	}

}
