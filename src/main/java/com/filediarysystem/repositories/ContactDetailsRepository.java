package com.filediarysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.filediarysystem.entities.ContactDetails;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Long>
{
	@Query("Select c from ContactDetails c where c.letter_diary_id= :letter_diary_id")
	ContactDetails findByLetterDiaryId(@Param("letter_diary_id") Long letter_diary_id);
}
