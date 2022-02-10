package com.xoriant.bank.managerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.bank.managerservice.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByUserName(String s);

}
