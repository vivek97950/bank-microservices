package com.xoriant.bank.managerservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.bank.managerservice.entity.Customer;
import com.xoriant.bank.managerservice.entity.Manager;
import com.xoriant.bank.managerservice.service.ManagerService;



@RestController
@RequestMapping("/api/manager")
@CrossOrigin
public class ManagerServiceResource {
	@Autowired
	private ManagerService managerService;

	@PostMapping
	public Manager addManager(@RequestBody Manager manager) {
		
		return managerService.add(manager);
	}

	@PutMapping
	public Manager updateManager(@RequestBody Manager manager) {
		return managerService.save(manager);
	}

	@DeleteMapping("/{managerId}")
	public void deleteManagerById(@PathVariable int managerId) {
		managerService.deleteById(managerId);
	}

	@GetMapping
	public List<Manager> getAllManager() {	
		return managerService.findAllManager();
	}

	@GetMapping("/{managerId}")
	public Manager getManagerById(@PathVariable int managerId) {
		return managerService.findById(managerId);
	}
	
	@GetMapping("/customer/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		return managerService.getCustomerById(customerId);
	}
	


}
