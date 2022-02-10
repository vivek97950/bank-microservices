package com.xoriant.bank.managerservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xoriant.bank.managerservice.dao.UserDao;
import com.xoriant.bank.managerservice.entity.Manager;
import com.xoriant.bank.managerservice.entity.PersonInfo;
import com.xoriant.bank.managerservice.entity.User;

@Component
public class UserUtil {
	

	
	@Autowired
	private UserDao userDao;

	public User addUser(Manager manager) {
		
		User user=new User();
		
		PersonInfo person=manager.getPersonInfo();
		
		System.out.println("=============="+person);
		
		user.setUserName(person.getEmailId());
		
		System.out.println(Role.MANAGER);
		user.setRole(Role.MANAGER);
		System.out.println();
		user.setPerson(manager.getPersonInfo());
		user.setPassword(Math.random()+"@"+Math.random());
		
		return userDao.save(user);
		
		
		
		
		
	}
	
	

}
