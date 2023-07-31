package com.filediarysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.filediarysystem.helper.JwtUtil;
import com.filediarysystem.payload.request.JwtRequest;
import com.filediarysystem.payload.response.JwtResponse;
import com.filediarysystem.services.CustomUserDetailsService;

@CrossOrigin(origins = "*")
@RestController
public class JwtController 
{
	@Autowired
	private AuthenticationManager authenticationmanager;
	@Autowired
	private CustomUserDetailsService customuserdetailsservice;
	@Autowired
	private JwtUtil jwtutil;
//	@Autowired
//	private BCryptPasswordEncoder bcryptpasswordencoder;
	
	@RequestMapping(value = "/token",method = RequestMethod.POST)
	public String generateToken1(@RequestBody JwtRequest jwtRequest) throws Exception
	{	
//		System.out.println(jwtRequest.toString());
		try {
			this.authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));				
		} 
		catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		//fine area
		UserDetails userDetails = this.customuserdetailsservice.loadUserByUsername(jwtRequest.getUsername());
//		System.out.println("userDetails : "+userDetails.toString());
		String token = this.jwtutil.generateToken(userDetails);
//		System.out.println("JWT : " + token);
		
		//{"token":"value"}
		ResponseEntity<?> res = ResponseEntity.status(200).body(token);
//		return ResponseEntity.ok(new JwtResponse(token));
		return (String) res.getBody();
	}

}
