package com.xoriant.bank.transactionservice.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class Sender {
	
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Bean
	public Queue f4() {
		return new Queue("FundTransfer", false);
	}
	
	@Bean
	public Queue f5() {
		return new Queue("Deposite", false);
	}
	
	@Bean
	public Queue f6() {
		return new Queue("Withdraw", false);
	}
	

	


	public void sendFundTransferMail(Map<String, Object> map) {
		
		rabbitTemplate.convertAndSend("FundTransfer",map);
		
	}

	public void sendDeposit(Map<String, Object> map) {
		rabbitTemplate.convertAndSend("Deposite",map);
		
	}

	public void sendWithdraw(Map<String, Object> map) {
		rabbitTemplate.convertAndSend("Withdraw",map);
		
	}
	

}
