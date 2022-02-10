package com.xoriant.bank.customerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.bank.customerservice.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
