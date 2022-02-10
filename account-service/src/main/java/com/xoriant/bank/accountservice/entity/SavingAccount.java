package com.xoriant.bank.accountservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SavingAccount {
	
	@Id
	@GeneratedValue
	private int savingAccountId;;
	
	private int dailyLimitofTransaction;
	
	private double minimumBalance;

	public int getSavingAccountId() {
		return savingAccountId;
	}

	public void setSavingAccountId(int savingAccountId) {
		this.savingAccountId = savingAccountId;
	}

	public int getDailyLimitofTransaction() {
		return dailyLimitofTransaction;
	}

	public void setDailyLimitofTransaction(int dailyLimitofTransaction) {
		this.dailyLimitofTransaction = dailyLimitofTransaction;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	@Override
	public String toString() {
		return "SavingAccount [savingAccountId=" + savingAccountId + ", dailyLimitofTransaction="
				+ dailyLimitofTransaction + ", minimumBalance=" + minimumBalance + "]";
	}
	
	
	

}
