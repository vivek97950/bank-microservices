package com.xoriant.bank.accountservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.bank.accountservice.entity.Branch;
import com.xoriant.bank.accountservice.service.BranchService;

@RestController
@RequestMapping("/api/branch")
@CrossOrigin
public class BranchServiceResource {
	@Autowired
	private BranchService branchService;

	@PostMapping
	public Branch addBranch(@RequestBody Branch branch) {
		return branchService.save(branch);
	}

	@PutMapping
	public Branch updateBranch(@RequestBody Branch branch) {
		return branchService.save(branch);
	}

	@DeleteMapping("/{branchId}")
	public void deleteBranchById(@PathVariable int branchId) {
		branchService.deleteById(branchId);
	}

	@GetMapping
	public List<Branch> getAllBranchs() {	
		return branchService.findAllBranch();
	}

	@GetMapping("/{branchId}")
	public Branch getBranchById(@PathVariable int branchId) {
		return branchService.findById(branchId);
	}

}
