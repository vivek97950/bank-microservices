package com.xoriant.bank.managerservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.xoriant.bank.managerservice.entity.Customer;



@FeignClient(name="customer-proxy",url="http://localhost:8081/api/customer")
public interface CustomerProxy {	
	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId);

}
