package com.xoriant.bank.reportservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class SavingAccount {
	

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
