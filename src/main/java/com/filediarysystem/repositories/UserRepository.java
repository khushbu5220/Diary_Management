package com.filediarysystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.filediarysystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("Select u from User u where u.username= :userName and u.ustatus= 'active'")
	User findByUsername(String userName);
	
	@Query("Select u from User u where u.role= :role and u.ustatus= 'active' order by u.cdt desc")
	List<User> findAllUser(String role);
	
	@Query("Select u from User u where u.userid= :id")
	User findUser(Long id);
}
