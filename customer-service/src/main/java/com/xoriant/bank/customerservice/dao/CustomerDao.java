package com.xoriant.bank.customerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.bank.customerservice.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
