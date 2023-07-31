package com.filediarysystem.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Webcontroller {

	// User home
    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal) {
    	return "index";
    }
    
    @RequestMapping("/loginpage")
    public String loginpage(Model model, Principal principal) {
    	return "loginpage";
    }
}
