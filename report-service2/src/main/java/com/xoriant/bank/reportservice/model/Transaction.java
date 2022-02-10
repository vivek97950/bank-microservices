package com.xoriant.bank.reportservice.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




public class Transaction {
	

	private int transactionId;
	
	private LocalDate transactionDate;
	

	private TransactionType transactionType;
	
	private double transactionAmount;
	

	private Account fromAcount;
	

	private Account toAcount;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	
	
	public Account getFromAcount() {
		return fromAcount;
	}

	public void setFromAcount(Account fromAcount) {
		this.fromAcount = fromAcount;
	}

	public Account getToAcount() {
		return toAcount;
	}

	public void setToAcount(Account toAcount) {
		this.toAcount = toAcount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionType=" + transactionType + ", transactionAmount=" + transactionAmount + ", fromAcount="
				+ fromAcount + ", toAcount=" + toAcount + "]";
	}


	
	

}
