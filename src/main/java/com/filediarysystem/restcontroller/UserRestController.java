package com.filediarysystem.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.filediarysystem.config.JwtAuthenticationFilter;
import com.filediarysystem.config.MySecurityConfig;
import com.filediarysystem.entities.User;
import com.filediarysystem.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
public class UserRestController 
{
	@Autowired
	UserRepository userrepository;
	@Autowired
	JwtAuthenticationFilter JwtAuthentication;
//	@Autowired(required=true)
//	BCryptPasswordEncoder bcryptpasswordencoder;
	
	@PostMapping("/addOfficer")
	public String saveusers(@RequestBody User userData)
	{
		String ret = "";
		String Username = JwtAuthentication.checkName();
		User user = userrepository.findByUsername(Username);
		ResponseEntity<?> res = null;
		try
		{
			if("".equalsIgnoreCase(userData.getDisplayname()))
			{
				res = ResponseEntity.status(400).body("Name is required");
				ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
				return ret;
			}
			if("".equalsIgnoreCase(userData.getUsername()))
			{
				res = ResponseEntity.status(400).body("Username is required");
				ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
				return ret;
			}
			if("".equalsIgnoreCase(userData.getEmailId()))
			{
				res = ResponseEntity.status(400).body("Email ID is required");
				ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
				return ret;
			}
			if("".equalsIgnoreCase(userData.getPassword()))
			{
				res = ResponseEntity.status(400).body("Password is required");
				ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
				return ret;
			}
			if("".equalsIgnoreCase(userData.getDesignation()))
			{
				res = ResponseEntity.status(400).body("Designation is required");
				ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
				return ret;
			}
			if("".equalsIgnoreCase(userData.getDivision()))
			{
				res = ResponseEntity.status(400).body("Division is required");
				ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
				return ret;
			}
			userData.setRole("ROLE_USER");
			userData.setUstatus("active");
			userData.setCdt(new Date());
			System.out.println("userData : "+ userData.toString());
			User u = userrepository.save(userData);
			res = ResponseEntity.status(201).body("Officer Added Successfully");
			ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
		}
		catch(Exception e)
		{
			if(e.toString().contains("user.username_UNIQUE"))
			{
				res = ResponseEntity.status(400).body("Username already exists");
				ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
				return ret;
			}
			e.printStackTrace();
		}
		return ret;
	}
	
	@PutMapping("/updateOfficer/{Id}")
	public String updateusers(@RequestBody User userData, @PathVariable("Id") Long Id)
	{
		String ret = "";
		String Username = JwtAuthentication.checkName();
		User user = userrepository.findByUsername(Username);
		ResponseEntity<?> res = null;
		try
		{
			User u = userrepository.findUser(Id);
			if("".equalsIgnoreCase(userData.getDisplayname()))
			{
				res = ResponseEntity.status(400).body("Name is required");
				ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
				return ret;
			}
			if("".equalsIgnoreCase(userData.getUsername()))
			{
				res = ResponseEntity.status(400).body("Username is required");
				ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
				return ret;
			}
			if("".equalsIgnoreCase(userData.getEmailId()))
			{
				res = ResponseEntity.status(400).body("Email ID is required");
				ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
				return ret;
			}
			if("".equalsIgnoreCase(userData.getDesignation()))
			{
				res = ResponseEntity.status(400).body("Designation is required");
				ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
				return ret;
			}
			if("".equalsIgnoreCase(userData.getDivision()))
			{
				res = ResponseEntity.status(400).body("Division is required");
				ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
				return ret;
			}
			userData.setPassword(u.getPassword());
			userData.setUserid(Id);
			userData.setRole(u.getRole());
//			userData.setUstatus(userData.getUstatus());
			userData.setCdt(u.getCdt());
			System.out.println("userData : "+ userData.toString());
			userrepository.save(userData);
			res = ResponseEntity.status(200).body("Officer Added Successfully");
			ret = String.valueOf(res.getStatusCodeValue())+"|"+res.getBody();
		}
		catch(Exception e)
		{
			if(e.toString().contains("Duplicate entry"))
			{
				System.out.println("----------------");
			}
//			e.printStackTrace();
		}
		return ret;
	}
	
	@GetMapping("/getOfficers")
	public List<User> getOfficers()
	{
		List<User> ret = null;
		try
		{
			ret = userrepository.findAllUser("ROLE_USER");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	
	@GetMapping("/viewOfficers/{Id}")
	public User viewOfficers(@PathVariable("Id") Long Id)
	{
		User ret = null;
		try
		{
			ret = userrepository.findUser(Id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	
//	@GetMapping("/getUser")
//	public String getUser()
//	{
//		
//		return "";
//	}
}
