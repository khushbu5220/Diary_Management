package com.filediarysystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.filediarysystem.entities.NavBarOption;

public interface NavBarOptionRepository extends JpaRepository<NavBarOption, Long> 
{
	@Query("Select n from NavBarOption n where n.foruserrole= :userrole and n.headerpredessor= :predecessor and n.status='active'")
	List<NavBarOption> findByHeaderPredecessor(String userrole, Long predecessor);
}
