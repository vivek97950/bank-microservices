package com.xoriant.bank.accountservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.xoriant.bank.accountservice.dao.AccountDao;
import com.xoriant.bank.accountservice.dao.BranchDao;
import com.xoriant.bank.accountservice.entity.Account;
import com.xoriant.bank.accountservice.entity.Branch;
import com.xoriant.bank.accountservice.model.Customer;

@Service
@EnableFeignClients
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private CustomerProxy customerProxy;

	@Autowired
	private BranchDao branchDao;

	@Override
	public Account findAccountByNumber(long accountNumber) {
		return accountDao.findByAccountNoEquals(accountNumber);
	}

	@Override
	public void deleteAccount(Account account) {
		accountDao.delete(account);
	}

	@Override
	public Account save(Account account) {
		
		System.out.println(account);

		Customer customer = customerProxy.getCustomerById(account.getCustomerId());

		Branch branch = branchDao.getById(account.getBranchId());

		if (customer != null && branch != null) {
			
			return accountDao.save(account);
			
		}
		return null;

	}
	
	

}
