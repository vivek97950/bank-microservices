package com.xoriant.bank.managerservice.service;

import java.util.List;

import com.xoriant.bank.managerservice.entity.Customer;
import com.xoriant.bank.managerservice.entity.Manager;

public interface ManagerService {

	Manager findById(int id);

	Manager save(Manager manager);

	void deleteById(int id);

	void deleteManager(Manager manager);

	List<Manager> findAllManager();

	Manager add(Manager manager);
	
    Customer getCustomerById(int customerId);

	

}