package com.filediarysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filediarysystem.entities.Division;

public interface DivisionRepository extends JpaRepository<Division, Long> 
{

}