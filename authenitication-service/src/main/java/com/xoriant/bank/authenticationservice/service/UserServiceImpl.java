package com.xoriant.bank.authenticationservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xoriant.bank.authenticationservice.dao.UserDao;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		
		com.xoriant.bank.authenticationservice.entity.User user=userDao.findByUserName(s);
		
		System.out.println(user);
				
		return new User(user.getUserName(), user.getPassword(),getAuthority(user));
    }
	
	private Set getAuthority(com.xoriant.bank.authenticationservice.entity.User user) {
        Set<SimpleGrantedAuthority> authorities=new HashSet();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER_"+user.getRole()));
		System.out.println("USER_"+user.getRole());
		return authorities;
	}
	 
}
