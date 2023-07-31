package com.filediarysystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.filediarysystem.entities.User;
import com.filediarysystem.helper.CustomUserDetails;
import com.filediarysystem.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
//	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		System.out.println(userName +" : userName");
		//user from database
				User user = this.userRepository.findByUsername(userName);
//				System.out.println(user.toString() +" : user");
				if(user == null) 
				{
					throw new UsernameNotFoundException("User not found !!");
				}
				else 
				{
					return new CustomUserDetails(user);
				}
		
		
//		if(userName.equals("Ashish")){
//			return new User("Ashish","Ashish123",new ArrayList<>());
//		}
//		else {
//			throw new UsernameNotFoundException("User not found");
//		}
	}

}
