package com.xoriant.bank.gatewaytservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class Gateway {
	
	@GetMapping("/transactionFallBack")
	@HystrixCommand(fallbackMethod = "transactionFallBack", commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
			})
	public String transactionFallBack() {
		return("Transaction Service is in maintainance ,please try after some time");
	}
	
	
	@GetMapping("/accountFallBack")
	@HystrixCommand(fallbackMethod = "accountFallBack", commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
			})
	public String accountFallBack() {
		return("Account Service is in maintainance ,please try after some time");
	}
	
	
	@GetMapping("/reportFallBack")
	@HystrixCommand(fallbackMethod = "reportFallBack", commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
			})
	public String reportFallBack() {
		return("Report Service is in maintainance ,please try after some time");
	}
	
	@GetMapping("/customerFallBack")
	@HystrixCommand(fallbackMethod = "customerFallBack", commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
			})
	public String customerFallBack() {
		return("Customer Service is in maintainance ,please try after some time");
	}
	
	@GetMapping("/managerFallBack")
	@HystrixCommand(fallbackMethod = "managerFallBack", commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
			})
	public String managerFallBack() {
		return("Manager Service is in maintainance ,please try after some time");
	}
	
	@GetMapping("/autheticationFallBack")
	@HystrixCommand(fallbackMethod = "autheticationFallBack", commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
			})
	public String autheticationFallBack() {
		return("Authentication Service is in maintainance ,please try after some time");
	}

}
