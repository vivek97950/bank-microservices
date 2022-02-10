package com.xoriant.bank.managerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.bank.managerservice.entity.Manager;

public interface ManagerDao extends JpaRepository<Manager, Integer> {

}
