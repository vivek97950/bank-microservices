package com.xoriant.bank.authenticationservice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

	UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

}