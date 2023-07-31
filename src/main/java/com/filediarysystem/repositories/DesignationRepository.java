package com.filediarysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filediarysystem.entities.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Long> 
{
	
}