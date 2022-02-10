package com.xoriant.bank.managerservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.xoriant.bank.managerservice.controller.Sender;
import com.xoriant.bank.managerservice.dao.ManagerDao;
import com.xoriant.bank.managerservice.entity.Customer;
import com.xoriant.bank.managerservice.entity.Manager;
import com.xoriant.bank.managerservice.entity.User;
import com.xoriant.bank.managerservice.util.UserUtil;

@Service
@EnableFeignClients
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private  Sender sender;

	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private CustomerProxy customerProxy;

	@Autowired
	private UserUtil userUtil;

	@Override
	public Manager findById(int id) {
		return managerDao.findById(id).orElse(null);
	}

	@Override
	public Manager save(Manager manager) {
		return managerDao.save(manager);
	}

	@Override
	public void deleteById(int id) {
		managerDao.deleteById(id);
	}

	@Override
	public void deleteManager(Manager manager) {
		managerDao.delete(manager);
	}

	@Override
	public List<Manager> findAllManager() {
		return managerDao.findAll();
	}

	@Override
	public Manager add(Manager manager) {
		User user=userUtil.addUser(manager);
		
		System.out.println("user added ");
		Manager _manager= managerDao.save(manager);
		Map<String,Object> map=new HashMap();
		map.put("id", _manager.getManagerId());
		map.put("userId", user.getUserName());
		map.put("password", user.getPassword());
		sender.sendUserCreationEmail(map);
		return _manager;

	}
	
	public Customer getCustomerById(int customerId) {
		return customerProxy.getCustomerById(customerId);
	}

}
