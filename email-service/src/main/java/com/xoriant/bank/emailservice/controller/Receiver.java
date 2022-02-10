package com.xoriant.bank.emailservice.controller;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

@Controller
public class Receiver {

	@Autowired
	private JavaMailSender javaMailSender;

	@RabbitListener(queues = "UserLogIn")
	public void userLogInInfo(Map<String, Object> userLogIn) {
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom("xor.viv@gmail.com");
		msg.setTo(userLogIn.get("userId").toString());
		msg.setSubject("Your user credential for id " + userLogIn.get("id"));
		msg.setText("You user id " + userLogIn.get("userId") + " \n  And password is " + userLogIn.get("password"));
		javaMailSender.send(msg);
	}

	@RabbitListener(queues = "FundTransfer")
	public void FundTransferInfo(Map<String, Object> map) {
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom("xor.viv@gmail.com");
		msg.setTo(map.get("toMail").toString(), map.get("fromMail").toString());
		msg.setSubject("Your Transaction is successful");
		msg.setText(map.get("amount").toString() + " is tranfered from account " + map.get("toAccount").toString()
				+ " to " + map.get("fromAccount").toString());
		javaMailSender.send(msg);
	}

	@RabbitListener(queues = "Deposite")
	public void depositeInfo(Map<String, Object> map) {
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom("xor.viv@gmail.com");
		msg.setTo(map.get("toMail").toString());
		msg.setSubject("Your Transaction is successful");
		msg.setText(map.get("amount").toString() + " is credited to account " + map.get("toAccount").toString());
		javaMailSender.send(msg);
	}

	@RabbitListener(queues = "Withdraw")
	public void withdrawInfo(Map<String, Object> map) {
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom("xor.viv@gmail.com");
		msg.setTo(map.get("toMail").toString());
		msg.setSubject("Your Transaction is successful");
		msg.setText(map.get("amount").toString() + " is debited from account " + map.get("toAccount").toString());
		javaMailSender.send(msg);
	}

}
