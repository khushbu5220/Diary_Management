package com.filediarysystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.filediarysystem.entities.FileMovementHistory;

public interface FileMovementHistoryRepository extends JpaRepository<FileMovementHistory, Long>
{
	@Query("Select f from FileMovementHistory f where f.file_id= :file_id order by f.cdt desc")
	List<FileMovementHistory> findByFileId(Long file_id);
}
