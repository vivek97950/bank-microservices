package com.xoriant.bank.transactionservice.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

enum AccountType{
	SAVING,CURRENT
}

@Entity(name="account")
public class Account {
	


	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Id
	@GeneratedValue
	private int accountId;
	private long accountNo;

	@Column(columnDefinition="ENUM('SAVING','CURRENT')")
	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	private LocalDate openDate;

	private boolean accountStatus;

	private double balance;
	

	private int branchId;
	

	private int customerId;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "saving_account_id")
	private SavingAccount savingAccount;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "current_account_id")
	private CurrentAccount currentAccount;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	public boolean isAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}



	public SavingAccount getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(SavingAccount savingAccount) {
		this.savingAccount = savingAccount;
	}

	public CurrentAccount getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(CurrentAccount currentAccount) {
		this.currentAccount = currentAccount;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNo=" + accountNo + ", accountType=" + accountType
				+ ", openDate=" + openDate + ", accountStatus=" + accountStatus + ", balance=" + balance + ", branchId="
				+ branchId + ", customerId=" + customerId + ", savingAccount=" + savingAccount + ", currentAccount="
				+ currentAccount + "]";
	}


	
	
	

}
