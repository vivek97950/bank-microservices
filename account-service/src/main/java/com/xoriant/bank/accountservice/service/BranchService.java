package com.xoriant.bank.accountservice.service;

import java.util.List;

import com.xoriant.bank.accountservice.entity.Branch;

public interface BranchService {

	Branch findById(int id);

	Branch save(Branch branch);

	void deleteById(int id);

	void deleteBranch(Branch branch);

	List<Branch> findAllBranch();

}