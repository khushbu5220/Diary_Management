package com.filediarysystem.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.filediarysystem.entities.LetterDiary;

public interface LetterDiaryRepository extends JpaRepository<LetterDiary, Long>
{
	@Query("Select f from LetterDiary f where f.user_id= :user_id order by f.cdt desc")
	List<LetterDiary> findAllByUserId(@Param("user_id") Long user_id);

	@Query("Select f from LetterDiary f where f.id= :id")
	LetterDiary findByLetterId(@Param("id") Long id);
	
	@Query("Select f from LetterDiary f where f.letter_number= :letter_no or f.refrence_no= :reference_no or f.received_from= :received_from or f.subject= :subject or f.cdt>= :from_date or f.cdt<= :to_date and user_id= :user_id")
	List<LetterDiary> searchLetterDiary(@Param("letter_no") String letter_no, @Param("reference_no") String reference_no, @Param("received_from") String received_from, 
			@Param("subject") String subject, @Param("from_date") Date from_date, @Param("to_date") Date to_date, @Param("user_id") Long user_id);

	
//	@Query("Select f from LetterDiary f where f.id= :id")
//	 private LetterDiary findById(@Param("id") Long id);
}
