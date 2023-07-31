package com.filediarysystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.filediarysystem.entities.LetterMovementHistory;

public interface LetterMovementHistoryRepository extends JpaRepository<LetterMovementHistory, Long>
{
	@Query("Select l from LetterMovementHistory l where l.letter_id= :letter_id order by l.cdt desc")
	List<LetterMovementHistory> findByLetterId(Long letter_id);
}
