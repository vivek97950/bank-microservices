package com.xoriant.bank.customerservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.bank.customerservice.controller.Sender;
import com.xoriant.bank.customerservice.dao.CustomerDao;
import com.xoriant.bank.customerservice.entity.Customer;
import com.xoriant.bank.customerservice.entity.User;
import com.xoriant.bank.customerservice.util.UserUtil;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private  Sender sender;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private UserUtil userUtil;

	@Override
	public Customer findById(int id) {
		return customerDao.findById(id).orElse(null);
	}

	@Override
	public Customer save(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public void deleteById(int id) {
		customerDao.deleteById(id);
	}

	@Override
	public void deleteManager(Customer customer) {
		customerDao.delete(customer);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return customerDao.findAll();
	}

	@Override
	public Customer add(Customer customer) {
		
		User user=userUtil.addUser(customer);	
		
		
		Customer _customer= customerDao.save(customer);
		
		Map<String,Object> map=new HashMap();
		map.put("id", _customer.getCustomerId());
		map.put("userId", user.getUserName());
		map.put("password", user.getPassword());
		
		sender.sendUserCreationEmail(map);
		return _customer;

	}

}
