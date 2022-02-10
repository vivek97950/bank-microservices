package com.xoriant.bank.authenticationservice.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.bank.authenticationservice.model.AuthenticationRequest;
import com.xoriant.bank.authenticationservice.model.AuthenticationResponse;
import com.xoriant.bank.authenticationservice.service.UserService;
import com.xoriant.bank.authenticationservice.util.JwtUtil;

@RestController
@RequestMapping("/api/authentication")
@CrossOrigin
@RefreshScope
public class AuthenticationResource {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UserService userDetailsService;
	
	
	
	
	@GetMapping("/customer")
	public String firstPage() {
		
		System.out.println("hello world====================");
		return "Customer";
	}
	
	

	@GetMapping("/manager")
	public String secondPage() {
		
		System.out.println("hello world====================");
		return "manager";
	}
	
	
	@PostMapping
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest){

		
		
		System.out.println(authenticationRequest.getUsername());
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (Exception e) {
			System.out.println("error in authenticate");
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
//		Map<String,Object> map=new HashMap();
//		
//		map.put("jwt", new AuthenticationResponse(jwt));
//		map.put("user", userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
		//return ResponseEntity.ok(map);
	}
	
}
