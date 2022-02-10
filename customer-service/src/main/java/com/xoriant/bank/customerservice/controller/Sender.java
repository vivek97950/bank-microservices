package com.xoriant.bank.customerservice.controller;

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
	public Queue f1() {
		return new Queue("UserLogIn", false);
	}

	public void sendUserCreationEmail(Map<String, Object> emailData) {

		rabbitTemplate.convertAndSend("UserLogIn", emailData);

	}

}
