package com.filediarysystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@RequestMapping("/welcome")
	public String welcome() {
		String text="this is welcome page";
		text+="this page in not allowed to unauthenticated user";
		return text;
	}
	
	@RequestMapping("/getUser")
	public String getUser() {
		
		return "{\"name\":\"Ashish\"}";
	}
}
