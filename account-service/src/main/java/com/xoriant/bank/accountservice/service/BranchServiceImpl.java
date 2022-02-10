package com.xoriant.bank.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.bank.accountservice.dao.BranchDao;
import com.xoriant.bank.accountservice.entity.Branch;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
	private BranchDao branchDao;

	@Override
	public Branch findById(int id) {
		return branchDao.findById(id).orElse(null);
	}

	@Override
	public Branch save(Branch branch) {
		return branchDao.save(branch);
	}

	@Override
	public void deleteById(int id) {
		branchDao.deleteById(id);
	}

	@Override
	public void deleteBranch(Branch branch) {
		branchDao.delete(branch);
	}

	@Override
	public List<Branch> findAllBranch() {
		return branchDao.findAll();
	}

}
