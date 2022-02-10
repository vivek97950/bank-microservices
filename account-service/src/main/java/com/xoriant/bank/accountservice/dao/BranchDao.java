package com.xoriant.bank.accountservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.bank.accountservice.entity.Branch;

@Repository
public interface BranchDao extends JpaRepository<Branch, Integer> {

}
