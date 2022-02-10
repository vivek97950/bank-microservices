package com.xoriant.bank.customerservice.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xoriant.bank.customerservice.dao.UserDao;
import com.xoriant.bank.customerservice.entity.Customer;
import com.xoriant.bank.customerservice.entity.PersonInfo;
import com.xoriant.bank.customerservice.entity.User;

@Component
public class UserUtil {
	

	
	@Autowired
	private UserDao userDao;

	public User addUser(Customer customer) {
		
		User user=new User();
		
		PersonInfo person=customer.getPersonInfo();
		
		user.setUserName(person.getEmailId());
		
		user.setRole(Role.CUSTOMER);

		user.setPerson(customer.getPersonInfo());
		
		user.setPassword(Math.random()+"@"+Math.random());
		
		return userDao.save(user);
		
		
		
	}
	
	

}
