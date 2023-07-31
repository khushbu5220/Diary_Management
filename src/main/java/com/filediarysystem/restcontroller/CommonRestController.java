package com.filediarysystem.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.filediarysystem.config.JwtAuthenticationFilter;
import com.filediarysystem.controller.JwtController;
import com.filediarysystem.entities.Designation;
import com.filediarysystem.entities.Division;
import com.filediarysystem.entities.NavBarOption;
import com.filediarysystem.entities.User;
import com.filediarysystem.payload.request.ChangePassword;
import com.filediarysystem.payload.request.JwtRequest;
import com.filediarysystem.payload.response.EmployeePositions;
import com.filediarysystem.payload.response.NavBarOptionsResponse;
import com.filediarysystem.repositories.DesignationRepository;
import com.filediarysystem.repositories.DivisionRepository;
import com.filediarysystem.repositories.NavBarOptionRepository;
import com.filediarysystem.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
public class CommonRestController 
{
	@Autowired
	DesignationRepository designationrepository;
	@Autowired
	DivisionRepository divisionrepository;
	@Autowired
	JwtAuthenticationFilter JwtAuthentication;
	@Autowired
	UserRepository userrepository;
	@Autowired
	NavBarOptionRepository navbaroptionrepository;
	@Autowired
	JwtController jwtcontroller;
	
	@GetMapping("/getEmployeePositions")
	public EmployeePositions getEmployeePositions()
	{
		EmployeePositions ret = new EmployeePositions();
		try
		{
			List<Designation> designations = designationrepository.findAll();
			List<Division> divisions = divisionrepository.findAll();
			ret.setDesignation(designations);
			ret.setDivision(divisions);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	
	@GetMapping("/getNavOptions")
	public List<NavBarOptionsResponse> getNavOptions()
	{
		List<NavBarOptionsResponse> ret = new ArrayList<>();
		try
		{
			String Username = JwtAuthentication.checkName();
			User user = userrepository.findByUsername(Username);

			List<NavBarOption> options = navbaroptionrepository.findByHeaderPredecessor(user.getRole(), 0L);
			
			for(NavBarOption l : options)
			{
				NavBarOptionsResponse navbar = new NavBarOptionsResponse();
				List<NavBarOption> list = navbaroptionrepository.findByHeaderPredecessor(user.getRole(), l.getId());
				navbar.setUsername(user.getUsername());
				navbar.setParent(l);
				navbar.setChild(list);
				ret.add(navbar);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	
	@PutMapping("/changePassword")
	public String changePassword(@RequestBody ChangePassword changepassword)
	{
		String ret = "";
		try
		{
			String Username = JwtAuthentication.checkName();
			User user = userrepository.findByUsername(Username);
			
			JwtRequest jwtr = new JwtRequest();
			jwtr.setUsername(user.getUsername());
			jwtr.setPassword(changepassword.getCurrentPassword());
			ret = "500";
			String token = jwtcontroller.generateToken1(jwtr);
			System.out.println(token);
			User u = new User();
			u.setCdt(user.getCdt());
			u.setDesignation(user.getDesignation());
			u.setDisplayname(user.getDisplayname());
			u.setDivision(user.getDivision());
			u.setEmailId(user.getEmailId());
			u.setPassword(changepassword.getNewPassword());
			u.setRole(user.getRole());
			u.setUserid(user.getUserid());
			u.setUstatus(user.getUstatus());
			u.setUsername(user.getUsername());
			userrepository.save(u);
			ret = "200";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
}
