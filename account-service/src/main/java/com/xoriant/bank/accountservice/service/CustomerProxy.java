package com.xoriant.bank.accountservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.bank.accountservice.model.Customer;



@FeignClient(name = "customer-proxy", url = "http://localhost:8081/api/customer")
public interface CustomerProxy {
	
	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId);

}
