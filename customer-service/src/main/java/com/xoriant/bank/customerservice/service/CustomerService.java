package com.xoriant.bank.customerservice.service;

import java.util.List;

import com.xoriant.bank.customerservice.entity.Customer;

public interface CustomerService {

	Customer findById(int id);

	Customer save(Customer customer);

	void deleteById(int id);

	void deleteManager(Customer customer);

	List<Customer> findAllCustomer();

	Customer add(Customer customer);
	
	

	

}