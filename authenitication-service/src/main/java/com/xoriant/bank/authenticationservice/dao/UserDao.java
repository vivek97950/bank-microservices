package com.xoriant.bank.authenticationservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.xoriant.bank.authenticationservice.entity.User;


public interface UserDao extends JpaRepository<User, Integer>{
	
	public User findByUserName(String userName);

}
