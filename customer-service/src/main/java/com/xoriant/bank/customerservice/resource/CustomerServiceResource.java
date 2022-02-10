package com.xoriant.bank.customerservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.bank.customerservice.entity.Customer;
import com.xoriant.bank.customerservice.service.CustomerService;



@RestController
@RequestMapping("/api/customer")
@CrossOrigin
@RefreshScope
public class CustomerServiceResource {
	

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		
		return customerService.add(customer);
	}

	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@DeleteMapping("/{customerId}")
	public void deleteCustomerById(@PathVariable int customerId) {
		customerService.deleteById(customerId);
	}

	@GetMapping
	public List<Customer> getAllCustomer() {	
		return customerService.findAllCustomer();
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		return customerService.findById(customerId);
	}




	
	

}
