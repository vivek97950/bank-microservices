package com.xoriant.bank.transactionservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurrentAccount {
	@Id
	@GeneratedValue
	private int currentAccountId;
	private String companyName;
	private double minimumBalance;
	public int getCurrentAccountId() {
		return currentAccountId;
	}
	public void setCurrentAccountId(int currentAccountId) {
		this.currentAccountId = currentAccountId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	@Override
	public String toString() {
		return "CurrentAccount [currentAccountId=" + currentAccountId + ", companyName=" + companyName
				+ ", minimumBalance=" + minimumBalance + "]";
	}
	
	

}
