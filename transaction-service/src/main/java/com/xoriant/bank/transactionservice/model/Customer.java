package com.xoriant.bank.transactionservice.model;




public class Customer {

	private int customerId;
	private PersonInfo personInfo;
	private int managerId;
	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", personInfo=" + personInfo + "]";
	}

	public Customer() {

	}
	

}
